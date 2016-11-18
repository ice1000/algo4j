package org.ice1000.bit;

import org.ice1000.error.BinaryIndexedTreeException;

/**
 * Created by ice1000 on 2016/11/18.
 *
 * @author ice1000
 */
@SuppressWarnings("WeakerAccess")
public final class IntervalUpdateIntervalQuery {
	private PointUpdateIntervalQuery bit1;
	private PointUpdateIntervalQuery bit2;
	public final int length;

	public IntervalUpdateIntervalQuery(int length) {
		this.length = length + 1;
		bit1 = new PointUpdateIntervalQuery(this.length);
		bit2 = new PointUpdateIntervalQuery(this.length);
	}

	/**
	 * O(n) = log(n)
	 * update all values in [begin, end]
	 * begin >= 1, end <= length
	 *
	 * @param begin left bound of [begin, end], >= 1
	 * @param end   right bound of [begin, end] <= length
	 * @param value every element in [begin, end] will 'plus assign' value.
	 */
	public void update(int begin, int end, long value) {
		if (end < begin) throw new BinaryIndexedTreeException("end should be smaller than begin!");
		if (begin < 1) throw new BinaryIndexedTreeException("index should be at least 1");
		if (end > length) throw new BinaryIndexedTreeException("index should be at least 1");
		bit1.add(begin, value);
		bit1.add(end + 1, -value);
		bit2.add(begin, value * (begin - 1));
		bit2.add(end + 1, -value * end);
	}

	/**
	 * returns sum(right) - sum(left). Mention that it's (left, right]
	 *
	 * @param begin left bound of (left, right]
	 * @param end   right bound of (left, right]
	 * @return sum(right) - sum(left)
	 */
	public long query(int begin, int end) {
		if (end < begin) throw new BinaryIndexedTreeException("end should be smaller than begin!");
		if (begin < 1) throw new BinaryIndexedTreeException("index should be at least 1");
		if (end > length) throw new BinaryIndexedTreeException("index should be at least 1");
		return (end * bit1.sum(end) - bit2.sum(end)) -
				((begin - 1) * bit1.sum(begin - 1) - bit2.sum(begin - 1));
	}
}

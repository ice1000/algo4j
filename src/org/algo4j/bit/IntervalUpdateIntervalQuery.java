package org.algo4j.bit;

import org.algo4j.error.BinaryIndexedTreeException;

/**
 * Created by algo4j on 2016/11/18.
 *
 * @author algo4j
 */
@SuppressWarnings("WeakerAccess")
public final class IntervalUpdateIntervalQuery {
	private BinaryIndexedTree bit1;
	private BinaryIndexedTree bit2;
	public final int length;

	public IntervalUpdateIntervalQuery(int length) {
		this.length = length + 1;
		bit1 = new BinaryIndexedTree(this.length);
		bit2 = new BinaryIndexedTree(this.length);
	}

	public IntervalUpdateIntervalQuery(int length, long... originValues) {
		this(length);
		long lastValue = 0;
		for (int i = 0; i < originValues.length; ++i) {
			bit1.add(i + 1, originValues[i] - lastValue);
			bit2.add(i + 1, i * (originValues[i] - lastValue));
			lastValue = originValues[i];
		}
	}

	/**
	 * O(n) = 4 * log(n)
	 * update all values in [begin, end]
	 * begin >= 1, end <= length
	 *
	 * @param begin left bound of [begin, end], >= 1
	 * @param end   right bound of [begin, end] <= length
	 * @param value every element in [begin, end] will 'plus assign' value.
	 */
	public void update(int begin, int end, long value) {
		if (end < begin) throw new BinaryIndexedTreeException("end should be smaller than begin!");
		bit1.add(begin, value);
		bit1.add(end + 1, -value);
		bit2.add(begin, value * (begin - 1));
		bit2.add(end + 1, -value * end);
	}

	/**
	 * O(n) = 4 * log(n)
	 * returns sum(right) - sum(left). Mention that it's (left, right]
	 *
	 * @param begin left bound of (left, right]
	 * @param end   right bound of (left, right]
	 * @return sum(right) - sum(left)
	 */
	public long query(int begin, int end) {
		if (end < begin) throw new BinaryIndexedTreeException("end should be smaller than begin!");
		return (end * bit1.sum(end) - bit2.sum(end)) -
				((begin - 1) * bit1.sum(begin - 1) - bit2.sum(begin - 1));
	}
}

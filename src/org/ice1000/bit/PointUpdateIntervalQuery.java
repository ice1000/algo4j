package org.ice1000.bit;

/**
 * indexed [1, length]
 * Created by ice1000 on 2016/11/15.
 *
 * @author ice1000
 */
@SuppressWarnings("WeakerAccess")
public final class PointUpdateIntervalQuery extends BinaryIndexedTree {

	public PointUpdateIntervalQuery(int length) {
		super(length);
	}

	/**
	 * O(n) = log(n)
	 * bit standard add function
	 *
	 * @param index position to add value
	 * @param value value to add
	 */
	@Override
	public void add(int index, long value) {
		super.add(index, value);
	}

	/**
	 * O(n) = log(n)
	 * bit standard sum function
	 *
	 * @param index bound
	 * @return summary value, from 1 to index
	 */
	@Override
	public long sum(int index) {
		return super.sum(index);
	}

	/**
	 * O(n) = 2 * log(n)
	 * returns sum(right) - sum(left). Mention that it's (left, right]
	 *
	 * @param left  left bound of (left, right]
	 * @param right right bound of (left, right]
	 * @return sum(right) - sum(left)
	 * @see #sum(int)
	 */
	public long sum(int left, int right) {
		return sum(right) - sum(left - 1);
	}

}

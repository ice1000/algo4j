package org.ice1000.bit;

/**
 * Created by ice1000 on 2016/11/15.
 *
 * @author ice1000
 */
public final class BinaryIndexedTreeImpl extends BinaryIndexedTree {

	public BinaryIndexedTreeImpl(int length) {
		super(length);
	}

	/**
	 * bit standard add function, O(n) = log(n)
	 *
	 * @param index position to add value
	 * @param value value to add
	 */
	@Override
	public void add(int index, long value) {
		super.add(index, value);
	}

	/**
	 * bit standard sum function, O(n) = log(n)
	 *
	 * @param index bound
	 * @return summary value, from 0 to index
	 */
	@Override
	public long sum(int index) {
		return super.sum(index);
	}

	/**
	 * returns sum(right) - sum(left). Mention that it's (left, right]
	 *
	 * @param left  left bound of (left, right]
	 * @param right right bound of (left, right]
	 * @return sum(right) - sum(left)
	 * @see #sum(int)
	 */
	public long sum(int left, int right) {
		return sum(right) - sum(left);
	}

}

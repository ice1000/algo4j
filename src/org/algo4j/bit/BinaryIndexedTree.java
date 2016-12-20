package org.algo4j.bit;

import org.algo4j.error.BinaryIndexedTreeException;

/**
 * [1, length]
 * A binary indexed tree, implemented by using jni.
 * Created by ice1000 on 2016/11/15.
 *
 * @author ice1000
 */
@SuppressWarnings("WeakerAccess")
public class BinaryIndexedTree {
	@SuppressWarnings("CanBeFinal")
	private long[] data;
	public final int length;

	protected BinaryIndexedTree(int length) {
		this.length = length;
		data = new long[length];
	}

	/**
	 * O(n) = log(n)
	 * bit standard add function
	 *
	 * @param index position to add value
	 * @param value value to add
	 */
	public void add(int index, long value) {
		if (index > length || index < 0) throw BinaryIndexedTreeException.indexOutBound();
		add(data, length, index, value);
	}

	/**
	 * O(n) = log(n)
	 * bit standard sum function
	 *
	 * @param index bound
	 * @return summary value, from 1 to index
	 */
	public long sum(int index) {
		if (index > length || index < 1) throw BinaryIndexedTreeException.indexOutBound(index);
		return sum(data, length, index);
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
		if (right > length || left < 0) throw BinaryIndexedTreeException.indexOutBound();
		if (left > right) throw new BinaryIndexedTreeException("left should be smaller than right");
		return sum(right) - sum(left - 1);
	}

	private native void add(
			long[] data,
			int length,
			int index,
			long value
	);

	private native long sum(
			long[] data,
			int length,
			int index
	);
}

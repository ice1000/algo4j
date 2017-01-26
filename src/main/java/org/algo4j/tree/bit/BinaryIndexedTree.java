package org.algo4j.tree.bit;

import org.algo4j.error.BinaryIndexedTreeException;
import org.algo4j.util.SeqUtils;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.Serializable;

/**
 * [1, length]
 * A binary indexed tree, implemented by using jni.
 * Created by ice1000 on 2016/11/15.
 *
 * @author ice1000
 */
@SuppressWarnings("WeakerAccess")
public final class BinaryIndexedTree implements
		Serializable,
		Cloneable {
	private final long[] data;
	public final int length;

	public BinaryIndexedTree(int length) {
		this.length = length;
		data = new long[length];
	}

	private BinaryIndexedTree(long[] data) {
		this.data = data;
		this.length = data.length;
	}

	/**
	 * O(n) = log(n)
	 * bit standard add function
	 *
	 * @param index position to add value
	 * @param value value to add
	 */
	public synchronized void add(int index, long value) {
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
	@Contract(pure = true)
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
	@Contract(pure = true)
	public long sum(int left, int right) {
		if (right > length || left < 0) throw BinaryIndexedTreeException.indexOutBound();
		if (left > right) throw new BinaryIndexedTreeException("left should be smaller than right");
		return sum(right) - sum(left - 1);
	}

	private static native void add(
			@NotNull long[] data,
			int length,
			int index,
			long value
	);

	@Contract(pure = true)
	private static native long sum(
			@NotNull long[] data,
			int length,
			int index
	);

	@Override
	@Contract(value = "null -> false", pure = true)
	public boolean equals(@Nullable Object obj) {
		if (obj == null || !(obj instanceof BinaryIndexedTree)) return false;
		if (obj == this) return true;
		BinaryIndexedTree o = (BinaryIndexedTree) obj;
		if (o.length != this.length) return false;
		for (int i = 0; i < this.length; ++i) if (this.data[i] != o.data[i]) return false;
		return true;
	}

	@Override
	@NotNull
	@Contract(value = " -> !null", pure = true)
	public BinaryIndexedTree clone(){
		return new BinaryIndexedTree(SeqUtils.copy(data));
	}
}

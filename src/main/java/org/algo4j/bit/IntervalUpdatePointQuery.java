package org.algo4j.bit;

import org.algo4j.error.BinaryIndexedTreeException;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * Created by ice1000 on 2016/11/15.
 *
 * @author ice1000
 */
@SuppressWarnings("WeakerAccess")
public final class IntervalUpdatePointQuery implements
		Cloneable {

	@NotNull
	private final BinaryIndexedTree tree;
	public final int length;

	@Contract(pure = true)
	public IntervalUpdatePointQuery(int length) {
		this.length = length;
		tree = new BinaryIndexedTree(length);
	}

	private IntervalUpdatePointQuery(@NotNull BinaryIndexedTree tree) {
		this.tree = tree;
		this.length = tree.length;
	}

	/**
	 * O(n) = 2 * log(n)
	 * update all values in [begin, end]
	 * begin >= 1, end <= length
	 *
	 * @param begin left bound of [begin, end], >= 1
	 * @param end   right bound of [begin, end] <= length
	 * @param value every element in [begin, end] will 'plus assign' value.
	 */
	public synchronized void update(int begin, int end, long value) {
		if (end < begin) throw new BinaryIndexedTreeException("end should be smaller than begin!");
		if (end >= length) throw BinaryIndexedTreeException.indexOutBound();
		tree.add(begin, value);
		tree.add(end + 1, -value);
	}

	/**
	 * O(n) = log(n)
	 * query the value at one position.
	 *
	 * @param index position
	 * @return value
	 */
	@Contract(pure = true)
	public long query(int index) {
		return tree.sum(index);
	}

	@Override
	@NotNull
	@Contract(value = " -> !null", pure = true)
	public IntervalUpdatePointQuery clone() {
		return new IntervalUpdatePointQuery(tree.clone());
	}
}

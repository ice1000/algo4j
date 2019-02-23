package org.algo4j.tree.seg;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.UnaryOperator;

/**
 * Slightly slow but versatile implementation using recursive approach
 * <p>
 * Use Comparator for max/min segment tree
 * <p>
 * Use BiFunction for more complicated functions
 * <br> update is supported <br/>
 * <p>
 * Created by Phosphorus15 on 2019/2/23.
 *
 * @author Phosphorus15
 */
@SuppressWarnings("WeakerAccess")
public class RecursiveSegmentTree<T> implements SegmentTree<T> {

	private class InteriorRecord {

		InteriorRecord left = null;

		InteriorRecord right = null;

		T value = null;

		int l;

		int r;

		public InteriorRecord(int l, int r) {
			this.l = l;
			this.r = r;
		}

	}

	private final int length;

	private final InteriorRecord root;

	private final BiFunction<T, T, T> process;

	public RecursiveSegmentTree(int length, Function<Integer, T> init, BiFunction<T, T, T> process) {
		this.length = length;
		root = new InteriorRecord(0, length - 1);
		this.process = process;
		makeSeg(root, init);
	}

	public RecursiveSegmentTree(@NotNull T[] values, BiFunction<T, T, T> process) {
		this(values.length, (index) -> values[index], process);
	}

	public RecursiveSegmentTree(int length, Function<Integer, T> init, Comparator<T> comparator) {
		this(length, init, (BiFunction<T, T, T>) (l, r) -> (comparator.compare(l, r) > 0) ? l : r);
	}

	public RecursiveSegmentTree(@NotNull T[] values, Comparator<T> comparator) {
		this(values, (BiFunction<T, T, T>) (l, r) -> (comparator.compare(l, r) > 0) ? l : r);
	}

	@Override
	@Contract(pure = true)
	public T query(int l, int r) {
		return queryRecursive(root, l, r);
	}

	@Override
	@Contract(pure = true)
	public void set(int l, int r, T value) {
		update(l, r, i -> value);
	}

	@Contract(pure = true)
	public void update(int l, int r, UnaryOperator<T> operator) {
	}

	private T queryRecursive(InteriorRecord current, int l, int r) {
		if (current.l == l && current.r == r) return current.value;
		int mid = (current.l + current.r) >> 1;
		if (r <= mid) return queryRecursive(current.left, l, r);
		if (l > mid) return queryRecursive(current.right, l, r);
		return process.apply(queryRecursive(current.left, l, mid), queryRecursive(current.right, mid + 1, r));
	}

	private void setRecursive(InteriorRecord current, int l, int r, UnaryOperator<T> operator) {
		if (current.l == current.r) {
			current.value = operator.apply(current.value);
		} else {
			int mid = (current.l + current.r) >> 1;
			if (r <= mid)
				setRecursive(current.left, l, r, operator);
			else if (l > mid)
				setRecursive(current.right, l, r, operator);
			else {
				setRecursive(current.left, l, mid, operator);
				setRecursive(current.right, mid + 1, r, operator);
			}
			current.value = process.apply(current.left.value, current.right.value);
		}
	}

	private void makeSeg(InteriorRecord current, Function<Integer, T> supplier) {
		if (current.l == current.r) {
			current.value = supplier.apply(current.l);
		} else {
			int mid = (current.l + current.r) >> 1;
			current.left = new InteriorRecord(current.l, mid);
			current.right = new InteriorRecord(mid + 1, current.r);
			makeSeg(current.left, supplier);
			makeSeg(current.right, supplier);
			current.value = process.apply(current.left.value, current.right.value);
		}
	}

	@Override
	public int size() {
		return length;
	}
}

package org.algo4j.tree.seg;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.UnaryOperator;

/**
 * Who would't like the GREAT PRESIDENT-TREE? or Durable-SegmentTree
 * <p>
 * Durable SegmentTree is capable of storing the historical form of trees with minimum memory required. you can make query of any historical tree by adding an extra number indicating which you would like to (query).
 * <p>
 * For example, the number indicating the initial tree is 0, while the number indicating the tree after two updates is 2
 * <p>
 * Refer to tests for more information
 * <p>
 * Due to technical & theoretical limits, durable segment trees can only be in the recursive form
 * <p>
 * Created by Phosphorus15 on 2019/3/1.
 *
 * @author Phosphorus15
 */
public class DurableSegmentTree<T> implements SegmentTree<T> {

	private class InteriorRecord {

		InteriorRecord left = null;

		InteriorRecord right = null;

		T value = null;

		int l;

		int r;

		int id = 0;

		InteriorRecord(int l, int r) {
			this.l = l;
			this.r = r;
		}

	}

	private int interiorRecord = 0;

	private final int length;

	private final InteriorRecord root;

	private final BiFunction<T, T, T> process;

	private final ArrayList<InteriorRecord> roots;

	public DurableSegmentTree(int length, Function<Integer, T> init, BiFunction<T, T, T> process) {
		this.length = length;
		root = new InteriorRecord(0, length - 1);
		this.process = process;
		roots = new ArrayList<>();
		roots.add(root);
		makeSeg(root, init);
	}

	public DurableSegmentTree(@NotNull T[] values, BiFunction<T, T, T> process) {
		this(values.length, (index) -> values[index], process);
	}

	public DurableSegmentTree(int length, Function<Integer, T> init, Comparator<T> comparator) {
		this(length, init, (BiFunction<T, T, T>) (l, r) -> (comparator.compare(l, r) > 0) ? l : r);
	}

	public DurableSegmentTree(@NotNull T[] values, Comparator<T> comparator) {
		this(values, (BiFunction<T, T, T>) (l, r) -> (comparator.compare(l, r) > 0) ? l : r);
	}

	@Override
	@Contract(pure = true)
	public T query(int l, int r) {
		return query(l, r, interiorRecord);
	}

	@Contract(pure = true)
	public T query(int l, int r, int record) {
		return queryRecursive(roots.get(record), l, r);
	}

	@Override
	@Contract(pure = true)
	public void set(int l, int r, T value) {
		update(l, r, i -> value);
	}

	@Contract(pure = true)
	public void update(int l, int r, UnaryOperator<T> operator) {
		roots.add(setRecursive(roots.get(interiorRecord++), l, r, operator));
	}

	private T queryRecursive(InteriorRecord current, int l, int r) {
		if (current.l == l && current.r == r) return current.value;
		int mid = (current.l + current.r) >> 1;
		if (r <= mid) return queryRecursive(current.left, l, r);
		if (l > mid) return queryRecursive(current.right, l, r);
		return process.apply(queryRecursive(current.left, l, mid), queryRecursive(current.right, mid + 1, r));
	}

	private InteriorRecord setRecursive(InteriorRecord current, int l, int r, UnaryOperator<T> operator) {
		InteriorRecord neo = new InteriorRecord(current.l, current.r);
		neo.id = interiorRecord;
		if (current.l == current.r) {
			neo.value = operator.apply(current.value);
		} else {
			InteriorRecord left = current.left, right = current.right;
			int mid = (current.l + current.r) >> 1;
			if (r <= mid)
				left = setRecursive(current.left, l, r, operator);
			else if (l > mid)
				right = setRecursive(current.right, l, r, operator);
			else {
				left = setRecursive(current.left, l, mid, operator);
				right = setRecursive(current.right, mid + 1, r, operator);
			}
			neo.value = process.apply(left.value, right.value);
			neo.left = left;
			neo.right = right;
		}
		return neo;
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

	public int getVariants() {
		return interiorRecord;
	}

}

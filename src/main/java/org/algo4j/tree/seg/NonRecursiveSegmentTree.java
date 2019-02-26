package org.algo4j.tree.seg;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.UnaryOperator;

/**
 * Slightly slow but versatile implementation using non-recursive approach
 * <p>
 * Same as the recursive implementation (whereas theoretically better in methods other than update)
 * <p>
 * Created by Phosphorus15 on 2019/2/23.
 *
 * @author Phosphorus15
 */
@SuppressWarnings("WeakerAccess")
public class NonRecursiveSegmentTree<T> implements SegmentTree<T> {


	private final int length;

	private int limit = 1;

	Object[] data;

	private final BiFunction<T, T, T> process;

	public NonRecursiveSegmentTree(int length, Function<Integer, T> init, BiFunction<T, T, T> process) {
		this.length = length;
		data = new Object[length << 1];
		this.process = process;
		makeSeg(init);
	}

	public NonRecursiveSegmentTree(@NotNull T[] values, BiFunction<T, T, T> process) {
		this(values.length, (index) -> values[index], process);
	}

	public NonRecursiveSegmentTree(int length, Function<Integer, T> init, Comparator<T> comparator) {
		this(length, init, (BiFunction<T, T, T>) (l, r) -> (comparator.compare(l, r) > 0) ? l : r);
	}

	public NonRecursiveSegmentTree(@NotNull T[] values, Comparator<T> comparator) {
		this(values, (BiFunction<T, T, T>) (l, r) -> (comparator.compare(l, r) > 0) ? l : r);
	}

	/// The implementation is somewhat... ugly
	@Override
	@Contract(pure = true)
	@SuppressWarnings("unchecked")
	public T query(int l, int r) {
		l += length;
		r += length;
		if (l == r) return (T) data[l];
		if (r >= limit && l < limit) { // force fragmenting
			return process.apply(query(limit - length, r - length), query(l - length, limit - 1 - length));
		}
		T ans = process.apply((T) data[r], (T) data[l]);
		for (; (l ^ r) != 1; l >>= 1, r >>= 1) {
			System.out.println(l + " " + r);
			if ((l & 1) == 0 && l != 1) {
				ans = process.apply(ans, (T) data[l ^ 1]);
			}
			if ((r & 1) == 1 && r != 1) {
				ans = process.apply(ans, (T) data[r ^ 1]);
			}
		}
		return ans;
	}

	@Override
	@Contract(pure = true)
	public void set(int l, int r, T value) {
		for (int i = l; i <= r; i++) {
			set(i, value);
		}
	}

	@Contract(pure = true)
	@SuppressWarnings("unchecked")
	public void update(int l, int r, UnaryOperator<T> operator) {
		for (int i = l; i <= r; i++) {
			set(i, operator.apply((T) data[i + length]));
		}
	}

	@Contract(pure = true)
	@SuppressWarnings("unchecked")
	public void set(int x, T value) {
		x += length;
		data[x] = value;
		x >>= 1;
		for (; x >= 1; x >>= 1) {
			data[x] = process.apply((T) data[x << 1], (T) data[x << 1 | 1]);
		}
	}

	@SuppressWarnings("unchecked")
	private void makeSeg(Function<Integer, T> supplier) {
		for (int i = 0; i < length; i++) {
			data[i + length] = supplier.apply(i);
		}
		for (int i = length - 1; i >= 1; i--) {
			data[i] = process.apply((T) data[i << 1], (T) data[i << 1 | 1]);
		}
		while (limit <= length << 1) limit <<= 1;
		limit >>= 1;
	}

	@Override
	public int size() {
		return length;
	}

}

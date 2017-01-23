package org.algo4j.graph;

import org.algo4j.error.UnionSetException;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.Serializable;

/**
 * Created by ice1000 on 2016/11/17.
 *
 * @author ice1000
 */
@SuppressWarnings({"WeakerAccess", "CanBeFinal"})
public class UnionSet implements
		Serializable,
		Cloneable {
	private final int[] data;
	private final int[] depth;

	public UnionSet(int length) {
		++length;
		data = new int[length];
		for (int i = 0; i < length; i++) data[i] = i;
		depth = new int[length];
	}

	private UnionSet(int[] data, int[] depth) {
		this.data = data;
		this.depth = depth;
	}

	@Contract(pure = true)
	public int size() {
		return data.length;
	}

	/**
	 * O(n) = 1
	 * standard union set find operation.
	 * to find the parent of num.
	 * Also, doing the path compression
	 *
	 * @param num to find a parent of this node
	 * @return the father of num
	 */
	public synchronized int find(int num) {
		if (num <= 0 || num >= data.length)
			throw UnionSetException.indexOutBound();
		return find(data, num);
	}

	/**
	 * O(n) = 2
	 * standard union set merge operation.
	 * to merge two points, a and b.
	 * Also, it's heuristic merge.
	 *
	 * @param a param a
	 * @param b param b
	 */
	public synchronized void merge(int a, int b) {
		int i = find(a);
		int j = find(b);
		if (depth[i] > depth[j]) {
			data[j] = i;
		} else {
			data[i] = j;
			if (depth[i] == depth[j]) ++depth[i];
		}
	}

	/**
	 * O(n) = 2
	 * return true if a and b are in the same tree.
	 * Vice versa.
	 *
	 * @param a param a
	 * @param b param b
	 * @return true if a and b are in the same tree. Vice versa.
	 */
	@Contract(pure = true)
	public boolean isConnected(int a, int b) {
		return find(a) == find(b);
	}

	@Contract(pure = false)
	@SuppressWarnings("DefaultAnnotationParam")
	private native int find(@NotNull int[] data, int num);

	@Override
	@Contract(value = " -> !null", pure = true)
	@SuppressWarnings("MethodDoesntCallSuperMethod")
	public UnionSet clone() {
		return new UnionSet(data, depth);
	}

	@Override
	@Contract(value = "null -> false", pure = true)
	public boolean equals(@Nullable Object obj) {
		if (obj == null || !(obj instanceof UnionSet)) return false;
		if (obj == this) return true;
		UnionSet o = (UnionSet) obj;
		if (o.size() != this.size()) return false;
		for (int i = 0; i < this.size(); ++i) if (this.data[i] != o.data[i]) return false;
		return true;
	}

}

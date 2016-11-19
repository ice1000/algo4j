package org.ice1000.graph;

import org.ice1000.error.UnionSetException;

/**
 * Created by ice1000 on 2016/11/17.
 *
 * @author ice1000
 */
@SuppressWarnings("WeakerAccess")
public class UnionSet {
	private int[] data;
	private int[] depth;
	public final int length;

	public UnionSet(int length) {
		++length;
		this.length = length;
		data = new int[length];
		for (int i = 0; i < length; i++) data[i] = i;
		depth = new int[length];
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
	public int find(int num) {
		if (num < 1 || num > length) throw UnionSetException.indexOutBound();
		return find(data, length, num);
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
	public void merge(int a, int b) {
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
	public boolean isConnected(int a, int b) {
		return find(a) == find(b);
	}

	private native int find(int[] data, int length, int num);
}

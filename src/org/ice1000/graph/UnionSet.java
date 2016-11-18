package org.ice1000.graph;

/**
 * Created by ice1000 on 2016/11/17.
 *
 * @author ice1000
 */
@SuppressWarnings("WeakerAccess")
abstract class UnionSet {
	private long[] data;
	public final int length;

	public UnionSet(int length) {
		this.length = length;
		data = new long[length];
	}

	protected native int find(long[] data, int length, int num);

	protected native void merge(long[] data, int length, int a, int b);
}

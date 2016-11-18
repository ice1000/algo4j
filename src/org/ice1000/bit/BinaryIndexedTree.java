package org.ice1000.bit;

/**
 * A binary indexed tree, implemented by using jni.
 * Created by ice1000 on 2016/11/15.
 *
 * @author ice1000
 */
@SuppressWarnings("WeakerAccess")
abstract class BinaryIndexedTree {
	private long[] data;
	public final int length;

	protected BinaryIndexedTree(int length) {
		this.length = length;
		data = new long[length];
	}

	protected void add(int index, long value) {
		if (index < 1 || index > length) throw new ArrayIndexOutOfBoundsException();
		add(data, length, index, value);
	}

	protected long sum(int index) {
		return sum(data, length, index);
	}

	private native void add(long[] data, int length, int index, long value);

	private native long sum(long[] data, int length, int index);
}

package org.ice1000.bit;

import org.ice1000.error.BinaryIndexedTreeException;

/**
 * Created by ice1000 on 2016/11/17.
 *
 * @author ice1000
 */
@SuppressWarnings("WeakerAccess")
public final class ReversePairSum extends BinaryIndexedTree {

	public static final int FLAG_BEFORE = 0x01;

	public static final int FLAG_AFTER = 0x02;

	public static final int FLAG_QUERIED = 0x03;

	private int flag = FLAG_BEFORE;
	private long result;

	public ReversePairSum(int length) {
		super(length);
	}

	/**
	 * set value of this array
	 *
	 * @param index position
	 * @param value value
	 * @throws BinaryIndexedTreeException when flag is wrong
	 */
	public void set(int index, int value) {
		if (flag != FLAG_BEFORE) throw new BinaryIndexedTreeException("do not set value after discretization!");
		data[index] = value;
	}

	public void setAll(long[] data, int offset, int len) {
		System.arraycopy(data, 0, this.data, offset, len);
//		for (int i = 0; i < len; i++) {
//			this.data[offset + 1] = data[i];
//		}
	}

	public void setAll(long[] data) {
		setAll(data, 0, data.length);
	}

	public long query() {
		if (flag == FLAG_BEFORE) discretization();
		if (flag == FLAG_QUERIED) return result;
		result = query(data, length);
		flag = FLAG_QUERIED;
		return result;
	}

	public void discretization() {
		flag = FLAG_AFTER;
		discretization(data, length);
	}

	private native void discretization(long[] data, int length);

	private native long query(long[] data, int length);
}

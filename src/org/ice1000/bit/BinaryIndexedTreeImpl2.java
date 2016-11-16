package org.ice1000.bit;

/**
 * Created by ice1000 on 2016/11/15.
 *
 * @author ice1000
 */
public final class BinaryIndexedTreeImpl2 extends BinaryIndexedTree {

	public BinaryIndexedTreeImpl2(int length) {
		super(length);
	}

	/**
	 * update all values in [begin, end], O(n) = log(n)
	 *
	 * @param begin left bound of [begin, end]
	 * @param end   right bound of [begin, end]
	 * @param value every element in [begin, end] will 'plus assign' value.
	 */
	public void update(int begin, int end, int value) {
		add(begin, value);
		add(end + 1, -value);
	}

	/**
	 * query the value at one position.
	 *
	 * @param index position
	 * @return value
	 */
	public long query(int index) {
		return sum(index);
	}
}

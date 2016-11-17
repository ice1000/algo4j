package org.ice1000.uset;

/**
 * Created by ice1000 on 2016/11/17.
 *
 * @author ice1000
 */
abstract class UnionSet {
	protected native int find(long[] data, int length, int num);

	protected native void merge(long[] data, int length, int a, int b);
}

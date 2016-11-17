package org.ice1000.util;

/**
 * Created by ice1000 on 2016/11/18.
 *
 * @author ice1000
 */
public final class ArrayUtils {
	private ArrayUtils() {
	}

	public static native void discretization(long[] data, int length);

	public static void discretization(long[] data) {
		discretization(data, data.length);
	}
}

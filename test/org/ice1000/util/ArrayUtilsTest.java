package org.ice1000.util;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by ice1000 on 2016/11/17.
 *
 * @author ice1000
 */
public final class ArrayUtilsTest {
	@BeforeClass
	public static void loadJniLibrary() {
		System.loadLibrary("jni");
	}

	@Test(timeout = 100)
	public void test() {
		long[] longs = new long[]{33, 1, 100, 20, 43, 43};
		ArrayUtils.discretization(longs);
		System.out.println(Arrays.toString(longs));
		assertArrayEquals(new long[]{2, 0, 4, 1, 3, 3}, longs);
//		for (int i = 0; i < sum.length - 1; i++) assertEquals(longs[i], sum.data[i + 1]);
//		assertEquals(5, sum.query());
	}

	public static void main(String[] args) {
		loadJniLibrary();
		new ArrayUtilsTest().test();
	}
}

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

	@Test(timeout = 1000)
	public void test() {
		int[] ints = new int[]{33, 1, 100, 20, 43, 43};
		ArrayUtils.discretization(ints);
		System.out.println(Arrays.toString(ints));
		assertArrayEquals(new int[]{2, 0, 4, 1, 3, 3}, ints);
//		for (int i = 0; i < sum.length - 1; i++) assertEquals(ints[i], sum.data[i + 1]);
//		assertEquals(5, sum.query());
	}

	public static void main(String[] args) {
		loadJniLibrary();
		new ArrayUtilsTest().test();
	}
}

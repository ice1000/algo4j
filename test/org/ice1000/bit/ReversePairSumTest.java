package org.ice1000.bit;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Created by ice1000 on 2016/11/17.
 *
 * @author ice1000
 */
public class ReversePairSumTest {
	@BeforeClass
	public static void setUp() {
		System.loadLibrary("jni");
	}

	@Test(timeout = 1000)
	public void test() {
		ReversePairSum sum = new ReversePairSum(6);
		sum.setAll(new long[]{33, 1, 100, 20, 43, 43});
		System.out.println("1");
		sum.discretization();
		System.out.println("2");
		long[] longs = new long[]{3, 1, 5, 2, 4, 4};
		System.out.println(Arrays.toString(sum.data));
//		assertArrayEquals(longs, sum.data);
		for (int i = 0; i < sum.length - 1; i++) assertEquals(longs[i], sum.data[i + 1]);
		assertEquals(5, sum.query());
	}

	public static void main(String[] args) {
		setUp();
		new ReversePairSumTest().test();
	}
}

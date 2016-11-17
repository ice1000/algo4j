package org.ice1000.bit;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
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
		sum.discretization();
		assertArrayEquals(new long[]{2, 0, 4, 1, 3, 3}, sum.data);
		assertEquals(4, sum.query());
	}

	public static void main(String[] args) {
		setUp();
		new ReversePairSumTest().test();
	}
}

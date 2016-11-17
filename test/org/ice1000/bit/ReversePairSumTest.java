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
		ReversePairSum sum = new ReversePairSum(5);
		sum.setAll(new long[]{33, 1, 100, 20, 43});
		System.out.println(Arrays.toString(sum.data));
		sum.discretization();
		System.out.println("after discretization:");
		System.out.println(Arrays.toString(sum.data));
		assertEquals(4, sum.query());
	}

	public static void main(String[] args) {
		setUp();
		new ReversePairSumTest().test();
	}
}

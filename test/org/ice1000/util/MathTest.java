package org.ice1000.util;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by ice1000 on 2016/11/16.
 *
 * @author ice1000
 */
public final class MathTest {

	@BeforeClass
	public static void loadJniLibrary() {
		System.loadLibrary("jni");
	}

	@Test
	public void basic() {
		assertEquals(4, 2 + 2);
	}

	@Test
	public void gcd() {
		assertEquals(Math.gcd(12, 15), 3);
		assertEquals(Math.gcd(12, 16), 4);
		assertEquals(Math.gcd(15, 20), 5);
		assertEquals(Math.gcd(100, 1000), 100);
		assertEquals(Math.gcd(1000, 100), 100);
		assertEquals(Math.gcd(1, 1), 1);
	}

	/**
	 * 2.5e-4ms per calc
	 */
	@Test(timeout = 100)
	public void sqrtTime() {
		Random random = new Random(System.currentTimeMillis());
		int timesOfTesting = 1000000;
		System.out.println(timesOfTesting + " test cases");
		while (timesOfTesting-- > 0) {
			Math.sqrt(random.nextDouble() * 10000);
		}
	}

	/**
	 * 2.5e-4ms per calc
	 */
	@SuppressWarnings("ResultOfMethodCallIgnored")
	@Test(timeout = 100)
	public void sqrtStdTime() {
		Random random = new Random(System.currentTimeMillis());
		int timesOfTesting = 1000000;
		System.out.println(timesOfTesting + " test cases");
		while (timesOfTesting-- > 0) {
			java.lang.Math.sqrt(random.nextDouble() * 10000);
		}
	}

	@Test(timeout = 10)
	public void sqrtCorrectness() {
		Random random = new Random(System.currentTimeMillis());
		System.out.println(Math.sqrt(100));
		System.out.println(java.lang.Math.sqrt(100));
		int timesOfTesting = 5000;
		System.out.println(timesOfTesting + " test cases");
		while (timesOfTesting-- > 0) {
			double temp = random.nextDouble();
			assertTrue(Math.abs(Math.sqrt(temp) - java.lang.Math.sqrt(temp)) < 1e-5);
		}
	}
}

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
		System.out.println("test passed");
	}

	/**
	 * 2.5e-4ms per calc
	 */
	@SuppressWarnings("deprecation")
	@Test(timeout = 100)
	public void sqrtTime() {
		Random random = new Random(System.currentTimeMillis());
		int timesOfTesting = 1000000;
		System.out.println(timesOfTesting + " test cases");
		while (timesOfTesting-- > 0) {
			Math.sqrt(random.nextDouble() * 10000);
		}
		System.out.println("test passed");
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
		System.out.println("test passed");
	}

	@Test(timeout = 100)
	@SuppressWarnings("deprecation")
	public void sqrtCorrectness() {
		Random random = new Random(System.currentTimeMillis());
		int testNumber = 100;
		System.out.println(Math.sqrt(testNumber));
		System.out.println(Math.sqrtStrict(testNumber));
		System.out.println(java.lang.Math.sqrt(testNumber));
		int timesOfTesting = 5000;
		System.out.println(timesOfTesting + " test cases");
		while (timesOfTesting-- > 0) {
			double temp = random.nextDouble();
			assertTrue(Math.abs(Math.sqrt(temp) - java.lang.Math.sqrt(temp)) < 1e-5);
		}
		System.out.println("test passed");
	}

	@Test(timeout = 50)
	public void triangleTest() {
		Random random = new Random(System.currentTimeMillis());
		int timesOfTesting = 5000;
		System.out.println(timesOfTesting + " test cases");
		while (timesOfTesting-- > 0) {
			double temp = random.nextDouble();
			assertEquals(Math.sin(temp), java.lang.Math.sin(temp), 1e-15);
			assertEquals(Math.cos(temp), java.lang.Math.cos(temp), 1e-15);
			assertEquals(Math.tan(temp), java.lang.Math.tan(temp), 1e-15);
			assertEquals(Math.tan(temp), java.lang.Math.tan(temp), 1e-15);
			assertEquals(Math.tan(temp) * Math.cot(temp), 1, 1e-15);
			assertEquals(Math.cos(temp) * Math.sec(temp), 1, 1e-15);
			assertEquals(Math.sin(temp) * Math.csc(temp), 1, 1e-15);
		}
		System.out.println("test passed");
	}

	/**
	 * fast power and fast plus test
	 * <p>
	 * data:
	 * 2 ^ 10 => 1024, 1024 % 1000 => 24
	 * 2 ^ 9 => 512, 512 % 100 => 12
	 * 2 ^ 10 => 1024, 1024 % 10 => 4
	 * 233 * 233 => 54289, 54289 % 1000 => 289
	 */
	@Test(timeout = 100)
	public void fastPlusPowerTest() {
		assertEquals(24, Math.fastPower(2, 10, 1000));
		assertEquals(12, Math.fastPower(2, 9, 100));
		assertEquals(4, Math.fastPower(2, 10, 10));

		assertEquals(289, Math.fastPlus(233, 233, 1000));
		System.out.println("test passed");
	}

	/**
	 * abstract value
	 */
	@Test(timeout = 100)
	public void absTest() {
		int timeOfTest = 4000;
		System.out.println(timeOfTest + " test cases");
		Random random = new Random(System.currentTimeMillis());
		while (timeOfTest-- > 0) {
			int anInt = random.nextInt();
			double aDouble = random.nextDouble();
			long aLong = random.nextLong();
			float aFloat = random.nextFloat();
			assertEquals(Math.abs(anInt), Math.abs(anInt));
			assertEquals(Math.abs(aLong), Math.abs(aLong));
			assertEquals(Math.abs(aDouble), Math.abs(aDouble), 1e-15);
			assertEquals(Math.abs(aFloat), Math.abs(aFloat), 1e-15);
		}
		System.out.println("test passed");
	}

	/**
	 * min max value
	 */
	@Test(timeout = 100)
	public void minMaxTest() {
		int timeOfTest = 1000;
		System.out.println(timeOfTest + " test cases");
		Random random = new Random(System.currentTimeMillis());
		while (timeOfTest-- > 0) {
			int anInt = random.nextInt();
			int anInt2 = random.nextInt();
			double aDouble = random.nextDouble();
			double aDouble2 = random.nextDouble();
			long aLong = random.nextLong();
			long aLong2 = random.nextLong();
			float aFloat = random.nextFloat();
			float aFloat2 = random.nextFloat();
			assertEquals(Math.min(anInt, anInt2), java.lang.Math.min(anInt, anInt2));
			assertEquals(Math.min(aLong, aLong2), java.lang.Math.min(aLong, aLong2));
			assertEquals(Math.min(aDouble, aDouble2), java.lang.Math.min(aDouble, aDouble2), 1e-15);
			assertEquals(Math.min(aFloat, aFloat2), java.lang.Math.min(aFloat, aFloat2), 1e-15);
			assertEquals(Math.max(anInt, anInt2), java.lang.Math.max(anInt, anInt2));
			assertEquals(Math.max(aLong, aLong2), java.lang.Math.max(aLong, aLong2));
			assertEquals(Math.max(aDouble, aDouble2), java.lang.Math.max(aDouble, aDouble2), 1e-15);
			assertEquals(Math.max(aFloat, aFloat2), java.lang.Math.max(aFloat, aFloat2), 1e-15);
		}
	}

	@Test(timeout = 10)
	public void logTest() {
		int timeOfTest = 5000;
		Random random = new Random(System.currentTimeMillis());
		System.out.println(timeOfTest + " test cases");
		while (timeOfTest-- > 0) {
			double temp = random.nextDouble();
			assertEquals(Math.ln(temp), java.lang.Math.log(temp), 1e-15);
			assertEquals(Math.lg(temp), java.lang.Math.log10(temp), 1e-15);
		}
		System.out.println("test passed");
	}
}

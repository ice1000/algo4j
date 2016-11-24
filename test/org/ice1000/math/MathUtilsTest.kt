package org.ice1000.math

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.BeforeClass
import org.junit.Test
import java.util.*

/**
 * Created by ice1000 on 2016/11/16.

 * @author ice1000
 */
class MathUtilsTest {

	@Test
	fun basic() {
		assertEquals(4, (2 + 2).toLong())
	}

	@Test
	fun gcd() {
		assertEquals(MathUtils.gcd(12, 15), 3)
		assertEquals(MathUtils.gcd(12, 16), 4)
		assertEquals(MathUtils.gcd(15, 20), 5)
		assertEquals(MathUtils.gcd(100, 1000), 100)
		assertEquals(MathUtils.gcd(1000, 100), 100)
		assertEquals(MathUtils.gcd(1, 1), 1)
		println("test passed")
	}

	/**
	 * 2.5e-4ms per calc
	 */
	@SuppressWarnings("deprecation")
	@Test(timeout = 100)
	fun sqrtTime() {
		val random = Random(System.currentTimeMillis())
		var timesOfTesting = 1000000
		println("$timesOfTesting test cases")
		while (timesOfTesting-- > 0) {
			MathUtils.sqrt(random.nextDouble() * 10000)
		}
		println("test passed")
	}

	/**
	 * 2.5e-4ms per calc
	 */
	@SuppressWarnings("ResultOfMethodCallIgnored")
	@Test(timeout = 100)
	fun sqrtStdTime() {
		val random = Random(System.currentTimeMillis())
		var timesOfTesting = 1000000
		println("$timesOfTesting test cases")
		while (timesOfTesting-- > 0) {
			java.lang.Math.sqrt(random.nextDouble() * 10000)
		}
		println("test passed")
	}

	@Test(timeout = 100)
	@SuppressWarnings("deprecation")
	fun sqrtCorrectness() {
		val random = Random(System.currentTimeMillis())
		val testNumber = 100
		println(MathUtils.sqrt(testNumber.toDouble()))
		println(MathUtils.sqrtStrict(testNumber.toDouble()))
		println(java.lang.Math.sqrt(testNumber.toDouble()))
		var timesOfTesting = 5000
		println("$timesOfTesting test cases")
		while (timesOfTesting-- > 0) {
			val temp = random.nextDouble()
			assertTrue(MathUtils.abs(MathUtils.sqrt(temp) - java.lang.Math.sqrt(temp)) < 1e-5)
		}
		println("test passed")
	}

	/**
	 * fast power and fast plus test
	 *
	 *
	 * data:
	 * 2 ^ 10 => 1024, 1024 % 1000 => 24
	 * 2 ^ 9 => 512, 512 % 100 => 12
	 * 2 ^ 10 => 1024, 1024 % 10 => 4
	 * 233 * 233 => 54289, 54289 % 1000 => 289
	 */
	@Test(timeout = 100)
	fun fastPlusPowerTest() {
		assertEquals(24, MathUtils.fastPower(2, 10, 1000))
		assertEquals(12, MathUtils.fastPower(2, 9, 100))
		assertEquals(4, MathUtils.fastPower(2, 10, 10))

		assertEquals(289, MathUtils.fastPlus(233, 233, 1000))
		println("test passed")
	}

	/**
	 * abstract value
	 */
	@Test(timeout = 100)
	fun absTest() {
		var timeOfTest = 4000
		println("$timeOfTest test cases")
		val random = Random(System.currentTimeMillis())
		while (timeOfTest-- > 0) {
			val anInt = random.nextInt()
			val aDouble = random.nextDouble()
			val aLong = random.nextLong()
			val aFloat = random.nextFloat()
			assertEquals(MathUtils.abs(anInt).toLong(), MathUtils.abs(anInt).toLong())
			assertEquals(MathUtils.abs(aLong), MathUtils.abs(aLong))
			assertEquals(MathUtils.abs(aDouble), MathUtils.abs(aDouble), 1e-15)
			assertEquals(MathUtils.abs(aFloat).toDouble(), MathUtils.abs(aFloat).toDouble(), 1e-15)
		}
		println("test passed")
	}

	/**
	 * min max value
	 */
	@Test(timeout = 100)
	fun minMaxTest() {
		var timeOfTest = 1000
		println("$timeOfTest test cases")
		val random = Random(System.currentTimeMillis())
		while (timeOfTest-- > 0) {
			val anInt = random.nextInt()
			val anInt2 = random.nextInt()
			val aDouble = random.nextDouble()
			val aDouble2 = random.nextDouble()
			val aLong = random.nextLong()
			val aLong2 = random.nextLong()
			val aFloat = random.nextFloat()
			val aFloat2 = random.nextFloat()
			assertEquals(
					MathUtils.min(anInt, anInt2).toLong(),
					java.lang.Math.min(anInt, anInt2).toLong())
			assertEquals(
					MathUtils.min(aLong, aLong2),
					java.lang.Math.min(aLong, aLong2))
			assertEquals(
					MathUtils.min(aDouble, aDouble2),
					java.lang.Math.min(aDouble, aDouble2), 1e-15)
			assertEquals(
					MathUtils.min(aFloat, aFloat2).toDouble(),
					java.lang.Math.min(aFloat, aFloat2).toDouble(), 1e-15)
			assertEquals(
					MathUtils.max(anInt, anInt2),
					java.lang.Math.max(anInt, anInt2).toLong())
			assertEquals(
					MathUtils.max(aLong, aLong2),
					java.lang.Math.max(aLong, aLong2))
			assertEquals(
					MathUtils.max(aDouble, aDouble2),
					java.lang.Math.max(aDouble, aDouble2), 1e-15)
			assertEquals(
					MathUtils.max(aFloat, aFloat2).toDouble(),
					java.lang.Math.max(aFloat, aFloat2).toDouble(), 1e-15)
		}
	}

	@Test(timeout = 50)
	fun logTest() {
		var timeOfTest = 5000
		val random = Random(System.currentTimeMillis())
		println("$timeOfTest test cases")
		while (timeOfTest-- > 0) {
			val temp = random.nextDouble()
			assertEquals(
					MathUtils.ln(temp),
					java.lang.Math.log(temp), 1e-15)
			assertEquals(
					MathUtils.lg(temp),
					java.lang.Math.log10(temp), 1e-15)
		}
		println("test passed")
	}

	companion object {

		@BeforeClass
		@JvmStatic
		fun loadJniLibrary() {
			System.loadLibrary("jni")
		}
	}
}

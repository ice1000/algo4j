package org.algo4j.math

import org.algo4j.test.test
import org.junit.Assert.*
import org.junit.BeforeClass
import org.junit.Test
import java.lang.SuppressWarnings
import java.lang.System
import java.util.*
import java.lang.Math as StdMath

/**
 * Created by ice1000 on 2016/11/16.

 * @author ice1000
 */
class MathUtilsTest {

	@Test(timeout = 1000)
	fun gcdTest() {
		val rand = Random(System.currentTimeMillis())
		test(10000) {
			val a: Long = rand.nextInt(23333333).toLong()
			val b: Long = rand.nextInt(23333333).toLong()
			assertEquals(MathUtils.gcdStein(a, b), MathUtils.gcd(a, b))
		}
	}

	@Test(timeout = 1000)
	fun exgcdTest() {
		val rand = Random(System.currentTimeMillis())
		test(1000) {
			val a: Long = rand.nextInt(23333333).toLong()
			val b: Long = rand.nextInt(23333333).toLong()
			val res = MathUtils.exgcd(a, b)
			assertEquals(MathUtils.gcd(a, b), res.x * a + res.y * b)
		}
	}

	/**
	 * 2.5e-4ms per calc
	 */
	@Test(timeout = 500)
	fun sqrtTime() {
		val random = Random(System.currentTimeMillis())
		test(1000000) {
			@Suppress("DEPRECATION")
			MathUtils.sqrt(random.nextDouble() * 10000)
		}
	}

	/**
	 * 2.5e-4ms per calc
	 */
	@Test(timeout = 100)
	@SuppressWarnings("ResultOfMethodCallIgnored")
	fun sqrtCarmarkTime() {
		val random = Random(System.currentTimeMillis())
		test(1000000) {
			@Suppress("DEPRECATION")
			MathUtils.sqrtCarmark(random.nextDouble() * 10000)
		}
	}

	@Test(timeout = 100)
	@SuppressWarnings("deprecation")
	fun sqrtCorrectness() {
		val random = Random(System.currentTimeMillis())
		val testNumber = random.nextDouble() * 10000
		@Suppress("DEPRECATION")
		println(MathUtils.sqrtCarmark(testNumber))
		println(MathUtils.sqrt(testNumber))
		println(StdMath.sqrt(testNumber))
		test(5000) {
			val temp = random.nextDouble()
			@Suppress("DEPRECATION")
			assertTrue(MathUtils.abs(MathUtils.sqrtCarmark(temp) - StdMath.sqrt(temp)) < 1e-5)
			assertTrue(MathUtils.abs(MathUtils.sqrt(temp) - StdMath.sqrt(temp)) < 1e-10)
		}
	}

	/**
	 * fast power and fast plus discretizationTest
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
	}

	/**
	 * abstract value
	 */
	@Test(timeout = 100)
	fun absTest() {
		val random = Random(System.currentTimeMillis())
		test(4000) {
			val anInt = random.nextInt()
			val aDouble = random.nextDouble()
			val aLong = random.nextLong()
			val aFloat = random.nextFloat()
			assertEquals(MathUtils.abs(anInt).toLong(), MathUtils.abs(anInt).toLong())
			assertEquals(MathUtils.abs(aLong), MathUtils.abs(aLong))
			assertEquals(MathUtils.abs(aDouble), MathUtils.abs(aDouble), 1e-15)
			assertEquals(MathUtils.abs(aFloat).toDouble(), MathUtils.abs(aFloat).toDouble(), 1e-15)
		}
	}

	/**
	 * min max value
	 */
	@Test(timeout = 100)
	fun minMaxTest() {
		val random = Random(System.currentTimeMillis())
		test(1000) {
			val anInt = random.nextInt()
			val anInt2 = random.nextInt()
			val aDouble = random.nextDouble()
			val aDouble2 = random.nextDouble()
			val aLong = random.nextLong()
			val aLong2 = random.nextLong()
			val aFloat = random.nextFloat()
			val aFloat2 = random.nextFloat()
			assertEquals(
					MathUtils.min(anInt, anInt2),
					StdMath.min(anInt, anInt2))
			assertEquals(
					MathUtils.min(aLong, aLong2),
					StdMath.min(aLong, aLong2))
			assertEquals(
					MathUtils.min(aDouble, aDouble2),
					StdMath.min(aDouble, aDouble2), 1e-15)
			assertEquals(
					MathUtils.min(aFloat, aFloat2),
					StdMath.min(aFloat, aFloat2), 1e-10F)
			assertEquals(
					MathUtils.max(anInt, anInt2),
					StdMath.max(anInt, anInt2))
			assertEquals(
					MathUtils.max(aLong, aLong2),
					StdMath.max(aLong, aLong2))
			assertEquals(
					MathUtils.max(aDouble, aDouble2),
					StdMath.max(aDouble, aDouble2), 1e-15)
			assertEquals(
					MathUtils.max(aFloat, aFloat2),
					StdMath.max(aFloat, aFloat2), 1e-10F)
		}
	}

	@Test(timeout = 50)
	fun logTest() {
		val random = Random(System.currentTimeMillis())
		test(5000) {
			val temp = random.nextDouble()
			assertEquals(
					MathUtils.ln(temp),
					StdMath.log(temp), 1e-15)
			assertEquals(
					MathUtils.lg(temp),
					StdMath.log10(temp), 1e-15)
		}
	}

	@Test(timeout = 1000)
	fun isPrimeTest() {
		val primes = listOf(
				2L, 3L, 5L, 7L,
				11L, 13L, 17L, 19L,
				23L, 29L, 31L, 37L,
				41L, 43L, 47L, 53L,
				59L, 61L, 67L, 71L,
				73L, 79L, 83L, 89L,
				97L, 101L)
		(0L..102L).forEach { i ->
			if (primes.contains(i)) assertTrue(MathUtils.isPrime(i))
			else assertFalse(MathUtils.isPrime(i))
		}
		val rand = Random(System.currentTimeMillis())
		test(1000) {
			assertFalse(MathUtils.isPrime(
					((MathUtils.abs(rand.nextInt(100)) + 2) *
							(MathUtils.abs(rand.nextInt(100)) + 2)).toLong()
			))
		}
	}

	companion object Initializer {

		@BeforeClass
		@JvmStatic
		fun loadJniLibrary() {
			System.loadLibrary("jni")
		}
	}
}

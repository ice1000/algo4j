package org.algo4j.math

import org.algo4j.linear.RollingArray
import org.algo4j.math.MathUtils.*
import org.algo4j.test.test
import org.algo4j.util.Loader
import org.jetbrains.annotations.TestOnly
import org.junit.Assert.*
import org.junit.BeforeClass
import org.junit.Test
import java.lang.SuppressWarnings
import java.lang.System
import java.util.*
import kotlin.io.println
import java.lang.Math as StdMath

/**
 * Created by ice1000 on 2016/11/16.

 * @author ice1000
 */
class MathUtilsTest {

	@TestOnly
	@Test(timeout = 1000)
	fun gcdTest() {
		val rand = Random(System.currentTimeMillis())
		test(10000) {
			val a: Long = rand.nextInt(23333333).toLong()
			val b: Long = rand.nextInt(23333333).toLong()
			assertEquals(gcdStein(a, b), gcd(a, b))
		}
	}

	@TestOnly
	@Test(timeout = 1000)
	fun exgcdTest() {
		val rand = Random(System.currentTimeMillis())
		test(1000) {
			val a: Long = rand.nextInt(23333333).toLong()
			val b: Long = rand.nextInt(23333333).toLong()
			val res = exgcd(a, b)
			assertEquals(gcd(a, b), res.x * a + res.y * b)
		}
	}

	/**
	 * 2.5e-4ms per calc
	 */
	@TestOnly
	@Test(timeout = 500)
	fun sqrtTime() {
		val random = Random(System.currentTimeMillis())
		test(1000000) {
			@Suppress("DEPRECATION")
			(sqrt(random.nextDouble() * 10000))
		}
	}

	/**
	 * 2.5e-4ms per calc
	 */
	@TestOnly
	@Test(timeout = 250)
	@SuppressWarnings("ResultOfMethodCallIgnored")
	fun sqrtCarmarkTime() {
		val random = Random(System.currentTimeMillis())
		test(1000000) {
			@Suppress("DEPRECATION")
			(sqrtCarmark(random.nextDouble() * 10000))
		}
	}

	@TestOnly
	@Test(timeout = 100)
	@SuppressWarnings("deprecation")
	fun sqrtCorrectness() {
		val random = Random(System.currentTimeMillis())
		val testNumber = random.nextDouble() * 10000
		@Suppress("DEPRECATION")
		println(sqrtCarmark(testNumber))
		println(sqrt(testNumber))
		println(StdMath.sqrt(testNumber))
		test(5000) {
			val temp = random.nextDouble()
			@Suppress("DEPRECATION")
			assertTrue(abs(sqrtCarmark(temp) - StdMath.sqrt(temp)) < 1e-5)
			assertTrue(abs(sqrt(temp) - StdMath.sqrt(temp)) < 1e-10)
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
	@TestOnly
	@Test(timeout = 100)
	fun fastPlusPowerTest() {
		assertEquals(24, fastPower(2, 10, 1000))
		assertEquals(12, fastPower(2, 9, 100))
		assertEquals(4, fastPower(2, 10, 10))
		assertEquals(289, fastPlus(233, 233, 1000))
	}

	/**
	 * abstract value
	 */
	@TestOnly
	@Test(timeout = 100)
	fun absTest() {
		val random = Random(System.currentTimeMillis())
		test(4000) {
			val anInt = random.nextInt()
			val aDouble = random.nextDouble()
			val aLong = random.nextLong()
			val aFloat = random.nextFloat()
			assertEquals(abs(anInt).toLong(), abs(anInt).toLong())
			assertEquals(abs(aLong), abs(aLong))
			assertEquals(abs(aDouble), abs(aDouble), 1e-15)
			assertEquals(abs(aFloat).toDouble(), abs(aFloat).toDouble(), 1e-15)
		}
	}

	/**
	 * min max value
	 */
	@TestOnly
	@Test(timeout = 1000)
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
					min(anInt, anInt2),
					StdMath.min(anInt, anInt2))
			assertEquals(
					min(aLong, aLong2),
					StdMath.min(aLong, aLong2))
			assertEquals(
					min(aDouble, aDouble2),
					StdMath.min(aDouble, aDouble2), 1e-15)
			assertEquals(
					min(aFloat, aFloat2),
					StdMath.min(aFloat, aFloat2), 1e-10F)
			assertEquals(
					max(anInt, anInt2),
					StdMath.max(anInt, anInt2))
			assertEquals(
					max(aLong, aLong2),
					StdMath.max(aLong, aLong2))
			assertEquals(
					max(aDouble, aDouble2),
					StdMath.max(aDouble, aDouble2), 1e-15)
			assertEquals(
					max(aFloat, aFloat2),
					StdMath.max(aFloat, aFloat2), 1e-10F)
		}
	}

	@TestOnly
	@Test(timeout = 50)
	fun logTest() {
		val random = Random(System.currentTimeMillis())
		test(5000) {
			val temp = random.nextDouble()
			assertEquals(
					ln(temp),
					StdMath.log(temp), 1e-15)
			assertEquals(
					lg(temp),
					StdMath.log10(temp), 1e-15)
		}
	}

	@TestOnly
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
			if (primes.contains(i)) assertTrue(isPrime(i))
			else assertFalse(isPrime(i))
		}
		val rand = Random(System.currentTimeMillis())
		test(1000) {
			assertFalse(isPrime(
					((abs(rand.nextInt(100)) + 2L) *
							(abs(rand.nextInt(100)) + 2L))
			))
		}
	}

	@TestOnly
	@Test(timeout = 5000)
	fun testFibVeryStrong() {
		val mod = 10007L
		val fib = RollingArray<Long>(3)
		fib[1] = 1L
		fib[2] = 1L
		test(5000) {
			fib[it + 2] = (fib[it] as Long + fib[it + 1] as Long) % mod
			assertEquals(fib[it + 2], fib(it + 2L, mod))
		}
	}

	companion object Initializer {

		@BeforeClass
		@JvmStatic
		fun loadJniLibrary() =
				Loader.loadJni()
	}
}

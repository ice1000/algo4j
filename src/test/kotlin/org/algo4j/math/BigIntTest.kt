package org.algo4j.math

import org.algo4j.div
import org.algo4j.test.loop
import org.algo4j.test.test
import org.algo4j.util.Loader
import org.jetbrains.annotations.TestOnly
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.BeforeClass
import org.junit.Test
import java.util.*
import java.math.BigInteger as StdBigInt

/**
 * Created by ice1000 on 2016/12/14.

 * @author ice1000
 */
class BigIntTest {
	@TestOnly
	@Test
	fun initTest() {
		val int = BigInt(-233)
		val stdInt = StdBigInt("-233")
		assertEquals(int.toString(), stdInt.toString())
	}

	@TestOnly
	@Test(timeout = 1000)
	fun plusTest() {
		val rand = Random(System.currentTimeMillis())
		test(1000) {
			val val1 = rand.nextInt(666666666) - 233333333
			val val2 = rand.nextInt(666666666) - 233333333
//			println("$val1, $val2")
			assertEquals(
					(val1 + val2).toString(),
					(BigInt(val1) + BigInt(val2)).toString())
		}
		assertEquals(
				"1222222222222222222222222222222222",
				(BigInt("1111111111111111111111111111111111")
						+ BigInt("111111111111111111111111111111111"))
						.toString())
	}

	@TestOnly
	@Test(timeout = 1000)
	fun stdPlusTest() {
		val rand = Random(System.currentTimeMillis())
		@Suppress("CanBeVal")
		var fuck = 100000000000000
		loop(1000) {
			val int = StdBigInt((rand.nextInt(666666666) - 233333333).toString())
			int.add(StdBigInt(rand.nextInt(223333333).toString())).toString()
			assertEquals(100000000000000, fuck)
		}
		StdBigInt("1111111111111111111111111111111111")
				.add(StdBigInt("111111111111111111111111111111111")).toString()
	}

	@TestOnly
	@Test(timeout = 50000)
	fun stdTimesTest() {
		val rand = Random(System.currentTimeMillis())
		@Suppress("CanBeVal")
		var fuck = 100000000000000
		loop(1000) {
			val int = StdBigInt((rand.nextInt(666666666) - 233333333).toString())
			(int * StdBigInt(rand.nextInt(223333333).toString())).toString()
			assertEquals(100000000000000, fuck)
		}
		loop(50) {
			val sb = StringBuilder(MathUtils.abs(rand.nextLong()).toString())
			(0..200).forEach { sb.append(MathUtils.abs(rand.nextLong()).toString()) }
			StdBigInt(sb.toString()) * StdBigInt(sb.toString())
		}
	}

	@TestOnly
	@Test(timeout = 1000)
	fun compareToTest() {
		val rand = Random(System.currentTimeMillis())
		test(1000) {
			val val1 = rand.nextInt(66666666) - 23333333
			val val2 = rand.nextInt(66666666) - 23333333
			assertEquals(
					if (val1 > val2) 1
					else if (val2 > val1) -1
					else 0,
					BigInt(val1).compareTo(BigInt(val2))
			)
		}
	}

	@TestOnly
	@Test(timeout = 1000)
	fun equalsTest() {
		val rand = Random(System.currentTimeMillis())
		test(100) {
			val num = rand.nextInt() * (if (rand.nextBoolean()) 1 else -1)
			assertTrue(BigInt(num) == BigInt(num.toString()))
		}
		assertTrue(BigInt(0) == BigInt.ZERO)
		assertTrue(BigInt("-0") == BigInt.ZERO)
	}

	@TestOnly
	@Test(timeout = 1000)
	fun minusTest() {
		val rand = Random(System.currentTimeMillis())
		test(1000) {
			val val1 = rand.nextInt(666666) - 333333
			val val2 = rand.nextInt(666666) - 333333
//			println("$val1, $val2")
			assertEquals(
					(val1 - val2).toString(),
					(BigInt(val1) - BigInt(val2)).toString())
		}
		assertEquals(
				"1000000000000000000000000000000000",
				(BigInt("1111111111111111111111111111111111") -
						BigInt("111111111111111111111111111111111"))
						.toString())
	}

	@TestOnly
	@Test(timeout = 50000)
	fun timesTest() {
		val rand = Random(System.currentTimeMillis())
		test(1000) {
			val val1 = rand.nextInt(66666) - 23333
			val val2 = rand.nextInt(66666) - 23333
//			println("$val1 $val2 -> ${val1 * val2}")
			assertEquals(
					(val1 * val2).toString(),
					(BigInt(val1) * BigInt(val2)).toString())
		}
		test(50) {
			val sb = StringBuilder(MathUtils.abs(rand.nextLong()).toString())
			(0..200).forEach { sb.append(MathUtils.abs(rand.nextLong()).toString()) }
			BigInt(sb.toString()) * BigInt(sb.toString())
		}
	}

	@TestOnly
	@Test(timeout = 1000)
	fun times10Test() {
		val rand = Random(System.currentTimeMillis())
		test(1000) {
			val boyNextDoor = rand.nextInt(Int.MAX_VALUE shr 5)
			assertEquals(
					(boyNextDoor * 10).toString(),
					(BigInt(boyNextDoor) * BigInt.TEN).toString())
			assertEquals(
					(boyNextDoor * -10).toString(),
					(BigInt(boyNextDoor) * BigInt.NEGA_TEN).toString())
		}
	}

	@TestOnly
	@Test(timeout = 1000)
	fun divideTest() {
		val rand = Random(System.currentTimeMillis())
		test(500) {
			val val1 = rand.nextInt(66666) - 23333
			val val2 = rand.nextInt(666) - 233
			if (0 == val2) return@test
			println("$val1 $val2 -> ${val1 / val2}")
			assertEquals(
					(val1 / val2).toString(),
					(BigInt(val1) / BigInt(val2)).toString())
		}
	}

	companion object Initializer {
		@JvmStatic
		@BeforeClass
		fun init() = Loader.loadJni()

		@JvmStatic
		fun main(args: Array<String>) {
			Loader.loadJni()
			println("=>>" + (BigInt(13945) / BigInt(-135)).toString())
		}
	}
}

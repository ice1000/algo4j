package org.algo4j.math

import org.algo4j.test.loop
import org.algo4j.test.test
import org.junit.Assert.assertEquals
import org.junit.BeforeClass
import org.junit.Test
import java.util.*
import java.math.BigInteger as StdBigInt

/**
 * Created by ice1000 on 2016/12/14.

 * @author ice1000
 */
class BigIntTest {
	@Test
	fun initTest() {
		val int = BigInt(-233)
		val stdInt = StdBigInt("-233")
		assertEquals(int.toString(), stdInt.toString())
	}

	@Test(timeout = 1000)
	fun plusTest() {
		val rand = Random(System.currentTimeMillis())
		test(1000) {
			val val1 = rand.nextInt(666666666) - 233333333
			val val2 = rand.nextInt(666666666) - 233333333
			println("$val1, $val2")
			assertEquals(
					(val1 + val2).toString(),
					BigInt(val1)
							.plus(BigInt(val2))
							.toString())
		}
		assertEquals(
				"1222222222222222222222222222222222",
				BigInt("1111111111111111111111111111111111")
						.plus(BigInt("111111111111111111111111111111111"))
						.toString())
	}

	@Test(timeout = 1000)
	fun stdPlusTest() {
		val rand = Random(System.currentTimeMillis())
		val fuck: Long by lazy { 100000000000000 }
		loop(1000) {
			val int = StdBigInt((rand.nextInt(666666666) - 233333333).toString())
			int.add(StdBigInt(rand.nextInt(223333333).toString())).toString()
			assertEquals(100000000000000, fuck)
		}
		StdBigInt("1111111111111111111111111111111111")
				.add(StdBigInt("111111111111111111111111111111111")).toString()
	}

	@Test(timeout = 1000)
	fun stdTimesTest() {
		val rand = Random(System.currentTimeMillis())
		val fuck: Long by lazy { 100000000000000 }
		loop(1000) {
			val int = StdBigInt((rand.nextInt(666666666) - 233333333).toString())
			int.times(StdBigInt(rand.nextInt(223333333).toString())).toString()
			assertEquals(100000000000000, fuck)
		}
		StdBigInt("1111111111111111111111111111111111")
				.times(StdBigInt("111111111111111111111111111111111")).toString()
	}

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

	@Test(timeout = 1000)
	fun minusTest() {
		val rand = Random(System.currentTimeMillis())
		test(1000) {
			val val1 = rand.nextInt(666666) - 133333
			val val2 = rand.nextInt(666666) - 133333
			println("$val1, $val2")
			assertEquals(
					(val1 - val2).toString(),
					BigInt(val1)
							.minus(BigInt(val2))
							.toString())
		}
		assertEquals(
				"1000000000000000000000000000000000",
				BigInt("1111111111111111111111111111111111")
						.minus(BigInt("111111111111111111111111111111111"))
						.toString())
	}

	@Test(timeout = 1000)
	fun timesTest() {
		val rand = Random(System.currentTimeMillis())
		test(1000) {
			val val1 = rand.nextInt(66666) - 23333
			val val2 = rand.nextInt(66666) - 23333
//			println("$val1 $val2 -> ${val1 * val2}")
			assertEquals(
					(val1 * val2).toString(),
					BigInt(val1)
							.times(BigInt(val2))
							.toString())
		}
	}

	companion object Initializer {
		@JvmStatic
		@BeforeClass
		fun init() {
			Random(System.currentTimeMillis())
			System.loadLibrary("jni")
		}
	}
}

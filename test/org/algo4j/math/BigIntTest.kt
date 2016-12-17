package org.algo4j.math

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
class BigIntTest() {
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
			val val1 = rand.nextInt(233333)
			val val2 = rand.nextInt(233333)
//			println("$val1, $val2")
			assertEquals(
					(val1 + val2).toString(),
					BigInt(val1)
							.plus(BigInt(val2))
							.toString())
		}
		assertEquals(
				BigInt("1111111111111111111111111111111111")
						.plus(BigInt("111111111111111111111111111111111"))
						.toString(),
				"1222222222222222222222222222222222")
	}

	@Test(timeout = 1000)
	fun minusTest() {
		val rand = Random(System.currentTimeMillis())
	}

	companion object Initializer {
		@JvmStatic
		@BeforeClass
		fun init() {
			System.loadLibrary("jni")
		}
	}
}

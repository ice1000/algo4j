package org.algo4j.math

import org.junit.Assert.assertEquals
import org.junit.BeforeClass
import org.junit.Test
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

	@Test
	fun plusTest() {
		val int = BigInt(2333)
		println(int.plus(BigInt(12)).toString())
	}

	companion object Initializer {
		@JvmStatic
		@BeforeClass
		fun init() {
			System.loadLibrary("jni")
		}
	}
}

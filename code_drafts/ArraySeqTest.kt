package org.algo4j.collections

import org.algo4j.math.MathUtils
import org.algo4j.math.value.ExgcdRes
import org.jetbrains.annotations.TestOnly
import org.junit.Assert.*
import org.junit.BeforeClass
import org.junit.Test

/**
 * Created by ice1000 on 2017/1/4.

 * @author ice1000
 */
class ArraySeqTest {
	@TestOnly
	@Test(timeout = 10)
	fun initTest() {
		ArraySeq<Int>()
	}

	@TestOnly
	@Test(timeout = 10)
	fun addTest() {
		ArraySeq<Int>().run {
			assertEquals(0, size)
			add(233)
			assertEquals(1, size)
			add(666)
			assertEquals(2, size)
			add(450)
			assertEquals(3, size)
		}
	}

	@TestOnly
	@Test(timeout = 10)
	fun containsTest() {
		ArraySeq<ExgcdRes>().run {
			val a = ExgcdRes(10, 0, 1)
			add(MathUtils.exgcd(10, 10))
			add(a)
			assertTrue(contains(a))
			assertFalse(contains(ExgcdRes(1, 1, 1)))
		}
	}

	companion object Initializer {
		@JvmStatic
		@TestOnly
		@BeforeClass
		fun init() {
			System.loadLibrary("jni")
		}
	}
}

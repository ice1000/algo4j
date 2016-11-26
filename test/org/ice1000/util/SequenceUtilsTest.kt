package org.ice1000.util

import org.junit.Assert.assertArrayEquals
import org.junit.BeforeClass
import org.junit.Test
import java.util.*

/**
 * Created by ice1000 on 2016/11/17.

 * @author ice1000
 */
class SequenceUtilsTest {

	@Test(timeout = 100)
	fun test() {
		val ints = intArrayOf(33, 1, 100, 20, 43, 43)
		SequenceUtils.discretization(ints)
		println(Arrays.toString(ints))
		assertArrayEquals(intArrayOf(2, 0, 4, 1, 3, 3), ints)
//		for (int i = 0; i < sum.length - 1; i++) assertEquals(ints[i], sum.data[i+1]);
//		assertEquals(5, sum.query());
	}

	companion object {
		@BeforeClass
		@JvmStatic
		fun loadJniLibrary() {
			System.loadLibrary("jni")
		}

		@JvmStatic
		fun main(args: Array<String>) {
			loadJniLibrary()
			SequenceUtilsTest().test()
		}
	}
}

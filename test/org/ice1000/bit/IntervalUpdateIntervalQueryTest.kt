package org.ice1000.bit

import org.junit.Assert.assertEquals
import org.junit.BeforeClass
import org.junit.Test

/**
 * Created by ice1000 on 2016/11/18.

 * @author ice1000
 */
class IntervalUpdateIntervalQueryTest {

	/**
	 * data:
	 * http://www.codevs.cn/problem/1082/
	 */
	@Test
	fun test() {
		val bit = IntervalUpdateIntervalQuery(3, 1, 2, 3, 2)
		bit.update(2, 3, 2)
		assertEquals(9, bit.query(2, 3))
	}

	companion object Initializer {
		@BeforeClass
		@JvmStatic
		fun loadJniLibrary() {
			System.loadLibrary("jni")
		}
	}
}

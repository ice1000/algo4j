package org.ice1000.graph

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.BeforeClass
import org.junit.Test

/**
 * Created by ice1000 on 2016/11/19.

 * @author ice1000
 */
class UnionSetTest {

	/**
	 * data from:
	 * http://codevs.cn/problem/1073/
	 */
	@Test
	fun test() {
		val set = UnionSet(6)
		set.merge(1, 2)
		set.merge(1, 5)
		set.merge(3, 4)
		set.merge(5, 2)
		set.merge(1, 3)
		assertTrue(set.isConnected(1, 4))
		assertTrue(set.isConnected(2, 3))
		assertFalse(set.isConnected(5, 6))
	}

	companion object Initializer {
		@BeforeClass
		@JvmStatic
		fun loadJniLibrary() {
			System.loadLibrary("jni")
		}
	}
}

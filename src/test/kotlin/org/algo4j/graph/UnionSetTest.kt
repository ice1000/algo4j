package org.algo4j.graph

import org.jetbrains.annotations.TestOnly
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.BeforeClass
import org.junit.Test

/**
 * Created by algo4j on 2016/11/19.

 * @author algo4j
 */
class UnionSetTest {

	/**
	 * data from:
	 * http://codevs.cn/problem/1073/
	 */
	@TestOnly
	@Test(timeout = 100)
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

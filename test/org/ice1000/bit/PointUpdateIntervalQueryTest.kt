package org.ice1000.bit

import org.junit.Assert.assertEquals
import org.junit.BeforeClass
import org.junit.Test

/**
 * Created by ice1000 on 2016/11/16.

 * @author ice1000
 */
class PointUpdateIntervalQueryTest {

	/**
	 * data from:
	 * http://www.codevs.cn/problem/1080/
	 */
	@Test(timeout = 200)
	fun test() {
		val tree = BinaryIndexedTree(10)
		tree.add(1, 4)
		tree.add(2, 5)
		tree.add(3, 6)
		tree.add(4, 2)
		tree.add(5, 1)
		tree.add(6, 3)
		tree.add(7, 4)
		tree.add(3, 5)
		assertEquals(14, tree.sum(3, 5))
		tree.add(1, 9)
		assertEquals(22, tree.sum(2, 6))
	}

	companion object Initializer {
		@BeforeClass
		@JvmStatic
		fun loadJniLibrary() {
			System.loadLibrary("jni")
		}
	}

}

package org.ice1000.bit

import org.junit.Assert.assertEquals
import org.junit.BeforeClass
import org.junit.Test

/**
 * Created by ice1000 on 2016/11/16.

 * @author ice1000
 */
class IntervalUpdatePointQueryTest {

	/**
	 * test
	 * data: I make it myself
	 */
	@Test(timeout = 100)
	fun test() {
		val tree = IntervalUpdatePointQuery(30)
		tree.update(10, 20, 5)
		tree.update(15, 25, 15)
		assertEquals(20, tree.query(15))
		assertEquals(20, tree.query(17))
		assertEquals(20, tree.query(20))
		assertEquals(20, tree.query(17))

		tree.update(1, 15, 1)
		assertEquals(6, tree.query(12))
	}

	companion object {

		@BeforeClass
		@JvmStatic
		fun loadJniLibrary() {
			System.loadLibrary("jni")
		}
	}

}

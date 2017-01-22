package org.algo4j.graph

import org.junit.BeforeClass
import org.junit.Test

/**
 * Created by ice1000 on 2017/1/22.
 *
 * @author ice1000
 */
class HeapTest {
	@Test
	fun testMake() {
		val heap = Heap.make(1, 2, 3, 4, 5)
	}

	companion object {
		@JvmStatic
		@BeforeClass
		fun init() {
			System.loadLibrary("jni")
		}
	}
}
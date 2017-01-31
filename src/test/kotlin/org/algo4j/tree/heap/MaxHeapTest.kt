package org.algo4j.tree.heap

import org.algo4j.get
import org.algo4j.test.optional
import org.algo4j.util.Loader
import org.jetbrains.annotations.TestOnly
import org.junit.BeforeClass
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

/**
 * Created by ice1000 on 2017/1/31.

 * @author ice1000
 */
class MaxHeapTest {
	@TestOnly
	@Test(timeout = 1000)
	fun testMake() {
		val heap = MaxHeap.make(1000, 233, 33, 41, 25, 6, 7)
		optional(true) {
			for (i in 1..heap.size()) {
				println(heap[i])
			}
		}
	}

	@Test(timeout = 1000)
	fun testMinHeapify() {
		val heap = MaxHeap.make(100, 342, 432, 45, 4, 54, 65)
		assertEquals(432, heap.peek())
		assertEquals(342, heap.peek())
		assertEquals(100, heap.peek())
		assertEquals(65, heap.peek())
		assertEquals(54, heap.peek())
		assertEquals(45, heap.peek())
		assertEquals(4, heap.peek())
		assertTrue { heap.empty() }
	}

	companion object Initializer {
		@JvmStatic
		@BeforeClass
		fun init() {
			System.loadLibrary(Loader.JNI_LIB_NAME)
		}
	}
}
package org.algo4j.linear

import org.algo4j.tree.heap.MinHeap
import org.algo4j.util.Loader
import org.jetbrains.annotations.TestOnly
import org.junit.BeforeClass
import org.junit.Test
import kotlin.test.assertEquals

/**
 * Created by ice1000 on 2017/1/27.
 *
 * @author ice1000
 */
class IntPriorityQueueTest {
	@Test
	fun make() {
		val heap = MinHeap.make(43, 2, 2234, 23, 4, 4234, 5)
		val heap2 = IntPriorityQueue.make(43, 2, 2234, 23, 4, 4234, 5)
		assertEquals(heap, heap2)
	}

	companion object Initializer {
		@TestOnly
		@JvmStatic
		@BeforeClass
		fun init() {
			System.loadLibrary(Loader.JNI_LIB_NAME)
		}
	}
}
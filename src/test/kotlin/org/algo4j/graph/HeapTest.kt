package org.algo4j.graph

import org.algo4j.get
import org.algo4j.plusAssign
import org.algo4j.test.optional
import org.algo4j.test.println
import org.jetbrains.annotations.TestOnly
import org.junit.BeforeClass
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

/**
 * Created by ice1000 on 2017/1/22.
 *
 * @author ice1000
 */
class HeapTest {
	@TestOnly
	@Test(timeout = 1000)
	fun testMake() {
		val heap = Heap.make(1000, 233, 33, 41, 25, 6, 7)
		optional(true) {
			for (i in 1..heap.size()) {
				println(heap[i])
			}
		}
	}

	@TestOnly
	@Test(timeout = 1000)
	fun testInsert() {
		val heap = Heap(100)
		assertTrue(heap.empty())
		heap += 1000
		heap += 233
		heap += 33
		heap += 41
		heap += 25
		heap += 6
		heap += 7
		val heap2 = Heap.make(1000, 233, 33, 41, 25, 6, 7)
		(1..heap.size()).forEach {
			// assertEquals(heap2[it], heap[it])
			println(heap[it])
		}
		println("")
		(1..heap2.size()).forEach {
			println(heap2[it])
		}
	}

	@Test
	fun testMinHeapify() {
		val heap = Heap.make(100, 342, 432, 45, 4, 54, 65)
		assertEquals(4, heap.peek().println())
		assertEquals(45, heap.peek().println())
		assertEquals(54, heap.peek().println())
		assertEquals(65, heap.peek().println())
		assertEquals(100, heap.peek().println())
		assertEquals(342, heap.peek().println())
		assertEquals(432, heap.peek().println())
		assertTrue { heap.empty() }
	}

	companion object {
		@JvmStatic
		@BeforeClass
		fun init() {
			System.loadLibrary("jni")
		}
	}
}
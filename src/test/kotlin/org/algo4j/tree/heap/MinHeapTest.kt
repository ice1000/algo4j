package org.algo4j.tree.heap

import org.algo4j.get
import org.algo4j.plusAssign
import org.algo4j.test.optional
import org.algo4j.test.shuffledIntList
import org.algo4j.test.test
import org.algo4j.util.Loader
import org.algo4j.util.SeqUtils.sortMerge
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
class MinHeapTest {
	@TestOnly
	@Test(timeout = 1000)
	fun testMake() {
		val heap = MinHeap.make(1000, 233, 33, 41, 25, 6, 7)
		optional(false) {
			for (i in 1..heap.size()) {
				println(heap[i])
			}
		}
	}

	@TestOnly
	@Test(timeout = 1000)
	fun testInsert() {
		val heap = MinHeap(100)
		assertTrue(heap.empty())
		heap += 1000
		heap += 233
		heap += 33
		heap += 41
		heap += 25
		heap += 6
		heap += 7
		val heap2 = MinHeap.make(1000, 233, 33, 41, 25, 6, 7)
		optional(false) {
			(1..heap.size()).forEach {
				// assertEquals(heap2[it], heap[it])
				println(heap[it])
			}
			println("")
			(1..heap2.size()).forEach {
				println(heap2[it])
			}
		}
	}


	@Test(timeout = 1000)
	fun testMinHeapify() {
		val heap = MinHeap.make(100, 342, 432, 45, 4, 54, 65)
		assertEquals(4, heap.peek())
		assertEquals(45, heap.peek())
		assertEquals(54, heap.peek())
		assertEquals(65, heap.peek())
		assertEquals(100, heap.peek())
		assertEquals(342, heap.peek())
		assertEquals(432, heap.peek())
		assertTrue { heap.empty() }
	}

	@Test(timeout = 4000)
	fun testMinHeapifyStrong() {
		test(400) {
			val arr = shuffledIntList.toIntArray()
			val heap = MinHeap.make(*arr)
			optional(false) {
				println(arr.size)
				println(heap.size())
			}
			sortMerge(arr)
			(1..heap.size()).forEach {
				assertEquals(arr[it - 1], heap.peek())
			}
		}
	}

	companion object Init {
		@JvmStatic
		@BeforeClass
		fun init() = Loader.loadJni()
	}
}

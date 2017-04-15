package org.algo4j.linear

import org.algo4j.util.Loader
import org.jetbrains.annotations.TestOnly
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.BeforeClass
import org.junit.Test

/**
 * Created by ice1000 on 2017/1/11.

 * @author ice1000
 */
class QueueTest {
	@TestOnly
	@Test(timeout = 1000)
	fun test() {
		val queue = Queue<Int>()
		queue.push(233)
		queue.push(666)
		queue.push(123)
		assertEquals(233, queue.top())
		queue.pop()
		assertEquals(666, queue.top())
		queue.pop()
		assertEquals(123, queue.top())
		queue.pop()
		assertTrue(queue.empty())
	}

	companion object Initializer {
		@TestOnly
		@JvmStatic
		@BeforeClass
		fun init() {
			Loader.loadJni()
		}
	}
}

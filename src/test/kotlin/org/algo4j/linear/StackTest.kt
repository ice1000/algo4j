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
class StackTest {
	@TestOnly
	@Test(timeout = 1000)
	fun test() {
		val stack = Stack<Int>()
		stack.push(233)
		stack.push(666)
		stack.push(123)
		assertEquals(123, stack.top())
		assertEquals(123, stack.pop())
		assertEquals(666, stack.pop())
		assertEquals(233, stack.pop())
		assertTrue(stack.empty())
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

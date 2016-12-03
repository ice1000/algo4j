package org.ice1000.bit

import org.ice1000.math.MathUtils
import org.ice1000.test.loop
import org.junit.Assert.assertEquals
import org.junit.BeforeClass
import org.junit.Test
import java.util.*

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

	@Test(timeout = 1000)
	fun strongTest() {
		val max = 300
		val bruteForce = LongArray(max)
		val bit = IntervalUpdatePointQuery(max)
		val rand = Random(System.currentTimeMillis())
		loop(10000) {
			var num1 = MathUtils.abs(rand.nextInt(max) - 2) + 2
			var num2 = MathUtils.abs(rand.nextInt(max) - 2) + 2
			if (num2 < num1) {
				val tmp = num1
				num1 = num2
				num2 = tmp
			}
			val value = rand.nextLong()
			(num1..num2).forEach { i -> bruteForce[i] += value}
			bit.update(num1, num2, value)
		}
		loop(10000) {
			val index = rand.nextInt(max - 2) + 2
			assertEquals(bruteForce[index], bit.query(index))
		}
	}

	companion object Initializer {

		@BeforeClass
		@JvmStatic
		fun loadJniLibrary() {
			System.loadLibrary("jni")
		}
	}

}

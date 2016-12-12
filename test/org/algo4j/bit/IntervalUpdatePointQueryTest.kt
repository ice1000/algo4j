package org.algo4j.bit

import org.algo4j.math.MathUtils
import org.algo4j.test.test
import org.algo4j.test.loop
import org.junit.Assert.assertEquals
import org.junit.BeforeClass
import org.junit.Test
import java.util.*

/**
 * Created by algo4j on 2016/11/16.

 * @author algo4j
 */
class IntervalUpdatePointQueryTest {

	/**
	 * discretizationTest
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
		val bruteForce = BruteForce(max)
		val bit = IntervalUpdatePointQuery(max)
		val rand = Random(System.currentTimeMillis())
		test(1000) {
			loop(10) {
				var num1 = MathUtils.abs(rand.nextInt(max) - 2) + 2
				var num2 = MathUtils.abs(rand.nextInt(max) - 2) + 2
				if (num2 < num1) {
					val tmp = num1
					num1 = num2
					num2 = tmp
				}
				val value = rand.nextLong()
				bruteForce.update(num1, num2, value)
				bit.update(num1, num2, value)
			}
			loop(10) {
				val index = rand.nextInt(max - 2) + 2
				assertEquals(bruteForce.query(index), bit.query(index))
			}
		}
	}

	/**
	 * brute force implementation of binary indexed tree.
	 */
	private inner class BruteForce(length: Int) {
		private val data = LongArray(length)

		/**
		 * standard update operation
		 */
		fun update(from: Int, to: Int, value: Long) {
			(from..to).forEach { i -> data[i] += value }
		}

		/**
		 * standard query operation
		 */
		fun query(index: Int) = data[index]
	}

	companion object Initializer {

		@BeforeClass
		@JvmStatic
		fun loadJniLibrary() {
			System.loadLibrary("jni")
		}
	}

}

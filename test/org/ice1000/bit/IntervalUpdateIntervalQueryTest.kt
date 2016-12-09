package org.ice1000.bit

import org.ice1000.math.MathUtils
import org.ice1000.test.loop
import org.ice1000.test.test
import org.junit.Assert.assertEquals
import org.junit.BeforeClass
import org.junit.Test
import java.util.*

/**
 * Created by ice1000 on 2016/11/18.

 * @author ice1000
 */
class IntervalUpdateIntervalQueryTest {

	/**
	 * data:
	 * http://www.codevs.cn/problem/1082/
	 */
	@Test
	fun test() {
		val bit = IntervalUpdateIntervalQuery(3, 1, 2, 3, 2)
		bit.update(2, 3, 2)
		assertEquals(9, bit.query(2, 3))
	}

	@Test(timeout = 1000)
	fun strongTest() {
		val max = 300
		val bruteForce = BruteForce(max)
		val bit = IntervalUpdateIntervalQuery(max)
		val rand = Random(System.currentTimeMillis())
		test(200) {
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
			loop(100) {
				var num1 = MathUtils.abs(rand.nextInt(max) - 2) + 2
				var num2 = MathUtils.abs(rand.nextInt(max) - 2) + 2
				if (num2 < num1) {
					val tmp = num1
					num1 = num2
					num2 = tmp
				}
				assertEquals(bruteForce.query(num1, num2), bit.query(num1, num2))
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
		fun query(from: Int, to: Int): Long {
			var ret = 0L
			(from..to).forEach { i -> ret += data[i] }
			return ret
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

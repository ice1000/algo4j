package org.algo4j.bit

import org.algo4j.math.MathUtils
import org.algo4j.test.loop
import org.algo4j.test.test
import org.jetbrains.annotations.Contract
import org.jetbrains.annotations.TestOnly
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
	@TestOnly
	@Test(timeout = 100)
	fun test() {
		val bit = IntervalUpdateIntervalQuery(1, 2, 3, 2)
		bit.update(2, 3, 2)
		assertEquals(9, bit.query(2, 3))
	}

	@TestOnly
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
	private inner class BruteForce
	@TestOnly
	internal constructor(length: Int) {
		private val data = LongArray(length)

		/**
		 * standard update operation
		 */
		@TestOnly
		@Contract(pure = false)
		internal fun update(from: Int, to: Int, value: Long) {
			(from..to).forEach { data[it] += value }
		}

		/**
		 * standard query operation
		 */
		@TestOnly
		@Contract(pure = true)
		internal fun query(from: Int, to: Int): Long {
			var ret = 0L
			(from..to).forEach { ret += data[it] }
			return ret
		}

		@TestOnly
		@Contract(pure = true)
		internal operator fun get(left: Int, right: Int) = query(left, right)
	}

	companion object Initializer {
		@BeforeClass
		@JvmStatic
		fun loadJniLibrary() {
			System.loadLibrary("jni")
		}
	}
}

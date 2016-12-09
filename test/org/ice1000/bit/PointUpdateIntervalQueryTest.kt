package org.ice1000.bit

import org.ice1000.math.MathUtils
import org.ice1000.test.loop
import org.ice1000.test.test
import org.junit.Assert.assertEquals
import org.junit.BeforeClass
import org.junit.Test
import java.util.*

/**
 * Created by ice1000 on 2016/11/16.

 * @author ice1000
 */
class PointUpdateIntervalQueryTest {

	/**
	 * data from:
	 * http://www.codevs.cn/problem/1080/
	 */
	@Test(timeout = 200)
	fun test() {
		val tree = BinaryIndexedTree(10)
		tree.add(1, 4)
		tree.add(2, 5)
		tree.add(3, 6)
		tree.add(4, 2)
		tree.add(5, 1)
		tree.add(6, 3)
		tree.add(7, 4)
		tree.add(3, 5)
		assertEquals(14, tree.sum(3, 5))
		tree.add(1, 9)
		assertEquals(22, tree.sum(2, 6))
	}

	@Test(timeout = 1000)
	fun strongTest() {
		val max = 300
		val bruteForce = BruteForce(max)
		val bit = BinaryIndexedTree(max)
		val rand = Random(System.currentTimeMillis())
		test(1000) {
			loop(10) {
				val index = rand.nextInt(max - 2) + 2
				val value = rand.nextLong()
				bruteForce.add(index, value)
				bit.add(index, value)
			}
			loop(10) {
				var num1 = MathUtils.abs(rand.nextInt(max) - 2) + 2
				var num2 = MathUtils.abs(rand.nextInt(max) - 2) + 2
				if (num2 < num1) {
					val tmp = num1
					num1 = num2
					num2 = tmp
				}
				assertEquals(bruteForce.sum(num1, num2), bit.sum(num1, num2))
			}
		}
	}

	/**
	 * brute force implementation of binary indexed tree.
	 */
	private inner class BruteForce(length: Int) {
		private val data = LongArray(length)

		/**
		 * standard add operation
		 */
		fun add(index: Int, value: Long) {
			data[index] += value
		}

		/**
		 * standard sum operation
		 */
		fun sum(from: Int, to: Int): Long {
			var ret = 0L
			(from..to).forEach { i -> ret += data[i] }
			return ret
		}

		fun sum(index: Int) = sum(1, index)
	}

	companion object Initializer {
		@BeforeClass
		@JvmStatic
		fun loadJniLibrary() {
			System.loadLibrary("jni")
		}
	}

}

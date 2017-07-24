package org.algo4j.tree.bit

import org.algo4j.get
import org.algo4j.math.MathUtils.abs
import org.algo4j.test.loop
import org.algo4j.test.test
import org.algo4j.util.Loader
import org.jetbrains.annotations.Contract
import org.jetbrains.annotations.TestOnly
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
	@TestOnly
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
		assertEquals(14, tree[3, 5])
		tree.add(1, 9)
		assertEquals(22, tree[2, 6])
	}

	@TestOnly
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
				var num1 = abs(rand.nextInt(max) - 2) + 2
				var num2 = abs(rand.nextInt(max) - 2) + 2
				if (num2 < num1) {
					val tmp = num1
					num1 = num2
					num2 = tmp
				}
				assertEquals(bruteForce[num1, num2], bit[num1, num2])
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
		 * standard accumulate operation
		 */
		@TestOnly
		fun add(index: Int, value: Long) {
			data[index] += value
		}

		/**
		 * standard sum operation
		 */
		@TestOnly
		@Contract(pure = true)
		fun sum(from: Int, to: Int): Long {
			var ret = 0L
			(from..to).forEach { ret += data[it] }
			return ret
		}

		@TestOnly
		@Contract(pure = true)
		internal operator fun get(left: Int, right: Int) = sum(left, right)

		@TestOnly
		@Contract(pure = true)
		internal operator fun get(index: Int) = sum(index)

		@TestOnly
		@Contract(pure = true)
		internal fun sum(index: Int) = sum(1, index)
	}

	companion object Initializer {
		@BeforeClass
		@JvmStatic
		fun loadJniLibrary() = Loader.loadJni()
	}

}

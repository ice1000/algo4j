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
class IntervalUpdatePointQueryTest {

	/**
	 * discretizationTest
	 * data: I make it myself
	 */
	@TestOnly
	@Test(timeout = 100)
	fun test() {
		val tree = IntervalUpdatePointQuery(30)
		tree[10, 20] += 5
		tree[15, 25] += 15
		assertEquals(20, tree[15])
		assertEquals(20, tree[17])
		assertEquals(20, tree[20])
		assertEquals(20, tree[17])

		tree.update(1, 15, 1)
		assertEquals(6, tree[12])
	}

	@TestOnly
	@Test(timeout = 1000)
	fun strongTest() {
		val max = 300
		val bruteForce = BruteForce(max)
		val bit = IntervalUpdatePointQuery(max)
		val rand = Random(System.currentTimeMillis())
		test(1000) {
			loop(10) {
				var num1 = abs(rand.nextInt(max) - 2) + 2
				var num2 = abs(rand.nextInt(max) - 2) + 2
				if (num2 < num1) {
					val tmp = num1
					num1 = num2
					num2 = tmp
				}
				val value = rand.nextLong()
				bruteForce.update(num1, num2, value)
				bit[num1, num2] += value
			}
			loop(10) {
				val index = rand.nextInt(max - 2) + 2
				assertEquals(bruteForce[index], bit[index])
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
		internal fun query(index: Int) = data[index]

		@TestOnly
		@Contract(pure = true)
		internal operator fun get(index: Int) = query(index)
	}

	companion object Initializer {

		@BeforeClass
		@JvmStatic
		fun loadJniLibrary() = Loader.loadJni()
	}

}

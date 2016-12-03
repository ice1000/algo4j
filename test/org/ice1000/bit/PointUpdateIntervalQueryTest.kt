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
		val bruteForce = LongArray(max)
		val bit = BinaryIndexedTree(max)
		val rand = Random(System.currentTimeMillis())
		loop(10000) {
			val index = rand.nextInt(max - 2) + 2
			val value = rand.nextLong()
			bruteForce[index] += value
			bit.add(index, value)
		}
		loop(10000) {
			var num1 = MathUtils.abs(rand.nextInt(max) - 2) + 2
			var num2 = MathUtils.abs(rand.nextInt(max) - 2) + 2
			if (num2 < num1) {
				val tmp = num1
				num1 = num2
				num2 = tmp
			}
			var res = 0L
			(num1..num2).forEach { i -> res += bruteForce[i] }
			assertEquals(res, bit.sum(num1, num2))
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

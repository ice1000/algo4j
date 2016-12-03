package org.ice1000.bit

import org.ice1000.math.MathUtils
import org.ice1000.test.loop
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
		val bruteForce = LongArray(max)
		val bit = IntervalUpdateIntervalQuery(max)
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
			(num1..num2).forEach { i -> bruteForce[i] += value }
			bit.update(num1, num2, value)
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
			assertEquals(res, bit.query(num1, num2))
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

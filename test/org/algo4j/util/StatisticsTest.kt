package org.algo4j.util

import org.algo4j.math.MathUtils
import org.algo4j.test.shuffledIntList
import org.algo4j.test.test
import org.junit.Assert.assertEquals
import org.junit.BeforeClass
import org.junit.Test

/**
 * Created by ice1000 on 2016/12/13.

 * @author ice1000
 */
class StatisticsTest {
	@Test(timeout = 1000)
	fun sumTest() {
		test(1000) {
			val list = shuffledIntList
			var sum = 0
			list.forEach { sum += it }
			assertEquals(sum, Statistics.sum(list.toIntArray()))
		}
	}

	@Test(timeout = 1000)
	fun avgTest() {
		test(1000) {
			val list = shuffledIntList
			var avg = 0.0
			list.forEach { avg += it }
			assertEquals(
					avg / list.size,
					Statistics.avg(list.toIntArray()), 1e-10)
		}
	}

	@Test(timeout = 1000)
	fun minMaxTest() {
		test(1000) {
			val list = shuffledIntList
			var min = list[0]
			var max = list[0]
			list.forEach {
				min = MathUtils.min(min, it)
				max = MathUtils.max(max, it)
			}
			assertEquals(max, Statistics.max(list.toIntArray()))
			assertEquals(min, Statistics.min(list.toIntArray()))
		}
	}

	@Test(timeout = 1000)
	fun stdDivTest() {
		test(1000) {
			val list = shuffledIntList
			var avg = 0.0
			list.forEach { avg += it }
			avg /= list.size
			var stdDiv = 0.0
			list.forEach { stdDiv += MathUtils.abs(it - avg) }
			assertEquals(
					stdDiv / list.size,
					Statistics.stdDiv(list.toIntArray()), 1e-12)
		}
	}

	companion object Initializer {
		@JvmStatic
		@BeforeClass
		fun init() {
			System.loadLibrary("jni")
		}
	}
}

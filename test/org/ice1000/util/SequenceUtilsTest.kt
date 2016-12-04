package org.ice1000.util

import org.ice1000.test.test
import org.junit.Assert.assertArrayEquals
import org.junit.BeforeClass
import org.junit.Test
import java.util.*

/**
 * Created by ice1000 on 2016/11/17.
 *
 * @author ice1000
 */
class SequenceUtilsTest {

	@Test(timeout = 500)
	fun discretizationTest() {
		val ints = intArrayOf(33, 1, 100, 20, 43, 43)
		SequenceUtils.discretization(ints)
		println(Arrays.toString(ints))
		assertArrayEquals(intArrayOf(2, 0, 4, 1, 3, 3), ints)
//		for (int i = 0; i < sum.length - 1; i++) assertEquals(ints[i], sum.data[i+1]);
//		assertEquals(5, sum.query());
	}

	@Test(timeout = 1000)
	fun sortBubbleTest() {
		test(5000) {
			val data = shuffledArray
			val res1 = data.toIntArray()
			Arrays.sort(res1)
			val res2 = data.toIntArray()
			SequenceUtils.sortBubble(res2)
			assertArrayEquals(res1, res2)
		}
	}

	@Test(timeout = 1000)
	fun sortInsertionTest() {
		test(5000) {
			val data = shuffledArray
			val res1 = data.toIntArray()
			Arrays.sort(res1)
			val res2 = data.toIntArray()
			SequenceUtils.sortInsertion(res2)
			assertArrayEquals(res1, res2)
		}
	}

	@Test(timeout = 1000)
	fun sortQuickTest() {
		test(10000) {
//			it.println()
			val data = shuffledArray
			val res1 = data.toIntArray()
			Arrays.sort(res1)
			val res2 = data.toIntArray()
			SequenceUtils.sortQuick(res2)
//			try {
			assertArrayEquals(res1, res2)
//			} catch (e: Exception) {
//				SequenceUtils.toString(res1).println()
//				SequenceUtils.toString(res2).println()
//			}
		}
	}

	companion object Initializer {
		@BeforeClass
		@JvmStatic
		fun loadJniLibrary() {
			System.loadLibrary("jni")
		}

		val bound = 2333
		val shuffledArray: List<Int>
			get() {
				val rand = Random(System.currentTimeMillis())
				return listOf(
						rand.nextInt(bound), rand.nextInt(bound), rand.nextInt(bound),
						rand.nextInt(bound), rand.nextInt(bound), rand.nextInt(bound),
						rand.nextInt(bound), rand.nextInt(bound), rand.nextInt(bound),
						rand.nextInt(bound), rand.nextInt(bound), rand.nextInt(bound),
						rand.nextInt(bound), rand.nextInt(bound), rand.nextInt(bound),
						rand.nextInt(bound), rand.nextInt(bound), rand.nextInt(bound),
						rand.nextInt(bound), rand.nextInt(bound), rand.nextInt(bound),
						rand.nextInt(bound), rand.nextInt(bound), rand.nextInt(bound),
						rand.nextInt(bound), rand.nextInt(bound), rand.nextInt(bound),
						rand.nextInt(bound), rand.nextInt(bound), rand.nextInt(bound)
				)
			}

		@JvmStatic
		fun main(args: Array<String>) {
			loadJniLibrary()
			SequenceUtilsTest().discretizationTest()
		}
	}
}

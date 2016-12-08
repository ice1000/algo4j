package org.ice1000.util

import org.ice1000.test.println
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
		val result = intArrayOf(2, 0, 4, 1, 3, 3)
		SequenceUtils
				.discretization(ints)
		SequenceUtils
				.toString(ints)
				.println()
		assertArrayEquals(result, ints)
		val doubles = ints
				.map(Int::toDouble)
				.toDoubleArray()
		SequenceUtils
				.discretization(doubles)
		SequenceUtils
				.toString(doubles)
				.println()
		assertArrayEquals(
				result
						.map(Int::toDouble)
						.toDoubleArray(),
				doubles,
				1e-10
		)
	}

	@JvmOverloads
	fun sortTest(
			sortInt: (IntArray) -> Unit,
			sortDouble: (DoubleArray) -> Unit,
			times: Int = 5000) {
		test(times) {
			val data1 = shuffledIntList
			val res11 = data1.toIntArray()
			Arrays.sort(res11)
			val res12 = data1.toIntArray()
			sortInt(res12)
			assertArrayEquals(res11, res12)
			val data2 = shuffledDoubleList
			val res21 = data2.toDoubleArray()
			Arrays.sort(res21)
			val res22 = data2.toDoubleArray()
			sortDouble(res22)
			assertArrayEquals(res21, res22, 1e-10)
		}
	}

	@Test(timeout = 1000)
	fun sortBubbleTest() =
			sortTest(SequenceUtils::sortBubble, SequenceUtils::sortBubble)

	@Test(timeout = 1000)
	fun sortInsertionTest() =
			sortTest(SequenceUtils::sortInsertion, SequenceUtils::sortInsertion)

	@Test(timeout = 1000)
	fun sortQuickTest() =
			sortTest(SequenceUtils::sortQuick, SequenceUtils::sortQuick)

	companion object Initializer {
		@BeforeClass
		@JvmStatic
		fun loadJniLibrary() {
			System.loadLibrary("jni")
		}

		val bound = 2333
		val shuffledIntList: List<Int>
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

		val shuffledDoubleList: List<Double>
			get() {
				val rand = Random(System.currentTimeMillis())
				return listOf(
						rand.nextDouble() * 1000, rand.nextDouble() * 1000, rand.nextDouble() * 1000,
						rand.nextDouble() * 1000, rand.nextDouble() * 1000, rand.nextDouble() * 1000,
						rand.nextDouble() * 1000, rand.nextDouble() * 1000, rand.nextDouble() * 1000,
						rand.nextDouble() * 1000, rand.nextDouble() * 1000, rand.nextDouble() * 1000,
						rand.nextDouble() * 1000, rand.nextDouble() * 1000, rand.nextDouble() * 1000,
						rand.nextDouble() * 1000, rand.nextDouble() * 1000, rand.nextDouble() * 1000,
						rand.nextDouble() * 1000, rand.nextDouble() * 1000, rand.nextDouble() * 1000,
						rand.nextDouble() * 1000, rand.nextDouble() * 1000, rand.nextDouble() * 1000,
						rand.nextDouble() * 1000, rand.nextDouble() * 1000, rand.nextDouble() * 1000,
						rand.nextDouble() * 1000, rand.nextDouble() * 1000, rand.nextDouble() * 1000
				)
			}

		@JvmStatic
		fun main(args: Array<String>) {
			loadJniLibrary()
			SequenceUtilsTest().discretizationTest()
		}
	}
}

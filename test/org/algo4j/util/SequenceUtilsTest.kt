package org.algo4j.util

import org.algo4j.test.println
import org.algo4j.test.test
import org.junit.Assert.assertArrayEquals
import org.junit.Assert.assertEquals
import org.junit.BeforeClass
import org.junit.Test
import java.util.*

/**
 * Created by algo4j on 2016/11/17.
 *
 * @author algo4j
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

	@Test(timeout = 1000)
	fun inversionTest() {
		assertEquals(SequenceUtils.inversion(intArrayOf(3, 1, 5, 2, 4)), 4)
	}

	@JvmOverloads
	fun sortTest(
			sortInt: (IntArray) -> Unit,
			sortDouble: (DoubleArray) -> Unit,
			times: Int = 10000) {
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

	@Test(timeout = 1000)
	fun sortMergeTest() =
			sortTest(SequenceUtils::sortMerge, SequenceUtils::sortMerge)

	@Test(timeout = 1000)
	fun sortSelectionTest() =
			sortTest(SequenceUtils::sortSelection, SequenceUtils::sortSelection)

	@Test(timeout = 1000)
	fun sortCombTest() =
			sortTest(SequenceUtils::sortComb, SequenceUtils::sortComb)

	@Test(timeout = 1000)
	fun sortCocktailTest() =
			sortTest(SequenceUtils::sortCocktail, SequenceUtils::sortCocktail)

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

package org.algo4j.util

import org.algo4j.test.*
import org.junit.Assert.assertArrayEquals
import org.junit.Assert.assertEquals
import org.junit.BeforeClass
import org.junit.Test
import java.util.*

/**
 * Created by ice1000 on 2016/11/17.
 *
 * @author ice1000
 */
class SeqUtilsTest {

	@Test(timeout = 500)
	fun discretizationTest() {
		val ints = intArrayOf(33, 1, 100, 20, 43, 43)
		val result = intArrayOf(2, 0, 4, 1, 3, 3)
		SeqUtils
				.discretization(ints)
		SeqUtils
				.toString(ints)
				.println()
		assertArrayEquals(result, ints)
		val doubles = ints
				.map(Int::toDouble)
				.toDoubleArray()
		SeqUtils
				.discretization(doubles)
		SeqUtils
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

	@Test(timeout = 100)
	fun inversionTest() {
		assertEquals(SeqUtils.inversion(intArrayOf(3, 1, 5, 2, 4)), 4)
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
			sortTest(SeqUtils::sortBubble, SeqUtils::sortBubble, 2000)

	@Test(timeout = 1000)
	fun sortInsertionTest() =
			sortTest(SeqUtils::sortInsertion, SeqUtils::sortInsertion, 2000)

	@Test(timeout = 1000)
	fun sortQuickTest() =
			sortTest(SeqUtils::sortQuick, SeqUtils::sortQuick)

	@Test(timeout = 1000)
	fun sortMergeTest() =
			sortTest(SeqUtils::sortMerge, SeqUtils::sortMerge)

	@Test(timeout = 1000)
	fun sortSelectionTest() =
			sortTest(SeqUtils::sortSelection, SeqUtils::sortSelection, 2000)

	@Test(timeout = 1000)
	fun sortCombTest() =
			sortTest(SeqUtils::sortComb, SeqUtils::sortComb, 2000)

	@Test(timeout = 1000)
	fun sortCocktailTest() =
			sortTest(SeqUtils::sortCocktail, SeqUtils::sortCocktail, 2000)

	@Test(timeout = 1000)
	fun veryStrongTestMergeSort() {
		SeqUtils.sortMerge(strongIntArray.toIntArray())
	}

	@Test(timeout = 1000)
	fun veryStrongTestQuickSort() {
		SeqUtils.sortQuick(strongIntArray.toIntArray())
	}

	companion object Initializer {
		@BeforeClass
		@JvmStatic
		fun loadJniLibrary() {
			System.loadLibrary("jni")
			randomArray = strongIntArray
		}

		lateinit var randomArray: List<Int>

		val bound = 2333

		@JvmStatic
		fun main(args: Array<String>) {
			loadJniLibrary()
			SeqUtilsTest().discretizationTest()
		}
	}
}

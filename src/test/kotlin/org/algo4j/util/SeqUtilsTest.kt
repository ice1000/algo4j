package org.algo4j.util

import org.algo4j.test.*
import org.jetbrains.annotations.Contract
import org.jetbrains.annotations.TestOnly
import org.junit.Assert.*
import org.junit.BeforeClass
import org.junit.Test
import java.util.*
import java.util.Arrays as StdArrays

/**
 * Created by ice1000 on 2016/11/17.
 *
 * @author ice1000
 */
class SeqUtilsTest {

	@TestOnly
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

	@TestOnly
	@Test(timeout = 100)
	fun inversionTest() {
		assertEquals(SeqUtils.inversion(intArrayOf(3, 1, 5, 2, 4)), 4)
	}

	@TestOnly
			//	@JvmOverloads
	fun sortTest(
			sortInt: (IntArray) -> Unit,
			sortDouble: (DoubleArray) -> Unit,
			times: Int = 10000) {
		test(times) {
			val data1 = shuffledIntList
			val res11 = data1.toIntArray()
			StdArrays.sort(res11)
			val res12 = data1.toIntArray()
			sortInt(res12)
			assertArrayEquals(res11, res12)
			val data2 = shuffledDoubleList
			val res21 = data2.toDoubleArray()
			StdArrays.sort(res21)
			val res22 = data2.toDoubleArray()
			sortDouble(res22)
			assertArrayEquals(res21, res22, 1e-10)
		}
	}

	@TestOnly
	@Test(timeout = 1000)
	fun sortBubbleTest() =
			sortTest(
					SeqUtils::sortBubble,
					SeqUtils::sortBubble,
					2000
			)

	@TestOnly
	@Test(timeout = 1000)
	fun sortInsertionTest() =
			sortTest(
					SeqUtils::sortInsertion,
					SeqUtils::sortInsertion,
					2000
			)

	@TestOnly
	@Test(timeout = 1000)
	fun sortQuickTest() =
			sortTest(
					SeqUtils::sortQuick,
					SeqUtils::sortQuick
			)

	@TestOnly
	@Test(timeout = 1000)
	fun sortMergeTest() =
			sortTest(
					SeqUtils::sortMerge,
					SeqUtils::sortMerge
			)

	@TestOnly
	@Test(timeout = 1000)
	fun sortSelectionTest() =
			sortTest(
					SeqUtils::sortSelection,
					SeqUtils::sortSelection,
					2000
			)

	@TestOnly
	@Test(timeout = 1000)
	fun sortCombTest() =
			sortTest(
					SeqUtils::sortComb,
					SeqUtils::sortComb,
					2000
			)

	@TestOnly
	@Test(timeout = 1000)
	fun sortCocktailTest() =
			sortTest(
					SeqUtils::sortCocktail,
					SeqUtils::sortCocktail,
					2000
			)

	/**
	 * 大数据归并测试（归并吊打快排现场）
	 */
	@TestOnly
	@Test(timeout = 1000)
	fun veryStrongTestMergeSort() {
		SeqUtils.sortMerge(strongIntArray.toIntArray())
	}

	/**
	 * 大数据快排测试（快排被归并吊打现场）
	 */
	@TestOnly
	@Test(timeout = 1000)
	fun veryStrongTestQuickSort() {
		SeqUtils.sortQuick(strongIntArray.toIntArray())
	}

	@TestOnly
	@Test(timeout = 10000)
	fun sortQuickMultiThreading() {
//		val arr = strongIntArray.toIntArray()
//		val equ = arr.copy() ?: intArrayOf()
//		equ.sort()
//		SeqUtils.sortQuickPartial(arr)
//		Thread.sleep(4000)
//		arr.forEachIndexed { index, i -> println("$index\t: $i") }
//		assertArrayEquals(equ, arr)
	}

	/**
	 * 复制测试
	 */
	@TestOnly
	@Test(timeout = 1000)
	fun copyTest() {
		assertNull(SeqUtils.copy(null as IntArray?))
		assertNull(SeqUtils.copy(null as DoubleArray?))
		assertNull(SeqUtils.copy(null as FloatArray?))
		assertNull(SeqUtils.copy(null as BooleanArray?))
		assertNull(SeqUtils.copy(null as ShortArray?))
		assertNull(SeqUtils.copy(null as ByteArray?))
		assertNull(SeqUtils.copy(null
				as IntArray?
				as DoubleArray?
				as FloatArray?
				as BooleanArray?
				as ShortArray?
				as ByteArray?))
		test(1000) {
			val arr = shuffledIntList.toIntArray()
			val arr2 = shuffledDoubleList.toDoubleArray()
			assertArrayEquals(
					StdArrays.copyOf(arr, arr.size),
					SeqUtils.copy(arr)
			)
			assertArrayEquals(
					StdArrays.copyOf(arr2, arr2.size),
					SeqUtils.copy(arr2),
					1e-15
			)
		}
	}

	/**
	 * 看毛片测试
	 */
	@TestOnly
	@Test(timeout = 1000)
	fun testKmp() {
		assertEquals(2, SeqUtils.kmp(
				intArrayOf(3, 2, 3, 5, 3, 2, 3),
				intArrayOf(3, 2, 3)))
		val rand = Random(System.currentTimeMillis())
		test(1000) {
			val str = rand.nextInt(10000).toString()
			val times = rand.nextInt(200)
			val van = "${str}van".repeat(times)
			assertEquals(times, SeqUtils.kmp(van, "van"))
			assertEquals(times, SeqUtils.kmp(van, "va"))
			assertEquals(times, SeqUtils.kmp(van, "an"))
			assertEquals(times, SeqUtils.kmp(van, "v"))
			assertEquals(times, SeqUtils.kmp(van, str))
		}
	}

	companion object Initializer {
		@BeforeClass
		@JvmStatic
		fun loadJniLibrary() {
			System.loadLibrary(Loader.JNI_LIB_NAME)
			randomArray = strongIntArray
		}

		lateinit var randomArray: List<Int>
			@TestOnly
			@Contract(pure = true)
			get

		val bound = 2333
			@TestOnly
			@Contract(pure = true)
			get

		@TestOnly
		@JvmStatic
		fun main(args: Array<String>) {
			System.loadLibrary(Loader.JNI_LIB_NAME)
			SeqUtilsTest().discretizationTest()
		}
	}
}

/**
 * Created by ice1000 on 2016/11/24.
 *
 * @author ice1000
 */
@file:Suppress("unused")

package org.algo4j.test

import org.algo4j.util.SeqUtilsTest
import org.jetbrains.annotations.Contract
import org.jetbrains.annotations.TestOnly
import java.util.*

inline fun loop(block: () -> Unit) {
	while (true) block.invoke()
}

inline fun loop(times: Int, block: (Int) -> Unit) {
	var cnt = times
	while (cnt-- > 0) block.invoke(times - cnt)
}

@TestOnly
inline fun test(times: Int, block: (Int) -> Unit) {
	print("$times test cases: ")
	loop(times, block)
	println("test passed")
}

@Contract(pure = true)
fun <T> T.println(): T {
	println(toString())
	return this
}

@Contract(pure = true)
fun <T> T.print(): T {
	print(toString())
	return this
}

object Monoid {
	@Contract(pure = true)
	inline fun <T> combine(crossinline func: (T, T) -> T) = { i: T, j: T -> func(i, j) }
}

@Contract(pure = false)
fun <T> MutableList<T>.append(ls: List<T>): MutableList<T> {
	addAll(ls)
	return this
}

inline fun forceRun(block: () -> Unit) {
	try {
		block.invoke()
	} catch (e: Throwable) {
	}
}

inline fun optional(run: Boolean, block: () -> Unit) {
	if (run) block.invoke()
}

val shuffledDoubleList: List<Double>
	@TestOnly
	@Contract(pure = true)
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

val shuffledIntList: List<Int>
	@TestOnly
	@Contract(pure = true)
	get() {
		val rand = Random(System.currentTimeMillis())
		return listOf(
				rand.nextInt(SeqUtilsTest.bound), rand.nextInt(SeqUtilsTest.bound), rand.nextInt(SeqUtilsTest.bound),
				rand.nextInt(SeqUtilsTest.bound), rand.nextInt(SeqUtilsTest.bound), rand.nextInt(SeqUtilsTest.bound),
				rand.nextInt(SeqUtilsTest.bound), rand.nextInt(SeqUtilsTest.bound), rand.nextInt(SeqUtilsTest.bound),
				rand.nextInt(SeqUtilsTest.bound), rand.nextInt(SeqUtilsTest.bound), rand.nextInt(SeqUtilsTest.bound),
				rand.nextInt(SeqUtilsTest.bound), rand.nextInt(SeqUtilsTest.bound), rand.nextInt(SeqUtilsTest.bound),
				rand.nextInt(SeqUtilsTest.bound), rand.nextInt(SeqUtilsTest.bound), rand.nextInt(SeqUtilsTest.bound),
				rand.nextInt(SeqUtilsTest.bound), rand.nextInt(SeqUtilsTest.bound), rand.nextInt(SeqUtilsTest.bound),
				rand.nextInt(SeqUtilsTest.bound), rand.nextInt(SeqUtilsTest.bound), rand.nextInt(SeqUtilsTest.bound),
				rand.nextInt(SeqUtilsTest.bound), rand.nextInt(SeqUtilsTest.bound), rand.nextInt(SeqUtilsTest.bound),
				rand.nextInt(SeqUtilsTest.bound), rand.nextInt(SeqUtilsTest.bound), rand.nextInt(SeqUtilsTest.bound)
		)
	}

val strongIntArray: List<Int>
	@TestOnly
	@Contract(pure = true)
	get() {
		val list = shuffledIntList
				.toMutableList()
				.append(shuffledIntList)
				.append(shuffledIntList)
		for (i in 1..5000) list.addAll(shuffledIntList)
		return list
	}


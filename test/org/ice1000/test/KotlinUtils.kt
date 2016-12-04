/**
 * Created by ice1000 on 2016/11/24.
 *
 * @author ice1000
 */
package org.ice1000.test

inline fun loop(block: () -> Unit) {
	while (true) block.invoke()
}

inline fun loop(times: Int, block: (Int) -> Unit) {
	var cnt = times
	while (cnt-- > 0) block.invoke(times - cnt)
}

inline fun test(times: Int, block: (Int) -> Unit) {
	println("$times test cases")
	loop(times, block)
	println("test passed")
}

fun <T> T.println() : T {
	println(toString())
	return this
}

fun <T> T.print(): T {
	print(toString())
	return this
}

object Monoid {
	fun <T> combine(func: (T, T) -> T) = { i: T, j: T -> func(i, j) }
}

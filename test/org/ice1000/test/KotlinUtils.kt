/**
 * Created by ice1000 on 2016/11/24.
 *
 * @author ice1000
 */
package org.ice1000.test

inline fun <reified T> T.loop(block: () -> Unit) {
	while (true) block.invoke()
}

inline fun <reified T> T.loop(times: Int, block: () -> Unit) {
	var cnt = times
	while (cnt-- > 0) block.invoke()
}

object Monoid {
	fun <T> combine(func: (T, T) -> T) = { i: T, j: T -> func(i, j) }
}

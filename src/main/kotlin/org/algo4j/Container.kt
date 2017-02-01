@file:JvmName("Extension")
@file:JvmMultifileClass

/**
 * Created by ice1000 on 2017/2/1.
 *
 * @author ice1000
 */
package org.algo4j

import org.algo4j.linear.Queue
import org.algo4j.linear.RollingArray
import org.algo4j.linear.Stack
import org.jetbrains.annotations.Contract


@Contract(pure = true)
operator fun <T> RollingArray<T>.get(index: Int) =
		get(index)

@Contract(pure = true)
operator fun <T> RollingArray<T>.set(index: Int, value: T) =
		set(index, value)

@Contract(pure = true)
operator fun <T> Queue<T>.get(index: Int) =
		get(index)

@Contract(pure = true)
operator fun <T> Queue<T>.set(index: Int, value: T) =
		set(index, value)

@Contract(pure = true)
operator fun <T> Stack<T>.get(index: Int) =
		get(index)

@Contract(pure = true)
operator fun <T> Stack<T>.set(index: Int, value: T) =
		set(index, value)




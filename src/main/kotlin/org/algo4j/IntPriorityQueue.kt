@file:JvmMultifileClass
@file:JvmName("Extension")

package org.algo4j

import org.algo4j.linear.IntPriorityQueue
import org.jetbrains.annotations.Contract

/**
 * Created by ice1000 on 2017/1/27.
 *
 * @author ice1000
 */


@Contract(pure = true)
operator fun IntPriorityQueue.get(index: Int) = getElementAt(index)

@Contract(pure = false)
operator fun IntPriorityQueue.plusAssign(value: Int) =
		push(value)

/**
 * functional plus
 */
@Contract(pure = true)
operator fun IntPriorityQueue.plus(value: Int) = clone().apply { plusAssign(value) }

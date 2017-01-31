@file:JvmName("Extension")
@file:JvmMultifileClass

/**
 * Created by ice1000 on 2017/1/24.
 *
 * @author ice1000
 */
package org.algo4j

import org.algo4j.tree.heap.MaxHeap
import org.algo4j.tree.heap.MinHeap
import org.jetbrains.annotations.Contract


@Contract(pure = true)
operator fun MinHeap.get(index: Int): Int =
		getElementAt(index)

@Contract(pure = false)
operator fun MinHeap.plusAssign(value: Int) =
		push(value)

/**
 * functional plus
 */
@Contract(pure = true)
operator fun MinHeap.plus(value: Int) = clone().apply { plusAssign(value) }


@Contract(pure = true)
operator fun MaxHeap.get(index: Int): Int =
		getElementAt(index)

@Contract(pure = false)
operator fun MaxHeap.plusAssign(value: Int) =
		push(value)

/**
 * functional plus
 */
@Contract(pure = true)
operator fun MaxHeap.plus(value: Int) = clone().apply { plusAssign(value) }


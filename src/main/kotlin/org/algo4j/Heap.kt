@file:JvmName("Extension")
@file:JvmMultifileClass
package org.algo4j

import org.algo4j.tree.heap.MinHeap
import org.jetbrains.annotations.Contract

/**
 * Created by ice1000 on 2017/1/24.
 *
 * @author ice1000
 */

@Contract(pure = true)
operator fun MinHeap.get(index: Int): Int =
		getElementAt(index)

operator fun MinHeap.plusAssign(value: Int) =
		insert(value)

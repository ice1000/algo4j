package org.algo4j

import org.algo4j.graph.Heap
import org.jetbrains.annotations.Contract

/**
 * Created by ice1000 on 2017/1/24.
 *
 * @author ice1000
 */

@Contract(pure = true)
operator fun Heap.get(index: Int): Int =
		getElementAt(index)

operator fun Heap.plusAssign(value: Int) =
		insert(value)

@file:JvmMultifileClass
@file:JvmName("Extension")

/**
 * Created by ice1000 on 2017/1/4.
 *
 * @author ice1000
 */
package org.algo4j

import org.algo4j.bit.BinaryIndexedTree
import org.algo4j.bit.IntervalUpdateIntervalQuery
import org.algo4j.bit.IntervalUpdatePointQuery
import org.jetbrains.annotations.Contract

@Contract(pure = true)
operator fun BinaryIndexedTree.get(index: Int) =
		sum(index)

@Contract(pure = true)
operator fun BinaryIndexedTree.get(left: Int, right: Int) =
		sum(left, right)

@Contract(pure = true)
operator fun IntervalUpdatePointQuery.get(index: Int) =
		query(index)

@Contract(pure = false)
operator fun IntervalUpdatePointQuery.get(from: Int, to: Int) =
		BinaryIndexedTreeAddingHolder(this, from, to)

@Contract(pure = true)
operator fun IntervalUpdateIntervalQuery.get(left: Int, right: Int) =
		query(left, right)

class BinaryIndexedTreeAddingHolder
@Contract(pure = false)
internal constructor(
		val tree: IntervalUpdatePointQuery,
		val from: Int,
		val to: Int) {

	@Contract(pure = false)
	operator fun plusAssign(value: Long) {
		tree.update(from, to, value)
	}

	@Contract(pure = false)
	operator fun minusAssign(value: Long) {
		plusAssign(-value)
	}
}

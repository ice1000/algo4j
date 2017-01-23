@file:JvmMultifileClass
@file:JvmName("Extension")
@file:Suppress("unused")

/**
 * Created by ice1000 on 2017/1/7.
 *
 * @author ice1000
 */
package org.algo4j

import org.algo4j.util.SeqUtils
import org.jetbrains.annotations.Contract

@Contract(pure = true)
fun IntArray.copy() =
		SeqUtils.copy(this)

@Contract(pure = true)
fun DoubleArray.copy() =
		SeqUtils.copy(this)

@Contract(pure = true)
fun FloatArray.copy() =
		SeqUtils.copy(this)

@Contract(pure = true)
fun ByteArray.copy() =
		SeqUtils.copy(this)

@Contract(pure = true)
fun LongArray.copy() =
		SeqUtils.copy(this)

@Contract(pure = true)
fun ShortArray.copy() =
		SeqUtils.copy(this)

@Contract(pure = true)
fun BooleanArray.copy() =
		SeqUtils.copy(this)

@Contract(pure = false)
fun IntArray.sort() =
		SeqUtils.sortBubble(this)

@Contract(pure = false)
fun IntArray.sortBubble() =
		SeqUtils.sortBubble(this)

@Contract(pure = false)
fun IntArray.sortCocktail() =
		SeqUtils.sortCocktail(this)

@Contract(pure = false)
fun IntArray.sortSelection() =
		SeqUtils.sortSelection(this)

@Contract(pure = false)
fun IntArray.sortInsertion() =
		SeqUtils.sortInsertion(this)

@Contract(pure = false)
fun IntArray.sortComb() =
		SeqUtils.sortComb(this)

@Contract(pure = false)
fun IntArray.sortQuick() =
		SeqUtils.sortQuick(this)

@Contract(pure = false)
fun IntArray.sortMerge() =
		SeqUtils.sortMerge(this)

@Contract(pure = false)
fun IntArray.discretization() =
		SeqUtils.discretization(this)

@Contract(pure = false)
fun LongArray.sortBubble() =
		SeqUtils.sortBubble(this)

@Contract(pure = false)
fun LongArray.sortCocktail() =
		SeqUtils.sortCocktail(this)

@Contract(pure = false)
fun LongArray.sortSelection() =
		SeqUtils.sortSelection(this)

@Contract(pure = false)
fun LongArray.sortInsertion() =
		SeqUtils.sortInsertion(this)

@Contract(pure = false)
fun LongArray.sortComb() =
		SeqUtils.sortComb(this)

@Contract(pure = false)
fun LongArray.sortQuick() =
		SeqUtils.sortQuick(this)

@Contract(pure = false)
fun LongArray.sortMerge() =
		SeqUtils.sortMerge(this)

@Contract(pure = false)
fun LongArray.discretization() =
		SeqUtils.discretization(this)

@Contract(pure = false)
fun DoubleArray.sortBubble() =
		SeqUtils.sortBubble(this)

@Contract(pure = false)
fun DoubleArray.sortCocktail() =
		SeqUtils.sortCocktail(this)

@Contract(pure = false)
fun DoubleArray.sortSelection() =
		SeqUtils.sortSelection(this)

@Contract(pure = false)
fun DoubleArray.sortInsertion() =
		SeqUtils.sortInsertion(this)

@Contract(pure = false)
fun DoubleArray.sortComb() =
		SeqUtils.sortComb(this)

@Contract(pure = false)
fun DoubleArray.sortQuick() =
		SeqUtils.sortQuick(this)

@Contract(pure = false)
fun DoubleArray.sortMerge() =
		SeqUtils.sortMerge(this)

@Contract(pure = false)
fun DoubleArray.discretization() =
		SeqUtils.discretization(this)

@Contract(pure = false)
fun FloatArray.sortBubble() =
		SeqUtils.sortBubble(this)

@Contract(pure = false)
fun FloatArray.sortCocktail() =
		SeqUtils.sortCocktail(this)

@Contract(pure = false)
fun FloatArray.sortSelection() =
		SeqUtils.sortSelection(this)

@Contract(pure = false)
fun FloatArray.sortInsertion() =
		SeqUtils.sortInsertion(this)

@Contract(pure = false)
fun FloatArray.sortComb() =
		SeqUtils.sortComb(this)

@Contract(pure = false)
fun FloatArray.sortQuick() =
		SeqUtils.sortQuick(this)

@Contract(pure = false)
fun FloatArray.sortMerge() =
		SeqUtils.sortMerge(this)

@Contract(pure = false)
fun FloatArray.discretization() =
		SeqUtils.discretization(this)

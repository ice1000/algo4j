package org.algo4j.gen

import org.algo4j.test.print

/**
 * Created by ice1000 on 2017/1/7.
 *
 * @author ice1000
 */

fun main(args: Array<String>) {
	listOf(
			"Int",
			"Long",
			"Double",
			"Float"
	).forEach { boy ->
		listOf(
				"sortBubble",
				"sortCocktail",
				"sortSelection",
				"sortInsertion",
				"sortComb",
				"sortQuick",
				"sortMerge",
				"discretization"
		).forEach { next ->
			"""
@Contract(pure = false)
fun ${boy}Array.$next() =
		SeqUtils.$next(this)
""".print()
		}
	}
}

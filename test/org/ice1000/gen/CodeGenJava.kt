package org.ice1000.gen

import org.ice1000.test.println

/**
 * Created by ice1000 on 2016/12/6.
 *
 * @author ice1000
 */
fun main(args: Array<String>) {
	println("running code generation")
	listOf(
			"discretization",
			"sortBubble",
			"sortComb",
			"sortSelection",
			"sortCocktail",
			"sortInsertion",
			"sortMerge",
			"sortQuick"
	).forEach { name ->
		listOf("int", "long", "float", "double").forEach { type ->
			"""
	public static native void $name($type[] data, int length);

	public static void $name($type[] data) {
		$name(data, data.length);
	}""".println()
		}
	}
}


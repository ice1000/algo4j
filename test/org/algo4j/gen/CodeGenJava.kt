package org.algo4j.gen

import org.algo4j.test.println

/**
 * Created by algo4j on 2016/12/6.
 *
 * @author algo4j
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
	listOf("inversion").forEach { ass ->
		listOf("int", "long", "float", "double").forEach { we ->
			"""
	public static native long $ass($we[] data, int length);

	public static long $ass($we[] data) {
		return $ass(data, data.length);
	}""".println()
		}
	}
}


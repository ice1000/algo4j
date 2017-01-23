package org.algo4j.gen

import org.algo4j.test.println

/**
 * Created by ice1000 on 2016/12/6.
 *
 * @author ice1000
 */
fun main(args: Array<String>) {
	println("running code generation")
//	listOf(
//			"discretization",
//			"sortBubble",
//			"sortComb",
//			"sortSelection",
//			"sortCocktail",
//			"sortInsertion",
//			"sortMerge",
//			"sortQuick"
//	).forEach { name ->
//		listOf("int", "long", "float", "double").forEach { type ->
//			"""
//	private static native void $name($type[] data, int length);
//
//	public static void $name($type[] data) {
//		$name(data, data.length);
//	}""".println()
//		}
//	}
	listOf(
//			"inversion",
//			"sum",
//			"avg",
//			"max",
//			"min",
			"copy"
	).forEach { ass ->
		listOf("int", "long", "float", "double", "short", "byte").forEach { we ->
			"""
	@Nullable
	@Contract(value = "!null -> !null; null -> null", pure = true)
	public static native $we[] $ass(@Nullable $we[] data);""".println()
		}
	}
}


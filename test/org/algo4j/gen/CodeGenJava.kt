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
			"stdDiv"
	).forEach { ass ->
		listOf("int", "long", "float", "double").forEach { we ->
			"""
	private static native $we $ass($we[] data, int length);

	public static $we $ass($we[] data) {
		return $ass(data, data.length);
	}""".println()
		}
	}
}


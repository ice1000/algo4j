package org.ice1000.gen

import org.ice1000.test.print

/**
 * Created by ice1000 on 2016/12/6.
 *
 * @author ice1000
 */

private data class Type(
		val type: String,
		val mark: String
)

private fun exe(deep: List<Type>, className: String, methodName: String) {
	deep.forEach { (type, mark) ->
		"""
JNIEXPORT auto JNICALL Java_org_ice1000_${className}_${methodName}___3$mark(
		JNIEnv *env,
		jclass,
		j${type}Array _data,
		jint len) -> void {
}
""".print()
	}
	println()
	println()
	println()
	println()
	deep.forEach { (type, mark) ->
		"""
/**
 * Class:     org_ice1000_$className
 * Method:    $methodName
 * Signature: ([$mark)V
 */
JNIEXPORT auto JNICALL Java_org_ice1000_${className}_${methodName}___3$mark(
		JNIEnv *,
		jclass,
		j${type}Array,
		jint
) -> void;
""".print()
	}
}

fun main(args: Array<String>) {
	val className = "util_SequenceUtils"
	val methodName = "sortInsertion"
	exe(listOf(
			Type("int", "II"),
			Type("long", "JI"),
			Type("float", "FI"),
			Type("double", "DI")
	), className, methodName)
}

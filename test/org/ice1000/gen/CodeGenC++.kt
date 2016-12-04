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
	deep.forEach { dark ->
		"""
JNIEXPORT auto JNICALL Java_org_ice1000_${className}_${methodName}___3${dark.mark}(
		JNIEnv *env,
		jclass,
		j${dark.type}Array _data,
		jint len) -> void {
}
""".print()
	}
	println()
	println()
	println()
	println()
	deep.forEach { fantasy ->
		"""
/**
 * Class:     org_ice1000_$className
 * Method:    $methodName
 * Signature: ([${fantasy.mark})V
 */
JNIEXPORT auto JNICALL Java_org_ice1000_${className}_${methodName}___3${fantasy.mark}(
		JNIEnv *,
		jclass,
		j${fantasy.type}Array,
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

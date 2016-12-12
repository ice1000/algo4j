package org.algo4j.gen

import org.algo4j.test.print

/**
 * Created by algo4j on 2016/12/6.
 *
 * @author algo4j
 */

private data class Type(
		val type: String,
		val mark: String
)

private fun exe(
		deep: List<Type>,
		className: String,
		methodName: String,
		ret: String) {
	deep.forEach { dark ->
		val (type, mark) = dark
		"""
JNIEXPORT auto JNICALL Java_org_ice1000_${className}_${methodName}___3$mark(
		JNIEnv *env,
		jclass,
		j${type}Array _data,
		jint len) -> $ret {
}
""".print()
	}
	println()
	println()
	println()
	println()
	deep.forEach { dark ->
		val (type, mark) = dark
		"""
/**
 * Class:     org_ice1000_$className
 * Method:    $methodName
 * Signature: ([$mark)J
 */
JNIEXPORT auto JNICALL Java_org_ice1000_${className}_${methodName}___3$mark(
		JNIEnv *,
		jclass,
		j${type}Array,
		jint
) -> $ret;
""".print()
	}
}

fun main(args: Array<String>) {
	val className = "util_SequenceUtils"
	val methodName = "inversion"
	exe(listOf(
			Type("int", "II"),
			Type("long", "JI"),
			Type("float", "FI"),
			Type("double", "DI")
	), className, methodName, "jlong")
}

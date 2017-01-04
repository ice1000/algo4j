@file:JvmMultifileClass
@file:JvmName("CodeGen")

package org.algo4j.gen

import org.algo4j.test.print

/**
 * Created by ice1000 on 2016/12/6.
 *
 * @author ice1000
 */

private data class Type(
		val type: String,
		val mark: String
)

private fun exe(
		deep: List<Type>,
		className: String,
		methodName: String,
		ret: String? = null,
		retMark: String) {
	deep.forEach { dark ->
		val (type, mark) = dark
		"""
JNIEXPORT auto JNICALL Java_org_algo4j_${className}_${methodName}___3${mark}I(
		JNIEnv *env,
		jclass,
		${type}Array _data,
		jint len) -> ${ret ?: type} {
	__ice__()
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
 * Class:     org_algo4j_$className
 * Method:    $methodName
 * Signature: ([${mark}I)${if (ret == null) mark else retMark}
 */
JNIEXPORT auto JNICALL Java_org_algo4j_${className}_${methodName}___3${mark}I(
		JNIEnv *,
		jclass,
		${type}Array,
		jint
) -> ${ret ?: type};
""".print()
	}
}

fun main(args: Array<String>) {
	val className = "util_SeqUtils"
	val methodName = "stdDiv"
	exe(listOf(
			Type("jint", "I"),
			Type("jbyte", "B"),
			Type("jlong", "J"),
			Type("jfloat", "F"),
			Type("jdouble", "D")
	), className, methodName, "jdouble", "D")
}

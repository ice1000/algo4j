///
/// Created by ice1000
///

#include "Trigonometric.h"

#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCUnusedGlobalDeclarationInspection"

using namespace algo4j_math;

JNIEXPORT jdouble JNICALL Java_org_algo4j_math_Trigonometric_sin(
		JNIEnv *,
		jclass,
		jdouble a) {
	return sin_ice(a);
}

JNIEXPORT jdouble JNICALL Java_org_algo4j_math_Trigonometric_cos(
		JNIEnv *,
		jclass,
		jdouble a) {
	return cos_ice(a);
}

JNIEXPORT jdouble JNICALL Java_org_algo4j_math_Trigonometric_tan(
		JNIEnv *,
		jclass,
		jdouble a) {
	return tan_ice(a);
}

JNIEXPORT jdouble JNICALL Java_org_algo4j_math_Trigonometric_cot(
		JNIEnv *,
		jclass,
		jdouble a) {
	return cot_ice(a);
}

JNIEXPORT jdouble JNICALL Java_org_algo4j_math_Trigonometric_csc(
		JNIEnv *,
		jclass,
		jdouble a) {
	return csc_ice(a);
}

JNIEXPORT jdouble JNICALL Java_org_algo4j_math_Trigonometric_sec(
		JNIEnv *,
		jclass,
		jdouble a) {
	return sec_ice(a);
}



#pragma clang diagnostic pop
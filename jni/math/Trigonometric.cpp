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
		jdouble _) {
	return sin_ice(_);
}

JNIEXPORT jdouble JNICALL Java_org_algo4j_math_Trigonometric_cos(
		JNIEnv *,
		jclass,
		jdouble _) {
	return cos_ice(_);
}

JNIEXPORT jdouble JNICALL Java_org_algo4j_math_Trigonometric_tan(
		JNIEnv *,
		jclass,
		jdouble _) {
	return tan_ice(_);
}

JNIEXPORT jdouble JNICALL Java_org_algo4j_math_Trigonometric_cot(
		JNIEnv *,
		jclass,
		jdouble _) {
	return cot_ice(_);
}

JNIEXPORT jdouble JNICALL Java_org_algo4j_math_Trigonometric_csc(
		JNIEnv *,
		jclass,
		jdouble _) {
	return csc_ice(_);
}

JNIEXPORT jdouble JNICALL Java_org_algo4j_math_Trigonometric_sec(
		JNIEnv *,
		jclass,
		jdouble _) {
	return sec_ice(_);
}



#pragma clang diagnostic pop
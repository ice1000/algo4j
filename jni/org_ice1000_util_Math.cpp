///
/// Created by ice1000 on 2016/11/16.
///

#include "org_ice1000_util_Math.h"

#pragma clang diagnostic push
#pragma clang diagnostic ignored "-Wunused-parameter"
#pragma ide diagnostic ignored "OCUnusedGlobalDeclarationInspection"

using namespace ice1000_math;


JNIEXPORT jlong JNICALL Java_org_ice1000_util_Math_gcd(
		JNIEnv *env,
		jclass jc,
		jlong a,
		jlong b) {
	return gcd(a, b);
}

JNIEXPORT jdouble JNICALL Java_org_ice1000_util_Math_sqrt(
		JNIEnv *env,
		jclass jc,
		jdouble a) {
	return sqrt_carmack((float) a);
}

JNIEXPORT jdouble JNICALL Java_org_ice1000_util_Math_sqrtStrict(
		JNIEnv *env,
		jclass jc,
		jdouble a) {
	return sqrt_strict(a);
}

JNIEXPORT jdouble JNICALL Java_org_ice1000_util_Math_sin(
		JNIEnv *env,
		jclass jc,
		jdouble a) {
	return sin_ice(a);
}

JNIEXPORT jdouble JNICALL Java_org_ice1000_util_Math_cos(
		JNIEnv *env,
		jclass jc,
		jdouble a) {
	return cos_ice(a);
}

JNIEXPORT jdouble JNICALL Java_org_ice1000_util_Math_tan(
		JNIEnv *env,
		jclass jc,
		jdouble a) {
	return tan_ice(a);
}

JNIEXPORT jdouble JNICALL Java_org_ice1000_util_Math_cot(
		JNIEnv *env,
		jclass jc,
		jdouble a) {
	return cot_ice(a);
}

JNIEXPORT jdouble JNICALL Java_org_ice1000_util_Math_csc(
		JNIEnv *env,
		jclass jc,
		jdouble a) {
	return csc_ice(a);
}

JNIEXPORT jdouble JNICALL Java_org_ice1000_util_Math_sec(
		JNIEnv *env,
		jclass jc,
		jdouble a) {
	return sec_ice(a);
}


#pragma clang diagnostic pop

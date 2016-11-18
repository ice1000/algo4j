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

JNIEXPORT jlong JNICALL Java_org_ice1000_util_Math_fastPlus(
		JNIEnv *env,
		jclass jc,
		jlong a,
		jlong b,
		jlong m) {
	return ice1000_math::fast_plus(a, b, m);
}

JNIEXPORT jlong JNICALL Java_org_ice1000_util_Math_fastPower(
		JNIEnv *env,
		jclass jc,
		jlong a,
		jlong b,
		jlong m) {
	return ice1000_math::fast_power(a, b, m);
}

JNIEXPORT jdouble JNICALL Java_org_ice1000_util_Math_abs__D(
		JNIEnv *env,
		jclass jc,
		jdouble a) {
  return a > 0 ? a : -a;
}

JNIEXPORT jfloat JNICALL Java_org_ice1000_util_Math_abs__F(
		JNIEnv *env,
		jclass jc,
		jfloat f) {
  return f > 0 ? f : -f;
}

JNIEXPORT jint JNICALL Java_org_ice1000_util_Math_abs__I(
		JNIEnv *env,
		jclass jc,
		jint i) {
  return i > 0 ? i : -i;
}

JNIEXPORT jlong JNICALL Java_org_ice1000_util_Math_abs__J(
		JNIEnv *env,
		jclass jc,
		jlong l) {
  return l > 0 ? l : -l;
}

#pragma clang diagnostic pop

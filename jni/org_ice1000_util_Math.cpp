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

#ifdef __abs__ice__
#undef __abs__ice__
#endif /// __abs__ice__

#define __abs__ice__ (a > 0 ? a : -a)

JNIEXPORT jdouble JNICALL Java_org_ice1000_util_Math_abs__D(
		JNIEnv *env,
		jclass jc,
		jdouble a) {
  return __abs__ice__;
}

JNIEXPORT jfloat JNICALL Java_org_ice1000_util_Math_abs__F(
		JNIEnv *env,
		jclass jc,
		jfloat a) {
  return __abs__ice__;
}

JNIEXPORT jint JNICALL Java_org_ice1000_util_Math_abs__I(
		JNIEnv *env,
		jclass jc,
		jint a) {
  return __abs__ice__;
}

JNIEXPORT jlong JNICALL Java_org_ice1000_util_Math_abs__J(
		JNIEnv *env,
		jclass jc,
		jlong a) {
  return __abs__ice__;
}

#undef __abs__ice__

#ifdef __max__ice__
#undef __max__ice__
#endif /// __max__ice__

#define __max__ice__ (a > b ? a : b)

JNIEXPORT jlong JNICALL Java_org_ice1000_util_Math_max__JJ(
		JNIEnv *env,
		jclass jc,
		jlong a,
		jlong b) {
  return __max__ice__;
}

JNIEXPORT jlong JNICALL Java_org_ice1000_util_Math_max__II(
		JNIEnv *env,
		jclass jc,
		jint a,
		jint b) {
  return __max__ice__;
}

JNIEXPORT jfloat JNICALL Java_org_ice1000_util_Math_max__FF(
		JNIEnv *env,
		jclass jc,
		jfloat a,
		jfloat b) {
  return __max__ice__;
}

JNIEXPORT jdouble JNICALL Java_org_ice1000_util_Math_max__DD(
		JNIEnv *env,
		jclass jc,
		jdouble a,
		jdouble b) {
  return __max__ice__;
}

#undef __max__ice__

#ifdef __min__ice__
#undef __min__ice__
#endif /// __min__ice__

#define __min__ice__ (a > b ? b : a)

JNIEXPORT jint JNICALL Java_org_ice1000_util_Math_min__II(
		JNIEnv *env,
		jclass jc,
		jint a,
		jint b) {
	return __min__ice__;
}

JNIEXPORT jlong JNICALL Java_org_ice1000_util_Math_min__JJ(
		JNIEnv *env,
		jclass jc,
		jlong a,
		jlong b) {
	return __min__ice__;
}

JNIEXPORT jfloat JNICALL Java_org_ice1000_util_Math_min__FF(
		JNIEnv *env,
		jclass jc,
		jfloat a,
		jfloat b) {
	return __min__ice__;
}

JNIEXPORT jdouble JNICALL Java_org_ice1000_util_Math_min__DD(
		JNIEnv *env,
		jclass jc,
		jdouble a,
		jdouble b) {
  return __min__ice__;
}

#undef __min__ice__

#pragma clang diagnostic pop

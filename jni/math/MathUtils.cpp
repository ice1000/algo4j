///
/// Created by ice1000 on 2016/11/16.
///

#include "MathUtils.h"
#include "../global/templates.hpp"
#include "../global/matrix.h"

#pragma clang diagnostic push
#pragma clang diagnostic ignored "-Wunused-parameter"
#pragma ide diagnostic ignored "OCUnusedGlobalDeclarationInspection"

using namespace algo4j_math;

using algo4j_matrix::fib_matrix;

JNIEXPORT auto JNICALL Java_org_algo4j_math_MathUtils_gcd(
		JNIEnv *env,
		jclass jc,
		jlong a,
		jlong b) -> jlong {
	return gcd(a, b);
}

JNIEXPORT auto JNICALL Java_org_algo4j_math_MathUtils_exgcdJni(
		JNIEnv *env,
		jclass,
		jlong a,
		jlong b) -> jlongArray {
	jlong x, y;
	auto c = exgcd(a, b, x, y);
	auto ret = new jlong[3]();
	ret[0] = c;
	ret[1] = x;
	ret[2] = y;
	__new(Long, ret, 3);
	__set(Long, ret, 3);
	delete ret;
	return _ret;
}

JNIEXPORT auto JNICALL Java_org_algo4j_math_MathUtils_gcdStein(
		JNIEnv *,
		jclass,
		jlong a,
		jlong b) -> jlong {
	return gcd_stein(a, b);
}

JNIEXPORT auto JNICALL Java_org_algo4j_math_MathUtils_sqrtCarmark(
		JNIEnv *env,
		jclass jc,
		jdouble _) -> jdouble {
	return sqrt_carmack((float) _);
}

JNIEXPORT auto JNICALL Java_org_algo4j_math_MathUtils_sqrt(
		JNIEnv *env,
		jclass jc,
		jdouble _) -> jdouble {
	return sqrt_strict(_);
}

JNIEXPORT auto JNICALL Java_org_algo4j_math_MathUtils_fastPlus(
		JNIEnv *env,
		jclass jc,
		jlong a,
		jlong b,
		jlong m) -> jlong {
	return fast_plus(a, b, m);
}

JNIEXPORT auto JNICALL Java_org_algo4j_math_MathUtils_fastPower(
		JNIEnv *env,
		jclass jc,
		jlong a,
		jlong b,
		jlong m) -> jlong {
	return fast_power(a, b, m);
}

JNIEXPORT auto JNICALL Java_org_algo4j_math_MathUtils_ln(
		JNIEnv *env,
		jclass jc,
		jdouble _) -> jdouble {
	return ln_ice(_);
}

JNIEXPORT auto JNICALL Java_org_algo4j_math_MathUtils_lg(
		JNIEnv *env,
		jclass jc,
		jdouble _) -> jdouble {
	return lg_ice(_);
}

JNIEXPORT auto JNICALL Java_org_algo4j_math_MathUtils_isPrime(
		JNIEnv *env,
		jclass,
		jlong _) -> jboolean {
	return *new jboolean(is_prime(_ > 0 ? _ : -_));
}

#undef __abs__ice__
#undef __max__ice__
#undef __min__ice__

JNIEXPORT auto JNICALL Java_org_algo4j_math_MathUtils_fib(
		JNIEnv *env,
		jclass,
		jlong _,
		jlong mod) -> jlong {
	return fib_matrix(_, mod);
}


#pragma clang diagnostic pop

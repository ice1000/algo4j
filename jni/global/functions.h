///
/// Created by ice1000 on 2016/11/16.
///

#include "jni.h"

//#include <iostream>
//
//using std::istream;
//using std::ostream;

#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCUnusedGlobalDeclarationInspection"

#ifndef __ALGO4J_FUNCTIONS_H__
#define __ALGO4J_FUNCTIONS_H__

#ifdef __cplusplus
extern "C" {
#endif /// __cplusplus

namespace algo4j_math {

	constexpr jdouble PI = 3.14159265358979323846263383279502884197;
	constexpr jdouble E = 2.718281828459045;

	auto sin_ice(const jdouble) -> jdouble;

	auto cos_ice(const jdouble) -> jdouble;

	auto tan_ice(const jdouble) -> jdouble;

	auto cot_ice(const jdouble) -> jdouble;

	auto csc_ice(const jdouble) -> jdouble;

	auto sec_ice(const jdouble) -> jdouble;

	auto sqrt_carmack(jfloat) -> jfloat;

	auto sqrt_strict(const jdouble) -> jdouble;

	auto gcd(jlong, jlong) -> jlong;

	auto gcd_stein(jlong, jlong) -> jlong;

	auto exgcd(const jlong, const jlong, jlong &, jlong &) -> jlong;

	auto ln_ice(const jdouble) -> jdouble;

	auto lg_ice(const jdouble) -> jdouble;

	auto is_prime(const jlong) -> bool;

	auto get_primes_simple(const jint) -> jlong *;
}

namespace algo4j_uset {
	auto find(jint *, jint) -> jint;

	auto init(jint *, jsize) -> void;

/*
	/// changed implementation into Java code
	auto merge(jint *, jint, jint) -> void;
*/
}

namespace algo4j_mem {
	auto alloc(jsize) -> jlong;

	auto release(jlong) -> void;
}

#ifdef __cplusplus
}
#endif /// __cplusplus

#endif /// __algo4j_FUNCTIONS_H__

#pragma clang diagnostic pop

///
/// Created by ice1000 on 2016/11/16.
///

#include <jni.h>
#include <math.h>
#include "templates.hpp"

#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCUnusedGlobalDeclarationInspection"

#ifndef __ICE1000_FUNCTIONS_H__
#define __ICE1000_FUNCTIONS_H__

#ifdef __cplusplus
extern "C" {
#endif /// __cplusplus

namespace ice1000_math {
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

	auto fast_plus(jlong, jlong, jlong) -> jlong;

	auto fast_power(jlong, jlong, jlong) -> jlong;

	auto ln_ice(const jdouble) -> jdouble;

	auto lg_ice(const jdouble) -> jdouble;

	auto is_prime(const jlong) -> bool;

	auto get_primes_simple(const jint) -> jlong *;
}

namespace ice1000_uset {
	auto find(jint *, jint) -> jint;

	/// changed implementation into Java code
	// void merge(jint *, jint, jint);
}

namespace ice1000_mem {
	auto alloc(size_t) -> jlong;

	auto release(jlong) -> void;
}

#ifdef __cplusplus
}
#endif /// __cplusplus

#endif /// __ICE1000_FUNCTIONS_H__

#pragma clang diagnostic pop

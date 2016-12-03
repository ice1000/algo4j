///
/// Created by ice1000 on 2016/11/16.
///

#include <jni.h>
#include <math.h>
#include <string.h>
#include "templates.hpp"

#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCUnusedGlobalDeclarationInspection"

#ifndef JNI_ORG_ICE1000_PUBLIC_FUNCTIONS_H
#define JNI_ORG_ICE1000_PUBLIC_FUNCTIONS_H

/// 0x5F3759DF thank you Carmack
#undef org_ice1000_util_Math_MAGIC_NUMBER
#define org_ice1000_util_Math_MAGIC_NUMBER 1597463007L

#ifndef __ice_memset
#define __ice_memset(x, y) (memset(x, y, sizeof(x)))
#endif /// __ice_memset

#ifndef __lowbit
#define __lowbit(x) ((x) & (-(x)))
#endif /// __lowbit

#define __JNI__FUNCTION__INIT__ \
auto option = new jboolean(false);

#define __JNI__FUNCTION__CLEAN__ \
delete option;

#ifdef __cplusplus
extern "C" {
#endif /// __cplusplus

namespace ice1000_bit {
	constexpr auto lowbit(const jlong) -> jlong;

	auto add(
			jlong *,
			jint,
			jint,
			jlong
	) -> void;

	auto sum(
			jlong *,
			jint
	) -> jlong;
}

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

	auto fast_plus(jlong, jlong, jlong) -> jlong;

	auto fast_power(jlong, jlong, jlong) -> jlong;

	auto ln_ice(const jdouble) -> jdouble;

	auto lg_ice(const jdouble) -> jdouble;

	auto is_prime(const jlong) -> bool;
}

// namespace ice1000_util {
	// void _a_b_c_d_e_f_g_h_i_j_k_l_m_n_() {
		// quick_sort(new Ice1000Pair[233], 233);
	// }
// }

namespace ice1000_uset {
	auto find(jint *, jint) -> jint;

	/// changed implementation into Java code
	// void merge(jint *, jint, jint);
}
#ifdef __cplusplus
}
#endif /// __cplusplus
#endif /// JNI_ORG_ICE1000_PUBLIC_FUNCTIONS_H

#pragma clang diagnostic pop

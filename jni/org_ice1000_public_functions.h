///
/// Created by ice1000 on 2016/11/16.
///

#include <math.h>
#include <string.h>
#include "org_ice1000_public_templates.hpp"

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


#ifdef __cplusplus
extern "C" {
#endif

namespace ice1000_bit {
	jlong lowbit(const jlong);

	void add(
			jlong *,
			jint,
			jint,
			jlong
	);

	jlong sum(
			jlong *,
			jint
	);
}

namespace ice1000_math {
	jdouble sin_ice(const jdouble);

	jdouble cos_ice(const jdouble);

	jdouble tan_ice(const jdouble);

	jdouble cot_ice(const jdouble);

	jdouble csc_ice(const jdouble);

	jdouble sec_ice(const jdouble);

	jdouble sqrt_carmack(float);

	jdouble sqrt_strict(const jdouble);

	jlong gcd(jlong, jlong);

	jlong fast_plus(jlong, jlong, jlong);

	jlong fast_power(jlong, jlong, jlong);

	jdouble ln_ice(const jdouble);

	jdouble lg_ice(const jdouble);
}

// namespace ice1000_util {
	// void _a_b_c_d_e_f_g_h_i_j_k_l_m_n_() {
		// quick_sort(new Ice1000Pair[233], 233);
	// }
// }

namespace ice1000_uset {
	jint find(jint *, jint);

	// void merge(jint *, jint, jint);
}
#ifdef __cplusplus
}
#endif /// __cplusplus
#endif /// JNI_ORG_ICE1000_PUBLIC_FUNCTIONS_H

#pragma clang diagnostic pop

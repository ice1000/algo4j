///
/// Created by ice1000 on 2016/11/16.
///

#include <jni.h>
#include <math.h>
#include <string.h>

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

namespace ice1000_util {

// 日了狗了 实在不行我就硬编码类型进去 md

	template<typename T>
	void __quick_sort_core(
			T *array,
			const jsize left,
			const jsize right) {
		if (left >= right) return;
		auto i = left;
		auto j = right;
		auto standard = array[left];
		T temp;
		while (i < j) {
			while (i < j and standard < array[j]) --j;
			array[i] = array[j];
			while (i < j and !(standard < array[i])) ++i;
			array[j] = array[i];
		}
		array[i] = standard;
		__quick_sort_core(array, left, i - 1);
		__quick_sort_core(array, i + 1, right);
	}


	template<typename T>
	void __quick_sort_core_with_cmp(
			T *array,
			const jsize left,
			const jsize right,
			bool (*compare)(const T &, const T &)) {
		if (left >= right) return;
		auto i = left;
		auto j = right;
		auto standard = array[left];
		T temp;
		while (i < j) {
			while (i < j and compare(standard, array[i])) --j;
			array[i] = array[j];
			while (i < j and !compare(standard, array[i])) ++i;
			array[j] = array[i];
		}
		array[i] = standard;
		__quick_sort_core_with_cmp(array, left, i - 1, compare);
		__quick_sort_core_with_cmp(array, i + 1, right, compare);
	}

	template<typename T>
	void quick_sort(
			T *array,
			const jsize length) {
		__quick_sort_core(array, 0, length - 1);
	}

	template<typename T>
	void quick_sort_with_cmp(
			T *array,
			const jsize length,
			bool (*compare)(const T &, const T &)) {
		__quick_sort_core_with_cmp(array, 0, (int) (length - 1), compare);
	}

	template<typename T1, typename T2>
	struct Ice1000Pair {
		T1 first;
		T2 second;

		Ice1000Pair(const T1 &f, const T2 &s) : first(f), second(s) { }

		Ice1000Pair() { }

		void setValue(const T1 &f, const T2 &s) {
			first = f;
			second = s;
		}

		const bool operator<(const Ice1000Pair &o) const {
			return first == o.first ? second < o.second : first < o.first;
		}
	};
}

// namespace ice1000_util {
	// void _a_b_c_d_e_f_g_h_i_j_k_l_m_n_() {
		// quick_sort(new Ice1000Pair[233], 233);
	// }
// }

namespace ice1000_uset {
	jint find(jint *, jint);

	void merge(jint *, jint, jint);
}

#endif /// JNI_ORG_ICE1000_PUBLIC_FUNCTIONS_H

#pragma clang diagnostic pop

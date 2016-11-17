///
/// Created by ice1000 on 2016/11/16.
///

#include <jni.h>
#include <math.h>

#ifndef JNI_ORG_ICE1000_PUBLIC_FUNCTIONS_H
#define JNI_ORG_ICE1000_PUBLIC_FUNCTIONS_H

/// 0x5F3759DF thank you Carmack
#undef org_ice1000_util_Math_MAGIC_NUMBER
#define org_ice1000_util_Math_MAGIC_NUMBER 1597463007L

#ifndef __lowbit
#define __lowbit(x) ((x) & (-(x)))
#endif /// __lowbit

namespace ice1000_bit {
	jlong lowbit(const jlong);

	void add(
	  JNIEnv *,
	  jlongArray,
	  jint,
	  jint,
	  jlong
	);

	jlong sum(
	  JNIEnv *,
	  jlongArray,
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
}

namespace ice1000_util {
	template<typename T>
	void quick_sort(T *array, const long length);

	template<typename T>
	void quick_sort_with_cmp(T *array, const long length, bool (*) (const T &, const T &));

	template<typename T1, typename T2>
	struct Ice1000Pair {
		T1 first;
		T2 second;

		Ice1000Pair(const T1 &f, const T2 &s) : first(f), second(s) { }
		Ice1000Pair() { }

		const bool operator<(const Ice1000Pair &o) const {
			return first == o.first ? second < o.second : first < o.first;
		}
	};
}

#endif /// JNI_ORG_ICE1000_PUBLIC_FUNCTIONS_H



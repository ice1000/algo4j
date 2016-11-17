///
/// Created by ice1000 on 2016/11/16.
///

#include <jni.h>

#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCUnusedGlobalDeclarationInspection"

#ifndef JNI_ORG_ICE1000_PUBLIC_FUNCTIONS_H
#define JNI_ORG_ICE1000_PUBLIC_FUNCTIONS_H

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
	void quick_sort(T *, const int);

	template<typename T>
	void quick_sort(T *, const int, bool (*) (const T &, const T &));

	template<typename T>
	struct Ice1000Pair {
		T first;
		T second;

		Ice1000Pair(const T &f, const T &s) : first(f), second(s) { }

		const bool operator<(const Ice1000Pair &o) const {
			return first == o.first ? second < o.second : first < o.first;
		}
	};
}

#endif /// JNI_ORG_ICE1000_PUBLIC_FUNCTIONS_H


#pragma clang diagnostic pop

///
/// Created by ice1000 on 2016/11/16.
///

#include <jni.h>
#include <algorithm>

#ifndef JNI_ORG_ICE1000_PUBLIC_FUNCTIONS_H
#define JNI_ORG_ICE1000_PUBLIC_FUNCTIONS_H

#ifdef __cplusplus
extern "C" {
#endif /// __cplusplus

#ifndef __lowbit
#define __lowbit(x) ((x) & (-(x)))
#endif

namespace ice1000_bit {
	jlong lowbit(jlong);

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
	jdouble sqrt(float);
	jlong gcd(jlong, jlong);
}

#ifdef __cplusplus
}
#endif /// __cplusplus

#endif /// JNI_ORG_ICE1000_PUBLIC_FUNCTIONS_H


///
/// Created by ice1000 on 2016/11/16.
///

// 我不做大哥好多年 我不爱冰冷的床沿

#include "org_ice1000_public_functions.h"

inline void ice1000_bit::add(
		JNIEnv *env,
		jlongArray _data,
		jint len,
		jint idx,
		jlong value) {
	jlong *data = env->GetLongArrayElements(_data, 0);
	while (idx < len) {
		data[idx] += value;
		idx += __lowbit(idx);
	}
	env->ReleaseLongArrayElements(_data, data, 0);
}

inline jlong ice1000_bit::sum(
		JNIEnv *env,
		jlongArray _data,
		jint idx) {
	jlong ret = 0;
	jlong *data = env->GetLongArrayElements(_data, 0);
	while (idx > 0) {
		ret += data[idx];
		idx -= __lowbit(idx);
	}
	env->ReleaseLongArrayElements(_data, data, 0);
	return ret;
}

inline jlong ice1000_bit::lowbit(jlong x) {
	return __lowbit(x);
}

inline jdouble ice1000_math::sqrt(jdouble) {
	
}

inline jlong gcd(jlong, jlong) {
	
}

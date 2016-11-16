///
/// Created by ice1000 on 2016/11/16.
///

// 我不做大哥好多年 我不爱冰冷的床沿

#include "org_ice1000_util_Math.h"
#include "org_ice1000_public_functions.h"

void ice1000_bit::add(
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

jlong ice1000_bit::sum(
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

jlong ice1000_bit::lowbit(jlong x) {
	return __lowbit(x);
}

jdouble ice1000_math::sqrt(float x) {
	float xhalf = 0.5f * x;
	int i = *(int *) &x;
	i = org_ice1000_util_Math_MAGIC_NUMBER - (i >> 1);
	x = *(float *) &i;
	x *= (1.5f - xhalf * x * x);
	x *= (1.5f - xhalf * x * x);
	x *= (1.5f - xhalf * x * x);
	return (jdouble) (1 / x);
}

jlong ice1000_math::gcd(jlong n, jlong m) {
	jlong c;
	for (; m > 0; c = n % m, n = m, m = c);
	return n;
}

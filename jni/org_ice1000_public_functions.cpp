///
/// Created by ice1000 on 2016/11/16.
///

// 我不做大哥好多年 我不爱冰冷的床沿

#include "org_ice1000_public_functions.h"

#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCUnusedGlobalDeclarationInspection"


void ice1000_bit::add(
		jlong *data,
		jint len,
		jint idx,
		jlong value) {
	while (idx < len) {
		data[idx] += value;
		idx += __lowbit(idx);
	}
}

jlong ice1000_bit::sum(
		jlong *data,
		jint idx) {
	jlong ret = 0;
	while (idx > 0) {
		ret += data[idx];
		idx -= __lowbit(idx);
	}
//	delete data;
	return ret;
}

jlong ice1000_bit::lowbit(const jlong x) {
	return __lowbit(x);
}

jdouble ice1000_math::sqrt_carmack(float x) {
	auto x_half = 0.5F * x;
	auto i = *(int *) &x;
	i = org_ice1000_util_Math_MAGIC_NUMBER - (i >> 1);
	x = *(float *) &i;
	x *= (1.5F - x_half * x * x);
	x *= (1.5F - x_half * x * x);
	return (jdouble) (1 / x);
}

jdouble ice1000_math::sqrt_strict(const jdouble x) {
	return sqrt(x);
}

jlong ice1000_math::gcd(jlong n, jlong m) {
	jlong c;
	for (; m > 0; c = n % m, n = m, m = c);
	return n;
}

jdouble ice1000_math::sin_ice(const jdouble x) {
	return sin(x);
}

jdouble ice1000_math::cos_ice(const jdouble x) {
	return cos(x);
}

jdouble ice1000_math::tan_ice(const jdouble x) {
	return tan(x);
}

jdouble ice1000_math::cot_ice(const jdouble x) {
	return 1 / tan(x);
}

jdouble ice1000_math::csc_ice(const jdouble x) {
	return 1 / sin(x);
}

jdouble ice1000_math::sec_ice(const jdouble x) {
	return 1 / cos(x);
}

#pragma clang diagnostic pop

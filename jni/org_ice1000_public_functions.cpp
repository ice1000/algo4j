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

jfloat ice1000_math::sqrt_carmack(jfloat x) {
	auto x_half = 0.5F * x;
	auto i = *(jint *) &x;
	i = org_ice1000_util_Math_MAGIC_NUMBER - (i >> 1);
	x = *(jfloat *) &i;
	x *= (1.5F - x_half * x * x);
	x *= (1.5F - x_half * x * x);
	return 1 / x;
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

jdouble ice1000_math::ln_ice(const jdouble x) {
  return log(x);
}

jdouble ice1000_math::lg_ice(const jdouble x) {
  return log10(x);
}

jlong ice1000_math::fast_plus(jlong a, jlong b, jlong m) {
	jlong ret = 0;
	while (b) {
		if (b & 1) ret = (ret + a) % m;
		b >>= 1;
		a = (a << 1) % m;
	}
	return ret;
}

jlong ice1000_math::fast_power(jlong a, jlong b, jlong m) {
	jlong ret = 1;
	while (b) {
		if (b & 1) ret = ice1000_math::fast_plus(ret, a, m);
		b >>= 1;
		a = ice1000_math::fast_plus(a, a, m);
	}
	return ret;
}

jint ice1000_uset::find(jint *data, jint n) {
  return data[n] == n ? n : (data[n] = ice1000_uset::find(data, data[n]));
}

// void ice1000_uset::merge(jint *data, jint a, jint b) {
//   int i = ice1000_uset::find(data, a), j = ice1000_uset::find(data, b);
// 	if (i != j) data[i] = j;
// }

#pragma clang diagnostic pop

///
/// Created by ice1000 on 2016/11/16.
///

// 我不做大哥好多年 我不爱冰冷的床沿

#include "functions.h"

#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCUnusedGlobalDeclarationInspection"

auto ice1000_bit::add(
		jlong *data,
		jint len,
		jint idx,
		jlong value) -> void {
	while (idx < len) {
		data[idx] += value;
		idx += lowbit(idx);
	}
}

auto ice1000_bit::sum(
		jlong *data,
		jint idx) -> jlong {
	jlong ret = 0;
	while (idx > 0) {
		ret += data[idx];
		idx -= lowbit(idx);
	}
//	delete data;
	return ret;
}

constexpr auto ice1000_bit::lowbit(const jlong x) -> jlong {
	return __lowbit(x);
}

auto ice1000_math::sqrt_carmack(jfloat x) -> jfloat {
	auto x_half = 0.5F * x;
	auto i = *(jint *) &x;
	i = org_ice1000_util_Math_MAGIC_NUMBER - (i >> 1);
	x = *(jfloat *) &i;
	x *= (1.5F - x_half * x * x);
	x *= (1.5F - x_half * x * x);
	return 1 / x;
}

auto ice1000_math::sqrt_strict(const jdouble x) -> jdouble {
	return sqrt(x);
}

auto ice1000_math::gcd(jlong n, jlong m) -> jlong {
	jlong c;
	for (; m > 0; c = n % m, n = m, m = c);
	return n;
}

auto ice1000_math::sin_ice(const jdouble x) -> jdouble {
	return sin(x);
}

auto ice1000_math::cos_ice(const jdouble x) -> jdouble {
	return cos(x);
}

auto ice1000_math::tan_ice(const jdouble x) -> jdouble {
	return tan(x);
}

auto ice1000_math::cot_ice(const jdouble x) -> jdouble {
	return 1 / tan(x);
}

auto ice1000_math::csc_ice(const jdouble x) -> jdouble {
	return 1 / sin(x);
}

auto ice1000_math::sec_ice(const jdouble x) -> jdouble {
	return 1 / cos(x);
}

auto ice1000_math::ln_ice(const jdouble x) -> jdouble {
	return log(x);
}

auto ice1000_math::lg_ice(const jdouble x) -> jdouble {
	return log10(x);
}

auto ice1000_math::fast_plus(jlong a, jlong b, jlong m) -> jlong {
	jlong ret = 0;
	while (b) {
		if (b & 1) ret = (ret + a) % m;
		b >>= 1;
		a = (a << 1) % m;
	}
	return ret;
}

auto ice1000_math::fast_power(jlong a, jlong b, jlong m) -> jlong {
	jlong ret = 1;
	while (b) {
		if (b & 1) ret = ice1000_math::fast_plus(ret, a, m);
		b >>= 1;
		a = ice1000_math::fast_plus(a, a, m);
	}
	return ret;
}

auto ice1000_math::is_prime(const jlong num) -> bool {
	if (num < 2) return false;
	if (num == 2) return true;
	if (!(num & 1)) return false;
	for (auto a = 3; a * a <= num; a += 2) {
		if (!(num % a))
			return false;
	}
	return true;
}

auto ice1000_math::get_primes_simple(const jint cnt) -> jlong* {
	auto primes = new jlong[cnt]();
	auto index = 0;
	for (auto i = 2; index < cnt; ++i) {
		auto j = 0;
		for ( ; j < index; ++j) {
			if (!(i % j)) break;
		}
		if (j >= index) primes[index++] = i;
	}
	return primes;
}

auto ice1000_uset::find(jint *data, jint n) -> jint {
	return data[n] == n ? n : (data[n] = ice1000_uset::find(data, data[n]));
}

// void ice1000_uset::merge(jint *data, jint a, jint b) {
//   int i = ice1000_uset::find(data, a), j = ice1000_uset::find(data, b);
// 	if (i != j) data[i] = j;
// }

#pragma clang diagnostic pop

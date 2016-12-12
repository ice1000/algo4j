///
/// Created by ice1000 on 2016/11/16.
///

// 我不做大哥好多年 我不爱冰冷的床沿

#include "functions.h"

using algo4j_util::max;
using algo4j_util::min;
using algo4j_util::swap;
using algo4j_util::abs;

#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCUnusedGlobalDeclarationInspection"


auto algo4j_math::sqrt_carmack(jfloat x) -> jfloat {
	auto x_half = 0.5F * x;
	auto i = *(jint *) &x;
	i = org_algo4j_util_Math_MAGIC_NUMBER - (i >> 1);
	x = *(jfloat *) &i;
	x *= (1.5F - x_half * x * x);
	x *= (1.5F - x_half * x * x);
	return 1 / x;
}

auto algo4j_math::sqrt_strict(const jdouble x) -> jdouble {
	return sqrt(x);
}

/// euclid gcd
auto algo4j_math::gcd(jlong n, jlong m) -> jlong {
	jlong c;
	for (; m > 0; c = n % m, n = m, m = c);
	return n;
}

auto algo4j_math::exgcd(const jlong a, const jlong b, jlong &x, jlong &y) -> jlong {
	if (!b) {
		x = 1, y = 0;
		return a;
	}
	auto r = exgcd(b, a % b, x, y);
	auto t = x;
	x = y;
	y = t - a / b * y;
	return r;
}

auto algo4j_math::gcd_stein(jlong a, jlong b) -> jlong {
	if (!a) return b;
	if (!b) return a;
	if (!(a & 1) and !(b & 1)) return gcd_stein(a >> 1, b >> 1) << 1;
	else if (!(a & 1)) return gcd_stein(a >> 1, b);
	else if (!(b & 1)) return gcd_stein(a, b >> 1);
	else return gcd_stein((a + b) >> 1, abs(a - b) >> 1);
}

auto algo4j_math::sin_ice(const jdouble x) -> jdouble {
	return sin(x);
}

auto algo4j_math::cos_ice(const jdouble x) -> jdouble {
	return cos(x);
}

auto algo4j_math::tan_ice(const jdouble x) -> jdouble {
	return tan(x);
}

auto algo4j_math::cot_ice(const jdouble x) -> jdouble {
	return 1 / tan(x);
}

auto algo4j_math::csc_ice(const jdouble x) -> jdouble {
	return 1 / sin(x);
}

auto algo4j_math::sec_ice(const jdouble x) -> jdouble {
	return 1 / cos(x);
}

auto algo4j_math::ln_ice(const jdouble x) -> jdouble {
	return log(x);
}

auto algo4j_math::lg_ice(const jdouble x) -> jdouble {
	return log10(x);
}

auto algo4j_math::fast_plus(jlong a, jlong b, jlong m) -> jlong {
	decltype(a) ret = 0;
	while (b) {
		if (b & 1) ret = (ret + a) % m;
		b >>= 1;
		a = (a << 1) % m;
	}
	return ret;
}

auto algo4j_math::fast_power(jlong a, jlong b, jlong m) -> jlong {
	decltype(a) ret = 1;
	while (b) {
		if (b & 1) ret = fast_plus(ret, a, m);
		b >>= 1;
		a = fast_plus(a, a, m);
	}
	return ret;
}

auto algo4j_math::is_prime(const jlong num) -> bool {
	if (num < 2) return false;
	if (num == 2) return true;
	if (!(num & 1)) return false;
	for (auto a = 3; a * a <= num; a += 2) {
		if (!(num % a))
			return false;
	}
	return true;
}

auto algo4j_math::get_primes_simple(const jint cnt) -> jlong * {
	auto primes = new jlong[cnt]();
	auto index = 0;
	for (auto i = 2; index < cnt; ++i) {
		auto j = 0;
		for (; j < index; ++j) {
			if (!(i % j)) break;
		}
		if (j >= index) primes[index++] = i;
	}
	return primes;
}

auto algo4j_uset::find(jint *data, jint n) -> jint {
	return data[n] == n ? n : (data[n] = algo4j_uset::find(data, data[n]));
}

auto algo4j_mem::alloc(size_t size) -> jlong {
	return (jlong) malloc(size);
}

auto algo4j_mem::release(jlong pointer) -> void {
	free((void *) pointer);
}

#pragma clang diagnostic pop


#include <c++/5.2.0/cstring>
#include "bigint.h"
#include "basics.hpp"
#include "complex.h"

#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCUnusedGlobalDeclarationInspection"

using algo4j_util::swap;
using algo4j_util::Single;
using algo4j_util::remove_reference;

using algo4j_int::BigInt;

using algo4j_complex::complex;
using algo4j_complex::change;
using algo4j_complex::fft;

#define check_less_than_0 \
while (buf[res_idx] < '0') { \
    buf[res_idx] += 10; \
    --(buf[res_idx - 1]); \
}

#define check_more_than_9 \
while (buf[res_idx] > '9') { \
    buf[res_idx] -= 10; \
    ++buf[res_idx - 1]; \
}

#define trim_string \
while (res_len > 1 and (buf[0] <= '0' or buf[0] > '9')) { \
    --res_len; \
    ++buf; \
} \
while (res_len > 1 and (buf[res_len - 1] < '0' or buf[res_len - 1] > '9')) { \
    --res_len; \
}

algo4j_int::BigInt::BigInt(jbyte *_data, jsize _len) : data(_data), len(_len) { }

auto algo4j_int::compare(
		const jbyte *a,
		const jbyte *b,
		const jsize a_len,
		const jsize b_len) -> jint {
	auto ret = static_cast<jint>(a_len - b_len);
	if (!ret)
		for (auto idx = 0; idx < a_len and not ret; ++idx)
			ret = a[idx] - b[idx];
	return ret;
}

auto algo4j_int::plus(
		jbyte *a,
		jbyte *b,
		jsize a_len,
		jsize b_len) -> BigInt * {
	if (a_len < b_len) {
		swap(a, b);
		swap(a_len, b_len);
	}
	auto a_idx = a_len;
	auto b_idx = b_len;
	auto res_len = a_len + 1;
	auto buf = new jbyte[res_len]();
	buf[0] = '0';
	auto res_idx = res_len;
	while (b_idx > 0) {
		buf[--res_idx] += a[--a_idx] + b[--b_idx] - '0';
		check_more_than_9
	}
	while (a_idx > 0) {
		buf[--res_idx] += a[--a_idx];
		check_more_than_9
	}
	trim_string
	return new BigInt(buf, res_len);
}

auto algo4j_int::minus(
		jbyte *a,
		jbyte *b,
		jsize a_len,
		jsize b_len) -> BigInt * {
	if (a_len < b_len) {
		swap(a, b);
		swap(a_len, b_len);
	}
	auto a_idx = a_len;
	auto b_idx = b_len;
	auto res_len = a_len;
	auto buf = new jbyte[res_len]();
	auto res_idx = res_len;
	while (b_idx > 0) {
		buf[--res_idx] += a[--a_idx] - b[--b_idx] + '0';
		check_less_than_0
	}
	while (a_idx > 0) {
		buf[--res_idx] += a[--a_idx];
		check_less_than_0
	}
	trim_string
	return new BigInt(buf, res_len);
}

auto algo4j_int::times_bf(
		jbyte *a,
		jbyte *b,
		jsize a_len,
		jsize b_len) -> BigInt * {
	if ((a_len == 1 and a[0] == '0') or (b_len == 1 and b[0] == '0')) {
		auto buf = new jbyte[1]();
		buf[0] = '0';
		return new BigInt(buf, 1);
	}
	auto a_idx = a_len;
	auto b_idx = b_len;
	auto res_len = a_len + b_len;
	auto buf = new jbyte[res_len]();
	for (auto __ = 0; __ < a_len; ++__) a[__] -= '0';
	for (auto __ = 0; __ < b_len; ++__) b[__] -= '0';
	while (a_idx-- > 0) {
		if (!a[a_idx])
			continue;
		while (b_idx-- > 0) {
			if (!b[b_idx])
				continue;
			buf[a_idx + b_idx + 1] += a[a_idx] * b[b_idx];
			buf[a_idx + b_idx] += buf[a_idx + b_idx + 1] / 10;
			buf[a_idx + b_idx + 1] = static_cast<jbyte>(buf[a_idx + b_idx + 1] % 10);
		}
		b_idx = b_len;
	}
	auto res_idx = res_len;
	while (res_idx-- > 1) {
		buf[res_idx - 1] += buf[res_idx] / 10;
		buf[res_idx] = static_cast<jbyte>(buf[res_idx] % 10 + '0');
	}
	buf[0] += '0';
	trim_string
	return new BigInt(buf, res_len);
}

auto algo4j_int::times(
		jbyte *a,
		jbyte *b,
		jsize a_len,
		jsize b_len) -> BigInt * {
	if ((a_len == 1 and a[0] == '0') or (b_len == 1 and b[0] == '0')) {
		auto buf = new jbyte[1]();
		buf[0] = '0';
		return new BigInt(buf, 1);
	}
	jsize len = 1;
	auto str1 = a;
	auto str2 = b;
	auto len1 = a_len;
	auto len2 = b_len;
	while (len < len1 << 1 || len < len2 << 1) len <<= 1;
	auto sum = new jint[len];
	complex x1[len];
	complex x2[len];
	for (auto i = 0; i < len1; ++i)
		x1[i] = complex(str1[len1 - 1 - i] - '0');
	for (auto i = len1; i < len; ++i)
		x1[i] = complex();
	for (auto i = 0; i < len2; ++i)
		x2[i] = complex(str2[len2 - 1 - i] - '0');
	for (auto i = len2; i < len; ++i)
		x2[i] = complex();
	// DFT
	fft(x1, len, 1);
	fft(x2, len, 1);
	for (auto i = 0; i < len; ++i)
		x1[i] = x1[i] * x2[i];
	fft(x1, len, -1);
	for (auto i = 0; i < len; ++i)
		sum[i] = (remove_reference<decltype(sum[0])>::type) (x1[i].r + 0.5);
	for (auto i = 0; i < len; ++i) {
		sum[i + 1] += sum[i] / 10;
		sum[i] %= 10;
	}
	len = len1 + len2 - 1;
	while (sum[len] <= 0 && len > 0) --len;
	auto ret = new jbyte[len];
	for (jsize __ = len, j = 0; __ >= 0; --__, ++j)
		ret[j] = (jbyte) (sum[__] + '0');
	delete sum;
//	delete x1;
//	delete x2;
	return new BigInt(ret, ++len);
}

auto algo4j_int::divide(
		jbyte *a,
		jbyte *b,
		jsize a_len,
		jsize b_len
) -> BigInt * { return nullptr; }

//auto algo4j_int::BigInt::operator/(const BigInt &o) const -> BigInt & {
//	auto res_len = len;
//	auto buf = new jbyte[res_len]();
//	auto f_data = new jbyte[1]();
//	f_data[0] = '0';
//	auto f = new Single<BigInt>(new BigInt(f_data, 1));
//	for (int i = len - 1; i >= 0; --i) {
//		f->get()->times_10();
//		f->get()->data[0] = this->data[i];
//		while (*f->get() >= o) {
//			auto tmp = *f->get() - o;
//			f->set(&tmp);
//			++buf[i];
//			printf("[%i, %i]", buf[i], i);
//		}
//	}
//	trim_string
//	delete f;
//	return *new BigInt(buf, res_len);
//}

namespace algo4j_int {

//	auto operator<<(ostream &os, const BigInt &o) -> ostream & {
//		for (auto _ = 0; _ < o.len; ++_) {
//			os << o.data[_];
//		}
//		return os;
//	}
//
//	auto operator>>(istream &is, BigInt &o) -> istream & {
//		for (auto _ = 0; _ < o.len; ++_) {
//			is >> o.data[_];
//		}
//		return is;
//	}
}

#undef check_more_than_9
#undef check_less_than_0
#undef trim_string


#pragma clang diagnostic pop

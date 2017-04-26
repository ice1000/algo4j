
#include "bigint.h"
#include "basics.hpp"
#include "complex.h"

#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCUnusedGlobalDeclarationInspection"

using algo4j_util::swap;
using algo4j_util::Single;
using algo4j_util::remove_reference;
using algo4j_util::can_trim;

using algo4j_int::BigInt;

using algo4j_complex::complex;
using algo4j_complex::change;
using algo4j_complex::fft;

algo4j_int::BigInt::BigInt(jbyte *_data, jsize _len) :
		data(_data),
		len(_len),
		offset(head_offset(data, len)) { }

algo4j_int::BigInt::BigInt(const char *_data, jsize _len) :
		data((jbyte *) _data),
		len(_len),
		offset(head_offset(data, len)) { }

auto BigInt::data_trim() -> jbyte * {
	return data + offset;
}

auto BigInt::len_trim() -> jsize {
	return len - offset;
}

auto algo4j_int::compare(
		jbyte *a,
		jbyte *b,
		jsize a_len,
		jsize b_len) -> jint {
	while (a_len > 0 and can_trim(a[0])) ++a, --a_len;
	while (b_len > 0 and can_trim(b[0])) ++b, --b_len;
	auto ret = static_cast<jint>(a_len - b_len);
	if (not ret)
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
		while (buf[res_idx] > '9') {
			buf[res_idx] -= 10;
			++buf[res_idx - 1];
		}
	}
	while (a_idx > 0) {
		buf[--res_idx] += a[--a_idx];
		while (buf[res_idx] > '9') {
			buf[res_idx] -= 10;
			++buf[res_idx - 1];
		}
	}

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
		while (buf[res_idx] < '0') {
			buf[res_idx] += 10;
			--(buf[res_idx - 1]);
		}
	}
	while (a_idx > 0) {
		buf[--res_idx] += a[--a_idx];
		while (buf[res_idx] < '0') {
			buf[res_idx] += 10;
			--(buf[res_idx - 1]);
		}
	}
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
	while (len < len1 << 1 or len < len2 << 1) len <<= 1;
	auto sum = new jlong[len + 1];
	auto x1 = new complex[len]();
	auto x2 = new complex[len]();
	for (auto __ = 0; __ < len1; ++__)
		x1[__] = complex(str1[len1 - 1 - __] - '0');
	for (auto __ = len1; __ < len; ++__)
		x1[__] = complex();
	for (auto __ = 0; __ < len2; ++__)
		x2[__] = complex(str2[len2 - 1 - __] - '0');
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
	while (0 >= sum[len] and 0 < len) --len;
	auto ret = new jbyte[len + 1];
	auto j = 0;
	for (auto __ = len; 0 <= __; --__, ++j)
		ret[j] = (jbyte) (sum[__] + '0');
	delete sum;
	return new BigInt(ret, ++len);
}

auto algo4j_int::divide(
		jbyte *a,
		jbyte *b,
		jsize a_len,
		jsize b_len
) -> BigInt * {
	auto cmp_res = compare(a, b, a_len, b_len);
	if (0 > cmp_res) return new BigInt((jbyte *) "0", 1);
	else if (not cmp_res) return new BigInt((jbyte *) "1", 1);
	else {
		auto len3 = 0;
		auto _res = new jbyte[a_len - b_len + 1]();
		auto _ret = new jbyte[a_len - b_len + 1]();
		for (auto i = 0; i < a_len; ++i) {
			_res[len3] = a[i];
			_res[++len3] = '\0';
			_ret[i] = '0';
			_ret[i + 1] = '\0';
			while (compare(_res, b, len3, b_len) >= 0) {
				auto res = minus(_res, b, len3, b_len);
				_res = res->data_trim();
				len3 = res->len_trim();
				delete res;
				_res[len3] = '\0';
				++_ret[i];
			}
		}
		return new BigInt(_ret, a_len);
	}
}

inline auto algo4j_int::head_offset(jbyte *a, jsize len) -> jsize {
	jsize ret = 0;
	while (ret < len - 1 and (a[ret] <= '0' or a[ret] > '9')) ++ret;
	return ret;
}

auto algo4j_int::rem(
		jbyte *a,
		jbyte *b,
		jsize a_len,
		jsize b_len) -> BigInt * {
	auto cmp_res = compare(a, b, a_len, b_len);
	if (0 > cmp_res) return new BigInt(a, a_len);
	else if (not cmp_res) return new BigInt((jbyte *) "0", 1);
	else {
		auto len3 = 0;
		auto _res = new jbyte[a_len - b_len + 1]();
		for (auto i = 0; i < a_len; ++i) {
			_res[len3] = a[i];
			_res[++len3] = '\0';
			while (compare(_res, b, len3, b_len) >= 0) {
				auto res = minus(_res, b, len3, b_len);
				_res = res->data_trim();
				len3 = res->len_trim();
				delete res;
				_res[len3] = '\0';
			}
		}
		return new BigInt(_res, len3);
	}
}

#pragma clang diagnostic pop

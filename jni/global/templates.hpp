//
// Created by ice1000 at 2016/11
//

//#include <ostream>
//#include <istream>
#include <string.h>

#include "sort.hpp"
#include "basics.hpp"

using algo4j_sort::merge_sort;
using algo4j_sort::quick_sort;

using algo4j_util::min;
using algo4j_util::max;
using algo4j_util::swap;

//using std::istream;
//using std::ostream;

#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCUnusedStructInspection"
#pragma ide diagnostic ignored "OCUnusedGlobalDeclarationInspection"

#ifndef __ALGO4J_TEMPLATES_HPP__
#define __ALGO4J_TEMPLATES_HPP__

#ifndef __lowbit
#define __lowbit(x) ((x) bitand (-(x)))
#endif /// __lowbit

namespace algo4j_math {

	template<typename T>
	auto fast_plus(T a, T b, T _) -> T {
		T ret = 0;
		while (b) {
			if (b bitand 1)
				ret = (ret + a) % _;
			b >>= 1;
//			a <<= 1;
//			a %= _;
			a = (a << 1) % _;
		}
		return ret;
	}

	template<typename T>
	auto fast_power(T a, T b, T m) -> T {
		T ret = 1;
		while (b) {
			if (b bitand 1)
				ret = fast_plus(ret, a, m);
			b >>= 1;
			a = fast_plus(a, a, m);
		}
		return ret;
	}

}

namespace algo4j_bit {
	template<typename T>
	constexpr auto lowbit(const T a) -> jlong {
		return __lowbit(a);
	}

	template<typename T>
	auto add(
			T *data,
			jsize len,
			jsize idx,
			T value) -> void {
		while (idx < len) {
			data[idx] += value;
			idx += lowbit(idx);
		}
	}

	template<typename T>
	auto sum(
			T *data,
			jsize idx) -> jlong {
		jlong ret = 0;
		while (idx > 0) {
			ret += data[idx];
			idx -= lowbit(idx);
		}
		return ret;
	}

	template<typename T>
	auto inversion(
			T *arr,
			const jsize len,
			const jsize maxV) -> jlong {
		auto bit = new jlong[maxV]();
		memset(bit, 0, sizeof(bit[0]) * maxV);
		jlong ret = 0;
		for (jsize _ = 0; _ < len; ++_) {
			add(bit, static_cast<jsize>(len) + 1, arr[_], 1LL);
			ret += _ + 1 - sum(bit, arr[_]);
		}
		delete bit;
		return ret;
	}
}

namespace algo4j_util {

	template<typename T>
	auto copy(T *data, jsize len) -> T * {
		auto ret = new T[len]();
		for (auto _ = 0; _ < len; ++_) {
			ret[_] = data[_];
		}
		return ret;
	}

	template<typename T1, typename T2>
	class Pair {
	public:
		T1 first;
		T2 second;

		constexpr Pair(const T1 &f, const T2 &s) :
				first(f),
				second(s) {}

		constexpr explicit Pair(const T1 &o) :
				first(o),
				second(static_cast<T2>(o)) {}

		constexpr explicit Pair() : first(), second() {}

		~Pair() {}

		void setValue(const T1 &f, const T2 &s) {
			first = f;
			second = s;
		}

		constexpr auto operator<(const Pair &o) const -> const bool {
			return first == o.first ? second < o.second : first < o.first;
		}

		constexpr auto operator==(const Pair &o) const -> const bool {
			return first == o.first and second == o.second;
		}

		constexpr auto operator<=(const Pair &o) const -> const bool {
			return *this < o or *this == o;
		}

		constexpr auto operator>(const Pair &o) const -> const bool {
			return not(*this <= o);
		}

		constexpr auto operator>=(const Pair &o) const -> const bool {
			return not(*this < o);
		}

		constexpr auto operator!=(const Pair &o) const -> const bool {
			return not(*this == o);
		}

		constexpr auto operator+(const Pair &o) const -> const Pair * {
			return new Pair(first + o.first, second + o.second);
		}

		constexpr auto operator-(const Pair &o) const -> const Pair * {
			return new Pair(first - o.first, second - o.second);
		}

//		constexpr auto operator*(const Pair &o) const -> const Pair * {
//			return new Pair(first * o.first, second * o.second);
//		}

//		auto operator=(Pair &pair) -> Pair & {
//			first = pair.first;
//			second = pair.second;
//			return *this;
//		}
//
//		friend auto operator<<(ostream &os, const Pair &pair) -> ostream & {
//			os << "first: " << pair.first << " second: " << pair.second;
//			return os;
//		}
//
//		friend auto operator>>(istream &is, Pair &pair) -> istream & {
//			is >> pair.first >> pair.second;
//			return is;
//		}
	};

	/// 离散化
	/// discretization is to reduce the range of data
	template<typename T>
	inline auto discretization(
			T *data,
			const jsize len) -> T * {
		auto pair = new Pair<T, jint>[len]();
		auto after = new T[len]();
		for (auto _ = 0; _ < len; ++_)
			pair[_].setValue(data[_], _);
		merge_sort(pair, len);
		for (auto _ = 0, __ = 0; _ < len; ++_, ++__) {
			after[pair[_].second] = __;
			if ((_ + 1 < len) and pair[_].first == pair[_ + 1].first)
				--__;
		}
		delete[] pair;
		return after;
	}

	/// kmp
	template<typename T>
	inline auto kmp(
			T *x, /// shorter
			const jsize m,
			T *y, /// longer
			const jsize n) -> jint {
		if (m > n) return 0;
		if (m == 1) {
			jsize ret = 0;
			for (auto i = 0; i < n; ++i) {
				if (y[i] == x[0])
					++ret;
			}
			return ret;
		}
		auto next = new T[n]();
		jsize i = 0;
		jsize j = next[0] = -1;
		while (i < m) {
			if (-1 == j or y[i] == y[j]) {
				next[++i] = ++j;
			} else {
				j = next[j];
			}
		}
		i = 0;
		j = 0;
		jint ans = 0;
		while (i < n and j < m) {
			if (-1 == j or y[i] == x[j]) {
				++i;
				++j;
			} else {
				j = next[j];
			}
			if (j == m) {
				++ans;
				i -= j - 1;
				j = -1;
			}
		}
		delete next;
		return ans;
	}
}

#endif /// __ALGO4J_TEMPLATES_HPP__


#pragma clang diagnostic pop

//
// Created by ice1000 at 2016/11
//

#include <ostream>
#include <istream>

#include "sort.hpp"

using algo4j_sort::merge_sort;
using algo4j_sort::quick_sort;

#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCUnusedStructInspection"
#pragma ide diagnostic ignored "OCUnusedGlobalDeclarationInspection"

#ifndef __ALGO4J_TEMPLATES_HPP__
#define __ALGO4J_TEMPLATES_HPP__

#ifndef __lowbit
#define __lowbit(x) ((x) & (-(x)))
#endif /// __lowbit

namespace algo4j_bit {
	constexpr auto lowbit(const long long int a) -> jlong {
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
		for (jsize i = 0; i < len; ++i) {
			add(bit, static_cast<jsize>(len) + 1, arr[i], 1LL);
			ret += i + 1 - sum(bit, arr[i]);
		}
		delete bit;
		return ret;
	}
}

namespace algo4j_util {

	template<typename T1, typename T2>
	class Pair {
	public:
		T1 first;
		T2 second;

		constexpr Pair(const T1 &f, const T2 &s) :
				first(f),
				second(s) { }

		constexpr explicit Pair(const T1 &o) :
				first(o),
				second(static_cast<T2>(o)) { }

		constexpr explicit Pair() : first(), second() { }

		~Pair() { }

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
			return !(*this <= o);
		}

		constexpr auto operator>=(const Pair &o) const -> const bool {
			return !(*this < o);
		}

		constexpr auto operator!=(const Pair &o) const -> const bool {
			return !(*this == o);
		}

//		auto operator=(Pair &pair) -> Pair & {
//			first = pair.first;
//			second = pair.second;
//			return *this;
//		}

		friend auto operator<<(std::ostream &os, const Pair &pair) -> std::ostream & {
			os << "first: " << pair.first << " second: " << pair.second;
			return os;
		}

		friend auto operator>>(std::istream &is, Pair &pair) -> std::istream & {
			is >> pair.first >> pair.second;
			return is;
		}
	};

	/// 离散化
	/// discretization is to reduce the range of data
	template<typename T>
	inline auto discretization(
			T *data,
			const jsize len) -> T * {
		auto pair = new algo4j_util::Pair<T, jint>[len]();
		auto after = new T[len]();
		for (auto i = 0; i < len; ++i) pair[i].setValue(data[i], i);
		merge_sort(pair, len);
		for (auto i = 0, j = 0; i < len; ++i, ++j) {
			after[pair[i].second] = j;
			if ((i + 1 < len) and pair[i].first == pair[i + 1].first) --j;
		}
		delete[] pair;
		return after;
	}
}

namespace algo4j_int {
	template<typename SIZE_TYPE>
	auto compare(jbyte *a, jbyte *b, SIZE_TYPE a_len, SIZE_TYPE b_len) -> jint {
		jint ret = static_cast<jint>(a_len - b_len);
		if (!ret) {
			for (auto idx = 0; idx < a_len and !ret; ++idx) {
				ret = a[idx] - b[idx];
			}
		}
		return ret;
	}
}

#endif /// __ALGO4J_TEMPLATES_HPP__


#pragma clang diagnostic pop

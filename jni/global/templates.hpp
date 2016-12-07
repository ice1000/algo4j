//
// Created by ice1000 at 2016/11
//

#include <jni.h>
#include <ostream>
#include <istream>

#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCUnusedStructInspection"
#pragma ide diagnostic ignored "OCUnusedGlobalDeclarationInspection"

#ifndef JNI_ORG_ICE1000_PUBLIC_TEMPLATES_HPP
#define JNI_ORG_ICE1000_PUBLIC_TEMPLATES_HPP

namespace ice1000_util {

	template<typename T1, typename T2>
	class Ice1000Pair {
	public:
		T1 first;
		T2 second;

		Ice1000Pair(const T1 &f, const T2 &s) : first(f), second(s) { }
		
		explicit Ice1000Pair(const T1 &o) : first(o), second(static_cast<T2>(o)) { };

		explicit Ice1000Pair() { }

		~Ice1000Pair() { }

		void setValue(const T1 &f, const T2 &s) {
			first = f;
			second = s;
		}

		constexpr auto operator<(const Ice1000Pair &o) const -> const bool {
			return first == o.first ? second < o.second : first < o.first;
		}

		constexpr auto operator==(const Ice1000Pair &o) const -> const bool {
			return first == o.first and second == o.second;
		}

		constexpr auto operator<=(const Ice1000Pair &o) const -> const bool {
			return *this < o or *this == o;
		}

		constexpr auto operator>(const Ice1000Pair &o) const -> const bool {
			return !(*this <= o);
		}

		constexpr auto operator>=(const Ice1000Pair &o) const -> const bool {
			return !(*this < o);
		}

		constexpr const bool operator!=(const Ice1000Pair &o) const {
			return !(*this == o);
		}

		friend auto operator<<(std::ostream &os, const Ice1000Pair &pair) -> std::ostream& {
			os << "first: " << pair.first << " second: " << pair.second;
			return os;
		}

		friend auto operator>>(std::istream &is, Ice1000Pair &pair) -> std::istream& {
			is >> pair.first >> pair.second;
			return is;
		}
	};

	template<typename T>
	constexpr auto swap (T &a, T &b) -> void {
		T c = a;
		a = b;
		b = c;
	}

	template<typename T>
	constexpr auto max(const T &a, const T &b) -> T {
		return a < b ? b : a;
	}

	template<typename T>
	constexpr auto min(const T &a, const T &b) -> T {
		return a < b ? a : b;
	}

// 日了狗了 实在不行我就硬编码类型进去 md

	template<typename T>
	auto __quick_sort_core (
			T *array,
			const jsize left,
			const jsize right) -> void {
		if (left >= right) return;
		auto i = left;
		auto j = right;
		while (i < j) {
			while ((i <= j) and  (array[left] < array[j])) --j;
			while ((i <= j) and !(array[left] < array[i])) ++i;
			swap(array[i], array[j]);
		}
		swap(array[left], array[i]);
		__quick_sort_core(array, left, i - 1);
		__quick_sort_core(array, i + 1, right);
	}

	template<typename T>
	auto __quick_sort_core_with_cmp (
			T *array,
			const jsize left,
			const jsize right,
			bool (*compare) (const T &, const T &)) -> void {
		if (left >= right) return;
		auto i = left;
		auto j = right;
		while (i < j) {
			while ((i <= j) and compare(array[left], array[j]) < 0) --j;
			while ((i <= j) and compare(array[left], array[i]) >= 0) ++i;
			swap(array[i], array[j]);
		}
		swap(array[left], array[i]);
		__quick_sort_core_with_cmp(array, left, i - 1, compare);
		__quick_sort_core_with_cmp(array, i + 1, right, compare);
	}

	template<typename T>
	auto quick_sort (
			T *array,
			const jsize length) -> void {
		__quick_sort_core(array, 0, length - 1);
	}

	template<typename T>
	auto quick_sort_with_cmp (
			T *array,
			const jsize length,
			bool (*compare) (const T &, const T &)) -> void {
		__quick_sort_core_with_cmp(array, 0, length - 1, compare);
	}

	template<typename T>
	auto bubble_sort (
			T *array,
			const jsize length) -> void {
		for (auto i = length - 1; i > 0; --i) {
			for (auto j = 0; j < i; ++j) {
				if (!(array[j] < array[i])) swap(array[i], array[j]);
			}
		}
	}

	template<typename T>
	auto bubble_sort_with_cmp (
			T *array,
			const jsize length,
			bool (*compare) (const T &, const T &)) -> void {
		for (auto i = length - 1; i > 0; --i) {
			for (auto j = 0; j < i; ++j) {
				if (compare(array[j], array[i]) < 0) swap(array[i], array[j]);
			}
		}
	}

	template<typename T>
	auto insertion_sort (
			T *array,
			const jsize length) -> void {
		for (auto i = 1; i < length; ++i) {
			auto j = i - 1;
			auto key = array[i];
			while (j >= 0 and array[j] > key) {
				array[j + 1] = array[j];
				--j;
			}
			array[j + 1] = key;
		}
	}

	template<typename T>
	auto insertion_sort_with_cmp (
			T *array,
			const jsize length,
			bool (*compare) (const T &, const T &)) -> void {
		for (auto i = 1; i < length; ++i) {
			auto j = i - 1;
			auto key = array[i];
			while (j >= 0 and compare(array[j], key) > 0) {
				array[j + 1] = array[j];
				--j;
			}
			array[j + 1] = key;
		}
	}

	template<typename T>
	auto in_place_sort(
			T *array,
			const jsize length) -> void {
		//
	}

	template<typename T>
	auto in_place_sort_with_cmp(
			T *array,
			const jsize length,
			bool (*compare) (const T &, const T &)) -> void {
		//
	}

	/// 离散化
	/// discretization is to reduce the range of data
	template<typename T>
	auto discretization (T *data, const jsize len) -> T* {
		auto pair = new ice1000_util::Ice1000Pair<T, jint>[len]();
		auto after = new T[len]();
		for (auto i = 0; i < len; ++i) pair[i].setValue(data[i], i);
		// TODO change into quick sort
		ice1000_util::bubble_sort(pair, len);
		for (auto i = 0, j = 0; i < len; ++i, ++j) {
			after[pair[i].second] = j;
			if ((i + 1 < len) and pair[i].first == pair[i + 1].first) --j;
		}
		return after;
	}
}

#endif /// JNI_ORG_ICE1000_PUBLIC_FUNCTIONS_H


#pragma clang diagnostic pop

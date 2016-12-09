
#include "basics.hpp"

using ice1000_util::min;
using ice1000_util::max;
using ice1000_util::swap;

#ifndef __ICE1000_SORT_HPP__
#define __ICE1000_SORT_HPP__

namespace ice1000_sort {

// 日了狗了 实在不行我就硬编码类型进去 md
	template<typename T>
	auto __quick_sort_core (
			T *array,
			const jsize left,
			const jsize right) -> void {
		if (left >= right) return;
		auto i = left;
		auto j = right;
		const auto temp = array[left];
		while (i < j) {
			while ((i < j) and  (temp < array[j] or temp == array[j])) --j;
			while ((i < j) and !(temp < array[i])) ++i;
			if (i < j)
				swap(array[i], array[j]);
		}
		array[left] = array[i];
		array[i] = temp;
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
		const auto temp = array[left];
		while (i < j) {
			while ((i < j) and compare(temp, array[j]) <= 0) --j;
			while ((i < j) and compare(temp, array[i]) >= 0) ++i;
			if (i < j)
				swap(array[i], array[j]);
		}
		array[left] = array[i];
		array[i] = temp;
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
		// TODO
	}

	template<typename T>
	auto in_place_sort_with_cmp(
			T *array,
			const jsize length,
			bool (*compare) (const T &, const T &)) -> void {
		// TODOs
	}

	template<typename T>
	auto merge_sort(
			T *arr,
			const jsize len) -> void {
		auto a = arr;
		auto b = new T[len];
		for (jsize seg = 1; seg < len; seg += seg) {
			for (jsize start = 0; start < len; start += seg + seg) {
				auto low = start;
				auto mid = min(start + seg, len);
				auto high = min(start + seg + seg, len);
				auto k = low;
				auto start1 = low;
				auto end1 = mid;
				auto start2 = mid;
				auto end2 = high;
				while (start1 < end1 and start2 < end2)
					b[k++] = a[start1] < a[start2] ? a[start1++] : a[start2++];
				while (start1 < end1)
					b[k++] = a[start1++];
				while (start2 < end2)
					b[k++] = a[start2++];
			}
			swap(a, b);
		}
		if (a != arr) {
			for (auto i = 0; i < len; i++)
				b[i] = a[i];
			b = a;
		}
		delete[] b;
	}

	template<typename T>
	auto merge_sort_with_cmp(
			T *arr,
			const jsize len,
			bool (*compare) (const T &, const T &)) -> void {
		auto a = arr;
		auto b = new T[len];
		for (jsize seg = 1; seg < len; seg += seg) {
			for (jsize start = 0; start < len; start += seg + seg) {
				auto low = start;
				auto mid = min(start + seg, len);
				auto high = min(start + seg + seg, len);
				auto k = low;
				auto start1 = low, end1 = mid;
				auto start2 = mid, end2 = high;
				while (compare(start1, end1) < 0 and compare(start2, end2) < 0)
					b[k++] = compare(a[start1], a[start2]) < 0 ? a[start1++] : a[start2++];
				while (start1 < end1)
					b[k++] = a[start1++];
				while (start2 < end2)
					b[k++] = a[start2++];
			}
			swap(a, b);
		}
		if (a != arr) {
			for (auto i = 0; i < len; i++)
				b[i] = a[i];
			b = a;
		}
		delete[] b;
	}
}


#endif // __ICE1000_SORT_HPP__


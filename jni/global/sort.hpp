
#include "basics.hpp"

using algo4j_util::min;
using algo4j_util::max;
using algo4j_util::swap;

#ifndef __ALGO4J_SORT_HPP__
#define __ALGO4J_SORT_HPP__

namespace algo4j_sort {

// 日了狗了 实在不行我就硬编码类型进去 md
	template<typename T>
	auto __quick_sort_core(
			T *array,
			const jsize left,
			const jsize right) -> void {
		if (left >= right) return;
		auto i = left;
		auto j = right;
		const auto temp = array[left];
		while (i < j) {
			while ((i < j) and (temp < array[j] or temp == array[j])) --j;
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
	inline auto quick_sort(
			T *array,
			const jsize length) -> void {
		__quick_sort_core(array, 0, length - 1);
	}

	template<typename T>
	inline auto bubble_sort(
			T *array,
			const jsize length) -> void {
		for (auto i = length - 1; i > 0; --i) {
			for (auto j = 0; j < i; ++j) {
				if (!(array[j] < array[i])) swap(array[i], array[j]);
			}
		}
	}

	template<typename T>
	inline auto insertion_sort(
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
	auto merge_sort_recursive(T arr[], T reg[], jsize start, jsize end) -> void {
		if (start >= end)
			return;
		auto len = end - start, mid = (len >> 1) + start;
		auto start1 = start, end1 = mid;
		auto start2 = mid + 1, end2 = end;
		merge_sort_recursive(arr, reg, start1, end1);
		merge_sort_recursive(arr, reg, start2, end2);
		auto k = start;
		while (start1 <= end1 and start2 <= end2)
			reg[k++] = arr[start1] < arr[start2] ? arr[start1++] : arr[start2++];
		while (start1 <= end1)
			reg[k++] = arr[start1++];
		while (start2 <= end2)
			reg[k++] = arr[start2++];
		for (k = start; k <= end; ++k)
			arr[k] = reg[k];
	}

	template<typename T>
	auto merge_sort(
			T *arr,
			const jsize length) -> void {
		auto reg = new T[length]();
		merge_sort_recursive(arr, reg, 0, length - 1);
	}

	template<typename T>
	inline auto comb_sort(
			T *arr,
			const jsize length) -> void {
		auto shrink_factor = 0.8;
		auto gap = length;
		auto swapped = true;
		while (gap > 1 || swapped) {
			if (gap > 1)
				gap = static_cast<int>(static_cast<double>(gap) * shrink_factor);
			swapped = false;
			for (auto i = 0; gap + i < length; ++i)
				if (arr[i] > arr[i + gap]) {
					swap(arr[i], arr[i + gap]);
					swapped = true;
				}
		}
	}

	template<typename T>
	inline auto selection_sort(
			T *arr,
			const jsize length) -> void {
		jsize min;
		for (auto i = 0; i < length - 1; ++i) {
			min = i;
			for (auto j = i + 1; j < length; ++j)
				if (arr[min] > arr[j])
					min = j;
			swap(arr[i], arr[min]);
		}
	}

	template<typename T>
	inline auto cocktail_sort(
			T *arr,
			const jsize len) -> void {
		auto left = 0;
		auto right = len - 1;
		while (left < right) {
			for (auto j = left; j < right; ++j)
				if (arr[j] > arr[j + 1])
					swap(arr[j], arr[j + 1]);
			--right;
			for (auto j = right; j > left; --j)
				if (arr[j - 1] > arr[j])
					swap(arr[j - 1], arr[j]);
			++left;
		}
	}

}


#endif // __ALGO4J_SORT_HPP__



#include "basics.hpp"

using ice1000_util::min;
using ice1000_util::max;
using ice1000_util::swap;

#ifndef __ICE1000_SORT_HPP__
#define __ICE1000_SORT_HPP__

namespace ice1000_sort {

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
	auto quick_sort(
			T *array,
			const jsize length) -> void {
		__quick_sort_core(array, 0, length - 1);
	}

	template<typename T>
	auto bubble_sort(
			T *array,
			const jsize length) -> void {
		for (auto i = length - 1; i > 0; --i) {
			for (auto j = 0; j < i; ++j) {
				if (!(array[j] < array[i])) swap(array[i], array[j]);
			}
		}
	}

	template<typename T>
	auto insertion_sort(
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
	auto merge_sort(
			T *array,
			const jsize length) -> void {
		auto copy = array;
		auto arr2 = new T[length];
		for (jsize seg = 1; seg < length; seg += seg) {
			for (jsize start = 0; start < length; start += seg + seg) {
				auto low = start;
				auto mid = min(start + seg, length);
				auto high = min(start + seg + seg, length);
				auto k = low;
				auto start1 = low;
				auto end1 = mid;
				auto start2 = mid;
				auto end2 = high;
				while (start1 < end1 and start2 < end2)
					arr2[k++] = copy[start1] < copy[start2] ? copy[start1++] : copy[start2++];
				while (start1 < end1)
					arr2[k++] = copy[start1++];
				while (start2 < end2)
					arr2[k++] = copy[start2++];
			}
			swap(copy, arr2);
		}
		if (copy != array) {
			for (auto i = 0; i < length; ++i)
				arr2[i] = copy[i];
			arr2 = copy;
		}
		delete[] arr2;
	}

	template<typename T>
	auto comb_sort(
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
	auto selection_sort(
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
	auto cocktail_sort(
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


#endif // __ICE1000_SORT_HPP__


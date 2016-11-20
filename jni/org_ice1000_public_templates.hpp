#include <jni.h>

#ifndef JNI_ORG_ICE1000_PUBLIC_TEMPLATES_HPP
#define JNI_ORG_ICE1000_PUBLIC_TEMPLATES_HPP

namespace ice1000_util {

	template<typename T>
	void swap(T &a, T &b) {
	  T c = a;
	  a = b;
	  b = c;
	}

// 日了狗了 实在不行我就硬编码类型进去 md

	template<typename T>
	void __quick_sort_core(
			T *array,
			const jsize left,
			const jsize right) {
		if (left >= right) return;
		auto i = left;
		auto j = right;
		T standard = array[left];
		T temp;
		while (i < j) {
			while ((i <= j) and (standard < array[j] or standard == array[j])) --j;
			array[i] = array[j];
			while ((i <= j) and !(standard < array[i])) ++i;
			array[j] = array[i];
		}
		array[i] = standard;
		// delete &temp;
		__quick_sort_core(array, left, i - 1);
		__quick_sort_core(array, i + 1, right);
	}

	template<typename T>
	void __quick_sort_core_with_cmp(
			T *array,
			const jsize left,
			const jsize right,
			bool (*compare)(const T &, const T &)) {
		if (left >= right) return;
		auto i = left;
		auto j = right;
		T standard = array[left];
		T temp;
		while (i < j) {
			while ((i < j) and compare(standard, array[j]) >= 0) --j;
			array[i] = array[j];
			while ((i < j) and compare(standard, array[i]) <= 0) ++i;
			array[j] = array[i];
		}
		array[i] = standard;
		// delete &temp;
		__quick_sort_core_with_cmp(array, left, i - 1, compare);
		__quick_sort_core_with_cmp(array, i + 1, right, compare);
	}

	template<typename T>
	void quick_sort(
			T *array,
			const jsize length) {
		__quick_sort_core(array, 0, length - 1);
	}

	template<typename T>
	void quick_sort_with_cmp(
			T *array,
			const jsize length,
			bool (*compare)(const T &, const T &)) {
		__quick_sort_core_with_cmp(array, 0, length - 1, compare);
	}

	template<typename T>
	void bubble_sort(
			T *array,
			const jsize length) {
		for (auto i = length - 1; i > 0; --i) {
			for (auto j = 0; j < i; ++j) {
				if (array[j] > array[i]) swap(array[i], array[j]);
			}
		}
	}

	template<typename T>
	void bubble_sort_with_cmp(
			T *array,
			const jsize length,
			bool (*compare)(const T &, const T &)) {
		for (auto i = length - 1; i > 0; --i) {
			for (auto j = 0; j < i; ++j) {
				if (compare(array[j], array[i]) < 0) swap(array[i], array[j]);
			}
		}
	}

	template<typename T1, typename T2>
	struct Ice1000Pair {
		T1 first;
		T2 second;

		Ice1000Pair(const T1 &f, const T2 &s) : first(f), second(s) { }

		Ice1000Pair() { }

		~Ice1000Pair() {
		  delete &first;
		  delete &second;
		}

		void setValue(const T1 &f, const T2 &s) {
			first = f;
			second = s;
		}

		const bool operator<(const Ice1000Pair &o) const {
			return first == o.first ? second < o.second : first < o.first;
		}

		const bool operator==(const Ice1000Pair &o) const {
		  return first == o.first and second == o.second;
		}

		const bool operator<=(const Ice1000Pair &o) const {
		  return *this < o or *this == o;
		}

		const bool operator>(const Ice1000Pair &o) const {
		  return !(*this <= o);
		}

		const bool operator>=(const Ice1000Pair &o) const {
		  return !(*this < o);
		}

		const bool operator!=(const Ice1000Pair &o) const {
		  return !(*this == o);
		}
	};
}

#endif /// JNI_ORG_ICE1000_PUBLIC_FUNCTIONS_H


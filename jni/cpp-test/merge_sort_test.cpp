#include "../global/templates.hpp"
#include <iostream>

using std::cout;
using std::endl;
using algo4j_sort::merge_sort;

template<typename T>
void merge_sort2(T arr[], const jsize len) {
	T* a = arr;
	T* b = new T[len];
	for (int seg = 1; seg < len; seg += seg) {
		for (int start = 0; start < len; start += seg + seg) {
			int low = start, mid = min(start + seg, len), high = min(start + seg + seg, len);
			int k = low;
			int start1 = low, end1 = mid;
			int start2 = mid, end2 = high;
			while (start1 < end1 && start2 < end2)
				b[k++] = a[start1] < a[start2] ? a[start1++] : a[start2++];
			while (start1 < end1)
				b[k++] = a[start1++];
			while (start2 < end2)
				b[k++] = a[start2++];
		}
		algo4j_util::swap(a, b); 
	}
	if (a != arr) {
		for (int i = 0; i < len; i++)
			b[i] = a[i];
		b = a;
	}
	delete[] b;
}

template<typename T>
void merge_sort_recursive(T arr[], T reg[], int start, int end) {
	if (start >= end)
		return;
	int len = end - start, mid = (len >> 1) + start;
	int start1 = start, end1 = mid;
	int start2 = mid + 1, end2 = end;
	merge_sort_recursive(arr, reg, start1, end1);
	merge_sort_recursive(arr, reg, start2, end2);
	int k = start;
	while (start1 <= end1 && start2 <= end2)
		reg[k++] = arr[start1] < arr[start2] ? arr[start1++] : arr[start2++];
	while (start1 <= end1)
		reg[k++] = arr[start1++];
	while (start2 <= end2)
		reg[k++] = arr[start2++];
	for (k = start; k <= end; k++)
		arr[k] = reg[k];
}

template<typename T>
void merge_sort3(T arr[], const int len) {
	T reg[len];
	merge_sort_recursive(arr, reg, 0, len - 1);
}

auto main(int argc, const char *argv[]) -> int {
	int a[] = { 3, 5, 2, 4, 344, 233, 4343, 1 };
	merge_sort(a, sizeof(a) / sizeof(a[0]));
	for (auto i = 0; i < sizeof(a) / sizeof(a[0]); ++i) {
		cout << a[i] << endl;
	}
	return 0;
}

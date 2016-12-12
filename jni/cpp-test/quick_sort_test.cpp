#include "../global/templates.hpp"
#include <iostream>

#define size 10

using std::cout;

int arr[size] = {
		34, 43, 43, 23, 2, 43, 545, 45, 6565, 65
};

void quicksort(const int left, const int right) {
	if (left > right)
		return;
	int i = left, j = right, tt;
	const int temp = arr[left];
	while (i != j) {
		while (i < j && arr[j] >= temp) j--;
		while (i < j && arr[i] <= temp) i++;
		if (i < j) {
			tt = arr[i];
			arr[i] = arr[j];
			arr[j] = tt;
		}
	}
	arr[left] = arr[i];
	arr[i] = temp;
	quicksort(left, i - 1);
	quicksort(i + 1, right);
}

auto main(int argc, const char *argv[]) -> int {
	algo4j_sort::quick_sort<int>(arr, sizeof(arr) / sizeof(arr[0]));
//	quicksort(0, size-1);
	for (auto i = 0; i < sizeof(arr) / sizeof(decltype(arr[0])); ++i) {
		cout << arr[i] << " ";
	}
	delete arr;
	return 0;
}



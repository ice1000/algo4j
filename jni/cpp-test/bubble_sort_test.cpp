#include "../global/templates.hpp"
#include <iostream>

using std::cout;

/// test passed

auto main(int argc, const char *argv[]) -> int {
  int arr[] = {
      34, 43, 43, 23, 2, 43, 545, 45, 6565, 65
	};
	ice1000_util::bubble_sort(arr, sizeof(arr) / sizeof(arr[0]));
	for (auto i = 0;
			i < sizeof(arr) / sizeof(decltype(arr[0]));
			++i) {
		cout << arr[i] << " ";
	}
	return 0;
}



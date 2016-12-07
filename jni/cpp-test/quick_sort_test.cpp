#include "../global/templates.hpp"
#include <iostream>

using std::cout;

auto main(int argc, const char *argv[]) -> int {
  int arr[] = {
      34, 43, 43, 23, 2, 43, 545, 45, 6565, 65
	};
	ice1000_util::quick_sort<int>(arr, sizeof(arr) / sizeof(arr[0]));
	for (auto i = 0;
			i < sizeof(arr) / sizeof(decltype(arr[0]));
			++i) {
		cout << arr[i] << " ";
	}
	delete arr;
	return 0;
}



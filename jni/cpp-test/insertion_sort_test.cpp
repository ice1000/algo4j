#include "../global/templates.hpp"
#include <iostream>

using std::cout;
using std::endl;
using algo4j_sort::insertion_sort;

auto main(int argc, const char *argv[]) -> int {
	int a[] = { 3, 5, 2, 4 };
	insertion_sort(a, sizeof(a) / sizeof(a[0]));
	for (auto i = 0; i < sizeof(a) / sizeof(a[0]); ++i) {
		cout << a[i] << endl;
	}
	return 0;
}

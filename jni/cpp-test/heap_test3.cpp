
#include "../global/heap.hpp"
//#include <iostream>

//using std::cout;
//using std::endl;

#include <stdio.h>

using algo4j_heap::insert;
using algo4j_heap::extract_min;

auto main(const int argc, const char *argv[]) -> int {
	int n;
	jsize len = 0;
	scanf("%i", &n);
	auto data = new int[n + 1]();
	for (auto i = 0; i < n; ++i) {
		int in;
		scanf("%i", &in);
		insert(data, ++len, in);
	}
	for (auto i = 1; i <= n; ++i) {
		printf("%i ", extract_min(data, len));
	}
	return 0;
}


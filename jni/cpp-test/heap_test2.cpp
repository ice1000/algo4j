
#include "../global/heap.hpp"
//#include <iostream>

//using std::cout;
//using std::endl;

#include <stdio.h>

using algo4j_heap::insert;


auto main(const int argc, const char *argv[]) -> int {
	auto data = new int[1000]();
	int n;
	jsize len = 0;
	scanf("%i", &n);
	for (auto i = 0; i < n; ++i) {
		int in;
		scanf("%i", &in);
		insert(data, ++len, in);
	}
	for (auto i = 1; i <= n; ++i) {
		printf("%i ", data[i]);
	}
	return 0;
}



#include "../global/heap.hpp"
//#include <iostream>

//using std::cout;
//using std::endl;

#include <stdio.h>

using algo4j_heap::min::make_heap;
using algo4j_heap::min::heap_extract_min;

int data[] = {
	-1, 10, 8, 3, 4, 5, 6
};

auto main(const int argc, const char *argv[]) -> int {
	make_heap(data, 6);
	for (auto i = 1; i <= 6; ++i) {
		printf("%i ", data[i]);
	}
	puts("");
	jsize len = 6;
	for (auto i = 1; i <= 6; ++i) {
		printf("%i ", heap_extract_min(data, len));
	}
	return 0;
}


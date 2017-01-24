
#include "../global/heap.hpp"
//#include <iostream>

//using std::cout;
//using std::endl;

#include <stdio.h>

using algo4j_heap::make_heap;

int data[] = {
	-1, 10, 8, 3, 4, 5, 6
};

auto main(const int argc, const char *argv[]) -> int {
	make_heap(data, 6);
	for (auto i = 1; i <= 6; ++i) {
		printf("%i ", data[i]);
	}
	return 0;
}


#include <stdio.h>
#include "../global/matrix.h"
#include "../global/matrix.cpp"

using algo4j_matrix::fib_matrix;

auto main(const int argc, const char *argv[]) -> int {
	printf("%d\n", fib_matrix(1, 100000));
	for (int i = 1; i < 120; ++i)
		printf("%d, %d\n", i, fib_matrix(i, 100000));
	return 0;
}


#include <stdio.h>
#include "../global/matrix.h"
#include "../global/matrix.cpp"

using algo4j_matrix::fib_matrix;

constexpr auto mod = 100000LL;

auto main(const int argc, const char *argv[]) -> int {
	printf(
			"%lli\n",
			fib_matrix(1LL, mod)
	);
	;puts("233");
	for (jlong i = 1; i < 120; ++i)
		printf("%lli, %lli\n", i, fib_matrix(i, mod));
	return 0;
}


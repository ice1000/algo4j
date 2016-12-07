#include "../global/functions.h"
#include <iostream>

using std::cout;
using std::endl;
using ice1000_math::is_prime;

const jlong primes[] = {
		2L, 3L, 5L, 7L,
		11L, 13L, 17L, 19L,
		23L, 29L, 31L, 37L,
		41L, 43L, 47L, 53L,
		59L, 61L, 67L, 71L,
		73L, 79L, 83L, 89L,
		97L, 101L
};

auto main(const int argc, const char *argv[]) -> int {
	auto index = 0;
	for (jlong i = 0; i < 103; ++i) {
		if (primes[index] == i) {
			if (!is_prime(i)) cout << "test failed, " << i << " is a prime." << endl;
			++index;
		} else {
			if (is_prime(i)) cout << "test failed, " << i << " is not a prime." << endl;
		}
	}
	return 0;
}


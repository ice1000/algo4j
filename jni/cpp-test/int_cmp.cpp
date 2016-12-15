#include "../global/functions.h"
#include <string.h>
#include <stdio.h>

using algo4j_util::swap;

auto cmp(char *, char *) -> jint;

auto main(const int argc, const char *argv[]) -> int {
	auto char1 = static_cast<char *>("2333");
	auto char2 = static_cast<char *>("2333");
	puts(char1);
	puts(char2);
	printf("%i\n", cmp(char1, char2));
	return 0;
}

auto cmp(char *a, char *b) -> jint {
	auto a_len = strlen(a);
	auto b_len = strlen(b);
	jint ret = a_len - b_len;
	if (!ret) {
		for (auto idx = 0; idx < a_len and !ret; ++idx) {
			ret = a[idx] - b[idx];
		}
	}
	return ret;
}

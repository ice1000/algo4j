#include "../jni/global/functions.h"
#include <stdio.h>
#include <string.h>

using algo4j_util::swap;

typedef char * str;

auto times(str a, str b) -> str;

auto main(const int argc, const char *argv[]) -> int {
	char char1[233];
	char char2[222];
	scanf("%s %s", char1, char2);
	puts(char1);
	puts(char2);
	puts(times(char1, char2));
	return 0;
}

auto times(str a, str b) -> str {
	auto a_len = strlen(a);
	auto b_len = strlen(b);
	if ((a_len == 1 and a[0] == '0') or (b_len == 1 and b[0] == '0')) {
		auto buf = new char[1];
		buf[0] = '0';
		return buf;
	}
	auto a_idx = a_len;
	auto b_idx = b_len;
	auto res_len = a_len + b_len;
	auto buf = new char[res_len]();
	for (auto i = 0; i < a_len; ++i) a[i] -= '0';
	for (auto i = 0; i < b_len; ++i) b[i] -= '0';
//	printf("233");
	while (a_idx --> 0) {
		if (!a[a_idx]) continue;
		while (b_idx --> 0) {
			if (!b[b_idx]) continue;
			buf[a_idx + b_idx + 1] += a[a_idx] * b[b_idx];
			buf[a_idx + b_idx] += buf[a_idx + b_idx + 1] / 10;
			buf[a_idx + b_idx + 1] = buf[a_idx + b_idx + 1] % 10;
			printf("[%i]\n", buf[a_idx + b_idx + 1]);
		}
		b_idx = b_len;
	}
	auto res_idx = res_len;
	while (res_idx --> 1) {
		buf[res_idx - 1] += buf[res_idx] / 10;
		buf[res_idx] = buf[res_idx] % 10 + '0';
	}
	buf[0] += '0';
	printf("[%i, ", strlen(buf));
	while (buf[0] == '0') ++buf;
	auto dick = buf[strlen(buf) - 1];
	while (dick < '0' or dick > '9') {
		buf[strlen(buf) - 1] = 0;
		dick = buf[strlen(buf) - 1];
	}
	printf("%i]\n", strlen(buf));
	return buf;
}


#include "../jni/global/functions.h"
#include <string.h>
#include <stdio.h>

using algo4j_util::swap;

auto minus(char *, char *) -> char *;

auto main(const int argc, const char *argv[]) -> int {
	auto char2 = static_cast<char *>("55333");
	auto char1 = static_cast<char *>("2333");
	puts(char1);
	puts(char2);
	printf("[{%i}]\n", 8234 - 2333);
	puts(minus(char2, char1));
	return 0;
}

auto minus(char *a, char *b) -> char * {
	auto a_len = strlen(a);
	auto b_len = strlen(b);
	auto a_idx = a_len;
	auto b_idx = b_len;
	if (a_len < b_len) {
		swap(a, b);
		swap(a_len, b_len);
	}
	auto res_len = a_len;
	auto buf = new char[res_len]();
	auto res_idx = res_len;
	while (b_idx > 0) {
		buf[--res_idx] += a[--a_idx] - b[--b_idx] + '0';
		if (buf[res_idx] < '0') {
		  printf("[%i]\n", res_idx);
			buf[res_idx] += 10;
			--(buf[res_idx - 1]);
		}
	}
	while (a_idx > 0) {
	  buf[--res_idx] += a[--a_idx];
		if (buf[res_idx] > '9') {
		  printf("[%i]\n", b_idx);
			buf[res_idx] -= 10;
			++(buf[res_idx - 1]);
		}
  }
	while (buf[0] == '0') ++buf;
	if (!buf[0]) --buf;
	return buf;
}


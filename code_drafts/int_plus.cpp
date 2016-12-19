#include "../jni/global/functions.h"
#include <string.h>
#include <stdio.h>

using algo4j_util::swap;

auto plus(char *, char *) -> char *;

auto main(const int argc, const char *argv[]) -> int {
	auto char1 = static_cast<char *>("2333");
	auto char2 = static_cast<char *>("234");
	puts(char1);
	puts(char2);
	puts(plus(char1, char2));
	return 0;
}

auto plus(char *a, char *b) -> char * {
	auto a_len = strlen(a);
	auto b_len = strlen(b);
	auto a_idx = a_len;
	auto b_idx = b_len;
	if (a_len < b_len) {
		swap(a, b);
		swap(a_len, b_len);
	}
	auto res_len = a_len + 1;
	auto buf = new char[res_len]();
	buf[0] = '0';
	auto res_idx = res_len;
	while (b_idx > 0) {
		buf[--res_idx] = a[--a_idx] + b[--b_idx] - '0';
		puts(buf);
		if (buf[res_idx] > '9') {
		  printf("[%i]\n", b_idx);
			buf[res_idx] -= 10;
			++(buf[res_idx - 1]);
		}
	}
	while (a_idx > 0) {
	  buf[--res_idx]+= a[--a_idx];
		if (buf[res_idx] > '9') {
		  printf("[%i]\n", b_idx);
			buf[res_idx] -= 10;
			++(buf[res_idx - 1]);
		}
  }
	if (buf[0] == '0') ++buf;
	return buf;
}

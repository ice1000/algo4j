#include "../jni/global/functions.h"
#include <stdio.h>
#include <string.h>

using algo4j_util::swap;

template<typename type>
int compare(type a[], type b[]) {
	int i;
	if (a[0] > b[0]) return 1;
	else if (a[0] < b[0]) return -1;
	else {
		i = a[0];
		while (a[i] == b[i]) --i;
		if (i == 0) return 0;
		else if (a[i] > b[i]) return 1;
		else return -1;
	}
}

typedef char * str;

auto divide(str a, str b) -> str;

auto divide_willot(str a, str b) -> str;

auto get_res(str a, str b, str c, str d) -> void;

auto main(const int argc, const char *argv[]) -> int {
	char char1[233];
	char char2[222];
	char c[233];
	char d[233];
	scanf("%s %s", char1, char2);
	puts(char1);
	puts(char2);
//	puts(divide(char1, char2));
	puts(divide_willot(char1, char2));
//	get_res(char1, char2, c, d);
//	for (auto i = 0; i < strlen(c); ++i) printf("%i", c[i]);
//	puts("");
//	for (auto i = 0; i < strlen(d); ++i) printf("%i", d[i]);
//	puts("");
	return 0;
}

auto get_res(str a, str b, str c, str d) -> void {
	int i, j, len;
	for (i = 0; i < strlen(a); i++) {
		c[i] = 0;
		d[i] = 0;
	}
	len = a[0];
	d[0] = 0;
	for (i = len; i >= 1; i--) {
		for (j = d[0]; j >= 1; j--)
			d[j + 1] = d[j];
		d[1] = a[i];
		++d[0];
		while (compare(d, b) >= 0) {
			for (j = 1; j <= d[0]; ++j) {
				d[j] -= b[j];
				if (d[j] < 0) {
					d[j] += 10;
					d[j + 1]--;
				}
			}
			while (j > 0 and !d[j])
				j--;
			d[0] = j;
			c[i]++;
		}
	}
	j = b[0];
	while (!c[j] and j > 0)
		j--;
	c[0] = j;
}

auto divide(str a, str b) -> str {
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

auto divide_willot(str a, str b) -> str {
	auto len = strlen(a);
	auto b_len = strlen(b);
	auto c = new char[len - b_len]();
	auto c_idx = 0;
	for (auto i = 0, g = 0; i < len; i++) {
		auto x = a[i] - g;
		if (i < b_len)
			x -= b[i];
		if (x >= 0)
			g = 0;
		else {
			g = 1;
			x += 10;
		}
		c[c_idx] = x;
	}
	while (c[0] <= '0' or c[0] > '9') ++c;
	return c;
}


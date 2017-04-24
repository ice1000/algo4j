//
// Created by ice1000 on 2017/4/24.
//

#include "../global/complex.h"
#include "../global/complex.cpp"
#include <string.h>

using algo4j_util::remove_reference;
using algo4j_complex::complex;
using algo4j_complex::change;
using algo4j_complex::fft;

const int MAXN = 2000010;
char str1[MAXN >> 1], str2[MAXN >> 1];
// 237192837218937219372893729837921837921837918237219837289382198290382103190230123
int main() {
	while (scanf("%s%s", str1, str2) == 2) {
		int len1 = strlen(str1);
		int len2 = strlen(str2);
		int len = 1;
		while (len < len1 << 1 || len < len2 << 1) len <<= 1;
		auto sum = new jint[len];
		auto x1 = new complex[len];
		auto x2 = new complex[len];
		for (auto i = 0; i < len1; ++i)
			x1[i] = complex(str1[len1 - 1 - i] - '0');
		for (auto i = len1; i < len; ++i)
			x1[i] = complex();
		for (auto i = 0; i < len2; ++i)
			x2[i] = complex(str2[len2 - 1 - i] - '0');
		for (auto i = len2; i < len; ++i)
			x2[i] = complex();
		//求DFT
		fft(x1, len, 1);
		fft(x2, len, 1);
		for (auto i = 0; i < len; ++i)
			x1[i] = x1[i] * x2[i];
		fft(x1, len, -1);
		for (auto i = 0; i < len; ++i)
			sum[i] = (jint) (x1[i].r + 0.5);
		for (auto i = 0; i < len; ++i) {
			sum[i + 1] += sum[i] / 10;
			sum[i] %= 10;
		}
		len = len1 + len2 - 1;
		while (sum[len] <= 0 && len > 0) --len;
		auto ret = new char[len];
		puts("out:");
		int j = 0;
		for (auto i = len; i >= 0; --i)
			ret[j++] = (jbyte) sum[i] + '0';
		ret[len+1] = 0;
		puts(ret);
		puts("1");
		delete ret;
		puts("2");
		delete sum;
		puts("3");
		delete x1;
		puts("4");
		delete x2;
	}
	return 0;
}

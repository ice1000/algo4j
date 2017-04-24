//
// Created by ice1000 on 2017/4/24.
//

#include "../global/complex.h"
#include "../global/complex.cpp"
#include <string.h>

const int MAXN = 200010;
char str1[MAXN >> 1], str2[MAXN >> 1];

int main() {
	while (scanf("%s%s", str1, str2) == 2) {
		int len1 = strlen(str1);
		int len2 = strlen(str2);
		auto sum = new int[len1 + len2];
		int len = 1;
		while (len < len1 << 1 || len < len2 << 1) len <<= 1;
		auto x1 = new complex[len]();
		auto x2 = new complex[len]();
		for (int i = 0; i < len1; ++i)
			x1[i] = complex(str1[len1 - 1 - i] - '0');
		for (int i = len1; i < len; ++i)
			x1[i] = complex();
		for (int i = 0; i < len2; ++i)
			x2[i] = complex(str2[len2 - 1 - i] - '0');
		for (int i = len2; i < len; ++i)
			x2[i] = complex();
		//求DFT
		fft(x1, len, 1);
		fft(x2, len, 1);
		for (int i = 0; i < len; ++i)
			x1[i] = x1[i] * x2[i];
		fft(x1, len, -1);
		for (int i = 0; i < len; ++i)
			sum[i] = (int) (x1[i].r + 0.5);
		for (int i = 0; i < len; ++i) {
			sum[i + 1] += sum[i] / 10;
			sum[i] %= 10;
		}
		len = len1 + len2 - 1;
		while (sum[len] <= 0 && len > 0) --len;
		auto ret = new char[len];
		for (int i = len, j = 0; i >= 0; --i, ++j)
			ret[j] = sum[i] + '0';
		puts(ret);
		delete ret;
		delete x1;
		delete x2;
	}
	return 0;
}

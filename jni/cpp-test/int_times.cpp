//
// Created by ice1000 on 2017/4/24.
//

#include "../global/complex.h"
#include "../global/complex.cpp"

const int MAXN = 200010;
complex x1[MAXN], x2[MAXN];
char str1[MAXN >> 1], str2[MAXN >> 1];
int sum[MAXN];

int main() {
	while (scanf("%s%s", str1, str2) == 2) {
		int len1 = strlen(str1);
		int len2 = strlen(str2);
		int len = 1;
		while (len < len1 * 2 || len < len2 * 2)len <<= 1;
		for (int i = 0; i < len1; i++)
			x1[i] = complex(str1[len1 - 1 - i] - '0', 0);
		for (int i = len1; i < len; i++)
			x1[i] = complex(0, 0);
		for (int i = 0; i < len2; i++)
			x2[i] = complex(str2[len2 - 1 - i] - '0', 0);
		for (int i = len2; i < len; i++)
			x2[i] = complex(0, 0);
		//求DFT
		fft(x1, len, 1);
		fft(x2, len, 1);
		for (int i = 0; i < len; i++)
			x1[i] = x1[i] * x2[i];
		fft(x1, len, -1);
		for (int i = 0; i < len; i++)
			sum[i] = (int) (x1[i].r + 0.5);
		for (int i = 0; i < len; i++) {
			sum[i + 1] += sum[i] / 10;
			sum[i] %= 10;
		}
		len = len1 + len2 - 1;
		while (sum[len] <= 0 && len > 0)len--;
		for (int i = len; i >= 0; i--)
			printf("%c", sum[i] + '0');
		printf("\n");
	}
	return 0;
}

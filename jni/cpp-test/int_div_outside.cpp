#include "../global/bigint.h"
#include "../global/bigint.cpp"
#include "../global/complex.cpp"
#include <string.h>

#define SIZE 200000

using algo4j_int::minus;
using algo4j_int::compare;

auto a = new char[SIZE];
auto b = new char[SIZE];
int main(int argc, const char *argv[]) {
	// freopen("123.txt", "r", stdin);
	// freopen("321.txt", "w", stdout);
	while (scanf("%s %s", a, b) == 2) {
		size_t len1 = strlen(a);
		size_t len2 = strlen(b);
		auto b1 = (jbyte *) b;
		auto a1 = (jbyte *) a;
		auto cmp_res = compare(a1, b1, len1, len2);
		if (cmp_res < 0) puts("0");
		else if (not cmp_res) puts("1");
		else {
			// init
			auto len3 = 0;
			auto _res = new jbyte[len1 - len2 + 1]();
			auto _ret = new jbyte[len1 - len2 + 1]();
			auto equ = false;
			for (auto i = 0; i < len1; ++i) {
				_res[len3] = a1[i];
				_res[++len3] = 0;
				_ret[i] = '0';
				_ret[i + 1] = 0;
				// puts("<><><><>");
				// puts((char *)_res);
				// puts("==============================");
				while (compare(_res, b1, len3, len2) >= 0) {
					// puts("------------------------------");
					// printf("len3 = %d, len2 = %d, _res = %s\n", len3, len2, _res);
					// auto cmp_res = compare(_res, b1, len3, len2);
					// if (not cmp_res) equ = true;
					// if (cmp_res < 0) break;
					auto res = minus(_res, b1, len3, len2);
					delete _res;
					_res = res->data;
					len3 = res->len;
					_res[len3] = 0;
					// puts("[][][][]");
					// printf("_res = %s len3 = %d\n", _res, len3);
					// printf("%d %d %d %d %d  %d\n", _res[0], _res[1], _res[2], _res[3], _res[4], len3);
					++_ret[i];
				}
			}
			// puts("1");
			while (_ret[0] <= '0' or _ret[0] > '9') ++_ret, --len1;
			if (not _ret[0]) {
				_ret[0] = '0';
				_ret[1] = 0;
				++len1;
			}
			// puts("2");
			delete _res;
			printf("%s => java.lang.String\n%d => java.lang.Integer\n", _ret, len1);
			// printf("%c %c %c %c\n", _ret[0], _ret[1], _ret[2], _ret[3]);
		}
	}
}


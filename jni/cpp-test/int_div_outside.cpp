#include "../global/bigint.h"
#include "../global/bigint.cpp"
#include "../global/complex.cpp"
#include <string.h>

using algo4j_int::minus;
using algo4j_int::compare;

auto a = new char[200000];
auto b = new char[200000];
int main(int argc, const char *argv[]) {
//	freopen("123.txt", "r", stdin);
//	freopen("321.txt", "w", stdout);
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
			for (auto i = len1 - 1; i >= 0; --i) {
				_res[len3] = a1[i];
				_res[++len3] = 0;
				_ret[i] = '0';
//				puts("<><><><>");
//				puts((char*)_res);
//				puts("==============================");
				while (not equ) {
//					puts("------------------------------");
					auto cmp_res = compare(_res, b1, len3, len2);
					if (not cmp_res) {
						equ = true;
						break;
					}
					if (cmp_res < 0) break;
					auto res = minus(_res, b1, len3, len2);
					delete _res;
					_res = res->data;
					_res[len3] = 0;
//					puts("[][][][]");
					printf("%s\t%d\t%d\n", _res, len3, res->len);
//					printf("%d %d %d %d %d  %d\n", _res[0], _res[1], _res[2], _res[3], _res[4], len3);
					++_ret[i];
				}
			}
			puts((char*)_ret);
		}
	}
}


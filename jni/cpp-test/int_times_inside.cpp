#include "../global/bigint.h"
#include "../global/bigint.cpp"
#include "../global/complex.cpp"
#include <string.h>

using algo4j_int::times;

auto a = new char[200000];
auto b = new char[200000];
int main(int argc, const char *argv[]) {
	freopen("123.txt", "r", stdin);
	freopen("321.txt", "w", stdout);
	while (scanf("%s %s", a, b) == 2) {
		size_t len1 = strlen(a);
		size_t len2 = strlen(b);
		auto data = (const char *) times((jbyte *) a, (jbyte *) b, len1, len2)->data;
		for (int i = 0; i < strlen(data); ++i) {
			putchar(data[i]);
//			putchar(' ');
		}
	}
}


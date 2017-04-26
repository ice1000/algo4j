#include "../global/bigint.h"
#include "../global/bigint.cpp"
#include "../global/complex.cpp"
#include <string.h>

using algo4j_int::rem;
using algo4j_int::compare;

auto a = new char[200000];
auto b = new char[200000];
int main(int argc, const char *argv[]) {
	printf("%d %d %d\n", 'b', 'Z', ' ');
//	freopen("123.txt", "r", stdin);
//	freopen("321.txt", "w", stdout);
	while (scanf("%s %s", a, b) == 2) {
		size_t len1 = strlen(a);
		size_t len2 = strlen(b);
		auto data = rem((jbyte *) a, (jbyte *) b, len1, len2);
		printf("%s %d\n", data->data_trim(), data->len_trim());
//		for (int i = 0; i < data->len; ++i) {
//			printf("%d ", data->data[i]);
//		}
//		for (int i = 0; i < data->len; ++i) {
//			printf("%c", data->data[i]);
//		}
		delete data;
//		putchar('\n');
	}
}


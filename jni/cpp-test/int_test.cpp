
#include <iostream>

#include "../global/bigint.h"
#include "../global/bigint.cpp"

using std::cout;
using std::endl;
using algo4j_int::BigInt;

auto main(int argc, const char *argv[]) -> int {
	constexpr jsize len = 3;
	auto data1 = new jbyte[len]();
	auto data2 = new jbyte[len]();
	for (auto i = 0; i < len; ++i) {
		data1[i] = '2';
		data2[i] = '1';
	}
	auto a = *new BigInt(data1, len);
	auto b = *new BigInt(data2, len);
//	auto c = a + b;
//	cout << c.len << endl;
//	for (auto i = 0; i < c.len; ++i) {
//		cout << c.data[i];
//	}
//	auto d = a - b;
//	cout << "\nminus:\n" << d.len << endl;
//	for (auto i = 0; i < d.len; ++i) {
//		cout << d.data[i];
//	}
//	auto e = a * b;
//	cout << "\ntimes:\n" << e.len << endl;
//	for (auto i = 0; i < e.len; ++i) {
//		cout << e[i];
//	}
//	cout << endl;
	cout << (a == b) << endl;
	cout << (a >= b) << endl;
	auto f = a / b;
	cout << "\ndivide:\n" << f.len << endl;
	for (auto i = 0; i < f.len; ++i) {
		cout << f[i];
	}
	return 0;
}




#include "../global/templates.hpp"
#include <iostream>

using std::cout;
using std::endl;

using algo4j_util::kmp;

auto main(const int argc, const char *argv[]) -> int {
	char *a = "boy";
	char *b = "boyboyboy";
	cout << kmp(a, 3, b, 9) << endl;
	return 0;
}


#include <iostream>
#include "../global/templates.hpp"

using std::cout;
using std::cin;
using std::endl;
using algo4j_util::Pair;

auto main(int argc, const char *argv[]) -> int {
	auto pair = *new Pair<int, int>(233, 666);
	cout << pair << endl;
	cin >> pair;
	cout << pair << endl;
	return 0;
}


#include <iostream>
#include <cstdlib>

using std::cout;
using std::endl;

auto main(int argc, const char *argv[]) -> int {
	void *p;
	int byte = 0;
	while (p = malloc(1024 * 1024 * 1024)){
		++byte;
	}
	free(p);
	cout << "result: " << byte << " GB." << endl;
	return 0;
}
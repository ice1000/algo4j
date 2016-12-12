#include "../global/templates.hpp"
#include <iostream>

using std::cout;
using std::endl;
using algo4j_bit::inversion;

auto main(int argc, const char *argv[]) -> int {
  int dark[] = { 3, 1, 5, 2, 4 };
  auto fantasy = inversion(dark, sizeof(dark) / sizeof(dark[0]), 10);
  cout << fantasy << endl;
  return 0;
}




#include "../org_ice1000_util_SequenceUtils.h"
#include <iostream>

#define size 11

jlong source[] = {
  10, 20, 30, 50, 40, 100, 70, 80, 90, 60, 11
};

int main(int argc, const char *argv[]) {
  auto pair = new ice1000_util::Ice1000Pair<jint, jint>[size]();
  auto after = new jlong[size]();
  for (auto i = 0; i < size; ++i) {
    pair[i].setValue(source[i], i);
  }
  std::cout << "set." << std::endl;
  ice1000_util::quick_sort(pair, size);
  std::cout << "sort." << std::endl;
  for (auto i = 0, j = 0; i < size; ++i, ++j) {
    after[pair[i].second] = j;
    if ((i + 1 < size) and pair[i].first == pair[i + 1].first) --j;
  }
  for (auto i = 0; i < size; ++i) {
    std::cout << after[i] << " ";
  }
//  delete pair;
  delete after;
  return 0;
}


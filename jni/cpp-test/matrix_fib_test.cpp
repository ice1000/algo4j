#include <stdio.h>
#include "../global/matrix.h"
#include "../global/matrix.cpp"

using algo4j_matrix::fib_matrix;

constexpr auto mod = 100000LL;

auto print(jlong _) -> void {
  printf("%lli\n", _);
}

auto print(jlong _, jlong __) -> void {
  printf("%lli, %lli\n", _, __);
}

auto print(jint _) -> void {
	printf("%li\n", _);
}

auto print(jint _, jint __) -> void {
	printf("%li, %li\n", _, __);
}

auto main(const int argc, const char *argv[]) -> int {
  print(fib_matrix(1, 100000));
  for (jlong i = 1; i < 190; ++i)
    print(i, fib_matrix(i, 100000));
  return 0;
}


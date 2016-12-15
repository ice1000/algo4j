#include "../global/functions.h"
#include <string.h>
#include <stdio.h>

using algo4j_util::swap;

auto plus(char *, char *) -> char *;

auto main(const int argc, const char *argv[]) -> int {
  auto char1 = "23333";
  auto char2 = "66666";
  printf(plus(char1, char2));
  return 0;
}

auto plus(char *a, char *b) -> char * {
  auto a_len = strlen(a);
  auto b_len = strlen(b);
  if (a_len < b_len) {
    swap(a, b);
    swap(a_len, b_len);
  }
}

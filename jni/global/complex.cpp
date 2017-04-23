
#include "complex.h"

using algo4j_complex::complex;

complex::complex(jdouble _r, jdouble _i) : r(_r), i(_i) { }

complex::~complex() { }

auto complex::operator+(const complex &b) -> complex {
	return complex(r + b.r, i + b.i);
}

auto complex::operator-(const complex &b) -> complex {
	return complex(r - b.r, i - b.i);
}

auto complex::operator*(const complex &b) -> complex {
	return complex(r * b.r - i * b.i, r * b.i + i * b.r);
}

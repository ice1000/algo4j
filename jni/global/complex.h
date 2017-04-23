#ifndef __COMPLEX__
#define __COMPLEX__

#include "basics.hpp"
#include "functions.h"
#include "math.h"

using algo4j_util::swap;
using algo4j_math::PI;

namespace algo4j_complex {

	struct complex {
	public:
		jdouble r, i;

		complex(jdouble _r = 0.0, jdouble _i = 0.0);

		~complex();

		auto operator+(const complex &b) -> complex;

		auto operator-(const complex &b) -> complex;

		auto operator*(const complex &b) -> complex;
	};

	auto change(complex *y, jsize len) -> void;

	auto fft(complex *y, jsize len, jsize on) -> void;
}

#endif /// __COMPLEX__

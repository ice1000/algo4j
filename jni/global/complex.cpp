
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

auto algo4j_complex::change(complex *y, jsize len) -> void {
	jsize _, __, ___;
	for (_ = 1, __ = len >> 1; _ < len - 1; ++_) {
		if (_ < __) swap(y[_], y[__]);
		___ = len >> 1;
		while (__ >= ___) {
			__ -= ___;
			___ >>= 1;
		}
		if (__ < ___) __ += ___;
	}
}

auto ::algo4j_complex::fft(complex *y, jsize len, jsize on) -> void {
	change(y, len);
	for (jsize h = 2; h <= len; h <<= 1) {
		complex wn(cos(-on * 2 * PI / h), sin(-on * 2 * PI / h));
		for (jsize j = 0; j < len; j += h) {
			complex w(1, 0);
			for (jsize k = j; k < j + (h >> 1); ++k) {
				complex u = y[k];
				complex t = w * y[k + (h >> 1)];
				y[k] = u + t;
				y[k + (h >> 1)] = u - t;
				w = w * wn;
			}
		}
	}
	if (!~on) for (jsize i = 0; i < len; ++i) y[i].r /= len;
}

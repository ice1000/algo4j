
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
	jsize _, j, k;
	for (_ = 1, j = len >> 1; _ < len - 1; ++_) {
		if (_ < j) swap(y[_], y[j]);
		k = len >> 1;
		while (j >= k) {
			j -= k;
			k >>= 1;
		}
		if (j < k) j += k;
	}
}

auto ::algo4j_complex::fft(complex *y, jsize len, jsize on) -> void {
	change(y, len);
	for (jsize h = 2; h <= len; h <<= 1) {
		complex wn(cos(-on * 2 * PI / h), sin(-on * 2 * PI / h));
		for (jsize j = 0; j < len; j += h) {
			complex w(1, 0);
			for (jsize k = j; k < (j + h) >> 1; ++k) {
				complex u = y[k];
				complex t = w * y[k + h / 2];
				y[k] = u + t;
				y[k + h / 2] = u - t;
				w = w * wn;
			}
		}
	}
	if (~on)
		for (jsize i = 0; i < len; ++i)
			y[i].r /= len;
}

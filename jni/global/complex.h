#ifndef __COMPLEX__
#define __COMPLEX__

#include "basics.hpp"

using algo4j_util::swap;

namespace algo4j_complex {

	struct complex {
	private:
		jdouble r, i;

	public:
		complex(jdouble _r = 0.0, jdouble _i = 0.0);

		~complex();

		auto operator+(const complex &b) -> complex;

		auto operator-(const complex &b) -> complex;

		auto operator*(const complex &b) -> complex;
	};

	auto change(complex *y, jsize len) -> void {
		jsize _, j, k;
		for (_ = 1, j = len >> 1; _ < len - 1; ++_) {
			if (_ < j) swap(y[_], y[j]);
			//交换互为小标反转的元素，i<j保证交换一次
			//i做正常的+1，j左反转类型的+1,始终保持i和j是反转的
			k = len >> 1;
			while (j >= k) {
				j -= k;
				k >>= 1;
			}
			if (j < k) j += k;
		}
	}
}

#endif /// __COMPLEX__

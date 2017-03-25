
#include "matrix.h"
#include "templates.hpp"
#include "math.h"

using algo4j_matrix::Matrix22;
using algo4j_matrix::Matrix22Pool;

using algo4j_math::fast_plus;


algo4j_matrix::Matrix22::~Matrix22() {
}

algo4j_matrix::Matrix22::Matrix22() {
}

algo4j_matrix::Matrix22::Matrix22(jlong aa, jlong b, jlong c, jlong d) {
	a[0][0] = aa;
	a[0][1] = b;
	a[1][0] = c;
	a[1][1] = d;
}

algo4j_matrix::Matrix22Pool::~Matrix22Pool() {
	delete[] pool;
}

algo4j_matrix::Matrix22Pool::Matrix22Pool(jsize s) : size(s), index(0) {
	pool = new ptr_to<Matrix22>[s]();
}

auto algo4j_matrix::Matrix22Pool::create(jlong a, jlong b, jlong c, jlong d) -> ptr_to<Matrix22> {
	pool[index] = new Matrix22(a, b, c, d);
	return pool[index++];
}

auto algo4j_matrix::Matrix22Pool::create() -> ptr_to<Matrix22> {
	pool[index] = new Matrix22();
	return pool[index++];
}

auto algo4j_matrix::magic_function(jlong x) -> jlong {
	return log(x + 1) * 3 + 4;
}

auto algo4j_matrix::mul(Matrix22Pool &pool, Matrix22 &x, Matrix22 &y, jlong mod) -> Matrix22 {
	auto res = *pool.create();
	decltype(mod) sum;
	for(auto i = 0; i < 2; ++i)
		for(auto j = 0; j < 2; ++j) {
			sum = 0;
			for(auto k = 0; k < 2; ++k) {
				if (mod <= -1) sum += x.a[i][k] * y.a[k][j];
				else {
					sum += fast_plus(x.a[i][k], y.a[k][j], mod);
					sum %= mod;
				}
			}
			res.a[i][j] = sum;
		}
	x = res;
	return x;
}

auto algo4j_matrix::pow(Matrix22Pool &pool, Matrix22 &origin, jlong k, jlong mod) -> Matrix22 {
	auto ans = *pool.create(1, 0, 0, 1);
	auto p = origin;
	while (k) {
		if (k & 1) {
			auto new_ans = mul(pool, ans, p, mod);
			ans = new_ans;
			--k;
		}
		k >>= 1;
		auto new_p = mul(pool, p, p, mod);
		p = new_p;
	}
	return ans;
}

auto algo4j_matrix::fib_matrix(jlong n, jlong mod) -> jlong {
	auto pool = new Matrix22Pool(magic_function(n));
	auto base = *pool->create(1, 1, 1, 0);
	auto ans = pow(*pool, base, n - 1, mod);
	auto ret = ans.a[0][0];
	delete pool;
	return ret;
}



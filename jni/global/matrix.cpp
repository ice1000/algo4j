
#include "matrix.h"
#include "templates.hpp"

using algo4j_matrix::Matrix22;

using algo4j_math::fast_plus;

algo4j_matrix::Matrix22::Matrix22() { }

algo4j_matrix::Matrix22::Matrix22(jlong aa, jlong b, jlong c, jlong d) {
	a[0][0] = aa;
	a[0][1] = b;
	a[1][0] = c;
	a[1][1] = d;
}

auto algo4j_matrix::mul(Matrix22 &x, Matrix22 &y, jlong mod) -> Matrix22 {
	auto res = *new Matrix22();
	int sum;
	for(auto i = 0; i < 2; ++i)
		for(auto j = 0; j < 2; ++j) {
			sum = 0;
			for(auto k = 0; k < 2; ++k) {
				if (mod > -1) sum += x.a[i][k] * y.a[k][j];
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

auto algo4j_matrix::pow(Matrix22 &x, jlong e, jlong mod) -> Matrix22 {
	if(e == 1) return x;
	if(not e) return *new Matrix22(1, 0, 0, 1);
	auto temp = pow(x, e >> 1);
	auto ans = mul(temp, temp, mod);
	delete &temp;
	if(e bitand 1) ans = mul(ans, x, mod);
	return ans;
}

auto algo4j_matrix::fib_matrix(jlong n, jlong mod) -> jlong {
	auto base = *new Matrix22(1, 1, 1, 0);
	auto ans = pow(base, n - 1, mod);
	auto ret = ans.a[0][0];
	delete &base;
	delete &ans;
	return ret;
}



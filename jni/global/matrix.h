
#ifndef __ALGO4J_MATRIX_H__
#define __ALGO4J_MATRIX_H__

#include "basics.hpp"

namespace algo4j_matrix {
	class Matrix22 {
	public:
		jlong a[2][2];

		explicit Matrix22();

		Matrix22(jlong, jlong, jlong, jlong);
	};

	auto mul(Matrix22 &, Matrix22 &, jlong = -1) -> Matrix22;

	auto pow(Matrix22 &, jlong, jlong = -1) -> Matrix22;

	auto fib_matrix(jlong n, jlong = -1) -> jlong;
}



#endif /// __ALGO4J_MATRIX_H__

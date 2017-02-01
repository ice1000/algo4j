
#ifndef __ALGO4J_MATRIX_H__
#define __ALGO4J_MATRIX_H__

#include "basics.hpp"

namespace algo4j_matrix {
	class Matrix22 {
	public:
		jint a[2][2];

		explicit Matrix22();

		Matrix22(jint aa, jint b, jint c, jint d);
	};

	auto mul(Matrix22 &x, Matrix22 &y, jint mod = -1) -> Matrix22;

	auto pow(Matrix22 x, jint e, jint mod = -1) -> Matrix22;

	auto fib_matrix(jint n, jint mod = -1) -> jint;
}



#endif /// __ALGO4J_MATRIX_H__

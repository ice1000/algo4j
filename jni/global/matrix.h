
#ifndef __ALGO4J_MATRIX_H__
#define __ALGO4J_MATRIX_H__

#include "basics.hpp"
#include "cstring"

using algo4j_util::ptr_to;

namespace algo4j_matrix {
    class Matrix22;

    class Matrix22Pool {
    public:

        const jsize size;

        explicit Matrix22Pool(jsize);

        ~Matrix22Pool();

        auto create(jlong, jlong, jlong, jlong) -> ptr_to<Matrix22>;

        auto create() -> ptr_to<Matrix22>;

    private:

        Matrix22 **pool;

        jsize index;
    };

    class Matrix22 {
    public:

        jlong a[2][2];

        explicit Matrix22();

        Matrix22(jlong, jlong, jlong, jlong);

        ~Matrix22();
    };

    auto mul(Matrix22Pool &, Matrix22 &, Matrix22 &, jlong = -1) -> Matrix22;

    auto pow(Matrix22Pool &, Matrix22 &, jlong, jlong = -1) -> Matrix22;

    auto fib_matrix(jlong n, jlong = -1) -> jlong;

    auto magic_function(jlong) -> jlong;

    using namespace std;
    using mat_size_t = long;
    using mat_value_t = double;

    class GeneralMatrix {

    public:
        mat_value_t *ptr;

        mat_size_t m, n;

        GeneralMatrix(mat_size_t m, mat_size_t n) : m(m), n(n) {
            ptr = new mat_value_t[m * n * sizeof(mat_value_t)];
        }

        GeneralMatrix(mat_size_t m, mat_size_t n, const mat_value_t *_copy) : m(m), n(n) {
            ptr = new mat_value_t[m * n * sizeof(mat_value_t)];
            memcpy(ptr, _copy, m * n * sizeof(mat_value_t));
        }

        mat_value_t *operator[](int x) {
            return &ptr[x * n];
        }

        auto get(mat_size_t x, mat_size_t y) -> mat_value_t;

        auto set(mat_size_t x, mat_size_t y, mat_value_t value) -> void;

        auto multiply(GeneralMatrix *o) -> GeneralMatrix *;

        GeneralMatrix operator*(GeneralMatrix o) {
            return *multiply(&o);
        }

        auto transpose() -> GeneralMatrix *;

        auto invert() -> GeneralMatrix *;

        auto determinant() -> mat_value_t;

        ~GeneralMatrix();
    };

}


#endif /// __ALGO4J_MATRIX_H__

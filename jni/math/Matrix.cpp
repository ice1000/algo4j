//
// Created by Phosphorus15 on 2019/3/2.
//

#include "../global/basics.hpp"
#include "Matrix.h"
#include "../global/matrix.h"

JNIEXPORT jlong JNICALL Java_org_algo4j_math_Matrix_newMatrix
        (JNIEnv *, jclass, jint m, jint n) {
    return (jlong) new algo4j_matrix::GeneralMatrix(m, n);
}

JNIEXPORT jlong JNICALL Java_org_algo4j_math_Matrix_makeClone
        (JNIEnv *, jclass, jlong pointer) {
    auto *original = (algo4j_matrix::GeneralMatrix *) pointer;
    return (jlong) new algo4j_matrix::GeneralMatrix(original->m, original->n, original->ptr);
}

JNIEXPORT jdouble JNICALL Java_org_algo4j_math_Matrix_get
        (JNIEnv *, jobject, jlong pointer, jint x, jint y) {
    return ((algo4j_matrix::GeneralMatrix *) pointer)->get(x, y);
}

JNIEXPORT void JNICALL Java_org_algo4j_math_Matrix_set
        (JNIEnv *, jobject, jlong pointer, jint x, jint y, jdouble value) {
    ((algo4j_matrix::GeneralMatrix *) pointer)->set(x, y, value);
}

JNIEXPORT jlong JNICALL Java_org_algo4j_math_Matrix_transpose
        (JNIEnv *, jobject, jlong pointer) {
    return (jlong) ((algo4j_matrix::GeneralMatrix *) pointer)->transpose();
}

JNIEXPORT jlong JNICALL Java_org_algo4j_math_Matrix_invert
        (JNIEnv *, jobject, jlong pointer) {
    return (jlong) ((algo4j_matrix::GeneralMatrix *) pointer)->invert();
}

JNIEXPORT jlong JNICALL Java_org_algo4j_math_Matrix_multiply
        (JNIEnv *, jobject, jlong a, jlong b) {
    return (jlong) ((algo4j_matrix::GeneralMatrix *) a)->multiply((algo4j_matrix::GeneralMatrix *) b);
}

JNIEXPORT void JNICALL Java_org_algo4j_math_Matrix_getRowSize
        (JNIEnv *, jobject, jlong) {
}

JNIEXPORT void JNICALL Java_org_algo4j_math_Matrix_getColumnSize
        (JNIEnv *, jobject, jlong) {
}

JNIEXPORT jdouble JNICALL Java_org_algo4j_math_Matrix_determinant
        (JNIEnv *, jobject, jlong pointer) {
    return ((algo4j_matrix::GeneralMatrix *) pointer)->determinant();
}

JNIEXPORT jlong JNICALL Java_org_algo4j_math_Matrix_free
        (JNIEnv *, jobject, jlong pointer) {
    delete ((algo4j_matrix::GeneralMatrix *) pointer);
    return 0;
}

//
// Created by Phosphorus15 on 2019/3/1.
//
#include "Vector.h"

/// this file has somewhat violated the code format, but was necessary for neat codes
JNIEXPORT void JNICALL Java_org_algo4j_math_Vector_add__JDI
        (JNIEnv *, jobject, jlong ptr, jdouble value, jint length) {
    auto *arr = (jdouble *) ptr;
    for (int i = 0; i < length; i++)
        arr[i] += value;
}

JNIEXPORT void JNICALL Java_org_algo4j_math_Vector_add__JJI
        (JNIEnv *, jobject, jlong _dest, jlong _source, jint length) {
    auto *dest = (jdouble *) _dest;
    auto *source = (jdouble *) _source;
    for (int i = 0; i < length; i++)
        dest[i] += source[i];
}

JNIEXPORT void JNICALL Java_org_algo4j_math_Vector_multiply__JDI
        (JNIEnv *, jobject, jlong ptr, jdouble value, jint length) {
    auto *arr = (jdouble *) ptr;
    for (int i = 0; i < length; i++)
        arr[i] *= value;
}

JNIEXPORT void JNICALL Java_org_algo4j_math_Vector_multiply__JJI
        (JNIEnv *, jobject, jlong _dest, jlong _source, jint length) {
    auto *dest = (jdouble *) _dest;
    auto *source = (jdouble *) _source;
    for (int i = 0; i < length; i++)
        dest[i] *= source[i];
}

JNIEXPORT auto JNICALL Java_org_algo4j_math_Vector_product
        (JNIEnv *, jobject, jlong _dest, jlong _source, jint length) -> jdouble {
    auto *dest = (jdouble *) _dest;
    auto *source = (jdouble *) _source;
    jdouble result = 0;
    for (int i = 0; i < length; i++)
        result += dest[i] * source[i];
    return result;
}

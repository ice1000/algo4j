//
// Created by Phosphorus15 on 2019/3/1.
//
#include "MemoryHelper.h"
#include "../global/basics.hpp"
#include "string.h"

/// this file has somewhat violated the code format, but was necessary for neat codes
JNIEXPORT auto JNICALL Java_org_algo4j_util_MemoryHelper_allocateDoubles
        (JNIEnv *env, jclass clz, jint length) -> jlong { // Unsafe Allocation
    return (jlong) new jdouble[length * sizeof(jdouble)];
}

JNIEXPORT void JNICALL Java_org_algo4j_util_MemoryHelper_fillDoubles
        (JNIEnv *env, jclass clz, jlong ptr, jdoubleArray _doubles) {
    __JNI__FUNCTION__INIT__
    __get(Double, doubles)
    auto *array = (jdouble *) ptr;
    int length = env->GetArrayLength(_doubles);
    memcpy(array, doubles, length * sizeof(jdouble)); // copy doubles
    __abort(Double, doubles)
    __JNI__FUNCTION__CLEAN__
}

JNIEXPORT jdouble JNICALL Java_org_algo4j_util_MemoryHelper_getDouble
        (JNIEnv *env, jclass clz, jlong ptr, jint x) {
    return *(((jdouble *) ptr) + x);
}

JNIEXPORT void JNICALL Java_org_algo4j_util_MemoryHelper_setDouble
        (JNIEnv *env, jclass clz, jlong ptr, jint x, jdouble value) {
    *(((jdouble *) ptr) + x) = value;
}

JNIEXPORT void JNICALL Java_org_algo4j_util_MemoryHelper_copyDoubles
        (JNIEnv *env, jclass clz, jlong source, jlong dest, jint length) {
    memcpy((jdouble *) dest, (const jdouble *) source, length * sizeof(jdouble));
}

JNIEXPORT void JNICALL Java_org_algo4j_util_MemoryHelper_free
        (JNIEnv *, jclass, jlong pointer) {
    delete ((jdouble *) pointer);
}

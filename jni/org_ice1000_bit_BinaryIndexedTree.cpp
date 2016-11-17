///
/// Created by ice1000
///

#include "org_ice1000_bit_BinaryIndexedTree.h"

#pragma clang diagnostic push
#pragma clang diagnostic ignored "-Wunused-parameter"
#pragma ide diagnostic ignored "OCUnusedGlobalDeclarationInspection"

using namespace ice1000_bit;

/**
 * Class:     org_ice1000_bit_BinaryIndexedTree
 * Method:    add
 * Signature: ([JIIJ)V
 */
JNIEXPORT void JNICALL Java_org_ice1000_bit_BinaryIndexedTree_add(
		JNIEnv *env, jobject jo, jlongArray _data, jint len, jint idx, jlong value) {
	jlong *data = env->GetLongArrayElements(_data, 0);
	add(data, len, idx, value);
	env->ReleaseLongArrayElements(_data, data, 0);
}

/**
 * Class:     org_ice1000_bit_BinaryIndexedTree
 * Method:    sum
 * Signature: ([JII)J
 */
JNIEXPORT jlong JNICALL Java_org_ice1000_bit_BinaryIndexedTree_sum(
		JNIEnv *env, jobject jo, jlongArray _data, jint len, jint idx) {
	auto data = env->GetLongArrayElements(_data, 0);
	auto result = sum(data, idx);
	env->ReleaseLongArrayElements(_data, data, 0);
	return result;
}


#pragma clang diagnostic pop

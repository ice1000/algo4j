///
/// Created by ice1000
///

#include "org_ice1000_bit_BinaryIndexedTree.h"

#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCUnusedGlobalDeclarationInspection"

using namespace ice1000_bit;

/**
 * Class:     org_ice1000_bit_BinaryIndexedTree
 * Method:    add
 * Signature: ([JIIJ)V
 */
JNIEXPORT void JNICALL Java_org_ice1000_bit_BinaryIndexedTree_add(
		JNIEnv *env, jobject jo, jlongArray _data, jint len, jint idx, jlong value) {
	add(env, _data, len, idx, value);
}

/**
 * Class:     org_ice1000_bit_BinaryIndexedTree
 * Method:    sum
 * Signature: ([JII)J
 */
JNIEXPORT jlong JNICALL Java_org_ice1000_bit_BinaryIndexedTree_sum(
		JNIEnv *env, jobject jo, jlongArray _data, jint len, jint idx) {
	return sum(env, _data, idx);
}


#pragma clang diagnostic pop

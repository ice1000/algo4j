///
/// Created by ice1000 on 2016.11.16
///

#include "BinaryIndexedTree.h"
#include "../global/templates.hpp"
#include "../global/basics.hpp"

#pragma clang diagnostic push
#pragma clang diagnostic ignored "-Wunused-parameter"
#pragma ide diagnostic ignored "OCUnusedGlobalDeclarationInspection"

using namespace algo4j_bit;

JNIEXPORT auto JNICALL Java_org_algo4j_bit_BinaryIndexedTree_add(
		JNIEnv *env,
		jclass,
		jlongArray _data,
		jint len,
		jint idx,
		jlong value) -> void {
	__JNI__FUNCTION__INIT__
	__get(Long, data);
	add(data, len, idx, value);
	__release(Long, data);
	__JNI__FUNCTION__CLEAN__
}

JNIEXPORT auto JNICALL Java_org_algo4j_bit_BinaryIndexedTree_sum(
		JNIEnv *env,
		jclass,
		jlongArray _data,
		jint len,
		jint idx) -> jlong {
	__JNI__FUNCTION__INIT__
	__get(Long, data);
	auto result = sum(data, idx);
	__release(Long, data);
	__JNI__FUNCTION__CLEAN__
	return result;
}


#pragma clang diagnostic pop


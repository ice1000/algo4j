///
/// Created by ice1000 on 2016.11.16
///

#include "BinaryIndexedTree.h"

#pragma clang diagnostic push
#pragma clang diagnostic ignored "-Wunused-parameter"
#pragma ide diagnostic ignored "OCUnusedGlobalDeclarationInspection"

using namespace algo4j_bit;

JNIEXPORT auto JNICALL Java_org_algo4j_bit_BinaryIndexedTree_add(
		JNIEnv *env, jobject jo, jlongArray _data, jint len, jint idx, jlong value) -> void {
	auto option = new jboolean(false);
	auto data = env->GetLongArrayElements(_data, option);
	add(data, len, idx, value);
	env->ReleaseLongArrayElements(_data, data, 0);
	delete option;
}

JNIEXPORT auto JNICALL Java_org_algo4j_bit_BinaryIndexedTree_sum(
		JNIEnv *env,
		jobject jo,
		jlongArray _data,
		jint len,
		jint idx) -> jlong {
	auto option = new jboolean(false);
	auto data = env->GetLongArrayElements(_data, option);
	auto result = sum(data, idx);
	env->ReleaseLongArrayElements(_data, data, 0);
	delete option;
	return result;
}


#pragma clang diagnostic pop

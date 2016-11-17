///
/// Created by ice1000
///

#include "org_ice1000_bit_ReversePairSum.h"
#include <stdio.h>

#pragma clang diagnostic push
#pragma clang diagnostic ignored "-Wunused-parameter"
#pragma ide diagnostic ignored "OCUnusedGlobalDeclarationInspection"

JNIEXPORT void JNICALL Java_org_ice1000_bit_ReversePairSum_discretization(
		JNIEnv *env,
		jobject jo,
		jlongArray _data,
		jint len) {
	auto option = new jboolean(false);
	auto data = env->GetLongArrayElements(_data, option);
	auto pair = new ice1000_util::Ice1000Pair<jlong, int>[len]();
	auto after = new jlong[len];
	for (auto i = 0; i < len; ++i) pair[i].setValue(data[i], i);
	ice1000_util::quick_sort(pair, len);
	for (auto i = 0, j = 0; i < len; ++i) {
		after[pair[i].second] = j;
		if (j < len && pair[i].first == pair[i + 1].first) --j;
	}
	for (auto i = 0; i < len; ++i) printf("%lli ", after[i]);
//	env->SetObjectArrayElement()
//  auto _after = env->NewLongArray((jsize)len);
	env->SetLongArrayRegion(_data, 0, len, after);
	env->ReleaseLongArrayElements(_data, data, NULL);
	delete option;
	delete pair;
	delete after;
}

JNIEXPORT jlong JNICALL Java_org_ice1000_bit_ReversePairSum_query(
		JNIEnv *env,
		jobject jo,
		jlongArray _data,
		jint len) {
	jlong ret = 0;
	auto option = new jboolean(false);
	auto data = env->GetLongArrayElements(_data, option);
	for (auto i = 0; i < len; ++i) {
		ice1000_bit::add(data, len, i, 1);
		ret += 1 + i - ice1000_bit::sum(data, i);
	}
	env->ReleaseLongArrayElements(_data, data, NULL);
	delete option;
	return ret;
}

#pragma clang diagnostic pop

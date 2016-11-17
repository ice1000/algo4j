///
/// Created by ice1000
///

#include "org_ice1000_bit_ReversePairSum.h"

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
	delete option;
	auto pair = new ice1000_util::Ice1000Pair<jlong, int>[len]();
	auto after = new jlong[len];
	for (auto i = 0; i < len; ++i) {
		pair[i].first = data[i];
		pair[i].second = i;
	}
	ice1000_util::quick_sort(pair, len);
	for (auto i = 0, j = 0; i < len; ++i) {
		after[pair[i].second] = j;
		if (j < len && pair[i].first == pair[i + 1].first) --j;
	}
//	delete pair;
	env->SetLongArrayRegion(_data, 0, len, after);
	env->ReleaseLongArrayElements(_data, data, NULL);
//	delete data;
}

JNIEXPORT jlong JNICALL Java_org_ice1000_bit_ReversePairSum_query(
		JNIEnv *env,
		jobject jo,
		jlongArray _data,
		jint len) {
	jlong ret = 0;
	for (auto i = 0; i < len; ++i) {
		ice1000_bit::add(env, _data, len, i, 1);
		ret += 1 + i - ice1000_bit::sum(env, _data, i);
	}
	return ret;
}

#pragma clang diagnostic pop

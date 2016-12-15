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
	auto pair = new ice1000_util::Ice1000Pair<jlong, int>[len]();
	auto after = new jlong[len + 1];
	for (auto i = 0; i < len; ++i) pair[i].setValue(data[i], i);
//	std::sort(pair, pair + len);
	ice1000_util::quick_sort(pair, len);
	for (auto i = 0, j = 0; i < len; ++i, ++j) {
		after[pair[i].second] = j;
		if (pair[i].first == pair[i + 1].first) --j;
	}
//	for (auto i = 0; i < len; ++i) printf("%lli ", after[i]);
//	env->SetObjectArrayElement()
//  auto _after = env->NewLongArray((jsize)len);
//  jlong l[] = { 3, 2, 1, 5, 4 };
	env->ReleaseLongArrayElements(_data, data, 0);
	env->SetLongArrayRegion(_data, 0, len, after);
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
	auto bit = new jlong[len + 1];
	__ice_memset(bit, 0);
	for (auto i = 0; i < len; ++i) {
		ice1000_bit::add(bit, len + 1, data[i], 1);
		ret += 1 + i - ice1000_bit::sum(bit, data[i]);
	}
	env->ReleaseLongArrayElements(_data, data, 0);
	delete option;
	delete bit;
	return ret;
}

#pragma clang diagnostic pop

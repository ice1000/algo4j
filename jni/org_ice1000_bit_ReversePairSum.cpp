///
/// Created by ice1000
///

#include "org_ice1000_bit_ReversePairSum.h"

using namespace ice1000_bit;

JNIEXPORT void JNICALL Java_org_ice1000_bit_ReversePairSum_discretization(
		JNIEnv *env,
		jobject jo,
		jlongArray _data,
		jint len) {
	auto data = env->GetLongArrayElements(_data, 0);
	auto pair = new ice1000_util::Ice1000Pair<jlong, int>[len]();
	for (auto i = 0; i < len; ++i) {
	  pair[i].first = data[i];
	  pair[i].second = i;
  }
  ice1000_util::quick_sort(pair, len);
	env->ReleaseLongArrayElements(_data, data, 0);
}

JNIEXPORT jlong JNICALL Java_org_ice1000_bit_ReversePairSum_query(
		JNIEnv *env,
		jobject jo,
		jlongArray _data,
		jint len) {
	return 0;
}

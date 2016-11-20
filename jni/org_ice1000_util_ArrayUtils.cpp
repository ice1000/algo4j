///
/// Created by ice1000
///

#include "org_ice1000_util_ArrayUtils.h"

JNIEXPORT void JNICALL Java_org_ice1000_util_ArrayUtils_discretization___3JI(
		JNIEnv *env,
		jclass jc,
		jlongArray _data,
		jint len) {
	auto option = new jboolean(false);
	auto data = env->GetLongArrayElements(_data, option);
	auto pair = new ice1000_util::Ice1000Pair<jlong, jint>[len]();
	auto after = new jlong[len];
	for (auto i = 0; i < len; ++i) pair[i].setValue(data[i], i);
//	std::sort(pair, pair + len);
	ice1000_util::quick_sort(pair, len);
	for (auto i = 0, j = 0; i < len; ++i, ++j) {
		after[pair[i].second] = j;
		if ((i + 1 < len) and pair[i].first == pair[i + 1].first) --j;
	}
//	for (auto i = 0; i < len; ++i) printf("%lli ", after[i]);
//	env->SetObjectArrayElement()
//  auto _after = env->NewLongArray((jsize)len);
//  jlong l[] = { 3, 2, 1, 5, 4 };
	env->ReleaseLongArrayElements(_data, data, 0);
	env->SetLongArrayRegion(_data, 0, len, after);
	delete option;
	delete after;
//	delete pair;
}

JNIEXPORT void JNICALL Java_org_ice1000_util_ArrayUtils_discretization___3II(
		JNIEnv *env,
		jclass jc,
		jintArray _data,
		jint len) {
	auto option = new jboolean(false);
	auto data = env->GetIntArrayElements(_data, option);
	auto pair = new ice1000_util::Ice1000Pair<jint, jint>[len]();
	auto after = new jint[len];
	for (auto i = 0; i < len; ++i) pair[i].setValue(data[i], i);
	ice1000_util::bubble_sort(pair, len);
	for (auto i = 0, j = 0; i < len; ++i, ++j) {
		after[pair[i].second] = j;
		if ((i + 1 < len) and pair[i].first == pair[i + 1].first) --j;
	}
	env->ReleaseIntArrayElements(_data, data, 0);
	env->SetIntArrayRegion(_data, 0, len, after);
	delete option;
	delete after;
	// delete pair;
}



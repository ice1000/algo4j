///
/// Created by ice1000
///

#include "org_ice1000_util_ArrayUtils.h"

#pragma clang diagnostic push
#pragma clang diagnostic ignored "-Wunused-parameter"
#pragma ide diagnostic ignored "OCUnusedGlobalDeclarationInspection"

JNIEXPORT void JNICALL Java_org_ice1000_util_ArrayUtils_discretization(
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


#pragma clang diagnostic pop


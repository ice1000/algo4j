///
/// Created by ice1000
///

#include "org_ice1000_util_SequenceUtils.h"

#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCUnusedGlobalDeclarationInspection"

JNIEXPORT void JNICALL Java_org_ice1000_util_SequenceUtils_discretization___3JI (
		JNIEnv *env,
		jclass,
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

JNIEXPORT void JNICALL Java_org_ice1000_util_SequenceUtils_discretization___3II (
		JNIEnv *env,
		jclass,
		jintArray _data,
		jint len) {
	auto option = new jboolean(false);
	auto data = env->GetIntArrayElements(_data, option);
	auto pair = new ice1000_util::Ice1000Pair<jint, jint>[len]();
	auto after = ice1000_util::discretization(data, len);
	env->ReleaseIntArrayElements(_data, data, 0);
	env->SetIntArrayRegion(_data, 0, len, after);
	delete option;
	delete after;
	// delete pair;
}

JNIEXPORT void JNICALL Java_org_ice1000_util_SequenceUtils_discretization___3FI (
		JNIEnv *,
		jclass,
		jfloatArray,
		jint len) {
	auto option = new jboolean(false);
	delete option;
}

JNIEXPORT void JNICALL Java_org_ice1000_util_SequenceUtils_discretization___3DI (
		JNIEnv *env,
		jclass,
		jdoubleArray,
		jint len) {
	auto option = new jboolean(false);
	delete option;
}

#define __ice_bubble_sort__ \
ice1000_util::bubble_sort(data, len);

#define bubble_get_params _data, option
#define bubble_set_params _data, 0, len, data


JNIEXPORT void JNICALL Java_org_ice1000_util_SequenceUtils_sortBubble___3II (
		JNIEnv *env,
		jclass,
		jintArray _data,
		jint len) {
	auto option = new jboolean(false);
	auto data = env->GetIntArrayElements(bubble_get_params);
	__ice_bubble_sort__
	env->SetIntArrayRegion(bubble_set_params);
	delete option;
}

JNIEXPORT void JNICALL Java_org_ice1000_util_SequenceUtils_sortBubble___3JI (
		JNIEnv *env,
		jclass,
		jlongArray _data,
		jint len) {
	auto option = new jboolean(false);
	auto data = env->GetLongArrayElements(bubble_get_params);
	__ice_bubble_sort__
	env->SetLongArrayRegion(bubble_set_params);
	delete option;
}

JNIEXPORT void JNICALL Java_org_ice1000_util_SequenceUtils_sortBubble___3FI (
		JNIEnv *env,
		jclass,
		jfloatArray _data,
		jint len) {
	auto option = new jboolean(false);
	auto data = env->GetFloatArrayElements(bubble_get_params);
	__ice_bubble_sort__
	env->SetFloatArrayRegion(bubble_set_params);
	delete option;
}

/**
 * Class:     org_ice1000_util_SequenceUtils
 * Method:    sortBubble
 * Signature: ([DI)V
 */
JNIEXPORT void JNICALL Java_org_ice1000_util_SequenceUtils_sortBubble___3DI (
		JNIEnv *env,
		jclass,
		jdoubleArray _data,
		jint len) {
	auto option = new jboolean(false);
	auto data = env->GetDoubleArrayElements(bubble_get_params);
	__ice_bubble_sort__
	env->SetDoubleArrayRegion(bubble_set_params);
	delete option;
}

#undef __ice_bubble_sort__
#undef bubble_set_params
#undef bubble_get_params

JNIEXPORT void JNICALL Java_org_ice1000_util_SequenceUtils_sortQuick___3II (
		JNIEnv *env,
		jclass,
		jintArray _data,
		jint len) {
	auto option = new jboolean(false);
	auto data = env->GetIntArrayElements(_data, option);
	// TODO
	env->SetIntArrayRegion(_data, 0, len, data);
	delete option;
}

JNIEXPORT void JNICALL Java_org_ice1000_util_SequenceUtils_sortQuick___3JI (
		JNIEnv *env,
		jclass,
		jlongArray _data,
		jint len) {
	auto option = new jboolean(false);
	delete option;
}

JNIEXPORT void JNICALL Java_org_ice1000_util_SequenceUtils_sortQuick___3FI (
		JNIEnv *env,
		jclass,
		jfloatArray _data,
		jint len) {
	auto option = new jboolean(false);
	delete option;
}

JNIEXPORT void JNICALL Java_org_ice1000_util_SequenceUtils_sortQuick___3DI (
		JNIEnv *env,
		jclass,
		jdoubleArray _data,
		jint len) {
	auto option = new jboolean(false);
	delete option;
}

#pragma clang diagnostic pop
///
/// Created by ice1000
///

#include "org_ice1000_util_SequenceUtils.h"

#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCUnusedGlobalDeclarationInspection"

JNIEXPORT auto JNICALL Java_org_ice1000_util_SequenceUtils_discretization___3JI (
		JNIEnv *env,
		jclass,
		jlongArray _data,
		jint len) -> void {
	__JNI__FUNCTION__INIT__
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
	__JNI__FUNCTION__CLEAN__
	delete after;
//	delete pair;
}

JNIEXPORT auto JNICALL Java_org_ice1000_util_SequenceUtils_discretization___3II (
		JNIEnv *env,
		jclass,
		jintArray _data,
		jint len) -> void {
	__JNI__FUNCTION__INIT__
	auto data = env->GetIntArrayElements(_data, option);
	auto pair = new ice1000_util::Ice1000Pair<jint, jint>[len]();
	auto after = ice1000_util::discretization(data, len);
	env->ReleaseIntArrayElements(_data, data, 0);
	env->SetIntArrayRegion(_data, 0, len, after);
	__JNI__FUNCTION__CLEAN__
	delete after;
	// delete pair;
}

JNIEXPORT auto JNICALL Java_org_ice1000_util_SequenceUtils_discretization___3FI (
		JNIEnv *,
		jclass,
		jfloatArray,
		jint len) -> void {
	__JNI__FUNCTION__INIT__
	__JNI__FUNCTION__CLEAN__
}

JNIEXPORT auto JNICALL Java_org_ice1000_util_SequenceUtils_discretization___3DI (
		JNIEnv *env,
		jclass,
		jdoubleArray,
		jint len) -> void {
	__JNI__FUNCTION__INIT__
	__JNI__FUNCTION__CLEAN__
}

#define __ice_bubble_sort__ \
ice1000_util::bubble_sort(data, len);

#define sort_get_params _data, option
#define sort_set_params _data, 0, len, data


JNIEXPORT auto JNICALL Java_org_ice1000_util_SequenceUtils_sortBubble___3II (
		JNIEnv *env,
		jclass,
		jintArray _data,
		jint len) -> void {
	__JNI__FUNCTION__INIT__
	auto data = env->GetIntArrayElements(sort_get_params);
	__ice_bubble_sort__
	env->SetIntArrayRegion(sort_set_params);
	__JNI__FUNCTION__CLEAN__
}

JNIEXPORT auto JNICALL Java_org_ice1000_util_SequenceUtils_sortBubble___3JI (
		JNIEnv *env,
		jclass,
		jlongArray _data,
		jint len) -> void {
	__JNI__FUNCTION__INIT__
	auto data = env->GetLongArrayElements(sort_get_params);
	__ice_bubble_sort__
	env->SetLongArrayRegion(sort_set_params);
	__JNI__FUNCTION__CLEAN__
}

JNIEXPORT auto JNICALL Java_org_ice1000_util_SequenceUtils_sortBubble___3FI (
		JNIEnv *env,
		jclass,
		jfloatArray _data,
		jint len) -> void {
	__JNI__FUNCTION__INIT__
	auto data = env->GetFloatArrayElements(sort_get_params);
	__ice_bubble_sort__
	env->SetFloatArrayRegion(sort_set_params);
	__JNI__FUNCTION__CLEAN__
}

/**
 * Class:     org_ice1000_util_SequenceUtils
 * Method:    sortBubble
 * Signature: ([DI)V
 */
JNIEXPORT auto JNICALL Java_org_ice1000_util_SequenceUtils_sortBubble___3DI (
		JNIEnv *env,
		jclass,
		jdoubleArray _data,
		jint len) -> void {
	__JNI__FUNCTION__INIT__
	auto data = env->GetDoubleArrayElements(sort_get_params);
	__ice_bubble_sort__
	env->SetDoubleArrayRegion(sort_set_params);
	__JNI__FUNCTION__CLEAN__
}

#undef __ice_bubble_sort__

JNIEXPORT auto JNICALL Java_org_ice1000_util_SequenceUtils_sortQuick___3II (
		JNIEnv *env,
		jclass,
		jintArray _data,
		jint len) -> void {
	__JNI__FUNCTION__INIT__
	auto data = env->GetIntArrayElements(sort_get_params);
	// TODO
	env->SetIntArrayRegion(sort_set_params);
	__JNI__FUNCTION__CLEAN__
}

JNIEXPORT auto JNICALL Java_org_ice1000_util_SequenceUtils_sortQuick___3JI (
		JNIEnv *env,
		jclass,
		jlongArray _data,
		jint len) -> void {
	__JNI__FUNCTION__INIT__
	__JNI__FUNCTION__CLEAN__
}

JNIEXPORT auto JNICALL Java_org_ice1000_util_SequenceUtils_sortQuick___3FI (
		JNIEnv *env,
		jclass,
		jfloatArray _data,
		jint len) -> void {
	__JNI__FUNCTION__INIT__
	__JNI__FUNCTION__CLEAN__
}

JNIEXPORT auto JNICALL Java_org_ice1000_util_SequenceUtils_sortQuick___3DI (
		JNIEnv *env,
		jclass,
		jdoubleArray _data,
		jint len) -> void {
	__JNI__FUNCTION__INIT__
	__JNI__FUNCTION__CLEAN__
}

#undef sort_set_params
#undef sort_get_params

#pragma clang diagnostic pop

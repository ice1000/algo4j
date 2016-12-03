///
/// Created by ice1000
///

#include "org_ice1000_util_SequenceUtils.h"

#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCUnusedGlobalDeclarationInspection"

JNIEXPORT auto JNICALL Java_org_ice1000_util_SequenceUtils_discretization___3JI(
		JNIEnv *env,
		jclass,
		jlongArray _data,
		jint len) -> void {
	__JNI__FUNCTION__INIT__
	auto data = env->GetLongArrayElements(_data, option);
	auto pair = new ice1000_util::Ice1000Pair<jlong, jint>[len]();
	auto after = ice1000_util::discretization(data, len);
	env->ReleaseLongArrayElements(_data, data, 0);
	env->SetLongArrayRegion(_data, 0, len, after);
	__JNI__FUNCTION__CLEAN__
	delete after;
}

JNIEXPORT auto JNICALL Java_org_ice1000_util_SequenceUtils_discretization___3II(
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
}

JNIEXPORT auto JNICALL Java_org_ice1000_util_SequenceUtils_discretization___3FI(
		JNIEnv *env,
		jclass,
		jfloatArray _data,
		jint len) -> void {
	__JNI__FUNCTION__INIT__
	auto data = env->GetFloatArrayElements(_data, option);
	auto pair = new ice1000_util::Ice1000Pair<jfloat, jint>[len]();
	auto after = ice1000_util::discretization(data, len);
	env->ReleaseFloatArrayElements(_data, data, 0);
	env->SetFloatArrayRegion(_data, 0, len, after);
	__JNI__FUNCTION__CLEAN__
	delete after;
}

JNIEXPORT auto JNICALL Java_org_ice1000_util_SequenceUtils_discretization___3DI(
		JNIEnv *env,
		jclass,
		jdoubleArray _data,
		jint len) -> void {
	__JNI__FUNCTION__INIT__
	auto data = env->GetDoubleArrayElements(_data, option);
	auto pair = new ice1000_util::Ice1000Pair<jdouble, jint>[len]();
	auto after = ice1000_util::discretization(data, len);
	env->ReleaseDoubleArrayElements(_data, data, 0);
	env->SetDoubleArrayRegion(_data, 0, len, after);
	__JNI__FUNCTION__CLEAN__
	delete after;
}

#define __ice_bubble_sort__ \
ice1000_util::bubble_sort(data, len);

#define sort_get_params _data, option
#define sort_set_params _data, 0, len, data


JNIEXPORT auto JNICALL Java_org_ice1000_util_SequenceUtils_sortBubble___3II(
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

JNIEXPORT auto JNICALL Java_org_ice1000_util_SequenceUtils_sortBubble___3JI(
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

JNIEXPORT auto JNICALL Java_org_ice1000_util_SequenceUtils_sortBubble___3FI(
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
JNIEXPORT auto JNICALL Java_org_ice1000_util_SequenceUtils_sortBubble___3DI(
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

JNIEXPORT auto JNICALL Java_org_ice1000_util_SequenceUtils_sortQuick___3II(
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

JNIEXPORT auto JNICALL Java_org_ice1000_util_SequenceUtils_sortQuick___3JI(
		JNIEnv *env,
		jclass,
		jlongArray _data,
		jint len) -> void {
	__JNI__FUNCTION__INIT__
	__JNI__FUNCTION__CLEAN__
}

JNIEXPORT auto JNICALL Java_org_ice1000_util_SequenceUtils_sortQuick___3FI(
		JNIEnv *env,
		jclass,
		jfloatArray _data,
		jint len) -> void {
	__JNI__FUNCTION__INIT__
	__JNI__FUNCTION__CLEAN__
}

JNIEXPORT auto JNICALL Java_org_ice1000_util_SequenceUtils_sortQuick___3DI(
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

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
	__ice_create_jni_option
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
	__ice_delete_jni_option
	delete after;
//	delete pair;
}

JNIEXPORT void JNICALL Java_org_ice1000_util_SequenceUtils_discretization___3II (
		JNIEnv *env,
		jclass,
		jintArray _data,
		jint len) {
	__ice_create_jni_option
	auto data = env->GetIntArrayElements(_data, option);
	auto pair = new ice1000_util::Ice1000Pair<jint, jint>[len]();
	auto after = ice1000_util::discretization(data, len);
	env->ReleaseIntArrayElements(_data, data, 0);
	env->SetIntArrayRegion(_data, 0, len, after);
	__ice_delete_jni_option
	delete after;
	// delete pair;
}

JNIEXPORT void JNICALL Java_org_ice1000_util_SequenceUtils_discretization___3FI (
		JNIEnv *,
		jclass,
		jfloatArray,
		jint) {
	__ice_create_jni_option
	__ice_delete_jni_option
}

JNIEXPORT void JNICALL Java_org_ice1000_util_SequenceUtils_discretization___3DI (
		JNIEnv *env,
		jclass,
		jdoubleArray,
		jint) {
	__ice_create_jni_option
	__ice_delete_jni_option
}

#define __ice_bubble_sort__\
ice1000_util::bubble_sort(data, len);\

#define __ice_bubble_get_params _data, option
#define __ice_bubble_set_params _data, 0, len, data


JNIEXPORT void JNICALL Java_org_ice1000_util_SequenceUtils_sortBubble___3II (
		JNIEnv *env,
		jclass,
		jintArray _data,
		jint len) {
	__ice_create_jni_option
	auto data = env->GetIntArrayElements(__ice_bubble_get_params);
	__ice_bubble_sort__
	env->SetIntArrayRegion(__ice_bubble_set_params);
	__ice_delete_jni_option
}

JNIEXPORT void JNICALL Java_org_ice1000_util_SequenceUtils_sortBubble___3JI (
		JNIEnv *env,
		jclass,
		jlongArray _data,
		jint len) {
	__ice_create_jni_option
	auto data = env->GetLongArrayElements(__ice_bubble_get_params);
	__ice_bubble_sort__
	env->SetLongArrayRegion(__ice_bubble_set_params);
	__ice_delete_jni_option
}

/**
 * Class:     org_ice1000_util_SequenceUtils
 * Method:    sortBubble
 * Signature: ([FI)V
 */
JNIEXPORT void JNICALL Java_org_ice1000_util_SequenceUtils_sortBubble___3FI (
		JNIEnv *env,
		jclass,
		jfloatArray _data,
		jint len) {
	__ice_create_jni_option
	auto data = env->GetFloatArrayElements(__ice_bubble_get_params);
	__ice_bubble_sort__
	env->SetFloatArrayRegion(__ice_bubble_set_params);
	__ice_delete_jni_option
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
	__ice_create_jni_option
	auto data = env->GetDoubleArrayElements(__ice_bubble_get_params);
	__ice_bubble_sort__
	env->SetDoubleArrayRegion(__ice_bubble_set_params);
	__ice_delete_jni_option
}

/**
 * Class:     org_ice1000_util_SequenceUtils
 * Method:    sortQuick
 * Signature: ([II)V
 */
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

/**
 * Class:     org_ice1000_util_SequenceUtils
 * Method:    sortQuick
 * Signature: ([JI)V
 */
JNIEXPORT void JNICALL Java_org_ice1000_util_SequenceUtils_sortQuick___3JI (
		JNIEnv *env,
		jclass,
		jlongArray,
		jint

);

/**
 * Class:     org_ice1000_util_SequenceUtils
 * Method:    sortQuick
 * Signature: ([FI)V
 */
JNIEXPORT void JNICALL Java_org_ice1000_util_SequenceUtils_sortQuick___3FI (
		JNIEnv *env,
		jclass,
		jfloatArray,
		jint
);

/**
 * Class:     org_ice1000_util_SequenceUtils
 * Method:    sortQuick
 * Signature: ([DI)V
 */
JNIEXPORT void JNICALL Java_org_ice1000_util_SequenceUtils_sortQuick___3DI (
		JNIEnv *env,
		jclass,
		jdoubleArray,
		jint
);

#pragma clang diagnostic pop
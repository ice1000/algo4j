//
// Created by ice1000 on 2016/12/13
//

#include "Statistics.h"
#include "../global/functions.h"
#include "../global/templates.hpp"

using algo4j_util::abs;

#define __ice_arr_min(type) \
__JNI__FUNCTION__INIT__ \
auto data = env->Get ## type ## ArrayElements(_data, option); \
auto len = env->GetArrayLength(_data); \
auto min = data[0]; \
for (auto i = 1; i < len; ++i) \
	if (data[i] < min) min = data[i]; \
env->Release ## type ## ArrayElements(_data, data, 0); \
__JNI__FUNCTION__CLEAN__ \
return min;

JNIEXPORT auto JNICALL Java_org_algo4j_util_Statistics_min___3I(
		JNIEnv *env,
		jclass,
		jintArray _data) -> jint {
	__ice_arr_min(Int);
}

JNIEXPORT auto JNICALL Java_org_algo4j_util_Statistics_min___3J(
		JNIEnv *env,
		jclass,
		jlongArray _data) -> jlong {
	__ice_arr_min(Long);
}

JNIEXPORT auto JNICALL Java_org_algo4j_util_Statistics_min___3F(
		JNIEnv *env,
		jclass,
		jfloatArray _data) -> jfloat {
	__ice_arr_min(Float);
}

JNIEXPORT auto JNICALL Java_org_algo4j_util_Statistics_min___3D(
		JNIEnv *env,
		jclass,
		jdoubleArray _data) -> jdouble {
	__ice_arr_min(Double);
}

#undef __ice_arr_min

#define __ice_arr_max(type) \
__JNI__FUNCTION__INIT__ \
auto data = env->Get ## type ## ArrayElements(_data, option); \
auto len = env->GetArrayLength(_data); \
auto max = data[0]; \
for (auto i = 1; i < len; ++i) \
	if (data[i] > max) max = data[i]; \
env->Release ## type ## ArrayElements(_data, data, 0); \
__JNI__FUNCTION__CLEAN__ \
return max;

JNIEXPORT auto JNICALL Java_org_algo4j_util_Statistics_max___3I(
		JNIEnv *env,
		jclass,
		jintArray _data) -> jint {
	__ice_arr_max(Int);
}

JNIEXPORT auto JNICALL Java_org_algo4j_util_Statistics_max___3J(
		JNIEnv *env,
		jclass,
		jlongArray _data) -> jlong {
	__ice_arr_max(Long);
}

JNIEXPORT auto JNICALL Java_org_algo4j_util_Statistics_max___3F(
		JNIEnv *env,
		jclass,
		jfloatArray _data) -> jfloat {
	__ice_arr_max(Float);
}

JNIEXPORT auto JNICALL Java_org_algo4j_util_Statistics_max___3D(
		JNIEnv *env,
		jclass,
		jdoubleArray _data) -> jdouble {
	__ice_arr_max(Double);
}

#undef __ice_arr_max

#define __ice_arr_sum(type) \
__JNI__FUNCTION__INIT__ \
auto data = env->Get ## type ## ArrayElements(_data, option); \
auto len = env->GetArrayLength(_data); \
auto sum = data[0]; \
for (auto i = 1; i < len; ++i) \
	sum += data[i]; \
env->Release ## type ## ArrayElements(_data, data, 0); \
__JNI__FUNCTION__CLEAN__ \
return sum;

JNIEXPORT auto JNICALL Java_org_algo4j_util_Statistics_sum___3I(
		JNIEnv *env,
		jclass,
		jintArray _data) -> jint {
	__ice_arr_sum(Int);
}

JNIEXPORT auto JNICALL Java_org_algo4j_util_Statistics_sum___3J(
		JNIEnv *env,
		jclass,
		jlongArray _data) -> jlong {
	__ice_arr_sum(Long);
}

JNIEXPORT auto JNICALL Java_org_algo4j_util_Statistics_sum___3F(
		JNIEnv *env,
		jclass,
		jfloatArray _data) -> jfloat {
	__ice_arr_sum(Float);
}

JNIEXPORT auto JNICALL Java_org_algo4j_util_Statistics_sum___3D(
		JNIEnv *env,
		jclass,
		jdoubleArray _data) -> jdouble {
	__ice_arr_sum(Double);
}

#undef __ice_arr_sum

#define __ice_arr_avg(type) \
__JNI__FUNCTION__INIT__ \
auto data = env->Get ## type ## ArrayElements(_data, option); \
auto len = env->GetArrayLength(_data); \
jdouble avg = 0; \
for (auto i = 0; i < len; ++i) \
	avg += data[i] * 1.0 / len; \
env->Release ## type ## ArrayElements(_data, data, 0); \
__JNI__FUNCTION__CLEAN__ \
return avg;

JNIEXPORT auto JNICALL Java_org_algo4j_util_Statistics_avg___3I(
		JNIEnv *env,
		jclass,
		jintArray _data) -> jdouble {
	__ice_arr_avg(Int);
}

JNIEXPORT auto JNICALL Java_org_algo4j_util_Statistics_avg___3J(
		JNIEnv *env,
		jclass,
		jlongArray _data) -> jdouble {
	__ice_arr_avg(Long);
}

JNIEXPORT auto JNICALL Java_org_algo4j_util_Statistics_avg___3F(
		JNIEnv *env,
		jclass,
		jfloatArray _data) -> jdouble {
	__ice_arr_avg(Float);
}

JNIEXPORT auto JNICALL Java_org_algo4j_util_Statistics_avg___3D(
		JNIEnv *env,
		jclass,
		jdoubleArray _data) -> jdouble {
	__ice_arr_avg(Double);
}

#undef __ice_arr_avg

#define __ice_arr_standard_division(type) \
__JNI__FUNCTION__INIT__ \
auto data = env->Get ## type ## ArrayElements(_data, option); \
auto len = env->GetArrayLength(_data); \
jdouble avg = 0; \
jdouble div = 0; \
for (auto i = 0; i < len; ++i) \
	avg += data[i] * 1.0 / len; \
for (auto i = 0; i < len; ++i) \
	div += abs(data[i] - avg) / len; \
env->Release ## type ## ArrayElements(_data, data, 0); \
__JNI__FUNCTION__CLEAN__ \
return div;

JNIEXPORT auto JNICALL Java_org_algo4j_util_Statistics_stdDiv___3I(
		JNIEnv *env,
		jclass,
		jintArray _data) -> jdouble {
	__ice_arr_standard_division(Int);
}

JNIEXPORT auto JNICALL Java_org_algo4j_util_Statistics_stdDiv___3J(
		JNIEnv *env,
		jclass,
		jlongArray _data) -> jdouble {
	__ice_arr_standard_division(Long);
}

JNIEXPORT auto JNICALL Java_org_algo4j_util_Statistics_stdDiv___3F(
		JNIEnv *env,
		jclass,
		jfloatArray _data) -> jdouble {
	__ice_arr_standard_division(Float);
}

JNIEXPORT auto JNICALL Java_org_algo4j_util_Statistics_stdDiv___3D(
		JNIEnv *env,
		jclass,
		jdoubleArray _data) -> jdouble {
	__ice_arr_standard_division(Double);
}

#undef 	__ice_arr_standard_division


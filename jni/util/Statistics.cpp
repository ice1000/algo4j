//
// Created by ice1000 on 2016/12/13
//

#include "Statistics.h"

using algo4j_util::abs;

#define __ice_arr_min(type) \
__JNI__FUNCTION__INIT__ \
auto data = env->Get ## type ## ArrayElements(_data, option); \
auto min = data[0]; \
for (auto i = 1; i < len; ++i) \
	if (data[i] < min) min = data[i]; \
env->Release ## type ## ArrayElements(_data, data, 0); \
__JNI__FUNCTION__CLEAN__ \
return min;

JNIEXPORT auto JNICALL Java_org_algo4j_util_Statistics_min___3II(
		JNIEnv *env,
		jclass,
		jintArray _data,
		jint len) -> jint {
	__ice_arr_min(Int);
}

JNIEXPORT auto JNICALL Java_org_algo4j_util_Statistics_min___3JI(
		JNIEnv *env,
		jclass,
		jlongArray _data,
		jint len) -> jlong {
	__ice_arr_min(Long);
}

JNIEXPORT auto JNICALL Java_org_algo4j_util_Statistics_min___3FI(
		JNIEnv *env,
		jclass,
		jfloatArray _data,
		jint len) -> jfloat {
	__ice_arr_min(Float);
}

JNIEXPORT auto JNICALL Java_org_algo4j_util_Statistics_min___3DI(
		JNIEnv *env,
		jclass,
		jdoubleArray _data,
		jint len) -> jdouble {
	__ice_arr_min(Double);
}

#undef __ice_arr_min

#define __ice_arr_max(type) \
__JNI__FUNCTION__INIT__ \
auto data = env->Get ## type ## ArrayElements(_data, option); \
auto max = data[0]; \
for (auto i = 1; i < len; ++i) \
	if (data[i] > max) max = data[i]; \
env->Release ## type ## ArrayElements(_data, data, 0); \
__JNI__FUNCTION__CLEAN__ \
return max;

JNIEXPORT auto JNICALL Java_org_algo4j_util_Statistics_max___3II(
		JNIEnv *env,
		jclass,
		jintArray _data,
		jint len) -> jint {
	__ice_arr_max(Int);
}

JNIEXPORT auto JNICALL Java_org_algo4j_util_Statistics_max___3JI(
		JNIEnv *env,
		jclass,
		jlongArray _data,
		jint len) -> jlong {
	__ice_arr_max(Long);
}

JNIEXPORT auto JNICALL Java_org_algo4j_util_Statistics_max___3FI(
		JNIEnv *env,
		jclass,
		jfloatArray _data,
		jint len) -> jfloat {
	__ice_arr_max(Float);
}

JNIEXPORT auto JNICALL Java_org_algo4j_util_Statistics_max___3DI(
		JNIEnv *env,
		jclass,
		jdoubleArray _data,
		jint len) -> jdouble {
	__ice_arr_max(Double);
}

#undef __ice_arr_max

#define __ice_arr_sum(type) \
__JNI__FUNCTION__INIT__ \
auto data = env->Get ## type ## ArrayElements(_data, option); \
auto sum = data[0]; \
for (auto i = 1; i < len; ++i) \
	sum += data[i]; \
env->Release ## type ## ArrayElements(_data, data, 0); \
__JNI__FUNCTION__CLEAN__ \
return sum;

JNIEXPORT auto JNICALL Java_org_algo4j_util_Statistics_sum___3II(
		JNIEnv *env,
		jclass,
		jintArray _data,
		jint len) -> jint {
	__ice_arr_sum(Int);
}

JNIEXPORT auto JNICALL Java_org_algo4j_util_Statistics_sum___3JI(
		JNIEnv *env,
		jclass,
		jlongArray _data,
		jint len) -> jlong {
	__ice_arr_sum(Long);
}

JNIEXPORT auto JNICALL Java_org_algo4j_util_Statistics_sum___3FI(
		JNIEnv *env,
		jclass,
		jfloatArray _data,
		jint len) -> jfloat {
	__ice_arr_sum(Float);
}

JNIEXPORT auto JNICALL Java_org_algo4j_util_Statistics_sum___3DI(
		JNIEnv *env,
		jclass,
		jdoubleArray _data,
		jint len) -> jdouble {
	__ice_arr_sum(Double);
}

#undef __ice_arr_sum

#define __ice_arr_avg(type) \
__JNI__FUNCTION__INIT__ \
auto data = env->Get ## type ## ArrayElements(_data, option); \
jdouble avg = 0; \
for (auto i = 0; i < len; ++i) \
	avg += data[i] * 1.0 / len; \
env->Release ## type ## ArrayElements(_data, data, 0); \
__JNI__FUNCTION__CLEAN__ \
return avg;

JNIEXPORT auto JNICALL Java_org_algo4j_util_Statistics_avg___3II(
		JNIEnv *env,
		jclass,
		jintArray _data,
		jint len) -> jdouble {
	__ice_arr_avg(Int);
}

JNIEXPORT auto JNICALL Java_org_algo4j_util_Statistics_avg___3JI(
		JNIEnv *env,
		jclass,
		jlongArray _data,
		jint len) -> jdouble {
	__ice_arr_avg(Long);
}

JNIEXPORT auto JNICALL Java_org_algo4j_util_Statistics_avg___3FI(
		JNIEnv *env,
		jclass,
		jfloatArray _data,
		jint len) -> jdouble {
	__ice_arr_avg(Float);
}

JNIEXPORT auto JNICALL Java_org_algo4j_util_Statistics_avg___3DI(
		JNIEnv *env,
		jclass,
		jdoubleArray _data,
		jint len) -> jdouble {
	__ice_arr_avg(Double);
}

#undef __ice_arr_avg

#define __ice_arr_standard_division(type) \
__JNI__FUNCTION__INIT__ \
auto data = env->Get ## type ## ArrayElements(_data, option); \
jdouble avg = 0; \
jdouble div = 0; \
for (auto i = 0; i < len; ++i) \
	avg += data[i] * 1.0 / len; \
for (auto i = 0; i < len; ++i) \
	div += abs(data[i] - avg) / len; \
env->Release ## type ## ArrayElements(_data, data, 0); \
__JNI__FUNCTION__CLEAN__ \
return div;

JNIEXPORT auto JNICALL Java_org_algo4j_util_Statistics_stdDiv___3II(
		JNIEnv *env,
		jclass,
		jintArray _data,
		jint len) -> jdouble {
	__ice_arr_standard_division(Int);
}

JNIEXPORT auto JNICALL Java_org_algo4j_util_Statistics_stdDiv___3JI(
		JNIEnv *env,
		jclass,
		jlongArray _data,
		jint len) -> jdouble {
	__ice_arr_standard_division(Long);
}

JNIEXPORT auto JNICALL Java_org_algo4j_util_Statistics_stdDiv___3FI(
		JNIEnv *env,
		jclass,
		jfloatArray _data,
		jint len) -> jdouble {
	__ice_arr_standard_division(Float);
}

JNIEXPORT auto JNICALL Java_org_algo4j_util_Statistics_stdDiv___3DI(
		JNIEnv *env,
		jclass,
		jdoubleArray _data,
		jint len) -> jdouble {
	__ice_arr_standard_division(Double);
}

#undef 	__ice_arr_standard_division


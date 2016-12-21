//
// Created by ice1000 on 2016/12/14
// 我的高精度 简洁简洁最简洁 逃课去机房我情不自禁 测试测试 在那垃圾的电脑上测试
// 月光下我看到测试全通过 有时很快有时很慢 感到一种力量驱使我的手速 有了高精度
// 负数都不怕 加法减法 乘法除法 乘方取余不压位 为了方便输出 为了方便输出 为了方便输出
//

#include "../global/templates.hpp"
#include "../global/bigint.h"

#include "BigInt.h"

using algo4j_util::swap;
using algo4j_int::compare;
using algo4j_int::BigInt;

#define check_more_than_9
#define check_less_than_0
#define trim_string

JNIEXPORT auto JNICALL Java_org_algo4j_math_BigInt_plus(
		JNIEnv *env,
		jclass,
		jbyteArray _a,
		jbyteArray _b) -> jbyteArray {
	__JNI__FUNCTION__INIT__
	auto a = env->GetByteArrayElements(_a, option);
	auto b = env->GetByteArrayElements(_b, option);
	auto a_len = env->GetArrayLength(_a);
	auto b_len = env->GetArrayLength(_b);
	auto buf = *new BigInt(a, a_len) + *new BigInt(b, b_len);
	auto ret = env->NewByteArray(buf.len);
	env->SetByteArrayRegion(ret, 0, buf.len, buf.data);
	env->ReleaseByteArrayElements(_a, a, 0);
	env->ReleaseByteArrayElements(_b, b, 0);
	__JNI__FUNCTION__CLEAN__
	return ret;
}

JNIEXPORT auto JNICALL Java_org_algo4j_math_BigInt_minus(
		JNIEnv *env,
		jclass,
		jbyteArray _a,
		jbyteArray _b) -> jbyteArray {
	__JNI__FUNCTION__INIT__
	auto a = env->GetByteArrayElements(_a, option);
	auto b = env->GetByteArrayElements(_b, option);
	auto a_len = env->GetArrayLength(_a);
	auto b_len = env->GetArrayLength(_b);
	auto buf = *new BigInt(a, a_len) - *new BigInt(b, b_len);
	auto ret = env->NewByteArray(buf.len);
	env->SetByteArrayRegion(ret, 0, buf.len, buf.data);
	env->ReleaseByteArrayElements(_a, a, 0);
	env->ReleaseByteArrayElements(_b, b, 0);
	__JNI__FUNCTION__CLEAN__
	return ret;
}

JNIEXPORT auto JNICALL Java_org_algo4j_math_BigInt_times(
		JNIEnv *env,
		jclass,
		jbyteArray _a,
		jbyteArray _b) -> jbyteArray {
	__JNI__FUNCTION__INIT__
	auto a = env->GetByteArrayElements(_a, option);
	auto b = env->GetByteArrayElements(_b, option);
	auto a_len = env->GetArrayLength(_a);
	auto b_len = env->GetArrayLength(_b);
	auto buf = *new BigInt(a, a_len) * *new BigInt(b, b_len);
	auto ret = env->NewByteArray(buf.len);
	env->SetByteArrayRegion(ret, 0, buf.len, buf.data);
	env->ReleaseByteArrayElements(_a, a, 0);
	env->ReleaseByteArrayElements(_b, b, 0);
	__JNI__FUNCTION__CLEAN__
	return ret;
}

JNIEXPORT auto JNICALL Java_org_algo4j_math_BigInt_divide(
		JNIEnv *env,
		jclass,
		jbyteArray _a,
		jbyteArray _b) -> jbyteArray {
	//
}

JNIEXPORT auto JNICALL Java_org_algo4j_math_BigInt_pow(
		JNIEnv *env,
		jclass,
		jbyteArray _a,
		jint pow) -> jbyteArray {
	//
}

JNIEXPORT auto JNICALL Java_org_algo4j_math_BigInt_compareTo(
		JNIEnv *env,
		jclass,
		jbyteArray _a,
		jbyteArray _b) -> jint {
	__JNI__FUNCTION__INIT__
	auto a = env->GetByteArrayElements(_a, option);
	auto b = env->GetByteArrayElements(_b, option);
	auto a_len = env->GetArrayLength(_a);
	auto b_len = env->GetArrayLength(_b);
	auto ret = compare(a, b, a_len, b_len);
	env->ReleaseByteArrayElements(_a, a, 0);
	env->ReleaseByteArrayElements(_b, b, 0);
	__JNI__FUNCTION__CLEAN__
	if (ret > 0) ret = 1;
	if (ret < 0) ret = -1;
	return ret;
}


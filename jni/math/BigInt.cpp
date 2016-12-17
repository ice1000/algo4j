//
// Created by ice1000 on 2016/12/14
//

#include "BigInt.h"

using algo4j_util::swap;
using algo4j_util::max;
using algo4j_util::min;
using algo4j_util::abs;

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
	if (a_len < b_len) {
		swap(a, b);
		swap(a_len, b_len);
	}
	auto a_idx = a_len;
	auto b_idx = b_len;
	auto res_len = a_len + 1;
	auto buf = new jbyte[res_len]();
	buf[0] = '0';
	auto res_idx = res_len;
	while (b_idx > 0) {
		buf[--res_idx] += a[--a_idx] + b[--b_idx] - '0';
		if (buf[res_idx] > '9') {
			buf[res_idx] -= 10;
			++buf[res_idx - 1];
		}
	}
	while (a_idx > 0) {
	  buf[--res_idx] += a[--a_idx];
		if (buf[res_idx] > '9') {
			buf[res_idx] -= 10;
			++(buf[res_idx - 1]);
		}
	}
	if (buf[0] == '0') {
		--res_len;
		++buf;
	}
	auto ret = env->NewByteArray(res_len);
	env->SetByteArrayRegion(ret, 0, res_len, buf);
	__JNI__FUNCTION__CLEAN__
	return ret;
}

JNIEXPORT auto JNICALL Java_org_algo4j_math_BigInt_times(
		JNIEnv *env,
		jclass,
		jbyteArray _a,
		jbyteArray _b
) -> jbyteArray;

JNIEXPORT auto JNICALL Java_org_algo4j_math_BigInt_divide(
		JNIEnv *env,
		jclass,
		jbyteArray _a,
		jbyteArray _b
) -> jbyteArray;

JNIEXPORT auto JNICALL Java_org_algo4j_math_BigInt_minus(
		JNIEnv *env,
		jclass,
		jbyteArray _a,
		jbyteArray _b
) -> jbyteArray;

JNIEXPORT auto JNICALL Java_org_algo4j_math_BigInt_pow(
		JNIEnv *env,
		jclass,
		jbyteArray _a,
		jint pow
) -> jbyteArray;

JNIEXPORT auto JNICALL Java_org_algo4j_math_BigInt_compareTo(
		JNIEnv *env,
		jclass,
		jbyteArray _a,
		jbyteArray _b
) -> jint;



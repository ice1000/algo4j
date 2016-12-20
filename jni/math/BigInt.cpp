//
// Created by ice1000 on 2016/12/14
//

#include "BigInt.h"

using algo4j_util::swap;
using algo4j_int::compare;

#define check_less_than_0 \
while (buf[res_idx] < '0') { \
	buf[res_idx] += 10; \
	--(buf[res_idx - 1]); \
}

#define check_more_than_9 \
while (buf[res_idx] > '9') { \
	buf[res_idx] -= 10; \
	++buf[res_idx - 1]; \
}

#define trim_string \
while (buf[0] <= '0' or buf[0] > '9') { \
	--res_len; \
	++buf; \
} \
if (!buf[0]) --buf; \
while (buf[res_len - 1] < '0' or buf[res_len - 1] > '9') { \
	--res_len; \
}

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
		check_more_than_9
	}
	while (a_idx > 0) {
	  buf[--res_idx] += a[--a_idx];
		check_more_than_9
	}
	trim_string
	auto ret = env->NewByteArray(res_len);
	env->SetByteArrayRegion(ret, 0, res_len, buf);
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
	if (a_len < b_len) {
		swap(a, b);
		swap(a_len, b_len);
	}
	auto a_idx = a_len;
	auto b_idx = b_len;
	auto res_len = a_len;
	auto buf = new jbyte[res_len]();
	auto res_idx = res_len;
	while (b_idx > 0) {
		buf[--res_idx] += a[--a_idx] - b[--b_idx] + '0';
		check_less_than_0
	}
	while (a_idx > 0) {
		buf[--res_idx] += a[--a_idx];
		check_less_than_0
	}

	trim_string
	auto ret = env->NewByteArray(res_len);
	env->SetByteArrayRegion(ret, 0, res_len, buf);
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
	if ((a_len == 1 and a[0] == '0') or (b_len == 1 and b[0] == '0')) {
		auto ret = env->NewByteArray(1);
		auto buf = new jbyte[1]();
		buf[0] = '0';
		env->SetByteArrayRegion(ret, 0, 1, buf);
		env->ReleaseByteArrayElements(_a, a, 0);
		env->ReleaseByteArrayElements(_b, b, 0);
		__JNI__FUNCTION__CLEAN__
		return ret;
	}
	auto a_idx = a_len;
	auto b_idx = b_len;
	auto res_len = a_len + b_len;
	auto buf = new jbyte[res_len]();
	for (auto i = 0; i < a_len; ++i) a[i] -= '0';
	for (auto i = 0; i < b_len; ++i) b[i] -= '0';
//	printf("233");
	while (a_idx --> 0) {
		if (!a[a_idx]) continue;
		while (b_idx --> 0) {
			if (!b[b_idx]) continue;
			buf[a_idx + b_idx + 1] += a[a_idx] * b[b_idx];
			buf[a_idx + b_idx] += buf[a_idx + b_idx + 1] / 10;
			buf[a_idx + b_idx + 1] = buf[a_idx + b_idx + 1] % 10;
		}
		b_idx = b_len;
	}
	auto res_idx = res_len;
	while (res_idx --> 1) {
		buf[res_idx - 1] += buf[res_idx] / 10;
		buf[res_idx] = buf[res_idx] % 10 + '0';
	}
	buf[0] += '0';

	trim_string
	auto ret = env->NewByteArray(res_len);
	env->SetByteArrayRegion(ret, 0, res_len, buf);
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

#undef check_more_than_9
#undef check_less_than_0
#undef trim_string


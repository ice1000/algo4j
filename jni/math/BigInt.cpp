//
// Created by ice1000 on 2016/12/14
// 我的高精度 简洁简洁最简洁 逃课去机房我情不自禁 测试测试 在那垃圾的电脑上测试
// 月光下我看到测试全通过 有时很快有时很慢 感到一种力量驱使我的手速 有了高精度
// 负数都不怕 加法减法 乘法除法 乘方取余不压位 为了方便输出 为了方便输出 为了方便输出
//

#include "BigInt.h"

#include "../global/templates.hpp"
#include "../global/bigint.h"

#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCUnusedGlobalDeclarationInspection"

using algo4j_util::swap;

using algo4j_int::compare;
using algo4j_int::plus;
using algo4j_int::minus;
using algo4j_int::times_bf;
using algo4j_int::times;
using algo4j_int::divide;
using algo4j_int::rem;
using algo4j_int::BigInt;

using algo4j_math::fast_mul;
using algo4j_math::fast_power;

JNIEXPORT auto JNICALL Java_org_algo4j_math_BigInt_plus(
		JNIEnv *env,
		jclass,
		jbyteArray _a,
		jbyteArray _b) -> jbyteArray {
	__JNI__FUNCTION__INIT__
	__get(Byte, a);
	__get(Byte, b);
	auto a_len = __len(a);
	auto b_len = __len(b);
	auto buf = plus(a, b, a_len, b_len);
	__new(Byte, ret, buf->len_trim());
	env->SetByteArrayRegion(_ret, 0, buf->len_trim(), buf->data_trim());
	__abort(Byte, a);
	__abort(Byte, b);
	delete buf;
	__JNI__FUNCTION__CLEAN__
	return _ret;
}

JNIEXPORT auto JNICALL Java_org_algo4j_math_BigInt_minus(
		JNIEnv *env,
		jclass,
		jbyteArray _a,
		jbyteArray _b) -> jbyteArray {
	__JNI__FUNCTION__INIT__
	__get(Byte, a);
	__get(Byte, b);
	auto a_len = __len(a);
	auto b_len = __len(b);
	auto buf = minus(a, b, a_len, b_len);
	__new(Byte, ret, buf->len_trim());
	env->SetByteArrayRegion(_ret, 0, buf->len_trim(), buf->data_trim());
	__abort(Byte, a);
	__abort(Byte, b);
	__JNI__FUNCTION__CLEAN__
	delete buf;
	return _ret;
}

JNIEXPORT auto JNICALL Java_org_algo4j_math_BigInt_times(
		JNIEnv *env,
		jclass,
		jbyteArray _a,
		jbyteArray _b) -> jbyteArray {
	__JNI__FUNCTION__INIT__
	__get(Byte, a);
	__get(Byte, b);
	auto a_len = __len(a);
	auto b_len = __len(b);
	auto buf = times(a, b, a_len, b_len);
	__new(Byte, ret, buf->len_trim());
	env->SetByteArrayRegion(_ret, 0, buf->len_trim(), buf->data_trim());
	__abort(Byte, a)
	__abort(Byte, b)
	__JNI__FUNCTION__CLEAN__
	delete buf;
	return _ret;
}

JNIEXPORT auto JNICALL Java_org_algo4j_math_BigInt_timesBruteForce(
		JNIEnv *env,
		jclass,
		jbyteArray _a,
		jbyteArray _b) -> jbyteArray {
	__JNI__FUNCTION__INIT__
	__get(Byte, a);
	__get(Byte, b);
	auto a_len = __len(a);
	auto b_len = __len(b);
	auto buf = times_bf(a, b, a_len, b_len);
	__new(Byte, ret, buf->len_trim());
	env->SetByteArrayRegion(_ret, 0, buf->len_trim(), buf->data_trim());
	__abort(Byte, a)
	__abort(Byte, b)
	__JNI__FUNCTION__CLEAN__
	delete buf;
	return _ret;
}

JNIEXPORT auto JNICALL Java_org_algo4j_math_BigInt_times10(
		JNIEnv *env,
		jclass,
		jbyteArray _a) -> jbyteArray {
	__JNI__FUNCTION__INIT__
	__get(Byte, a);
	auto a_len = __len(a);
	auto ret = new jbyte[a_len + 1];
	__new(Byte, ret, a_len + 1);
	for (auto i = 0; i < a_len; ++i) {
		ret[i] = a[i];
	}
	ret[a_len] = '0';
	env->SetByteArrayRegion(_ret, 0, a_len + 1, ret);
	__abort(Byte, a);
	__JNI__FUNCTION__CLEAN__
	delete ret;
	return _ret;
}

JNIEXPORT auto JNICALL Java_org_algo4j_math_BigInt_divide(
		JNIEnv *env,
		jclass,
		jbyteArray _a,
		jbyteArray _b) -> jbyteArray {
	__JNI__FUNCTION__INIT__
	__get(Byte, a);
	__get(Byte, b);
	auto a_len = __len(a);
	auto b_len = __len(b);
	auto buf = divide(a, b, a_len, b_len);
	__new(Byte, ret, buf->len_trim());
	env->SetByteArrayRegion(_ret, 0, buf->len_trim(), buf->data_trim());
	__abort(Byte, a)
	__abort(Byte, b)
	__JNI__FUNCTION__CLEAN__
	delete buf;
	return _ret;
}

JNIEXPORT auto JNICALL Java_org_algo4j_math_BigInt_rem(
		JNIEnv *env,
		jclass,
		jbyteArray _a,
		jbyteArray _b) -> jbyteArray {
	__JNI__FUNCTION__INIT__
	__get(Byte, a);
	__get(Byte, b);
	auto a_len = __len(a);
	auto b_len = __len(b);
	auto buf = rem(a, b, a_len, b_len);
	__new(Byte, ret, buf->len_trim());
	env->SetByteArrayRegion(_ret, 0, buf->len_trim(), buf->data_trim());
	__abort(Byte, a)
	__abort(Byte, b)
	__JNI__FUNCTION__CLEAN__
	delete buf;
	return _ret;
}

JNIEXPORT auto JNICALL Java_org_algo4j_math_BigInt_pow(
		JNIEnv *env,
		jclass,
		jbyteArray _a,
		jint pow) -> jbyteArray {
	// TODO
}

JNIEXPORT auto JNICALL Java_org_algo4j_math_BigInt_fastPower(
		JNIEnv *env,
		jclass,
		jbyteArray _a,
		jint pow,
		jint mod) -> jint {
	__JNI__FUNCTION__INIT__
	__get(Byte, a);
	auto len = __len(a);
	jint ret = 0;
	for (auto _ = 0; _ < len; ++_) {
		ret = (ret * 10 + a[_] - '0') % mod;
	}
	__abort(Byte, a);
	__JNI__FUNCTION__CLEAN__
	return fast_power(ret, pow, mod);
}

JNIEXPORT auto JNICALL Java_org_algo4j_math_BigInt_compareTo(
		JNIEnv *env,
		jclass,
		jbyteArray _a,
		jbyteArray _b) -> jint {
	__JNI__FUNCTION__INIT__
	__get(Byte, a);
	__get(Byte, b);
	auto a_len = __len(a);
	auto b_len = __len(b);
	auto ret = compare(a, b, a_len, b_len);
	__abort(Byte, a);
	__abort(Byte, b);
	__JNI__FUNCTION__CLEAN__
	if (ret > 0) ret = 1;
	if (ret < 0) ret = -1;
	return ret;
}


#pragma clang diagnostic pop

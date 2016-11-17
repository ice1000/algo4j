///
/// Created by ice1000 on 2016/11/16.
///

// 我不做大哥好多年 我不爱冰冷的床沿

#include "org_ice1000_public_functions.h"

void ice1000_bit::add(
		JNIEnv *env,
		jlongArray _data,
		jint len,
		jint idx,
		jlong value) {
	jlong *data = env->GetLongArrayElements(_data, 0);
	while (idx < len) {
		data[idx] += value;
		idx += __lowbit(idx);
	}
	env->ReleaseLongArrayElements(_data, data, 0);
}

jlong ice1000_bit::sum(
		JNIEnv *env,
		jlongArray _data,
		jint idx) {
	jlong ret = 0;
	auto data = env->GetLongArrayElements(_data, 0);
	while (idx > 0) {
		ret += data[idx];
		idx -= __lowbit(idx);
	}
	env->ReleaseLongArrayElements(_data, data, 0);
	return ret;
}

jlong ice1000_bit::lowbit(const jlong x) {
	return __lowbit(x);
}

jdouble ice1000_math::sqrt_carmack(float x) {
	auto x_half = 0.5F * x;
	auto i = *(int *) &x;
	i = org_ice1000_util_Math_MAGIC_NUMBER - (i >> 1);
	x = *(float *) &i;
	x *= (1.5F - x_half * x * x);
	x *= (1.5F - x_half * x * x);
	return (jdouble) (1 / x);
}

jdouble ice1000_math::sqrt_strict(const jdouble x) {
	return sqrt(x);
}

jlong ice1000_math::gcd(jlong n, jlong m) {
	jlong c;
	for (; m > 0; c = n % m, n = m, m = c);
	return n;
}

jdouble ice1000_math::sin_ice(const jdouble x) {
	return sin(x);
}

jdouble ice1000_math::cos_ice(const jdouble x) {
	return cos(x);
}

jdouble ice1000_math::tan_ice(const jdouble x) {
	return tan(x);
}

jdouble ice1000_math::cot_ice(const jdouble x) {
	return 1 / tan(x);
}

jdouble ice1000_math::csc_ice(const jdouble x) {
	return 1 / sin(x);
}

jdouble ice1000_math::sec_ice(const jdouble x) {
	return 1 / cos(x);
}

/// 这快排比std::sort(begin, end)不知道高到哪里去了
/// 我和它谈笑风生
template<typename T>
void quick_sort_core(
		T *array,
		const int left,
		const int right) {
	if (left >= right) return;
	auto i = left;
	auto j = right;
	auto standard = array[left];
	T temp;
	while (i < j) {
		while(i < j and standard < array[j]) --j;
		while(i < j and !(standard < array[i])) ++i;
		if (i < j) {
			temp = array[i];
			array[i] = array[j];
			array[j] = temp;
		}
	}
	standard = array[i];
	quick_sort_core(array, left, i - 1);
	quick_sort_core(array, i + 1, right);
}

/// 这快排比std::sort(begin, end, cmp)不知道高到哪里去了
/// 我和它谈笑风生
template<typename T>
void quick_sort_core_with_cmp(
		T *array,
		const int left,
		const int right,
		bool (*compare) (const T &, const T &)) {
	if (left >= right) return;
	auto i = left;
	auto j = right;
	auto standard = array[left];
	T temp;
	while (i < j) {
		while(i < j and compare(standard, array[i])) --j;
		while(i < j and !compare(standard, array[i])) ++i;
		if (i < j) {
			temp = array[i];
			array[i] = array[j];
			array[j] = temp;
    }
	}
	temp = array[i];
	quick_sort_core(array, left, i - 1);
	quick_sort_core(array, i + 1, right);
}

template<typename T>
void ice1000_util::quick_sort(
		T *array,
		const long length) {
	quick_sort_core(array, 0, length);
}

template<typename T>
void ice1000_util::quick_sort_with_cmp(
		T *array,
		const long length,
		bool (*compare) (const T &, const T &)) {
	quick_sort_core_with_cmp(array, 0, length, compare);
}



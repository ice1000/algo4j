///
/// Created by algo4j
///

#include "SeqUtils.h"
#include "../global/functions.h"
#include "../global/templates.hpp"

using algo4j_util::discretization;
using algo4j_util::kmp;
using algo4j_util::copy;

using algo4j_sort::insertion_sort;
using algo4j_sort::merge_sort;
using algo4j_sort::bubble_sort;
using algo4j_sort::quick_sort;
using algo4j_sort::comb_sort;
using algo4j_sort::selection_sort;
using algo4j_sort::cocktail_sort;

using algo4j_bit::add;
using algo4j_bit::sum;
using algo4j_bit::inversion;

#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCUnusedGlobalDeclarationInspection"

/**
 * implemention
 *
 * @param type data type, like Int, Float, Double.
 */
#define __discretization_with(type0, type2, type) \
JNIEXPORT auto JNICALL Java_org_algo4j_util_SeqUtils_discretization___ ## type0 ( \
		JNIEnv *env, \
		jclass, \
		j ## type2 ## Array _data) -> void { \
	__JNI__FUNCTION__INIT__ \
	auto len = __len(data); \
	__get(type, data); \
	auto after = discretization(data, len); \
	__abort(type, data); \
	env->Set ## type ## ArrayRegion(_data, 0, len, after); \
	__JNI__FUNCTION__CLEAN__ \
	delete after; \
}

__discretization_with(3J, long, Long);
__discretization_with(3I, int, Int);
__discretization_with(3F, float, Float);
__discretization_with(3D, double, Double);


#undef __discretization_with

#define __algo4j_inversion(type0, type2, type) \
JNIEXPORT auto JNICALL Java_org_algo4j_util_SeqUtils_inversion___ ## type0 ( \
		JNIEnv *env, \
		jclass, \
		j ## type2 ## Array _data) -> jlong { \
	__JNI__FUNCTION__INIT__ \
	__get(type, data); \
	auto len = __len(data); \
	auto after = discretization(data, len); \
	for (auto _ = 0; _ < len; ++_) ++after[_]; \
	auto ret = inversion(after, len, len + 1); \
	__release(type, data) \
	__JNI__FUNCTION__CLEAN__ \
	delete after; \
	return ret; \
}

__algo4j_inversion(3I, int, Int);
__algo4j_inversion(3J, long, Long);
__algo4j_inversion(3D, double, Double);
__algo4j_inversion(3F, float, Float);

#undef __algo4j_inversion

#define __algo4j_sort(type0, type2, type, sort, sort2) \
JNIEXPORT auto JNICALL Java_org_algo4j_util_SeqUtils_sort ## sort2 ## ___ ## type0 ( \
		JNIEnv *env, \
		jclass, \
		j ## type2 ## Array _data) -> void { \
	__JNI__FUNCTION__INIT__ \
	__get(type, data); \
	auto len = __len(data); \
	sort ## _sort(data, len); \
	__release(type, data) \
	__JNI__FUNCTION__CLEAN__ \
}

__algo4j_sort(3I, int, Int, bubble, Bubble);
__algo4j_sort(3J, long, Long, bubble, Bubble);
__algo4j_sort(3F, float, Float, bubble, Bubble);
__algo4j_sort(3D, double, Double, bubble, Bubble);

__algo4j_sort(3I, int, Int, quick, Quick);
__algo4j_sort(3J, long, Long, quick, Quick);
__algo4j_sort(3F, float, Float, quick, Quick);
__algo4j_sort(3D, double, Double, quick, Quick);

__algo4j_sort(3I, int, Int, insertion, Insertion);
__algo4j_sort(3J, long, Long, insertion, Insertion);
__algo4j_sort(3F, float, Float, insertion, Insertion);
__algo4j_sort(3D, double, Double, insertion, Insertion);

__algo4j_sort(3I, int, Int, merge, Merge);
__algo4j_sort(3J, long, Long, merge, Merge);
__algo4j_sort(3F, float, Float, merge, Merge);
__algo4j_sort(3D, double, Double, merge, Merge);

__algo4j_sort(3I, int, Int, comb, Comb);
__algo4j_sort(3J, long, Long, comb, Comb);
__algo4j_sort(3F, float, Float, comb, Comb);
__algo4j_sort(3D, double, Double, comb, Comb);

__algo4j_sort(3I, int, Int, selection, Selection);
__algo4j_sort(3J, long, Long, selection, Selection);
__algo4j_sort(3F, float, Float, selection, Selection);
__algo4j_sort(3D, double, Double, selection, Selection);

__algo4j_sort(3I, int, Int, cocktail, Cocktail);
__algo4j_sort(3J, long, Long, cocktail, Cocktail);
__algo4j_sort(3F, float, Float, cocktail, Cocktail);
__algo4j_sort(3D, double, Double, cocktail, Cocktail);

#undef __algo4j_sort

#define __algo4j_arr_copy(type0, type2, type) \
JNIEXPORT auto JNICALL Java_org_algo4j_util_SeqUtils_copy___ ## type0 ( \
		JNIEnv *env, \
		jclass, \
		j ## type2 ## Array _data) -> j ## type2 ## Array { \
	if (_data == NULL) return NULL; \
	__JNI__FUNCTION__INIT__ \
	__get(type, data); \
	auto len = __len(data); \
	auto ret = copy(data, len); \
	__new(type, ret, len) \
	__abort(type, data) \
	__set(type, ret, len) \
	__JNI__FUNCTION__CLEAN__ \
	return _ret; \
}

__algo4j_arr_copy(3I, int, Int);
__algo4j_arr_copy(3J, long, Long);
__algo4j_arr_copy(3F, float, Float);
__algo4j_arr_copy(3D, double, Double);
__algo4j_arr_copy(3S, short, Short);
__algo4j_arr_copy(3B, byte, Byte);
__algo4j_arr_copy(3Z, boolean, Boolean);
__algo4j_arr_copy(3C, char, Char);

#undef __algo4j_arr_copy

#define __algo4j_arr_kmp(type0, type2, type) \
JNIEXPORT auto JNICALL Java_org_algo4j_util_SeqUtils_kmp___ ## type0 ## _ ## type0 ( \
		JNIEnv *env, \
		jclass, \
		j ## type2 ## Array _a, \
		j ## type2 ## Array _b) -> jint { \
	__JNI__FUNCTION__INIT__ \
	__get(type, a); \
	__get(type, b); \
	auto a_len = __len(a); \
	auto b_len = __len(b); \
	auto ret = kmp(b, b_len, a, a_len); \
	__abort(type, a); \
	__abort(type, b); \
	__JNI__FUNCTION__CLEAN__ \
	return ret; \
}

__algo4j_arr_kmp(3I, int, Int);
__algo4j_arr_kmp(3J, long, Long);
__algo4j_arr_kmp(3C, char, Char);
__algo4j_arr_kmp(3B, byte, Byte);

#undef __algo4j_arr_kmp

#pragma clang diagnostic pop

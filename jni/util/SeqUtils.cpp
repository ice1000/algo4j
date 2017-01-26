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
#define __discretization_with(type) \
__JNI__FUNCTION__INIT__ \
auto len = __len(data); \
__get(type, data); \
auto after = discretization(data, len); \
__abort(type, data); \
env->Set ## type ## ArrayRegion(_data, 0, len, after); \
__JNI__FUNCTION__CLEAN__ \
delete after;

JNIEXPORT auto JNICALL Java_org_algo4j_util_SeqUtils_discretization___3J(
		JNIEnv *env,
		jclass,
		jlongArray _data) -> void {
	__discretization_with(Long);
}

JNIEXPORT auto JNICALL Java_org_algo4j_util_SeqUtils_discretization___3I(
		JNIEnv *env,
		jclass,
		jintArray _data) -> void {
	__discretization_with(Int);
}

JNIEXPORT auto JNICALL Java_org_algo4j_util_SeqUtils_discretization___3F(
		JNIEnv *env,
		jclass,
		jfloatArray _data) -> void {
	__discretization_with(Float);
}

JNIEXPORT auto JNICALL Java_org_algo4j_util_SeqUtils_discretization___3D(
		JNIEnv *env,
		jclass,
		jdoubleArray _data) -> void {
	__discretization_with(Double);
}

#undef __discretization_with

#define __algo4j_inversion(type) \
__JNI__FUNCTION__INIT__ \
__get(type, data); \
auto len = __len(data); \
auto after = discretization(data, len); \
for (auto _ = 0; _ < len; ++_) ++after[_]; \
auto ret = inversion(after, len, len + 1); \
__release(type, data) \
__JNI__FUNCTION__CLEAN__ \
delete after; \
return ret;

JNIEXPORT auto JNICALL Java_org_algo4j_util_SeqUtils_inversion___3I(
		JNIEnv *env,
		jclass,
		jintArray _data) -> jlong {
	__algo4j_inversion(Int);
}

JNIEXPORT auto JNICALL Java_org_algo4j_util_SeqUtils_inversion___3J(
		JNIEnv *env,
		jclass,
		jlongArray _data) -> jlong {
	__algo4j_inversion(Long);
}

JNIEXPORT auto JNICALL Java_org_algo4j_util_SeqUtils_inversion___3F(
		JNIEnv *env,
		jclass,
		jfloatArray _data) -> jlong {
	__algo4j_inversion(Float);
}

JNIEXPORT auto JNICALL Java_org_algo4j_util_SeqUtils_inversion___3D(
		JNIEnv *env,
		jclass,
		jdoubleArray _data) -> jlong {
	__algo4j_inversion(Double);
}

#undef __algo4j_inversion

/**
 * implementation
 *
 * @param type same as __discretization_with
 */
#define __algo4j_bubble_sort(type) \
__JNI__FUNCTION__INIT__ \
__get(type, data); \
auto len = __len(data); \
bubble_sort(data, len); \
__release(type, data) \
__JNI__FUNCTION__CLEAN__

JNIEXPORT auto JNICALL Java_org_algo4j_util_SeqUtils_sortBubble___3I(
		JNIEnv *env,
		jclass,
		jintArray _data) -> void {
	__algo4j_bubble_sort(Int);
}

JNIEXPORT auto JNICALL Java_org_algo4j_util_SeqUtils_sortBubble___3J(
		JNIEnv *env,
		jclass,
		jlongArray _data) -> void {
	__algo4j_bubble_sort(Long);
}

JNIEXPORT auto JNICALL Java_org_algo4j_util_SeqUtils_sortBubble___3F(
		JNIEnv *env,
		jclass,
		jfloatArray _data) -> void {
	__algo4j_bubble_sort(Float);
}

JNIEXPORT auto JNICALL Java_org_algo4j_util_SeqUtils_sortBubble___3D(
		JNIEnv *env,
		jclass,
		jdoubleArray _data) -> void {
	__algo4j_bubble_sort(Double);
}

#undef __algo4j_bubble_sort

#define __algo4j_quick_sort(type) \
__JNI__FUNCTION__INIT__ \
__get(type, data); \
auto len = __len(data); \
quick_sort(data, len); \
__release(type, data) \
__JNI__FUNCTION__CLEAN__

JNIEXPORT auto JNICALL Java_org_algo4j_util_SeqUtils_sortQuick___3I(
		JNIEnv *env,
		jclass,
		jintArray _data) -> void {
	__algo4j_quick_sort(Int);
}

JNIEXPORT auto JNICALL Java_org_algo4j_util_SeqUtils_sortQuick___3J(
		JNIEnv *env,
		jclass,
		jlongArray _data) -> void {
	__algo4j_quick_sort(Long);
}

JNIEXPORT auto JNICALL Java_org_algo4j_util_SeqUtils_sortQuick___3F(
		JNIEnv *env,
		jclass,
		jfloatArray _data) -> void {
	__algo4j_quick_sort(Float);
}

JNIEXPORT auto JNICALL Java_org_algo4j_util_SeqUtils_sortQuick___3D(
		JNIEnv *env,
		jclass,
		jdoubleArray _data) -> void {
	__algo4j_quick_sort(Double);
}

#undef __algo4j_quick_sort

#define __algo4j_insertion_sort(type) \
__JNI__FUNCTION__INIT__ \
__get(type, data); \
auto len = __len(data); \
insertion_sort(data, len); \
__release(type, data) \
__JNI__FUNCTION__CLEAN__

JNIEXPORT auto JNICALL Java_org_algo4j_util_SeqUtils_sortInsertion___3I(
		JNIEnv *env,
		jclass,
		jintArray _data) -> void {
	__algo4j_insertion_sort(Int);
}

JNIEXPORT auto JNICALL Java_org_algo4j_util_SeqUtils_sortInsertion___3J(
		JNIEnv *env,
		jclass,
		jlongArray _data) -> void {
	__algo4j_insertion_sort(Long);
}


JNIEXPORT auto JNICALL Java_org_algo4j_util_SeqUtils_sortInsertion___3F(
		JNIEnv *env,
		jclass,
		jfloatArray _data) -> void {
	__algo4j_insertion_sort(Float);
}

JNIEXPORT auto JNICALL Java_org_algo4j_util_SeqUtils_sortInsertion___3D(
		JNIEnv *env,
		jclass,
		jdoubleArray _data) -> void {
	__algo4j_insertion_sort(Double);
}

#undef __algo4j_insertion_sort

#define __algo4j_merge_sort(type) \
__JNI__FUNCTION__INIT__ \
__get(type, data); \
auto len = __len(data); \
merge_sort(data, len); \
__release(type, data) \
__JNI__FUNCTION__CLEAN__

JNIEXPORT auto JNICALL Java_org_algo4j_util_SeqUtils_sortMerge___3I(
		JNIEnv *env,
		jclass,
		jintArray _data) -> void {
	__algo4j_merge_sort(Int);
}

JNIEXPORT auto JNICALL Java_org_algo4j_util_SeqUtils_sortMerge___3J(
		JNIEnv *env,
		jclass,
		jlongArray _data) -> void {
	__algo4j_merge_sort(Long);
}

JNIEXPORT auto JNICALL Java_org_algo4j_util_SeqUtils_sortMerge___3F(
		JNIEnv *env,
		jclass,
		jfloatArray _data) -> void {
	__algo4j_merge_sort(Float);
}

JNIEXPORT auto JNICALL Java_org_algo4j_util_SeqUtils_sortMerge___3D(
		JNIEnv *env,
		jclass,
		jdoubleArray _data) -> void {
	__algo4j_merge_sort(Double);
}

#undef __algo4j_merge_sort

#define __algo4j_comb_sort(type) \
__JNI__FUNCTION__INIT__ \
__get(type, data); \
auto len = __len(data); \
comb_sort(data, len); \
__release(type, data) \
__JNI__FUNCTION__CLEAN__

JNIEXPORT auto JNICALL Java_org_algo4j_util_SeqUtils_sortComb___3I(
		JNIEnv *env,
		jclass,
		jintArray _data) -> void {
	__algo4j_comb_sort(Int);
}

JNIEXPORT auto JNICALL Java_org_algo4j_util_SeqUtils_sortComb___3J(
		JNIEnv *env,
		jclass,
		jlongArray _data) -> void {
	__algo4j_comb_sort(Long);
}

JNIEXPORT auto JNICALL Java_org_algo4j_util_SeqUtils_sortComb___3F(
		JNIEnv *env,
		jclass,
		jfloatArray _data) -> void {
	__algo4j_comb_sort(Float);
}

JNIEXPORT auto JNICALL Java_org_algo4j_util_SeqUtils_sortComb___3D(
		JNIEnv *env,
		jclass,
		jdoubleArray _data) -> void {
	__algo4j_comb_sort(Double);
}

#undef __algo4j_comb_sort

#define __algo4j_selection_sort(type) \
__JNI__FUNCTION__INIT__ \
__get(type, data); \
auto len = __len(data); \
selection_sort(data, len); \
__release(type, data) \
__JNI__FUNCTION__CLEAN__

JNIEXPORT auto JNICALL Java_org_algo4j_util_SeqUtils_sortSelection___3I(
		JNIEnv *env,
		jclass,
		jintArray _data) -> void {
	__algo4j_selection_sort(Int);
}

JNIEXPORT auto JNICALL Java_org_algo4j_util_SeqUtils_sortSelection___3J(
		JNIEnv *env,
		jclass,
		jlongArray _data) -> void {
	__algo4j_selection_sort(Long);
}

JNIEXPORT auto JNICALL Java_org_algo4j_util_SeqUtils_sortSelection___3F(
		JNIEnv *env,
		jclass,
		jfloatArray _data) -> void {
	__algo4j_selection_sort(Float);
}

JNIEXPORT auto JNICALL Java_org_algo4j_util_SeqUtils_sortSelection___3D(
		JNIEnv *env,
		jclass,
		jdoubleArray _data) -> void {
	__algo4j_selection_sort(Double);
}

#undef __algo4j_selection_sort

#define __algo4j_cocktail_sort(type) \
__JNI__FUNCTION__INIT__ \
__get(type, data); \
auto len = __len(data); \
cocktail_sort(data, len); \
__release(type, data) \
__JNI__FUNCTION__CLEAN__

JNIEXPORT auto JNICALL Java_org_algo4j_util_SeqUtils_sortCocktail___3I(
		JNIEnv *env,
		jclass,
		jintArray _data) -> void {
	__algo4j_cocktail_sort(Int);
}

JNIEXPORT auto JNICALL Java_org_algo4j_util_SeqUtils_sortCocktail___3J(
		JNIEnv *env,
		jclass,
		jlongArray _data) -> void {
	__algo4j_cocktail_sort(Long);
}

JNIEXPORT auto JNICALL Java_org_algo4j_util_SeqUtils_sortCocktail___3F(
		JNIEnv *env,
		jclass,
		jfloatArray _data) -> void {
	__algo4j_cocktail_sort(Float);
}

JNIEXPORT auto JNICALL Java_org_algo4j_util_SeqUtils_sortCocktail___3D(
		JNIEnv *env,
		jclass,
		jdoubleArray _data) -> void {
	__algo4j_cocktail_sort(Double);
}

#undef __algo4j_cocktail_sort

#define __algo4j_arr_copy(type) \
if (_data == NULL) return NULL; \
__JNI__FUNCTION__INIT__ \
__get(type, data); \
auto len = __len(data); \
auto ret = copy(data, len); \
__new(type, ret, len) \
__abort(type, data) \
__set(type, ret, len) \
__JNI__FUNCTION__CLEAN__ \
return _ret;


JNIEXPORT auto JNICALL Java_org_algo4j_util_SeqUtils_copy___3I(
		JNIEnv *env,
		jclass,
		jintArray _data) -> jintArray {
	__algo4j_arr_copy(Int);
}

JNIEXPORT auto JNICALL Java_org_algo4j_util_SeqUtils_copy___3J(
		JNIEnv *env,
		jclass,
		jlongArray _data) -> jlongArray {
	__algo4j_arr_copy(Long);
}

JNIEXPORT auto JNICALL Java_org_algo4j_util_SeqUtils_copy___3F(
		JNIEnv *env,
		jclass,
		jfloatArray _data) -> jfloatArray {
	__algo4j_arr_copy(Float);
}

JNIEXPORT auto JNICALL Java_org_algo4j_util_SeqUtils_copy___3D(
		JNIEnv *env,
		jclass,
		jdoubleArray _data) -> jdoubleArray {
	__algo4j_arr_copy(Double);
}

JNIEXPORT auto JNICALL Java_org_algo4j_util_SeqUtils_copy___3S(
		JNIEnv *env,
		jclass,
		jshortArray _data) -> jshortArray {
	__algo4j_arr_copy(Short);
}


JNIEXPORT auto JNICALL Java_org_algo4j_util_SeqUtils_copy___3B(
		JNIEnv *env,
		jclass,
		jbyteArray _data) -> jbyteArray {
	__algo4j_arr_copy(Byte);
}

JNIEXPORT auto JNICALL Java_org_algo4j_util_SeqUtils_copy___3Z(
		JNIEnv *env,
		jclass,
		jbooleanArray _data) -> jbooleanArray {
	__algo4j_arr_copy(Boolean);
}

JNIEXPORT auto JNICALL Java_org_algo4j_util_SeqUtils_copy___3C(
		JNIEnv *env,
		jclass,
		jcharArray _data) -> jcharArray {
	__algo4j_arr_copy(Char);
}

#undef __algo4j_arr_copy

#define __algo4j_arr_kmp(type) \
__JNI__FUNCTION__INIT__ \
__get(type, a); \
__get(type, b); \
auto a_len = __len(a); \
auto b_len = __len(b); \
auto ret = kmp(b, b_len, a, a_len); \
__abort(type, a); \
__abort(type, b); \
__JNI__FUNCTION__CLEAN__ \
return ret;

JNIEXPORT auto JNICALL Java_org_algo4j_util_SeqUtils_kmp___3I_3I(
		JNIEnv *env,
		jclass,
		jintArray _a,
		jintArray _b) -> jint {
	__algo4j_arr_kmp(Int);
}

JNIEXPORT auto JNICALL Java_org_algo4j_util_SeqUtils_kmp___3J_3J(
		JNIEnv *env,
		jclass,
		jlongArray _a,
		jlongArray _b) -> jint {
	__algo4j_arr_kmp(Long);
}

JNIEXPORT auto JNICALL Java_org_algo4j_util_SeqUtils_kmp___3C_3C(
		JNIEnv *env,
		jclass,
		jcharArray _a,
		jcharArray _b) -> jint {
	__algo4j_arr_kmp(Char);
}

JNIEXPORT auto JNICALL Java_org_algo4j_util_SeqUtils_kmp___3B_3B(
		JNIEnv *env,
		jclass,
		jbyteArray _a,
		jbyteArray _b) -> jint {
	__algo4j_arr_kmp(Byte);
}

#undef __algo4j_arr_kmp

#pragma clang diagnostic pop

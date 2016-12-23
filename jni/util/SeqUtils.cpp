///
/// Created by algo4j
///

#include "SeqUtils.h"
#include "../global/functions.h"
#include "../global/templates.hpp"

using algo4j_util::discretization;
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
auto len = env->GetArrayLength(_data); \
auto data = env->Get ## type ## ArrayElements(_data, option); \
auto after = discretization(data, len); \
env->Release ## type ## ArrayElements(_data, data, JNI_ABORT); \
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
auto data = env->Get ## type ## ArrayElements(_data, option); \
auto len = env->GetArrayLength(_data); \
auto after = discretization(data, len); \
for (auto i = 0; i < len; ++i) ++after[i]; \
auto ret = inversion(after, len, len + 1); \
env->Release ## type ## ArrayElements(_data, data, 0); \
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
 * implemention
 *
 * @param type same as __discretization_with
 */
#define __algo4j_bubble_sort(type) \
__JNI__FUNCTION__INIT__ \
auto data = env->Get ## type ## ArrayElements(_data, option); \
auto len = env->GetArrayLength(_data); \
bubble_sort(data, len); \
env->Release ## type ## ArrayElements(_data, data, 0); \
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
auto data = env->Get ## type ## ArrayElements(_data, option); \
auto len = env->GetArrayLength(_data); \
quick_sort(data, len); \
env->Release ## type ## ArrayElements(_data, data, 0); \
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
auto data = env->Get ## type ## ArrayElements(_data, option); \
auto len = env->GetArrayLength(_data); \
insertion_sort(data, len); \
env->Release ## type ## ArrayElements(_data, data, 0); \
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
auto data = env->Get ## type ## ArrayElements(_data, option); \
auto len = env->GetArrayLength(_data); \
merge_sort(data, len); \
env->Release ## type ## ArrayElements(_data, data, 0); \
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
auto data = env->Get ## type ## ArrayElements(_data, option); \
auto len = env->GetArrayLength(_data); \
comb_sort(data, len); \
env->Release ## type ## ArrayElements(_data, data, 0); \
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
auto data = env->Get ## type ## ArrayElements(_data, option); \
auto len = env->GetArrayLength(_data); \
selection_sort(data, len); \
env->Release ## type ## ArrayElements(_data, data, 0); \
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
auto data = env->Get ## type ## ArrayElements(_data, option); \
auto len = env->GetArrayLength(_data); \
cocktail_sort(data, len); \
env->Release ## type ## ArrayElements(_data, data, 0); \
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


#pragma clang diagnostic pop

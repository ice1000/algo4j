///
/// Created by algo4j
///

#include "SeqUtils.h"

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
auto data = env->Get ## type ## ArrayElements(_data, option); \
auto after = discretization(data, len); \
env->Release ## type ## ArrayElements(_data, data, 0); \
env->Set ## type ## ArrayRegion(_data, 0, len, after); \
__JNI__FUNCTION__CLEAN__ \
delete after;

JNIEXPORT auto JNICALL Java_org_algo4j_util_SeqUtils_discretization___3JI(
		JNIEnv *env,
		jclass,
		jlongArray _data,
		jint len) -> void {
	__discretization_with(Long);
}

JNIEXPORT auto JNICALL Java_org_algo4j_util_SeqUtils_discretization___3II(
		JNIEnv *env,
		jclass,
		jintArray _data,
		jint len) -> void {
	__discretization_with(Int);
}

JNIEXPORT auto JNICALL Java_org_algo4j_util_SeqUtils_discretization___3FI(
		JNIEnv *env,
		jclass,
		jfloatArray _data,
		jint len) -> void {
	__discretization_with(Float);
}

JNIEXPORT auto JNICALL Java_org_algo4j_util_SeqUtils_discretization___3DI(
		JNIEnv *env,
		jclass,
		jdoubleArray _data,
		jint len) -> void {
	__discretization_with(Double);
}

#undef __discretization_with

#define __ice_inversion(type) \
__JNI__FUNCTION__INIT__ \
auto data = env->Get ## type ## ArrayElements(_data, option); \
auto after = discretization(data, len); \
for (auto i = 0; i < len; ++i) ++after[i]; \
auto ret = inversion(after, len, len + 1); \
env->Release ## type ## ArrayElements(_data, data, 0); \
__JNI__FUNCTION__CLEAN__ \
delete after; \
return ret;

JNIEXPORT auto JNICALL Java_org_algo4j_util_SeqUtils_inversion___3II(
		JNIEnv *env,
		jclass,
		jintArray _data,
		jint len) -> jlong {
	__ice_inversion(Int);
}

JNIEXPORT auto JNICALL Java_org_algo4j_util_SeqUtils_inversion___3JI(
		JNIEnv *env,
		jclass,
		jlongArray _data,
		jint len) -> jlong {
  __ice_inversion(Long);
}

JNIEXPORT auto JNICALL Java_org_algo4j_util_SeqUtils_inversion___3FI(
		JNIEnv *env,
		jclass,
		jfloatArray _data,
		jint len) -> jlong {
  __ice_inversion(Float);
}

JNIEXPORT auto JNICALL Java_org_algo4j_util_SeqUtils_inversion___3DI(
		JNIEnv *env,
		jclass,
		jdoubleArray _data,
		jint len) -> jlong {
  __ice_inversion(Double);
}

#undef __ice_inversion

/**
 * implemention
 *
 * @param type same as __discretization_with
 */
#define __ice_bubble_sort(type) \
__JNI__FUNCTION__INIT__ \
auto data = env->Get ## type ## ArrayElements(_data, option); \
bubble_sort(data, len); \
env->Set ## type ## ArrayRegion(_data, 0, len, data); \
__JNI__FUNCTION__CLEAN__

JNIEXPORT auto JNICALL Java_org_algo4j_util_SeqUtils_sortBubble___3II(
		JNIEnv *env,
		jclass,
		jintArray _data,
		jint len) -> void {
	__ice_bubble_sort(Int);
}

JNIEXPORT auto JNICALL Java_org_algo4j_util_SeqUtils_sortBubble___3JI(
		JNIEnv *env,
		jclass,
		jlongArray _data,
		jint len) -> void {
	__ice_bubble_sort(Long);
}

JNIEXPORT auto JNICALL Java_org_algo4j_util_SeqUtils_sortBubble___3FI(
		JNIEnv *env,
		jclass,
		jfloatArray _data,
		jint len) -> void {
	__ice_bubble_sort(Float);
}

JNIEXPORT auto JNICALL Java_org_algo4j_util_SeqUtils_sortBubble___3DI(
		JNIEnv *env,
		jclass,
		jdoubleArray _data,
		jint len) -> void {
	__ice_bubble_sort(Double);
}

#undef __ice_bubble_sort

#define __algo4j_quick_sort(type) \
__JNI__FUNCTION__INIT__ \
auto data = env->Get ## type ## ArrayElements(_data, option); \
quick_sort(data, len); \
env->Set ## type ## ArrayRegion(_data, 0, len, data); \
__JNI__FUNCTION__CLEAN__

JNIEXPORT auto JNICALL Java_org_algo4j_util_SeqUtils_sortQuick___3II(
		JNIEnv *env,
		jclass,
		jintArray _data,
		jint len) -> void {
	__algo4j_quick_sort(Int);
}

JNIEXPORT auto JNICALL Java_org_algo4j_util_SeqUtils_sortQuick___3JI(
		JNIEnv *env,
		jclass,
		jlongArray _data,
		jint len) -> void {
	__algo4j_quick_sort(Long);
}

JNIEXPORT auto JNICALL Java_org_algo4j_util_SeqUtils_sortQuick___3FI(
		JNIEnv *env,
		jclass,
		jfloatArray _data,
		jint len) -> void {
	__algo4j_quick_sort(Float);
}

JNIEXPORT auto JNICALL Java_org_algo4j_util_SeqUtils_sortQuick___3DI(
		JNIEnv *env,
		jclass,
		jdoubleArray _data,
		jint len) -> void {
	__algo4j_quick_sort(Double);
}

#undef __algo4j_quick_sort

#define __ice_insertion_sort(type) \
__JNI__FUNCTION__INIT__ \
auto data = env->Get ## type ## ArrayElements(_data, option); \
insertion_sort(data, len); \
env->Set ## type ## ArrayRegion(_data, 0, len, data); \
__JNI__FUNCTION__CLEAN__

JNIEXPORT auto JNICALL Java_org_algo4j_util_SeqUtils_sortInsertion___3II(
		JNIEnv *env,
		jclass,
		jintArray _data,
		jint len) -> void {
	__ice_insertion_sort(Int);
}


JNIEXPORT auto JNICALL Java_org_algo4j_util_SeqUtils_sortInsertion___3JI(
		JNIEnv *env,
		jclass,
		jlongArray _data,
		jint len) -> void {
	__ice_insertion_sort(Long);
}


JNIEXPORT auto JNICALL Java_org_algo4j_util_SeqUtils_sortInsertion___3FI(
		JNIEnv *env,
		jclass,
		jfloatArray _data,
		jint len) -> void {
	__ice_insertion_sort(Float);
}


JNIEXPORT auto JNICALL Java_org_algo4j_util_SeqUtils_sortInsertion___3DI(
		JNIEnv *env,
		jclass,
		jdoubleArray _data,
		jint len) -> void {
	__ice_insertion_sort(Double);
}

#undef __ice_insertion_sort

#define __ice_merge_sort(type) \
__JNI__FUNCTION__INIT__ \
auto data = env->Get ## type ## ArrayElements(_data, option); \
merge_sort(data, len); \
env->Set ## type ## ArrayRegion(_data, 0, len, data); \
__JNI__FUNCTION__CLEAN__

JNIEXPORT auto JNICALL Java_org_algo4j_util_SeqUtils_sortMerge___3II(
		JNIEnv *env,
		jclass,
		jintArray _data,
		jint len) -> void {
	__ice_merge_sort(Int);
}

JNIEXPORT auto JNICALL Java_org_algo4j_util_SeqUtils_sortMerge___3JI(
		JNIEnv *env,
		jclass,
		jlongArray _data,
		jint len) -> void {
	__ice_merge_sort(Long);
}

JNIEXPORT auto JNICALL Java_org_algo4j_util_SeqUtils_sortMerge___3FI(
		JNIEnv *env,
		jclass,
		jfloatArray _data,
		jint len) -> void {
	__ice_merge_sort(Float);
}

JNIEXPORT auto JNICALL Java_org_algo4j_util_SeqUtils_sortMerge___3DI(
		JNIEnv *env,
		jclass,
		jdoubleArray _data,
		jint len) -> void {
	__ice_merge_sort(Double);
}

#undef __ice_merge_sort

#define __ice_comb_sort(type) \
__JNI__FUNCTION__INIT__ \
auto data = env->Get ## type ## ArrayElements(_data, option); \
comb_sort(data, len); \
env->Set ## type ## ArrayRegion(_data, 0, len, data); \
__JNI__FUNCTION__CLEAN__

JNIEXPORT auto JNICALL Java_org_algo4j_util_SeqUtils_sortComb___3II(
		JNIEnv *env,
		jclass,
		jintArray _data,
		jint len) -> void {
	__ice_comb_sort(Int);
}

JNIEXPORT auto JNICALL Java_org_algo4j_util_SeqUtils_sortComb___3JI(
		JNIEnv *env,
		jclass,
		jlongArray _data,
		jint len) -> void {
	__ice_comb_sort(Long);
}

JNIEXPORT auto JNICALL Java_org_algo4j_util_SeqUtils_sortComb___3FI(
		JNIEnv *env,
		jclass,
		jfloatArray _data,
		jint len) -> void {
	__ice_comb_sort(Float);
}

JNIEXPORT auto JNICALL Java_org_algo4j_util_SeqUtils_sortComb___3DI(
		JNIEnv *env,
		jclass,
		jdoubleArray _data,
		jint len) -> void {
	__ice_comb_sort(Double);
}

#undef __ice_comb_sort

#define __ice_selection_sort(type) \
__JNI__FUNCTION__INIT__ \
auto data = env->Get ## type ## ArrayElements(_data, option); \
selection_sort(data, len); \
env->Set ## type ## ArrayRegion(_data, 0, len, data); \
__JNI__FUNCTION__CLEAN__

JNIEXPORT auto JNICALL Java_org_algo4j_util_SeqUtils_sortSelection___3II(
		JNIEnv *env,
		jclass,
		jintArray _data,
		jint len) -> void {
	__ice_selection_sort(Int);
}

JNIEXPORT auto JNICALL Java_org_algo4j_util_SeqUtils_sortSelection___3JI(
		JNIEnv *env,
		jclass,
		jlongArray _data,
		jint len) -> void {
	__ice_selection_sort(Long);
}

JNIEXPORT auto JNICALL Java_org_algo4j_util_SeqUtils_sortSelection___3FI(
		JNIEnv *env,
		jclass,
		jfloatArray _data,
		jint len) -> void {
	__ice_selection_sort(Float);
}

JNIEXPORT auto JNICALL Java_org_algo4j_util_SeqUtils_sortSelection___3DI(
		JNIEnv *env,
		jclass,
		jdoubleArray _data,
		jint len) -> void {
	__ice_selection_sort(Double);
}

#undef __ice_selection_sort

#define __ice_cocktail_sort(type) \
__JNI__FUNCTION__INIT__ \
auto data = env->Get ## type ## ArrayElements(_data, option); \
cocktail_sort(data, len); \
env->Set ## type ## ArrayRegion(_data, 0, len, data); \
__JNI__FUNCTION__CLEAN__

JNIEXPORT auto JNICALL Java_org_algo4j_util_SeqUtils_sortCocktail___3II(
		JNIEnv *env,
		jclass,
		jintArray _data,
		jint len) -> void {
	__ice_cocktail_sort(Int);
}

JNIEXPORT auto JNICALL Java_org_algo4j_util_SeqUtils_sortCocktail___3JI(
		JNIEnv *env,
		jclass,
		jlongArray _data,
		jint len) -> void {
	__ice_cocktail_sort(Long);
}

JNIEXPORT auto JNICALL Java_org_algo4j_util_SeqUtils_sortCocktail___3FI(
		JNIEnv *env,
		jclass,
		jfloatArray _data,
		jint len) -> void {
	__ice_cocktail_sort(Float);
}

JNIEXPORT auto JNICALL Java_org_algo4j_util_SeqUtils_sortCocktail___3DI(
		JNIEnv *env,
		jclass,
		jdoubleArray _data,
		jint len) -> void {
	__ice_cocktail_sort(Double);
}

#undef __ice_cocktail_sort


#pragma clang diagnostic pop

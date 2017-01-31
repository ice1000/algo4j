
#include "MinHeap.h"
#include "../../global/functions.h"
#include "../../global/basics.hpp"
#include "../../global/heap.hpp"

#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCUnusedGlobalDeclarationInspection"

using algo4j_heap::min::make_heap;
using algo4j_heap::min::heap_insert;
using algo4j_heap::min::heap_adjust;

JNIEXPORT auto JNICALL Java_org_algo4j_tree_heap_MinHeap_makeHeap(
		JNIEnv *env,
		jclass,
		jintArray _data) -> jintArray {
	__JNI__FUNCTION__INIT__
	__get(Int, data);
	auto len = __len(data);
	__new(Int, ret, len + 1);
	auto ret = new jint[len + 1];
	ret[0] = -1;
	for (auto _ = 0; _ < len; ++_) {
		ret[_ + 1] = data[_];
	}
	make_heap(ret, len);
	__abort(Int, data);
	__set(Int, ret, len + 1);
	__JNI__FUNCTION__CLEAN__
	return _ret;
}


JNIEXPORT auto JNICALL Java_org_algo4j_tree_heap_MinHeap_insert(
		JNIEnv *env,
		jclass,
		jintArray _data,
		jint cursor,
		jint element) -> void {
	__JNI__FUNCTION__INIT__
	__get(Int, data);
	heap_insert(data, cursor, element);
	__release(Int, data);
	__JNI__FUNCTION__CLEAN__
}

JNIEXPORT auto JNICALL Java_org_algo4j_tree_heap_MinHeap_minHeapify(
		JNIEnv *env,
		jclass,
		jintArray _data,
		jint cursor,
		jint index) -> void {
	__JNI__FUNCTION__INIT__
	__get(Int, data);
	heap_adjust(data, cursor, index);
	__release(Int, data);
	__JNI__FUNCTION__CLEAN__
}


#pragma clang diagnostic pop

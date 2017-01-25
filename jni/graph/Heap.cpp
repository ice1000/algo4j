
#include "Heap.h"
#include "../global/functions.h"
#include "../global/basics.hpp"
#include "../global/heap.hpp"

using algo4j_heap::make_heap;
using algo4j_heap::insert;
using algo4j_heap::min_heapify;

JNIEXPORT auto JNICALL Java_org_algo4j_graph_Heap_makeHeap(
		JNIEnv *env,
		jclass,
		jintArray _data) -> jintArray {
	__JNI__FUNCTION__INIT__
	__get(Int, data);
	auto len = __len(data);
	__new(Int, ret, len + 1);
	auto ret = new jint[len + 1];
	ret[0] = -1;
	for (auto i = 0; i < len; ++i) {
		ret[i + 1] = data[i];
	}
	make_heap(ret, len);
	__abort(Int, data);
	__set(Int, ret, len + 1);
	__JNI__FUNCTION__CLEAN__
	return _ret;
}


JNIEXPORT auto JNICALL Java_org_algo4j_graph_Heap_insert(
		JNIEnv *env,
		jclass,
		jintArray _data,
		jint cursor,
		jint element) -> void {
	__JNI__FUNCTION__INIT__
	__get(Int, data);
	insert(data, cursor, element);
	__release(Int, data);
	__JNI__FUNCTION__CLEAN__
}

JNIEXPORT auto JNICALL Java_org_algo4j_graph_Heap_minHeapify(
		JNIEnv *env,
		jclass,
		jintArray _data,
		jint cursor,
		jint index) -> void {
	__JNI__FUNCTION__INIT__
	__get(Int, data);
	min_heapify(data, cursor, index);
	__release(Int, data);
	__JNI__FUNCTION__CLEAN__
}



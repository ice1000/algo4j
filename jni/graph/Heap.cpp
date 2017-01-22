
#include "Heap.h"
#include "../global/functions.h"
#include "../global/basics.hpp"
#include "../global/heap.hpp"

using algo4j_heap::make_heap;

JNIEXPORT auto JNICALL Java_org_algo4j_linear_Heap_makeHeap(
		JNIEnv *env,
		jclass,
		jintArray _data) -> jintArray {
	__JNI__FUNCTION__INIT__
	__get(Int, data);
	make_heap(data, __len(data));
	__release(Int, data);
	__JNI__FUNCTION__CLEAN__
}



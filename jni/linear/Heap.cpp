
#include "Heap.h"

JNIEXPORT auto JNICALL Java_org_algo4j_linear_Heap_makeHeap(
		JNIEnv *env,
		jclass,
		jintArray _data) -> jintArray {
	__JNI__FUNCTION__INIT__
	__get(Int, data);
	__JNI__FUNCTION__CLEAN__
}



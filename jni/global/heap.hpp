#include <jni.h>
#include "basics.hpp"

#ifndef __ALGO4J_HEAP_HPP__
#define __ALGO4J_HEAP_HPP__

using algo4j_util::swap;

namespace algo4j_heap {
	// template<typename T>
	// auto insert(T* heap, jsize len, T x) -> void;

	auto min_heapify(int *heap, int heapsize, int i) -> void {
		int smallest = i;
		int lch = i << 1;
		int rch = lch + 1;

		if (lch <= heapsize and heap[smallest] > heap[lch])
			smallest = lch;
		if (rch <= heapsize and heap[smallest] > heap[rch])
			smallest = rch;

		if (smallest != i) {
			swap(heap[smallest], heap[i]);
			min_heapify(heap, heapsize, smallest);
		}
	}

	template<typename T>
	auto make_heap(T *heap, jsize len) -> void {
		for (auto i = len >> 1; i >= 1; --i)
			min_heapify(heap, i);
	}
}


#endif /// __ALGO4J_HEAP_HPP__


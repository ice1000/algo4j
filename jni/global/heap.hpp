#include <jni.h>
#include "basics.hpp"

#ifndef __ALGO4J_HEAP_HPP__
#define __ALGO4J_HEAP_HPP__

using algo4j_util::swap;

namespace algo4j_heap {
	// should be called like this:
	// insert(data, ++cursor, element);
	template<typename T>
	auto insert(T *heap, jsize heapsize, T &x) -> void {
		heap[heapsize] = x;
		auto ch = heapsize;
    auto p = heapsize >> 1;
		while (heap[p] > heap[ch] and p >= 1) {
			swap(heap[p], heap[ch]);
			ch = p;
			p = ch >> 1;
		}
	}

	template<typename T>
	auto min_heapify(T *heap, const jsize heapsize, jsize i) -> void {
		auto smallest = i;
		auto lch = i << 1;
		auto rch = lch + 1;

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
	auto make_heap(T *heap, const jsize heapsize) -> void {
		for (auto i = heapsize >> 1; i >= 1; --i)
			min_heapify(heap, heapsize, i);
	}

	template<typename T>
	auto extract_min(T *heap, jsize &heapsize) -> T {
		auto res = heap[1];
		heap[1] = heap[heapsize--];
		min_heapify(heap, heapsize, 1);
		return res;
	}
}


#endif /// __ALGO4J_HEAP_HPP__


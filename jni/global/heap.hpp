#include <jni.h>
#include "basics.hpp"

#ifndef __ALGO4J_HEAP_HPP__
#define __ALGO4J_HEAP_HPP__

using algo4j_util::swap;

namespace algo4j_heap {
	// should be called like this:
	// insert(data, ++cursor, element);
	template<typename T>
	inline auto heap_insert(T *heap, jsize len, T &_) -> void {
		heap[len] = _;
		auto ch = len;
		auto p = len >> 1;
		while (heap[p] > heap[ch] and p >= 1) {
			swap(heap[p], heap[ch]);
			ch = p;
			p = ch >> 1;
		}
	}

	template<typename T>
	inline auto heap_adjust(T *heap, const jsize len, jsize _) -> void {
		auto mini = _;
		auto lch = _ << 1;
		auto rch = lch + 1;

		if (lch <= len and heap[mini] > heap[lch])
			mini = lch;
		if (rch <= len and heap[mini] > heap[rch])
			mini = rch;

		if (mini != _) {
			swap(heap[mini], heap[_]);
			heap_adjust(heap, len, mini);
		}
	}

	template<typename T>
	inline auto make_heap(T *heap, const jsize len) -> void {
		for (auto _ = len >> 1; _ >= 1; --_)
			heap_adjust(heap, len, _);
	}

	template<typename T>
	inline auto heap_extract_min(T *heap, jsize &len) -> T {
		auto res = heap[1];
		heap[1] = heap[len];
		heap_adjust(heap, --len, 1);
		return res;
	}

	template<typename T>
	class heap {
	private:
		T *data;
		jsize len;

	public:
		heap(jsize _len) : len(0) {
			data = new T[_len + 1];
		}

		auto insert(const T &element) -> void {
			heap_insert(data, len, element);
		}

		/// min_heapify
		auto adjust(jsize i = 1) -> void {
			heap_adjust(data, len, i);
		}

		auto extract_top() -> T {
			if (len <= 0) return nullptr;
			else return heap_extract_min(data, len);
		}
	};
}


#endif /// __ALGO4J_HEAP_HPP__


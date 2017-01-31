#include <jni.h>
#include "basics.hpp"

#ifndef __ALGO4J_HEAP_HPP__
#define __ALGO4J_HEAP_HPP__

using algo4j_util::swap;

#define __heap_class \
template<typename T> \
class heap { \
private: \
    T *data; \
    jsize len; \
public: \
    heap(jsize _len) : len(0) { data = new T[_len + 1]; } \
    auto insert(const T &element) -> void { heap_insert(data, len, element); } \
    auto adjust(jsize i = 1) -> void { heap_adjust(data, len, i); } \
    auto extract_top() -> T { return len <= 0 ? nullptr : heap_extract_top(data, len); } \
};

#define __heap_extract_top \
template<typename T> \
inline auto heap_extract_top(T *heap, jsize &len) -> T { \
    auto res = heap[1]; \
    heap[1] = heap[len]; \
    heap_adjust(heap, --len, 1); \
    return res; \
}

#define __make_heap \
template<typename T> \
inline auto make_heap(T *heap, const jsize len) -> void { \
    for (auto _ = len >> 1; _ >= 1; --_) heap_adjust(heap, len, _); \
} \

namespace algo4j_heap {
	namespace min {
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
			auto __ = _;
			auto lch = _ << 1;
			auto rch = lch + 1;

			if (lch <= len and heap[__] > heap[lch])
				__ = lch;
			if (rch <= len and heap[__] > heap[rch])
				__ = rch;

			if (__ != _) {
				swap(heap[__], heap[_]);
				heap_adjust(heap, len, __);
			}
		}

		__make_heap

		__heap_extract_top

		__heap_class
	}

	namespace max {
		// should be called like this:
		// insert(data, ++cursor, element);
		template<typename T>
		inline auto heap_insert(T *heap, jsize len, T &_) -> void {
			heap[len] = _;
			auto ch = len;
			auto p = len >> 1;
			while (heap[p] < heap[ch] and p >= 1) {
				swap(heap[p], heap[ch]);
				ch = p;
				p = ch >> 1;
			}
		}

		template<typename T>
		inline auto heap_adjust(T *heap, const jsize len, jsize _) -> void {
			auto __ = _;
			auto lch = _ << 1;
			auto rch = lch + 1;

			if (lch <= len and heap[__] < heap[lch])
				__ = lch;
			if (rch <= len and heap[__] < heap[rch])
				__ = rch;

			if (__ != _) {
				swap(heap[__], heap[_]);
				heap_adjust(heap, len, __);
			}
		}

		__make_heap

		__heap_extract_top

		__heap_class
	}
}

#undef __make_heap
#undef __heap_extract_top
#undef __heap_class

#endif /// __ALGO4J_HEAP_HPP__


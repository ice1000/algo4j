
#include <jni.h>

#ifndef __ICE1000_BASICS_HPP__
#define __ICE1000_BASICS_HPP__

namespace ice1000_util {
	template<typename T>
	constexpr auto swap (T &a, T &b) -> void {
		T c = a;
		a = b;
		b = c;
	}

	template<typename T>
	constexpr auto max(const T &a, const T &b) -> T {
		return a < b ? b : a;
	}

	template<typename T>
	constexpr auto min(const T &a, const T &b) -> T {
		return a < b ? a : b;
	}
}


#endif // __ICE1000_BASICS_HPP__

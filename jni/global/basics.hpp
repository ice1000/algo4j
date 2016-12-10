//
// Created by ice1000
//

#include <jni.h>
#include <stdlib.h>

#ifndef __ICE1000_BASICS_HPP__
#define __ICE1000_BASICS_HPP__

namespace ice1000_util {
	template<typename T>
	inline constexpr auto swap(T &a, T &b) -> void {
		T c = a;
		a = b;
		b = c;
	}

	template<typename T1, typename T2>
	inline constexpr auto max(const T1 &a, const T2 &b) -> T1 {
		return a < b ? b : a;
	}

	template<typename T1, typename T2>
	inline constexpr auto min(const T1 &a, const T2 &b) -> T1 {
		return a > b ? a : b;
	}

	template<typename T>
	inline constexpr auto abs(const T &o) -> T {
		return o < 0 ? -o : o;
	}
}


#endif // __ICE1000_BASICS_HPP__

//
// Created by ice1000
//

#include <jni.h>
#include <stdlib.h>

#ifndef __ICE1000_BASICS_HPP__
#define __ICE1000_BASICS_HPP__

namespace ice1000_util {
	template<typename T>
	constexpr auto swap(T &a, T &b) -> void {
		T c = a;
		a = b;
		b = c;
	}

	template<typename T1, typename T2>
	constexpr auto max(const T1 &a, const T2 &b) -> T1 {
		return a < b ? b : a;
	}

	template<typename T1, typename T2>
	constexpr auto min(const T1 &a, const T2 &b) -> T1 {
		return a > b ? a : b;
	}
}


#endif // __ICE1000_BASICS_HPP__

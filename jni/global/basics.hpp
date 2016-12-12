//
// Created by ice1000
//

#include <jni.h>
#include <string.h>
#include <stdlib.h>

#ifndef __ALGO4J_BASICS_HPP__
#define __ALGO4J_BASICS_HPP__

#ifndef __algo4j_memset
#define __algo4j_memset(x, y) (memset(x, y, sizeof(x)))
#endif /// __algo4j_memset

/// 0x5F3759DF thank you Carmack
#undef org_algo4j_util_Math_MAGIC_NUMBER
#define org_algo4j_util_Math_MAGIC_NUMBER 1597463007L

#define __JNI__FUNCTION__INIT__ \
auto option = new jboolean(false);

#define __JNI__FUNCTION__CLEAN__ \
delete option;

namespace algo4j_util {
	template<typename T>
	inline constexpr auto swap(T &a, T &b) -> void {
		auto c = a;
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

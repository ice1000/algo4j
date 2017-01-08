//
// Created by ice1000
//

#include <jni.h>

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

#define __release(type, name) \
env->Release ## type ## ArrayElements(_ ## name, name, 0);

#define __get(type, name) \
auto name = env->Get ## type ## ArrayElements(_ ## name, option);

#define __new(type, name, len) \
auto _ ## name = env->New ## type ## Array(len);

#define __set(type, name, len) \
env->Set ## type ## ArrayRegion(_ ## name, 0, len, name);

#define __len(name) \
env->GetArrayLength(_ ## name)

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

	template<typename T>
	class Single {
	public:
		T *value;

		explicit Single(T *val) :
				value(val) { }

		~Single() {
			clear();
		}

		auto set(T * val) -> T * {
			delete value;
			return value = val;
		}

		constexpr auto get() -> T * {
			return value;
		}

		constexpr auto clear() -> void {
			delete value;
		}
	};

}


#endif // __ALGO4J_BASICS_HPP__

//
// Created by ice1000
//

#include "jni.h"

#ifndef __ALGO4J_BASICS_HPP__
#define __ALGO4J_BASICS_HPP__

#ifndef __algo4j_memset
#define __algo4j_memset(x, y) (memset(x, y, sizeof(x)))
#endif /// __algo4j_memset

/// 0x5F3759DF thank you Carmack
#undef SQRT_MAGIC_NUMBER
#define SQRT_MAGIC_NUMBER 1597463007L

#define __JNI__FUNCTION__INIT__ \
jboolean *option = NULL;

#define __JNI__FUNCTION__CLEAN__ \
delete option;

#define __release(type, name) \
env->Release ## type ## ArrayElements(_ ## name, name, JNI_OK);

#define __abort(type, name) \
env->Release ## type ## ArrayElements(_ ## name, name, JNI_ABORT);

#define __get(type, name) \
auto name = env->Get ## type ## ArrayElements(_ ## name, option);

#define __new(type, name, len) \
auto _ ## name = env->New ## type ## Array(len);

#define __set(type, name, len) \
env->Set ## type ## ArrayRegion(_ ## name, 0, len, name);

#define __len(name) \
env->GetArrayLength(_ ## name)

#ifdef _
#undef _
#endif /// _

namespace algo4j_util {
	template<class T>
	using ptr_to = T*;

	template<typename T>
	inline auto swap(T &___, T &__) -> void {
		auto _ = ___;
		___ = __;
		__ = _;
	}

	template<typename T1, typename T2>
	inline constexpr auto max(const T1 &__, const T2 &___) -> T1 {
		return __ < ___ ? ___ : __;
	}

	template<typename T1, typename T2>
	inline constexpr auto min(const T1 &__, const T2 &___) -> T1 {
		return __ > ___ ? __ : ___;
	}

	template<typename T>
	inline constexpr auto abs(const T &_) -> T {
		return _ < 0 ? -_ : _;
	}

	template<typename T>
	class Single {
	private:
		T *_;

	public:

		explicit Single(T *val) :
				_(val) {}

		~Single() {
//			clear();
		}

		auto set(T *__) -> T * {
			delete _;
			return _ = __;
		}

		auto get() -> T * {
			return _;
		}

		auto clear() -> void {
			delete _;
		}
	};

}


#endif // __ALGO4J_BASICS_HPP__

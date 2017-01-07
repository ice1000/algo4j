#include "AdjacentMatrix.h"
#include "../global/basics.hpp"
#include "../global/functions.h"
#include "../global/templates.hpp"

using algo4j_math::sqrt_strict;

#define __mtrx(a, x, y) a[x * len + y]

JNIEXPORT auto JNICALL Java_org_algo4j_graph_AdjacentMatrix_floyd(
		JNIEnv *env,
		jclass,
		jintArray _origin) -> jintArray {
	__JNI__FUNCTION__INIT__
	// do not release.
	__get(Int, origin);
	auto lenSquare = __len(origin);
	auto len = static_cast<int>(sqrt_strict(lenSquare));
	auto ret = new jint[lenSquare]();
	__new(Int, ret, lenSquare);
	for (auto i = 0; i < lenSquare; ++i) {
		ret[i] = origin[i];
	}
	for (auto k = 0; k < len; ++k) {
		for (auto i = 0; i < len; ++i) {
			for (auto j = 0; j < len; ++j) {
				if (__mtrx(ret, i, j) > __mtrx(ret, i, k) + __mtrx(ret, k, j)) {
					__mtrx(ret, i, j) = __mtrx(ret, i, k) + __mtrx(ret, k, j);
				}
			}
		}
	}
	__set(Int, ret, lenSquare);
	__JNI__FUNCTION__CLEAN__
	return _ret;
}



#undef __mtrx


#include "org_ice1000_math_Matrix.h"

JNIEXPORT jint JNICALL Java_org_ice1000_math_Matrix_sum(
		JNIEnv *env,
		jobject jo,
		jlongArray _data,
		jint width,
		jint height) {
	auto option = new jboolean(false);
	auto data = env->GetLongArrayElements(_data, option);
	for (auto i = 0; i < width; ++i) {
		for (auto j = 0; j < height; ++j) {
			////
		}
	}
	env->ReleaseLongArrayElements(_data, data, 0);
	delete option;
}



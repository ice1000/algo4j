///
/// Created by ice1000 on 2016/11/19.
///

#include "org_ice1000_graph_UnionSet.h"

#pragma clang diagnostic push
#pragma clang diagnostic ignored "-Wunused-parameter"
#pragma ide diagnostic ignored "OCUnusedGlobalDeclarationInspection"

using namespace ice1000_uset;

JNIEXPORT auto JNICALL Java_org_ice1000_graph_UnionSet_find(
		JNIEnv *env,
		jobject jo,
		jintArray _data,
		jint len,
		jint a) -> jint {
  __JNI__FUNCTION__INIT__
  auto data = env->GetIntArrayElements(_data, option);
  auto ret = find(data, a);
  env->ReleaseIntArrayElements(_data, data, 0);
  __JNI__FUNCTION__CLEAN__
  return ret;
}

/// changed implementation into Java code
// JNIEXPORT auto JNICALL Java_org_ice1000_graph_UnionSet_merge(
// 		JNIEnv *env,
// 		jobject jo,
// 		jintArray _data,
// 		jint len,
// 		jint a,
// 		jint b) -> void {
// 	__JNI__FUNCTION__INIT__
// 	auto data = env->GetIntArrayElements(_data, option);
// 	merge(data, a, b);
// 	env->ReleaseIntArrayElements(_data, data, 0);
// 	__JNI__FUNCTION__CLEAN__
// }

#pragma clang diagnostic pop

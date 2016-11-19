#include "org_ice1000_graph_UnionSet.h"

#pragma clang diagnostic push
#pragma clang diagnostic ignored "-Wunused-parameter"
#pragma ide diagnostic ignored "OCUnusedGlobalDeclarationInspection"

using namespace ice1000_uset;

JNIEXPORT jint JNICALL Java_org_ice1000_graph_UnionSet_find(
		JNIEnv *env,
		jobject jo,
		jintArray _data,
		jint len,
		jint a) {
  auto option = new jboolean(false);
  auto data = env->GetIntArrayElements(_data, option);
  auto ret = find(data, a);
  env->ReleaseIntArrayElements(_data, data, 0);
  delete option;
  return ret;
}


// JNIEXPORT void JNICALL Java_org_ice1000_graph_UnionSet_merge(
// 		JNIEnv *env,
// 		jobject jo,
// 		jintArray _data,
// 		jint len,
// 		jint a,
// 		jint b) {
//   auto option = new jboolean(false);
//   auto data = env->GetIntArrayElements(_data, option);
//   merge(data, a, b);
//   env->ReleaseIntArrayElements(_data, data, 0);
//   delete option;
// }

#pragma clang diagnostic pop

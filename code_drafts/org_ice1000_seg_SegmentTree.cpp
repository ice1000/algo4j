#include "org_ice1000_seg_SegmentTree.h"

JNIEXPORT void JNICALL Java_org_ice1000_seg_SegmentTree_build___3J_3JI(
	  JNIEnv *env,
	  jobject jo,
	  jlongArray _data,
	  jlongArray source,
	  jint len) {
	auto option = new jboolean(false);
	auto data = env->GetLongArrayElements(_data, option);

	delete option;
}

JNIEXPORT void JNICALL Java_org_ice1000_seg_SegmentTree_build___3JI(
	  JNIEnv *env,
	  jobject jo,
	  jlongArray _data,
	  jint len) {
	auto option = new jboolean(false);
	auto data = env->GetLongArrayElements(_data, option);
	///
	delete option;
}

// Ä¤·¨Ê¦

JNIEXPORT void JNICALL Java_org_ice1000_seg_SegmentTree_query(
	  JNIEnv *env,
	  jobject jo,
	  jlongArray _data,
	  jint left,
	  jint right,
	  jint begin,
	  jint end) {
	auto option = new jboolean(false);
	auto data = env->GetLongArrayElements(_data, option);
	///
	delete option;
}

JNIEXPORT void JNICALL Java_org_ice1000_seg_SegmentTree_update(
	  JNIEnv *env,
	  jobject jo,
	  jlongArray _data,
		jint len) {
	auto option = new jboolean(false);
	auto data = env->GetLongArrayElements(_data, option);
	///
	delete option;
}



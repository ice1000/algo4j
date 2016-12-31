//
// Created by ice1000 on 2017/1/4
//

#include "ArraySeq.h"
#include "../global/basics.hpp"
#include <stdlib.h>
//#include <stdio.h>

// #include <iostream>

// using std::cin;
// using std::cout;
// using std::endl;

JNIEXPORT auto JNICALL Java_org_algo4j_collections_ArraySeq_getInitPtr(
		JNIEnv *env,
		jclass) -> jint {
	return (jint) malloc(org_algo4j_collections_ArraySeq_INITiAL_LENGTH * sizeof(jobject));
}

JNIEXPORT auto JNICALL Java_org_algo4j_collections_ArraySeq_setElement(
		JNIEnv *,
		jclass,
		jint _ptr,
		jint offset,
		jobject o
) -> void {
	auto p = (jobject *) _ptr;
	p[offset] = o;
}

JNIEXPORT auto JNICALL Java_org_algo4j_collections_ArraySeq_expandSize(
		JNIEnv *,
		jclass,
		jint _ptr,
		jint _current_size) -> void {
	//
}

//JNIEXPORT auto JNICALL Java_org_algo4j_collections_ArraySeq_contains(
//		JNIEnv *,
//		jclass,
//		jint _ptr,
//		jint len,
//		jobject _obj) -> jboolean {
//	// cout << _obj << endl;
//	auto fp = fopen("1.txt", "a");
//	fprintf(fp, "%d\n", _obj);
//	fclose(fp);
//	auto p = (jobject *) _ptr;
//	for(auto i = 0; i < len; ++i) {
//		if (p[i] == _obj) {
//			return JNI_TRUE;
//		}
//	}
//	return JNI_FALSE;
//}

JNIEXPORT auto JNICALL Java_org_algo4j_collections_ArraySeq_getAll(
		JNIEnv *env,
		jclass,
		jint _ptr,
		jint ) -> jobjectArray {
	__JNI__FUNCTION__INIT__
	auto env->NewObjectArray();
	__JNI__FUNCTION__CLEAN__
}



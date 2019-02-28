//
// Created by Phosphorus15 on 2019/2/26.
//

#include "Segtree.h"
#include "../global/functions.h"
#include "../global/basics.hpp"
#include "../global/segtree.h"

/// this has been a STATELESS implementation

JNIEXPORT auto JNICALL Java_org_algo4j_tree_seg_IntSegmentTree_set
        (JNIEnv *env, jobject obj, jint mode, jint l, jint r, jintArray _segments, jint length,
         jint value) -> void {
    __JNI__FUNCTION__INIT__
    __get(Int, segments)
    for (jint i = l; i <= r; i++)
        SegtreeUtil::set(i, value, length, segments, mode);
    // Macro release - copying might happen
    __release(Int, segments)
    __JNI__FUNCTION__CLEAN__
}

JNIEXPORT auto JNICALL Java_org_algo4j_tree_seg_IntSegmentTree_makeSeg
        (JNIEnv *env, jobject obj, jint mode, jintArray _data, jintArray _segments, jint length) -> void {
    __JNI__FUNCTION__INIT__
    __get(Int, data)
    __get(Int, segments)
    for (jint i = 0; i < length; i++) {
        segments[i + length] = data[i];
    }
    for (jint i = length - 1; i >= 1; i--) {
        segments[i] = SegtreeUtil::select(segments[i << 1], segments[i << 1 | 1], mode);
    }
    // Macro release
    __abort(Int, data)
    __release(Int, segments)
    __JNI__FUNCTION__CLEAN__
}

JNIEXPORT auto JNICALL Java_org_algo4j_tree_seg_IntSegmentTree_query
        (JNIEnv *env, jobject obj, jint mode, jint l, jint r, jintArray _segments, jint length) -> jint {
    __JNI__FUNCTION__INIT__
    __get(Int, segments)
    jint ans = SegtreeUtil::query(mode, l, r, segments, length);
    // Macro release
    __abort(Int, segments)
    __JNI__FUNCTION__CLEAN__
    return ans;
}
///
/// Created by ice1000 on 2016/11/19.
///

#include "FrontStarGraph.h"
#include "../global/functions.h"
#include "../global/templates.hpp"

#include <iostream>

using std::cin;
using std::cout;
using std::endl;

#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCUnusedGlobalDeclarationInspection"

using algo4j_sort::merge_sort;
using algo4j_uset::find;
using algo4j_frontstar::FrontStarNode;

JNIEXPORT auto JNICALL Java_org_algo4j_graph_FrontStarGraph_spfa(
		JNIEnv *env,
		jobject,
		jint source,
		jintArray _next,
		jintArray _head,
		jintArray _target,
		jintArray _value,
		jint edge_count,
		jint node_count) -> jintArray {
	__JNI__FUNCTION__INIT__
	auto _dis = env->NewIntArray(node_count);
	auto dis = new jint[node_count];
	auto inq = new jboolean[node_count];
	auto vis = new jint[node_count];
	auto queue = new jint[edge_count];
	jsize begin = 0, end = 0;
	jint i, j;
	auto looped = false;
	auto next = env->GetIntArrayElements(_next, option);
	auto head = env->GetIntArrayElements(_head, option);
	auto target = env->GetIntArrayElements(_target, option);
	auto value = env->GetIntArrayElements(_value, option);
	memset(dis, org_algo4j_graph_FrontStarGraph_INFINITY_FILLING, sizeof(dis[0]) * node_count);
	memset(vis, 0, sizeof(vis[0]) * node_count);
	memset(inq, false, sizeof(inq[0]) * node_count);
	dis[source] = 0;
	dis[0] = -1;
	inq[source] = JNI_TRUE;
	queue[end++] = source;
	while (begin < end and !looped) {
		i = queue[begin++ % edge_count];
		for (j = head[i]; ~j; j = next[j]) {
			if (dis[target[j]] > dis[i] + value[j]) {
				dis[target[j]] = dis[i] + value[j];
				if (!inq[target[j]]) {
					inq[target[j]] = JNI_TRUE;
					queue[end++ % edge_count] = target[j];
					if (++vis[target[j]] >= node_count) {
						memset(dis, -1, sizeof(dis[0]) * node_count);
						looped = true;
						break;
					}
				}
			}
		}
		inq[i] = JNI_FALSE;
	}
	env->ReleaseIntArrayElements(_next, next, 0);
	env->ReleaseIntArrayElements(_head, head, 0);
	env->ReleaseIntArrayElements(_target, target, 0);
	env->ReleaseIntArrayElements(_value, value, 0);
	env->SetIntArrayRegion(_dis, 0, node_count, dis);
	delete option;
	delete dis;
	delete inq;
	delete vis;
	delete queue;
	__JNI__FUNCTION__CLEAN__
	return _dis;
}

JNIEXPORT auto JNICALL Java_org_algo4j_graph_FrontStarGraph_kruskal(
		JNIEnv *env,
		jobject,
		jintArray _next,
		jintArray _head,
		jintArray _target,
		jintArray _departure,
		jintArray _value,
		jint edge_count,
		jint node_count) -> jintArray {
	__JNI__FUNCTION__INIT__
	auto looped = false;
	auto next = env->GetIntArrayElements(_next, option);
	auto head = env->GetIntArrayElements(_head, option);
	auto target = env->GetIntArrayElements(_target, option);
	auto departure = env->GetIntArrayElements(_departure, option);
	auto value = env->GetIntArrayElements(_value, option);
	auto uset = new jint[node_count]();
	auto depth = new jint[node_count]();
	auto edges = new FrontStarNode[edge_count]();
	auto find_res_1 = 0;
	auto find_res_2 = 0;
	memset(depth, 0, node_count * sizeof(depth[0]));
	for (auto i = 0; i < node_count; ++i) {
		uset[i] = i;
	}
	for (auto i = 0; i < edge_count; ++i) {
		edges[i].setValue(value[i], target[i], departure[i]);
	}
	env->ReleaseIntArrayElements(_next, next, 0);
	env->ReleaseIntArrayElements(_head, head, 0);
	env->ReleaseIntArrayElements(_target, target, 0);
	env->ReleaseIntArrayElements(_departure, departure, 0);
	env->ReleaseIntArrayElements(_value, value, 0);
	merge_sort(edges, edge_count);
	auto ret = new jint[node_count]();
	auto ret_idx = 0;
	for (auto i = 0; i < edge_count; ++i) {
		find_res_1 = find(uset, edges[i].from);
		find_res_2 = find(uset, edges[i].to);
		if (find_res_1 != find_res_2) {
			if (depth[find_res_1] > depth[find_res_2]) {
				uset[find_res_2] = find_res_1;
			} else {
				uset[find_res_1] = find_res_2;
				if (depth[find_res_1] == depth[find_res_2])
					++depth[find_res_1];
			}
			ret[ret_idx++] = i;
			if (ret_idx >= node_count)
				break;
		}
	}
	for (auto i = 0; i < node_count-1; ++i) {
		cout << "idx: " << i << " val:" << ret[i] << " edge: " << edges[i].value << endl;
	}
	auto _ret = env->NewIntArray(node_count - 1);
	env->SetIntArrayRegion(_ret, 0, node_count - 1, ret);
	delete option;
	delete depth;
	delete uset;
	delete[] edges;
	__JNI__FUNCTION__CLEAN__
	return _ret;
}


#pragma clang diagnostic pop

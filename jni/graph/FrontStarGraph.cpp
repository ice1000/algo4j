///
/// Created by ice1000 on 2016/11/19.
///

#include "FrontStarGraph.h"
#include "../global/basics.hpp"
#include "../global/functions.h"
#include "../global/templates.hpp"

//#include <iostream>
//
//using std::cin;
//using std::cout;
//using std::endl;

#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCUnusedGlobalDeclarationInspection"

using algo4j_sort::merge_sort;

using algo4j_uset::find;
using algo4j_uset::init;

using algo4j_front_star::FrontStarNode;

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
	__new(Int, dis, node_count);
	auto dis = new jint[node_count];
	auto inq = new bool[node_count];
	auto vis = new jint[node_count];
	auto queue = new jint[edge_count];
	auto begin = 0;
	auto end = 0;
	auto looped = false;
	__get(Int, next);
	__get(Int, head);
	__get(Int, target);
	__get(Int, value);
	for (auto i = 0; i < node_count; ++i) {
		dis[i] = FrontStarGraph_INFINITY;
	}
	dis[source] = 0;
	dis[0] = -1;
	memset(vis, 0, sizeof(vis[0]) * node_count);
	memset(inq, false, sizeof(inq[0]) * node_count);
	inq[source] = true;
	queue[end++] = source;
	while (begin < end and not looped) {
		auto i = queue[begin++ % edge_count];
		for (auto j = head[i]; ~j; j = next[j]) {
			if (dis[target[j]] > dis[i] + value[j]) {
				dis[target[j]] = dis[i] + value[j];
				if (not inq[target[j]]) {
					inq[target[j]] = true;
					queue[end++ % edge_count] = target[j];
					if (++vis[target[j]] >= node_count) {
						memset(dis, -1, sizeof(dis[0]) * node_count);
						looped = true;
						break;
					}
				}
			}
		}
		inq[i] = false;
	}
	__release(Int, next);
	__release(Int, head);
	__release(Int, target);
	__release(Int, value);
	__set(Int, dis, node_count);
	delete dis;
//	delete &looped, &begin, &end, &i, &j;
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
	__get(Int, next);
	__get(Int, head);
	__get(Int, target);
	__get(Int, departure);
	__get(Int, value);
	auto union_set = new jint[node_count]();
	init(union_set, node_count);
	auto depth = new jint[node_count]();
	memset(depth, 0, node_count * sizeof(depth[0]));
	auto edges = new FrontStarNode[edge_count]();
	for (auto i = 0; i < edge_count; ++i) {
		edges[i].setValue(value[i], target[i], departure[i]);
	}
	auto find_res_1 = 0;
	auto find_res_2 = 0;
	__release(Int, next);
	__release(Int, head);
	__release(Int, target);
	__release(Int, departure);
	__release(Int, value);
	merge_sort(edges, edge_count);
	auto ret = new jint[(node_count - 2) * 3]();
	auto ret_idx = 0;
	for (auto i = 0; i < edge_count; ++i) {
		find_res_1 = find(union_set, edges[i].from);
		find_res_2 = find(union_set, edges[i].to);
		if (find_res_1 != find_res_2) {
			if (depth[find_res_1] > depth[find_res_2]) {
				union_set[find_res_2] = find_res_1;
			} else {
				union_set[find_res_1] = find_res_2;
				if (depth[find_res_1] == depth[find_res_2])
					++depth[find_res_1];
			}
			ret[ret_idx++] = edges[i].from;
			ret[ret_idx++] = edges[i].to;
			ret[ret_idx++] = edges[i].value;
			if (ret_idx >= (node_count - 2) * 3)
				break;
		}
	}
	__new(Int, ret, (node_count - 2) * 3);
	__set(Int, ret, (node_count - 2) * 3);
	delete depth;
	delete union_set;
	delete ret;
//	delete &ret_idx, &find_res_1, &find_res_2;
	delete[] edges;
	__JNI__FUNCTION__CLEAN__
	return _ret;
}


JNIEXPORT auto JNICALL Java_org_algo4j_graph_FrontStarGraph_bellmanFord(
		JNIEnv *env,
		jobject,
		jint source,
		jintArray _target,
		jintArray _departure,
		jintArray _value,
		jint edge_count,
		jint node_count) -> jintArray {
	__JNI__FUNCTION__INIT__
	auto dis = new jint[node_count];
	__new(Int, dis, node_count);
	__get(Int, departure);
	__get(Int, target);
	__get(Int, value);
	for (auto i = 0; i < node_count; ++i) {
		dis[i] = FrontStarGraph_INFINITY;
	}
	dis[source] = 0;
	dis[0] = -1;
	bool changed;
	for (auto _ = 0; _ < node_count; ++_) {
		changed = false;
		for (auto i = 0; i < edge_count; ++i) {
			if (dis[departure[i]] < FrontStarGraph_INFINITY and
				dis[target[i]] > dis[departure[i]] + value[i]) {
				dis[target[i]] = dis[departure[i]] + value[i];
				changed = true;
			}
		}
		if (!changed) break;
	}
//	for (auto i = 0; i < edge_count; ++i) {
//		if (dis[target[i]] > dis[departure[i]] + value[i]) {
//			/// negative loop
//			memset(dis, -1, sizeof(decltype(dis[0])) * node_count);
//		}
//	}
	__set(Int, dis, node_count);
	delete dis;
	__JNI__FUNCTION__CLEAN__
	return _dis;
}


#pragma clang diagnostic pop



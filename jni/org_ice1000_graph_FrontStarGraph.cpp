#include "org_ice1000_graph_FrontStarGraph.h"

JNIEXPORT jlongArray JNICALL Java_org_ice1000_graph_FrontStarGraph_spfa(
		JNIEnv *env,
		jobject jo,
		jint source,
		jlongArray _next,
		jlongArray _head,
		jlongArray _target,
		jlongArray _value,
		jint edge_count,
		jint node_count) {
	auto _dis = env->NewLongArray(node_count);
	auto dis = new jlong[node_count];
	auto inq = new jlong[node_count];
	auto vis = new jlong[node_count];
	auto queue = new jlong[edge_count];
	auto begin = 0, end = 0;
	jlong i, j;
	auto option = new jboolean(false);
	auto next = env->GetLongArrayElements(_next, option);
	auto head = env->GetLongArrayElements(_head, option);
	auto target = env->GetLongArrayElements(_target, option);
	auto value = env->GetLongArrayElements(_value, option);
	__ice_memset(dis, org_ice1000_graph_FrontStarGraph_INFINITY_FILLING);
	__ice_memset(vis, 0);
	__ice_memset(inq, 0);
	dis[source] = 0;
	++inq[source];
	queue[end++] = source;
	while (begin < end) {
		i = queue[begin++];
		if (++vis[i] >= node_count) break;
		for (j = head[i]; j; j = next[j]) {
			if (dis[i] > dis[target[j]] + value[j]) {
				dis[i] = dis[target[j]] + value[j];
				if (!inq[target[j]]) {
					++inq[target[j]];
					queue[end++] = target[j];
				}
			}
		}
		inq[i] = 0;
	}
	env->SetLongArrayRegion(_dis, 0, node_count, dis);
	env->ReleaseLongArrayElements(_next, next, 0);
	env->ReleaseLongArrayElements(_head, head, 0);
	env->ReleaseLongArrayElements(_target, target, 0);
	env->ReleaseLongArrayElements(_value, value, 0);
	delete option;
	delete dis;
	delete inq;
	delete vis;
	delete queue;
	return _dis;
}

JNIEXPORT jlong JNICALL Java_org_ice1000_graph_FrontStarGraph_kruskal(
		JNIEnv *env,
		jobject jo,
		jlongArray _next,
		jlongArray _head,
		jlongArray _target,
		jlongArray _value,
		jint edge_count,
		jint node_count) {
	return NULL;
}



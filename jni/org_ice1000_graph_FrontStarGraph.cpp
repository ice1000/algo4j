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
	auto inq = new bool[node_count];
	auto vis = new int[node_count];
	auto queue = new jlong[edge_count];
	size_t begin = 0, end = 0;
	jlong i, j;
	auto option = new jboolean(false);
	auto looped = false;
	auto next = env->GetLongArrayElements(_next, option);
	auto head = env->GetLongArrayElements(_head, option);
	auto target = env->GetLongArrayElements(_target, option);
	auto value = env->GetLongArrayElements(_value, option);
	__ice_memset(dis, org_ice1000_graph_FrontStarGraph_INFINITY_FILLING);
	__ice_memset(vis, 0);
	__ice_memset(inq, false);
	dis[source] = 0;
	inq[source] = true;
	queue[end++] = source;
	while (begin < end and !looped) {
		i = queue[begin++ % edge_count];
		for (j = head[i]; ~j; j = next[j]) {
			if (dis[target[j]] > dis[i] + value[j]) {
				dis[target[j]] = dis[i] + value[j];
				if (!inq[target[j]]) {
					inq[target[j]] = true;
					queue[end++ % edge_count] = target[j];
					if (++vis[target[j]] >= node_count) {
						__ice_memset(dis, -1);
						looped = true;
						break;
					}
				}
			}
		}
		inq[i] = false;
	}
	env->ReleaseLongArrayElements(_next, next, 0);
	env->ReleaseLongArrayElements(_head, head, 0);
	env->ReleaseLongArrayElements(_target, target, 0);
	env->ReleaseLongArrayElements(_value, value, 0);
	env->SetLongArrayRegion(_dis, 0, node_count, dis);
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



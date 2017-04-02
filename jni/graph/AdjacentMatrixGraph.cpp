#include "AdjacentMatrixGraph.h"
#include "../global/basics.hpp"
#include "../global/templates.hpp"

#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCUnusedGlobalDeclarationInspection"
using algo4j_math::sqrt_strict;

#ifdef matrix
#undef matrix
#endif /// matrix

#define matrix(a, x, y) a[x * len + y]

JNIEXPORT auto JNICALL Java_org_algo4j_graph_AdjacentMatrixGraph_floyd(
		JNIEnv *env,
		jclass,
		jintArray _origin) -> jintArray {
	__JNI__FUNCTION__INIT__
	// do not release.
	__get(Int, origin);
	auto lenSquare = __len(origin);
	auto len = static_cast<jsize>(sqrt_strict(lenSquare));
	auto ret = new jint[lenSquare]();
	__new(Int, ret, lenSquare);
	for (auto i = 0; i < lenSquare; ++i) {
		ret[i] = origin[i];
	}
	for (auto k = 0; k < len; ++k) {
		for (auto i = 0; i < len; ++i) {
			for (auto j = 0; j < len; ++j) {
				if (matrix(ret, i, j) > matrix(ret, i, k) + matrix(ret, k, j)) {
					matrix(ret, i, j) = matrix(ret, i, k) + matrix(ret, k, j);
				}
			}
		}
	}
	__set(Int, ret, lenSquare);
	delete ret;
	__JNI__FUNCTION__CLEAN__
	return _ret;
}

JNIEXPORT auto JNICALL Java_org_algo4j_graph_AdjacentMatrixGraph_dijkstra(
		JNIEnv *env,
		jclass,
		jint source,
		jintArray _origin) -> jintArray {
	auto len = static_cast<jsize>(sqrt_strict(__len(origin)));
	auto dis = new jint[len]();
	auto v = new bool[len]();
	__JNI__FUNCTION__INIT__
	// do not release.
	__get(Int, origin);
	jint min;
	auto min_index = 0;
	memset(v, false, sizeof(v));
	__new(Int, dis, len);
	int begin = source * len;
	for (auto _ = 0; _ < len; ++_) {
		dis[_] = origin[begin + _];
	}
	dis[source] = 0;
	dis[0] = -1;
	v[source] = true;
	for (auto _ = 0; _ < len; ++_) {
		min = AdjacentMatrixGraph_ORIGINAL_FILLING_VALUE;
		for (auto __ = 0; __ < len; ++__) {
			if (!v[__] and
				min > dis[__]) {
				min = dis[__];
				min_index = __;
			}
		}
		v[min_index] = true;
		for (auto __ = 0; __ < len; ++__) {
			if (!v[__] and
				dis[__] > dis[min_index] + matrix(origin, min_index, __)) {
				dis[__] = dis[min_index] + matrix(origin, min_index, __);
			}
		}
	}
	delete v;
	__set(Int, dis, len);
	delete dis;
	__JNI__FUNCTION__CLEAN__
	return _dis;
}

//int edmonds_karp(jint *G, jsize len, int s, int e) {
//	auto vis = new bool[len + 1]();
//	auto que = new jint[len + 1]();
//	auto fa = new jint[len + 1]();
//	int curFlow = 1 << 30, ans = 0;
//	do {
//		memset(vis, 0, sizeof(vis));
//		memset(fa, 0, sizeof(fa));
//		int head = 0, tail = 0, cur;
//		curFlow = 1 << 30;
//		que[tail++] = s;
//		vis[s] = true;
//		while (head < tail) {
//			cur = que[head++ % (len + 1)];
//			if (cur == e) break;
//			for (int i = 1; i <= n; i++)
//				if (G[cur * len + i] && !vis[i]) {
//					que[tail++ % n + 1] = i;
//					fa[i] = cur;
//					vis[i] = true;
//				}
//		}
//		cur = e;
//		while (fa[cur]) {
//			curFlow = min(G[fa[cur] * len + cur], curFlow);
//			cur = fa[cur];
//		}
//		cur = e;
//		while (fa[cur]) {
//			G[fa[cur] * len + cur] -= curFlow;
//			G[cur * len + fa[cur]] += curFlow;
//			cur = fa[cur];
//		}
//		if (curFlow == 1 << 30) curFlow = 0;
//		ans += curFlow;
//	} while (curFlow);
//	delete vis;
//	delete que;
//	delete fa;
//	return ans;
//}

#undef matrix


#pragma clang diagnostic pop

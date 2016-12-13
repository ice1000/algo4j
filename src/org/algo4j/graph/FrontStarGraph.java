package org.algo4j.graph;

import org.algo4j.error.FrontStarGraphException;

import java.util.Arrays;

/**
 * Created by ice1000 on 2016/11/17.
 *
 * @author ice1000
 */
@SuppressWarnings("WeakerAccess")
public final class FrontStarGraph {
	private long[] next;
	private long[] head;
	private long[] target;
	private long[] depart;
	private long[] value;
	private int nodeCount;
	private int edgeCount;
	private int addingEdgeIndex = 0;

	/** used in jni C++ port. */
	public static final int INFINITY = 0x7f7f7f7f;

	/** used in jni C++ port. */
	public static final int INFINITY_FILLING = 0x7f;

	public FrontStarGraph(int nodeCount, int edgeCount) {
		++nodeCount;
		this.nodeCount = nodeCount;
		this.edgeCount = edgeCount;
		value = new long[edgeCount];
		target = new long[edgeCount];
		depart = new long[edgeCount];
		next = new long[edgeCount];
		head = new long[nodeCount];
		Arrays.fill(next, -1);
		Arrays.fill(head, -1);
		// there's no need to initialize depart.
	}

	/**
	 * add an edge to this front star graph.
	 *
	 * @param from begin position
	 * @param to   end position
	 * @param val  the value of the edge
	 */
	public void addEdge(int from, int to, int val) {
		if (from < 1 ||
				to < 1 ||
				from > nodeCount ||
				to > nodeCount ||
				from == to)
			throw FrontStarGraphException.numberInvalid();
		target[addingEdgeIndex] = to;
		depart[addingEdgeIndex] = from;
		value[addingEdgeIndex] = val;
		next[addingEdgeIndex] = head[from];
		head[from] = addingEdgeIndex++;
	}

	/**
	 * add two edges
	 *
	 * @param p1   position1
	 * @param p2   position2
	 * @param p1p2 distance from position1 to position2
	 * @param p2p1 distance from position2 to position1
	 */
	public void addEdge(int p1, int p2, int p1p2, int p2p1) {
		addEdge(p1, p2, p1p2);
		addEdge(p2, p1, p2p1);
	}

	/**
	 * add two-direction edge
	 *
	 * @param p1  position1
	 * @param p2  position2
	 * @param val distance
	 */
	public void addDirectionlessEdge(int p1, int p2, int val) {
		addEdge(p1, p2, val);
		addEdge(p2, p1, val);
	}

	/**
	 * O(n) = n * log(n)
	 * Shortest path faster algorithm
	 * The queue-based optimization of bellman-ford algorithm.
	 *
	 * @param source the begin position
	 * @return the shortest path to each position
	 */
	public long[] spfa(int source) {
		if (source < 1 || source > nodeCount)
			throw FrontStarGraphException.indexOutBound();
		return spfa(source, next, head, target, value, edgeCount, nodeCount);
	}

	/**
	 * The Kruskal algorithm, minimum spanning tree
	 *
	 * @return the length of the minimum spanning tree
	 */
	public long kruskal() {
		return kruskal(next, head, target, depart, value, edgeCount, nodeCount);
	}

	/**
	 * Shortest path faster algorithm (‘_’)
	 * (‘_’) %%%
	 *
	 * @param source    start node id
	 * @param next      memset(next, -1, sizeof(next))
	 * @param head      memset(next, -1, sizeof(next))
	 * @param target    memset(next, -1, sizeof(next))
	 * @param value     memset(next, -1, sizeof(next))
	 * @param edgeCount edges
	 * @param nodeCount nodes
	 */
	private native long[] spfa(
			int source,
			long[] next,
			long[] head,
			long[] target,
			long[] value,
			int edgeCount,
			int nodeCount
	);

	/**
	 * @param next      memset(next, -1, sizeof(next))
	 * @param head      memset(next, -1, sizeof(next))
	 * @param target    memset(next, -1, sizeof(next))
	 * @param value     memset(next, -1, sizeof(next))
	 * @param edgeCount edges
	 * @param nodeCount nodes
	 */
	private native long kruskal(
			long[] next,
			long[] head,
			long[] target,
			long[] departure,
			long[] value,
			int edgeCount,
			int nodeCount
	);
}

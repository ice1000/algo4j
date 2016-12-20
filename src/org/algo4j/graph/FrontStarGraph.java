package org.algo4j.graph;

import org.algo4j.error.FrontStarGraphException;
import org.algo4j.math.MathUtils;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Created by ice1000 on 2016/11/17.
 *
 * @author ice1000
 */
@SuppressWarnings({"WeakerAccess", "CanBeFinal", "unused"})
public final class FrontStarGraph {
	private int[] next;
	private int[] head;
	private int[] target;
	private int[] depart;
	private int[] value;
	private int addingEdgeIndex = 0;
	private int maximumNodeNumber = 0;
	public final int nodeCount;
	public final int edgeCount;

	/**
	 * used in jni C++ port.
	 */
	public static final int INFINITY = 0x7f7f7f7f;

	/**
	 * used in jni C++ port.
	 */
	public static final int INFINITY_FILLING = 0x7f;

	public FrontStarGraph(int nodeCount, int edgeCount) {
		if (nodeCount <= 0) throw new FrontStarGraphException("node count cannot be lower than 0");
		if (edgeCount <= 0) throw new FrontStarGraphException("node count cannot be lower than 0");
		++nodeCount;
		this.nodeCount = nodeCount;
		this.edgeCount = edgeCount;
		value = new int[edgeCount];
		target = new int[edgeCount];
		depart = new int[edgeCount];
		next = new int[edgeCount];
		head = new int[nodeCount];
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
		if (from <= 0 || to <= 0 || from > nodeCount || to > nodeCount || from == to)
			throw FrontStarGraphException.numberInvalid();
		maximumNodeNumber = MathUtils.max(maximumNodeNumber, from);
		maximumNodeNumber = MathUtils.max(maximumNodeNumber, to);
		target[addingEdgeIndex] = to;
		depart[addingEdgeIndex] = from;
		value[addingEdgeIndex] = val;
		next[addingEdgeIndex] = head[from];
		head[from] = addingEdgeIndex++;
	}

	/**
	 * add two edges
	 * <p>
	 * 前两个参数a, b是点 后面两个分别是a->b和b->a的距离
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
		addEdge(p1, p2, val, val);
	}

	/**
	 * return all edges between p1 and p2
	 *
	 * @param p1 position 1
	 * @param p2 position 2
	 * @return all edges between p1 and p2
	 */
	@NotNull
	@Contract("_, _ -> !null")
	public int[] getEdges(int p1, int p2) {
		if (p1 <= 0 || p2 <= 0 || p1 > nodeCount || p2 > nodeCount)
			throw FrontStarGraphException.numberInvalid();
		ArrayList<Integer> edges = new ArrayList<>();
//		if (p1 == p2) edges.add(0L);
		for (int i = head[p1]; i != -1; i = next[i])
			if (target[i] == p2) edges.add(value[i]);
		int[] ret = new int[edges.size()];
		for (int i = 0; i < ret.length; i++) ret[i] = edges.get(ret.length - i - 1);
		return ret;
	}

	/**
	 * O(n) = n * log(n)
	 * Shortest path faster algorithm
	 * The queue-based optimization of bellman-ford algorithm.
	 * <p>
	 * 返回一个数组 参数是源点 返回的数组是源点到每个点的最短距离
	 *
	 * @param source the begin position
	 * @return the shortest path to each position
	 * @throws FrontStarGraphException if 'source' is out of bound
	 */
	@NotNull
	@Contract("_ -> !null")
	public int[] spfa(int source) {
		if (source <= 0 || source > nodeCount)
			throw FrontStarGraphException.indexOutBound();
		return spfa(
				source,
				next,
				head,
				target,
				value,
				edgeCount,
				nodeCount
		);
	}

	/**
	 * The Kruskal algorithm, minimum spanning tree
	 *
	 * @return the length of the minimum spanning tree
	 */
	public int kruskal() {
		return kruskal(
				next,
				head,
				target,
				depart,
				value,
				edgeCount,
				nodeCount
		);
	}

	/**
	 * depth first search
	 *
	 * @param source       the source position
	 * @param initValue    origin value passed to the function,
	 * @param function     the function applied to each search
	 * @param <DataHolder> the return type of 'function' and 'initValue'
	 *                     passed from last function call or
	 * @throws FrontStarGraphException if 'source' is out of bound
	 */
	public <DataHolder> void dfs(
			int source,
			@NotNull DataHolder initValue,
			@NotNull BiFunction<Edge, DataHolder, DataHolder> function) {
		if (source <= 0 || source > nodeCount)
			throw FrontStarGraphException.indexOutBound();
		dfs(source, initValue, function, new boolean[getAddedEdgeCount() + 1]);
	}

	/**
	 * depth first search
	 *
	 * @param source   the source position
	 * @param function the function applied to each search,
	 *                 with no 'DataHolder' value passing
	 * @throws FrontStarGraphException if 'source' is out of bound
	 */
	public void dfs(
			int source,
			@NotNull Function<Edge, Object> function) {
		if (source <= 0 || source > nodeCount)
			throw FrontStarGraphException.indexOutBound();
		dfs(source, function, new boolean[getAddedEdgeCount() + 1]);
	}

	private void dfs(
			int source,
			@NotNull Function<Edge, Object> function,
			@NotNull boolean[] mark) {
		for (int i = head[source]; i != -1; i = next[i]) {
			if (!mark[i]) {
				mark[i] = true;
				function.apply(new Edge(target[i], depart[i], value[i]));
				dfs(target[i], function, mark);
			}
		}
	}

	private <DataHolder> void dfs(
			int source,
			@NotNull DataHolder initValue,
			@NotNull BiFunction<Edge, DataHolder, DataHolder> function,
			@NotNull boolean[] mark) {
		for (int i = head[source]; i != -1; i = next[i]) {
			if (!mark[i]) {
				mark[i] = true;
				DataHolder ret = function.apply(new Edge(target[i], depart[i], value[i]), initValue);
				dfs(target[i], ret, function, mark);
			}
		}
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
	private native int[] spfa(
			int source,
			@NotNull int[] next,
			@NotNull int[] head,
			@NotNull int[] target,
			@NotNull int[] value,
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
	private native int kruskal(
			@NotNull int[] next,
			@NotNull int[] head,
			@NotNull int[] target,
			@NotNull int[] departure,
			@NotNull int[] value,
			int edgeCount,
			int nodeCount
	);

	@Contract(pure = true)
	public int getAddedEdgeCount() {
		return addingEdgeIndex;
	}

	@Contract(pure = true)
	public int getMaximumNodeNumber() {
		return maximumNodeNumber;
	}

	public class Edge {
		public int target;
		public int depart;
		public int value;

		@Contract(pure = true)
		public Edge(int target, int depart, int value) {
			this.target = target;
			this.depart = depart;
			this.value = value;
		}
	}
}

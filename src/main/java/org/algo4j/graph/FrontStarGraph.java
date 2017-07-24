package org.algo4j.graph;

import org.algo4j.error.GraphException;
import org.algo4j.math.MathUtils;
import org.algo4j.util.SeqUtils;
import org.algo4j.util.Statistics;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * node: from 1 to nodeCount
 * Created by ice1000 on 2016/11/17.
 *
 * @author ice1000
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class FrontStarGraph implements
		Graph,
		Iterable<Edge> {
	private final int[] next;
	private final int[] head;
	private final int[] target;
	private final int[] depart;
	private final int[] value;
	public final int nodeCount;
	public final int edgeCount;
	private int maximumNodeNumber;
	private int addingEdgeIndex;

	/**
	 * used in jni C++ port.
	 */
	public static final int INFINITY = ORIGINAL_FILLING_VALUE;

	/**
	 * used in jni C++ port.
	 */
	public static final int INFINITY_FILLING = 0x7f;

	/**
	 * init
	 *
	 * @param nodeCount maximum number of nudes.
	 * @param edgeCount maximum number of edges.
	 * @throws GraphException if numbers is zero or negative
	 */
	public FrontStarGraph(int nodeCount, int edgeCount) {
		if (nodeCount <= 0)
			throw new GraphException("node count cannot be zero or negative!");
		if (edgeCount <= 0)
			throw new GraphException("edge count cannot be zero or negative!");
		this.nodeCount = nodeCount + 1;
		this.edgeCount = edgeCount;
		target = new int[edgeCount];
		depart = new int[edgeCount];
		value = new int[edgeCount];
		next = new int[edgeCount];
		head = new int[this.nodeCount];
		maximumNodeNumber = 0;
		addingEdgeIndex = 0;
		Arrays.fill(next, -1);
		Arrays.fill(head, -1);
		// there's no need to initialize depart.
	}

	/**
	 * cloning.
	 *
	 * @param next              original next
	 * @param head              original head
	 * @param target            original target
	 * @param depart            original depart
	 * @param value             original value
	 * @param addingEdgeIndex   original addingEdgeIndex
	 * @param maximumNodeNumber original maximumNodeNumber
	 * @param nodeCount         original nodeCount
	 * @param edgeCount         original edgeCount
	 */
	private FrontStarGraph(
			@NotNull int[] next,
			@NotNull int[] head,
			@NotNull int[] target,
			@NotNull int[] depart,
			@NotNull int[] value,
			int addingEdgeIndex,
			int maximumNodeNumber,
			int nodeCount,
			int edgeCount) {
		this.next = next;
		this.head = head;
		this.target = target;
		this.depart = depart;
		this.value = value;
		this.addingEdgeIndex = addingEdgeIndex;
		this.maximumNodeNumber = maximumNodeNumber;
		this.nodeCount = nodeCount;
		this.edgeCount = edgeCount;
	}

	/**
	 * accumulate an edge to this top star graph.
	 *
	 * @param from begin position
	 * @param to   end position
	 * @param val  the value of the edge
	 * @throws GraphException if index is out of bound
	 */
	@Override
	public void addEdge(int from, int to, int val) {
		if (from <= 0 || to <= 0 || from > nodeCount || to > nodeCount)
			throw GraphException.numberInvalid();
		if (addingEdgeIndex >= edgeCount)
			throw GraphException.tooManyEdges();
		maximumNodeNumber = MathUtils.max(maximumNodeNumber, from);
		maximumNodeNumber = MathUtils.max(maximumNodeNumber, to);
		target[addingEdgeIndex] = to;
		depart[addingEdgeIndex] = from;
		value[addingEdgeIndex] = val;
		next[addingEdgeIndex] = head[from];
		head[from] = addingEdgeIndex++;
	}

	/**
	 * return all edges between p1 and p2
	 *
	 * @param p1 position 1
	 * @param p2 position 2
	 * @return all edges between p1 and p2
	 * @throws GraphException if 'p1' and 'p2' is out of bound
	 */
	@NotNull
	@Contract("_, _ -> !null")
	public int[] getEdges(int p1, int p2) {
		if (p1 <= 0 || p2 <= 0 || p1 > nodeCount || p2 > nodeCount)
			throw GraphException.numberInvalid();
		List<Integer> edges = new ArrayList<>(nodeCount >> 1);
		for (int i = head[p1]; i != -1; i = next[i])
			if (target[i] == p2)
				edges.add(value[i]);
		int[] ret = new int[edges.size()];
		for (int i = 0; i < ret.length; ++i)
			ret[i] = edges.get(ret.length - i - 1);
		return ret;
	}

	/**
	 * O(n) = n * log(n)
	 * Shortest path faster algorithm
	 * The queue-based optimization of bellman-ford algorithm.
	 * <p>
	 * 返回一个数组 参数是源点 返回的数组是源点到每个点的最短距离
	 * 有负权环的话抛异常
	 *
	 * @param source the begin position
	 * @return the shortest path to each position
	 * @throws GraphException if 'source' is out of bound
	 * @throws GraphException if there is negative loop
	 */
	@NotNull
	@Contract(value = "_ -> !null", pure = true)
	public int[] spfa(int source) {
		if (source <= 0 || source > nodeCount)
			throw GraphException.indexOutBound();
		int[] ret = spfa(
				source,
				next,
				head,
				target,
				value,
				edgeCount,
				nodeCount
		);
		assert ret[0] == -1;
		if (ret[source] == -1) throw GraphException.negativeLoop();
		return ret;
	}

	@Override
	@NotNull
	@Contract(pure = true)
	public int[] shortestPath(int source) {
		return spfa(source);
	}

	/**
	 * O(n) = n * m
	 * Bellman-Ford algorithm
	 * <p>
	 * 返回一个数组 参数是源点 返回的数组是源点到每个点的最短距离
	 * 有负权环的话抛异常
	 *
	 * @param source the begin position
	 * @return the shortest path to each position
	 * @throws GraphException if 'source' is out of bound
	 * @throws GraphException if there is negative loop
	 */
	@NotNull
	@Contract(value = "_ -> !null", pure = true)
	public int[] bellmanFord(int source) {
		if (source <= 0 || source > nodeCount)
			throw GraphException.indexOutBound();
		int[] ret = bellmanFord(
				source,
				target,
				depart,
				value,
				edgeCount,
				nodeCount
		);
		assert ret[0] == -1;
		if (ret[source] == -1) throw GraphException.negativeLoop();
		return ret;
	}

	@NotNull
	@Contract("-> !null")
	public FrontStarGraph kruskal() {
		return kruskal(false);
	}

	/**
	 * The Kruskal algorithm, minimum spanning tree
	 *
	 * @param directionless refers to the returned graph.
	 * @return The minimum spanning tree.
	 */
	@NotNull
	@Contract("_ -> !null")
	@SuppressWarnings("SameParameterValue")
	public FrontStarGraph kruskal(boolean directionless) {
		int[] kruskal = kruskal(
				next,
				head,
				target,
				depart,
				value,
				edgeCount,
				nodeCount
		);
		FrontStarGraph graph = new FrontStarGraph(nodeCount, nodeCount - 1);
		if (directionless) {
			/// accumulate directionless edges.
			for (int i = 0; i < kruskal.length; i += 3)
				graph.addDirectionlessEdge(kruskal[i], kruskal[i + 1], kruskal[i + 2]);
		} else {
			/// accumulate edges not directionless.
			for (int i = 0; i < kruskal.length; i += 3)
				graph.addEdge(kruskal[i], kruskal[i + 1], kruskal[i + 2]);
		}
		return graph;
	}

	/**
	 * depth first search
	 *
	 * @param source       the source position
	 * @param initValue    origin value passed to the function,
	 * @param function     the function applied to each search
	 * @param <DataHolder> the return type of 'function' and 'initValue'
	 *                     passed from last function call or
	 * @throws GraphException if 'source' is out of bound
	 */
	public <DataHolder> void dfs(
			int source,
			@NotNull DataHolder initValue,
			@NotNull BiFunction<Edge, DataHolder, DataHolder> function) {
		if (source <= 0 || source > nodeCount)
			throw GraphException.indexOutBound();
		dfs(source, initValue, function, new boolean[getAddedEdgeCount() + 1]);
	}

	/**
	 * depth first search
	 *
	 * @param source   the source position
	 * @param function the function applied to each search,
	 *                 with no 'DataHolder' value passing
	 * @throws GraphException if 'source' is out of bound
	 */
	public void dfs(
			int source,
			@NotNull Function<Edge, Void> function) {
		if (source <= 0 || source > nodeCount)
			throw GraphException.indexOutBound();
		dfs(source, function, new boolean[getAddedEdgeCount() + 1]);
	}

	private <DataHolder> void dfs(
			int source,
			@NotNull Function<Edge, Void> function,
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

	@Override
	public void forEach(@Nullable Consumer<? super Edge> action) {
		if (action != null) {
			for (int i = 0; i < addingEdgeIndex; ++i) {
				action.accept(new Edge(target[i], depart[i], value[i]));
			}
		}
	}

	@Override
	@NotNull
	@Contract(value = " -> !null", pure = true)
	public Iterator<Edge> iterator() {
		return new FrontStarItr(this);
	}

	/**
	 * Shortest path faster algorithm (‘_’)
	 * This is Bellman-Ford with queue optimization
	 *
	 * @param source    start node id
	 * @param next      top star graph edge
	 * @param head      top star graph edge
	 * @param target    edge target
	 * @param value     edge value
	 * @param edgeCount edges
	 * @param nodeCount nodes
	 */
	@NotNull
	@Contract(pure = true)
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
	 * Bellman-Ford algorithm(without queue optimization)
	 *
	 * @param source    start node id
	 * @param depart    edge departure
	 * @param target    edge target
	 * @param value     edge value
	 * @param edgeCount edges
	 * @param nodeCount nodes
	 */
	@NotNull
	@Contract(pure = true)
	private native int[] bellmanFord(
			int source,
			@NotNull int[] target,
			@NotNull int[] depart,
			@NotNull int[] value,
			int edgeCount,
			int nodeCount
	);

	/**
	 * @param next      top star graph edge
	 * @param head      top star graph edge
	 * @param target    edge target
	 * @param value     edge value
	 * @param edgeCount edges
	 * @param nodeCount nodes
	 * @return the indexes of the edges that the minimum spinning tree consists of.
	 */
	@NotNull
	@Contract(pure = true)
	private native int[] kruskal(
			@NotNull int[] next,
			@NotNull int[] head,
			@NotNull int[] target,
			@NotNull int[] depart,
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

	/**
	 * returns the sum of all edges.
	 *
	 * @return value sum
	 */
	@Contract(pure = true)
	public int getValueSum() {
		return Statistics.sum(value);
	}

	@Contract(pure = true)
	public int getNodeCount() {
		return nodeCount;
	}

	@Contract(pure = true)
	public int getEdgeCount() {
		return edgeCount;
	}

	@Override
	@NotNull
	@Contract(value = " -> !null", pure = true)
	public FrontStarGraph clone() {
		return new FrontStarGraph(
				SeqUtils.copy(next),
				SeqUtils.copy(head),
				SeqUtils.copy(target),
				SeqUtils.copy(depart),
				SeqUtils.copy(value),
				addingEdgeIndex,
				maximumNodeNumber,
				nodeCount,
				edgeCount
		);
	}

	public class FrontStarItr implements Iterator<Edge> {
		@NotNull
		private final FrontStarGraph context;
		private int cursor = 0;

		public FrontStarItr(@NotNull FrontStarGraph context, int cursor) {
			this.context = context;
			this.cursor = cursor;
		}

		public FrontStarItr(@NotNull FrontStarGraph context) {
			this(context, 0);
		}

		@Override
		@Contract(pure = true)
		public boolean hasNext() {
			return cursor >= context.getAddedEdgeCount();
		}

		@Override
		@Nullable
		public Edge next() {
			if (!hasNext())
				throw new NoSuchElementException();
			Edge edge = new Edge(
					context.target[cursor],
					context.depart[cursor],
					context.value[cursor]
			);
			++cursor;
			return edge;
		}

		/**
		 * this graph doesn't support removing an edge.
		 *
		 * @deprecated it doesn't support this operation
		 */
		@Override
		@Deprecated
		public void remove() {
			throw GraphException.cannotRemove();
		}
	}

}

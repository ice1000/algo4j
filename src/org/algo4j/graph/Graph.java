package org.algo4j.graph;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;

/**
 * Created by ice1000 on 2017/1/8.
 *
 * @author ice1000
 */
public interface Graph extends
		Serializable,
		Cloneable {

	/**
	 * base add edge method
	 *
	 * @param from pos1
	 * @param to   pos2
	 * @param val  value from pos1 to pos2
	 */
	void addEdge(int from, int to, int val);

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
	default void addEdge(int p1, int p2, int p1p2, int p2p1) {
		addEdge(p1, p2, p1p2);
		addEdge(p2, p1, p2p1);
	}

	/**
	 * add an edge
	 *
	 * @param edge the edge
	 */
	default void addEdge(@NotNull Edge edge) {
		addEdge(edge.depart, edge.target, edge.value);
	}

	/**
	 * add two-direction edge
	 *
	 * @param p1  position1
	 * @param p2  position2
	 * @param val distance
	 */
	default void addDirectionlessEdge(int p1, int p2, int val) {
		addEdge(p1, p2, val, val);
	}

	/**
	 * add an directionless edge
	 *
	 * @param edge the edge
	 */
	default void addDirectionlessEdge(@NotNull Edge edge) {
		addDirectionlessEdge(
				edge.depart,
				edge.target,
				edge.value
		);
	}

}

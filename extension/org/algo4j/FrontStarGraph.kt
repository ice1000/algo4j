@file:JvmMultifileClass
@file:JvmName("Extension")

/**
 * Created by ice1000 on 2017/1/4.
 *
 * @author ice1000
 */
package org.algo4j

import org.algo4j.graph.FrontStarGraph
import org.jetbrains.annotations.Contract

@Contract(pure = false)
operator fun FrontStarGraph.set(from: Int, to: Int, value: Int) =
		addEdge(from, to, value)

@Contract(pure = false)
operator fun FrontStarGraph.set(from: Int, to: Int, value: Pair<Int, Int>) =
		addEdge(from, to, value.first, value.second)

@Contract(pure = true)
operator fun FrontStarGraph.get(from: Int, to: Int) =
		getEdges(from, to)


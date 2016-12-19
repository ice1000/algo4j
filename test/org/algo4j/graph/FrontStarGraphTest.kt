package org.algo4j.graph

import org.algo4j.util.SeqUtils
import org.junit.Assert.assertArrayEquals
import org.junit.Assert.assertEquals
import org.junit.BeforeClass
import org.junit.Test

/**
 * Created by ice1000 on 2016/11/18.

 * @author ice1000s
 */
class FrontStarGraphTest {

	/**
	 * data from codeVs
	 * http://codevs.cn/problem/2645
	 *
	 *
	 * 3 2 1 2 2 -1 2 3 0 1 0 0
	 *
	 *
	 * data from cwoj
	 *
	 *
	 * 3 3
	 * 1 2 -1
	 * 2 3 -1
	 * 3 1 -1
	 */
	@Test(timeout = 1000)
	fun spfaTest() {
		val graph = FrontStarGraph(3, 2 shl 1)
		graph.addEdge(1, 2, 2, -1)
		graph.addEdge(2, 3, 0, 1)
		val res = graph.spfa(1)
		println(SeqUtils.toString(res))
		assertEquals(2, res[3])

		val graph1 = FrontStarGraph(3, 3)
		graph1.addEdge(1, 2, -1)
		graph1.addEdge(2, 3, -1)
		graph1.addEdge(3, 1, -1)
		val res1 = graph1.spfa(1)
		println(SeqUtils.toString(res1))
		assertArrayEquals(intArrayOf(-1, -1, -1, -1), res1)
	}

	/**
	 * data from vijos:
	 * https://vijos.org/p/1190
	 * 4 5
	 * 1 2 3
	 * 1 4 5
	 * 2 4 7
	 * 2 3 6
	 * 3 4 8
	 */
	@Test(timeout = 1000)
	fun kruskalTest() {
		val graph = FrontStarGraph(4, 5 shl 1)
		graph.addDirectionlessEdge(1, 2, 3)
		graph.addDirectionlessEdge(1, 4, 5)
		graph.addDirectionlessEdge(2, 4, 7)
		graph.addDirectionlessEdge(2, 3, 6)
		graph.addDirectionlessEdge(3, 4, 8)
		assertEquals(14, graph.kruskal())
	}

	@Test(timeout = 1000)
	fun getEdgesTest() {
		val graph = FrontStarGraph(4, 5 shl 1)
		graph.addDirectionlessEdge(1, 2, 3)
		graph.addDirectionlessEdge(1, 2, 4)
		graph.addDirectionlessEdge(1, 2, 5)
		graph.addDirectionlessEdge(1, 4, 5)
		assertArrayEquals(intArrayOf(3, 4, 5), graph.getEdges(1, 2))
		assertArrayEquals(intArrayOf(5), graph.getEdges(1, 4))
	}

	@Test(timeout = 1000)
	fun dfsTest() {
		val graph = FrontStarGraph(4, 4 shl 1)
		graph.addDirectionlessEdge(1, 2, 3)
		graph.addDirectionlessEdge(1, 2, 4)
		graph.addDirectionlessEdge(1, 2, 5)
		graph.addDirectionlessEdge(1, 4, 5)
		var count = 0
		graph.dfs(1, 0, { edge, last ->
			count++
			return@dfs last + 1
		})
		assertEquals(graph.addedEdgeCount, count)
	}

	companion object Initializer {
		@BeforeClass
		@JvmStatic
		fun loadJniLibrary() {
			System.loadLibrary("jni")
		}
	}
}

package org.algo4j.graph

import org.algo4j.util.SequenceUtils
import org.junit.Assert.assertArrayEquals
import org.junit.Assert.assertEquals
import org.junit.BeforeClass
import org.junit.Test

/**
 * Created by algo4j on 2016/11/18.

 * @author algo4j
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
	@Test
	fun spfaTest() {
		val graph = FrontStarGraph(3, 2 shl 1)
		graph.addEdge(1, 2, 2, -1)
		graph.addEdge(2, 3, 0, 1)
		val res = graph.spfa(1)
		println(SequenceUtils.toString(res))
		assertEquals(2, res[3])

		val graph1 = FrontStarGraph(3, 3)
		graph1.addEdge(1, 2, -1)
		graph1.addEdge(2, 3, -1)
		graph1.addEdge(3, 1, -1)
		val res1 = graph1.spfa(1)
		println(SequenceUtils.toString(res1))
		assertArrayEquals(longArrayOf(-1, -1, -1, -1), res1)
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
	 * TODO
	 */
//	@Test
	fun kruskalTest() {
		val graph = FrontStarGraph(4, 5 shl 1)
		graph.addDirectionlessEdge(1, 2, 3)
		graph.addDirectionlessEdge(1, 4, 5)
		graph.addDirectionlessEdge(2, 4, 7)
		graph.addDirectionlessEdge(2, 3, 6)
		graph.addDirectionlessEdge(3, 4, 8)
		println("edges added.")
		assertEquals(6, graph.kruskal())
	}

	companion object Initializer {
		@BeforeClass
		@JvmStatic
		fun loadJniLibrary() {
			System.loadLibrary("jni")
		}
	}
}

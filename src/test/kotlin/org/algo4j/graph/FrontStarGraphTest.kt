package org.algo4j.graph

import org.algo4j.error.GraphException
import org.algo4j.get
import org.algo4j.set
import org.algo4j.test.forceRun
import org.algo4j.test.loop
import org.algo4j.test.optional
import org.algo4j.util.Loader
import org.algo4j.util.SeqUtils
import org.jetbrains.annotations.TestOnly
import org.junit.Assert.*
import org.junit.BeforeClass
import org.junit.Test
import java.util.*

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
	@TestOnly
	@Test(timeout = 2000)
	fun testSpfa() {
		val graph = FrontStarGraph(3, 2 shl 1)
		graph[1, 2] = Pair(2, -1)
		graph[2, 3] = Pair(0, 1)
		val res = graph.spfa(1)
		optional(false) {
			println(SeqUtils.toString(res))
		}
		assertEquals(2, res[3])

		val graph1 = FrontStarGraph(3, 3)
		graph1[1, 2] = -1
		graph1[2, 3] = -1
		graph1[3, 1] = -1
		try {
			graph1.spfa(1)
		} catch (e: GraphException) {
			println("exception successfully thrown!")
		} catch (e: Throwable) {
			fail("exception not caught!")
		} finally {
		}
	}

	@TestOnly
	@Test(timeout = 10)
	fun testFillingNum() {
		println(org.algo4j.graph.Graph.ORIGINAL_FILLING_VALUE)
	}

	@TestOnly
	@Test(timeout = 1000)
	fun testBellmanFord() {
		val edgeCount = 500
		val graph = FrontStarGraph(100, edgeCount)
		val rand = Random(System.currentTimeMillis())
		loop(edgeCount) {
			val from = rand.nextInt(95) + 1
			val to = rand.nextInt(95) + 1
			val value = rand.nextInt(233333)
			graph.addEdge(from, to, value)
		}
		optional(false) {
			graph
					.spfa(1)
					.map {
						println(it);
						return@map it
					}
					.toIntArray()
			println("")
			graph
					.bellmanFord(1)
					.map {
						println(it);
						return@map it
					}
					.toIntArray()
		}
		for (i in 2..98) {
			optional(false) {
				println(i)
			}
			forceRun {
				assertArrayEquals(
						graph.spfa(i),
						graph.bellmanFord(i)
				)
			}
		}
	}

	/**
	 * data from vijos:
	 * https://vijos.org/p/1190
	 *
	 * 4 5
	 * 1 2 3
	 * 1 4 5
	 * 2 4 7
	 * 2 3 6
	 * 3 4 8
	 */
	@TestOnly
	@Test(timeout = 5000)
	fun testKruskal() {
		val graph = FrontStarGraph(4, 5 shl 1)
		graph[1, 2] = 3
		graph[2, 1] = 3
		graph[1, 4] = 5
		graph[4, 1] = 5
		graph[2, 4] = 7
		graph[4, 2] = 7
		graph[2, 3] = 6
		graph[3, 2] = 6
		graph[3, 4] = 8
		graph[4, 3] = 8
		assertEquals(14, graph
				.kruskal()
				.valueSum
		)
	}

	@TestOnly
	@Test(timeout = 1000)
	fun testGetEdges() {
		val graph = FrontStarGraph(4, 5 shl 1)
		graph[1, 2] = 3
		graph[2, 1] = 3
		graph[1, 2] = 4
		graph[2, 1] = 4
		graph[1, 2] = 5
		graph[2, 1] = 5
		graph[1, 4] = 5
		graph[4, 1] = 5
		assertArrayEquals(intArrayOf(3, 4, 5), graph[1, 2])
		assertArrayEquals(intArrayOf(5), graph[1, 4])
	}

	@TestOnly
	@Test(timeout = 1000)
	fun testDfs() {
		val graph = FrontStarGraph(4, 4 shl 1)
		graph[1, 2] = 3
		graph[2, 1] = 3
		graph[1, 2] = 4
		graph[2, 1] = 4
		graph[1, 2] = 5
		graph[2, 1] = 5
		graph[1, 4] = 5
		graph[4, 1] = 5
		var count = 0
		graph.dfs(1, 0, { _, last ->
			count++
			return@dfs last + 1
		})
		assertEquals(graph.addedEdgeCount, count)
	}

	companion object Initializer {
		@BeforeClass
		@JvmStatic
		fun loadJniLibrary() = Loader.loadJni()
	}
}

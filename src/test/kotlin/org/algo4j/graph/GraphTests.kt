package org.algo4j.graph

import org.algo4j.get
import org.algo4j.test.loop
import org.algo4j.util.Loader
import org.jetbrains.annotations.TestOnly
import org.junit.Assert.assertEquals
import org.junit.BeforeClass
import org.junit.Test
import java.util.*

/**
 * Created by ice1000 on 2017/1/9.
 *
 * @author ice1000
 */
class GraphTests {

	/**
	 * test floyd and spfa
	 */
	@TestOnly
	@Test(timeout = 1000)
	fun testShortestPath() {
		val edgeCount = 500
		val rand = Random(System.currentTimeMillis())
		val spfa = FrontStarGraph(100, edgeCount)
		val floyd = AdjacentMatrixGraph(100)
		loop(edgeCount) {
			val from = rand.nextInt(95) + 1
			val to = rand.nextInt(95) + 1
			val value = rand.nextInt(233333)
			spfa.addEdge(from, to, value)
			floyd.addEdge(from, to, value)
		}
		val source = rand.nextInt(95) + 1
		val spfaRes = spfa.spfa(source)
		val floydRes = floyd.floyd()
		(1..99)
				.filter {
					floydRes[source, it] <= AdjacentMatrixGraph.ORIGINAL_FILLING_VALUE shr 1 &&
							spfaRes[it] <= FrontStarGraph.INFINITY shr 1
				}
				.forEach {
					assertEquals(
							spfaRes[it],
							floydRes[source, it]
					)
				}
	}

	@TestOnly
	@Test(timeout = 1000)
	fun testShortestPath2() {
		val edgeCount = 500
		val rand = Random(System.currentTimeMillis())
		val bellmanFord = FrontStarGraph(100, edgeCount)
		val dijkstra = AdjacentMatrixGraph(100)
		loop(edgeCount) {
			val from = rand.nextInt(95) + 1
			val to = rand.nextInt(95) + 1
			val value = rand.nextInt(233333)
			bellmanFord.addEdge(from, to, value)
			dijkstra.addEdge(from, to, value)
		}
		(2..98).forEach {
			val bellmanFordRes = bellmanFord.bellmanFord(it)
			val dijkstraRes = dijkstra.dijkstra(it)
			(1..99)
					.filter {
						bellmanFordRes[it] <= AdjacentMatrixGraph.ORIGINAL_FILLING_VALUE shr 1 &&
								dijkstraRes[it] <= FrontStarGraph.INFINITY shr 1
					}
					.forEach {
						assertEquals(
								bellmanFordRes[it],
								dijkstraRes[it]
						)
					}
		}
	}

	companion object Initializer {
		@JvmStatic
		@BeforeClass
		@TestOnly
		fun init() {
			System.loadLibrary(Loader.JNI_LIB_NAME)
		}
	}
}

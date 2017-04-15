package org.algo4j.graph

import org.algo4j.get
import org.algo4j.set
import org.algo4j.test.loop
import org.algo4j.test.optional
import org.algo4j.test.println
import org.algo4j.util.Loader
import org.algo4j.util.SeqUtils
import org.jetbrains.annotations.TestOnly
import org.junit.Assert.assertEquals
import org.junit.BeforeClass
import org.junit.Test
import java.util.*

/**
 * Created by ice1000 on 2017/1/8.

 * @author ice1000
 */
class AdjacentMatrixGraphTest {

	/**
	 * to prove my way of treating
	 * an one-dimension array as
	 * a two-dimension array is correct.
	 */
	@TestOnly
	@Test(timeout = 1000)
	fun testAddEdge() {
//		val graph = AdjacentMatrixGraph(1000)
//		val a = fun AdjacentMatrixGraph.(): IntArray {
//			return matrix
//		}
		val len = 100
		val value = 9
		val a = IntArray(len * len)
		val b = Array(len, { IntArray(len) })
		val rand = Random(System.currentTimeMillis())
		loop(300) {
			val r1 = rand.nextInt(len)
			val r2 = rand.nextInt(len)
			a[r1 * len + r2] += value
			b[r1][r2] += value
		}
		var idx = 0
		for (i in 0..len - 1) {
			for (j in 0..len - 1) {
				assertEquals(b[i][j], a[idx])
				++idx
			}
		}
	}

	@TestOnly
	@Test(timeout = 1000)
	fun testInit() {
		val len = 10
		val graph = AdjacentMatrixGraph(len)
		for (i in 0..len - 1) {
			assertEquals(0, graph[i, i])
		}
		optional(false) {
			graph.toString().println()
		}
	}

	@TestOnly
	@Test(timeout = 1000)
	fun testEasyFloyd() {
		val graph = AdjacentMatrixGraph(10)
		graph.addDirectionlessEdge(1, 3, 1)
		graph.addDirectionlessEdge(3, 5, 1)
		graph.addDirectionlessEdge(1, 5, 100)
		optional(false) {
			graph.toString().println()
		}
		val res = graph.floyd()
		optional(false) {
			res.toString().println()
		}
		assertEquals(2, res[1, 5])
	}

	@TestOnly
	@Test(timeout = 1000)
	fun testDijkstra() {
		val graph = AdjacentMatrixGraph(4)
		graph[1, 2] = Pair(2, -1)
		graph[2, 3] = Pair(0, 1)
		graph.dijkstra(1).apply {
			SeqUtils.toString(this).println()
		}
	}

	companion object Initializer {
		@JvmStatic
		@BeforeClass
		fun loadJniLib() {
//			Loader.load()
			Loader.loadJni()
		}
	}
}

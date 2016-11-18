package org.ice1000.graph;

import org.ice1000.util.ArrayUtils;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Created by ice1000 on 2016/11/18.
 *
 * @author ice1000
 */
public final class FrontStarGraphTest {
	@BeforeClass
	public static void loadJniLibrary() {
		System.loadLibrary("jni");
	}

	/**
	 * data from codeVs
	 * http://codevs.cn/problem/2645
	 * <p>
	 * 3 2 1 2 2 -1 2 3 0 1 0 0
	 * <p>
	 * data from cwoj
	 * <p>
	 * 3 3
	 * 1 2 -1
	 * 2 3 -1
	 * 3 1 -1
	 */
	@Test
	public void spfaTest() {
		FrontStarGraph graph = new FrontStarGraph(3, 2 << 1);
		graph.addEdge(1, 2, 2, -1);
		graph.addEdge(2, 3, 0, 1);
		long[] res = graph.spfa(1);
		System.out.println(ArrayUtils.toString(res));
		assertEquals(2, res[3]);

		FrontStarGraph graph1 = new FrontStarGraph(3, 3);
		graph1.addEdge(1, 2, -1);
		graph1.addEdge(2, 3, -1);
		graph1.addEdge(3, 1, -1);
		long[] res1 = graph1.spfa(1);
		System.out.println(ArrayUtils.toString(res1));
		assertArrayEquals(new long[]{-1, -1, -1, -1}, res1);
	}
}

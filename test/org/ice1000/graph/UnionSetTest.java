package org.ice1000.graph;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by ice1000 on 2016/11/19.
 *
 * @author ice1000
 */
public final class UnionSetTest {
	@BeforeClass
	public static void loadJniLibrary() {
		System.loadLibrary("jni");
	}

	/**
	 * data from:
	 * http://codevs.cn/problem/1073/
	 */
	@Test(timeout = 100)
	public void test() {
		UnionSet set = new UnionSet(6);
		set.merge(1, 2);
		set.merge(1, 5);
		set.merge(3, 4);
		set.merge(5, 2);
		set.merge(1, 3);
		assertTrue(set.isConnected(1, 4));
		assertTrue(set.isConnected(2, 3));
		assertFalse(set.isConnected(5, 6));
	}
}
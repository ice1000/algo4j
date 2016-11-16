package org.ice1000.bit;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by ice1000 on 2016/11/16.
 *
 * @author ice1000
 */
public final class BinaryIndexedTreeImplTest {

	@BeforeClass
	public static void loadJniLibrary() {
		System.loadLibrary("jni");
	}

	/**
	 * data from:
	 * http://www.codevs.cn/problem/1080/
	 */
	@Test(timeout = 10)
	public void test() {
		BinaryIndexedTreeImpl tree = new BinaryIndexedTreeImpl(10);
		tree.add(1, 4);
		tree.add(2, 5);
		tree.add(3, 6);
		tree.add(4, 2);
		tree.add(5, 1);
		tree.add(6, 3);
		tree.add(7, 4);
		tree.add(3, 5);
		assertEquals(14, tree.sum(3, 5));
		tree.add(1, 9);
		assertEquals(22, tree.sum(2, 6));
	}

}
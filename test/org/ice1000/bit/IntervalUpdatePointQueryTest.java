package org.ice1000.bit;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by ice1000 on 2016/11/16.
 *
 * @author ice1000
 */
public final class IntervalUpdatePointQueryTest {

	@BeforeClass
	public static void loadJniLibrary() {
		System.loadLibrary("jni");
	}

	/**
	 * test
	 */
	@Test(timeout = 100)
	public void test() {
		IntervalUpdatePointQuery tree = new IntervalUpdatePointQuery(30);
		tree.update(10, 20, 5);
		tree.update(15, 25, 15);
		assertEquals(20, tree.query(17));

		tree.update(1, 15, 1);
		assertEquals(6, tree.query(12));
	}

}

package org.ice1000.bit;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by ice1000 on 2016/11/16.
 *
 * @author ice1000
 */
public final class BinaryIndexedTreeImpl2Test {

	@BeforeClass
	public static void loadJniLibrary() {
		System.loadLibrary("jni");
	}

	/**
	 * data from:
	 * http://www.codevs.cn/problem/1081/
	 */
	@Test(timeout = 10)
	public void test() {
		BinaryIndexedTreeImpl2 tree = new BinaryIndexedTreeImpl2(10);
//		TODO
	}

}
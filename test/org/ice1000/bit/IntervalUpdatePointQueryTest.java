package org.ice1000.bit;

import org.junit.BeforeClass;
import org.junit.Test;

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

	@Test(timeout = 10)
	public void test() {
		IntervalUpdatePointQuery tree = new IntervalUpdatePointQuery(10);

	}

}

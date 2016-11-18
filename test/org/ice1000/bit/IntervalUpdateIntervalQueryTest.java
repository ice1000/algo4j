package org.ice1000.bit;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by ice1000 on 2016/11/18.
 *
 * @author ice1000
 */
public final class IntervalUpdateIntervalQueryTest {
	@BeforeClass
	public static void loadJniLibrary() {
		System.loadLibrary("jni");
	}

	/**
	 * data:
	 * http://www.codevs.cn/problem/1082/
	 */
	@Test
	public void test() {
		IntervalUpdateIntervalQuery bit =
				new IntervalUpdateIntervalQuery(3, 1, 2, 3, 2);
		bit.update(2, 3, 2);
		assertEquals(9, bit.query(2, 3));
	}
}

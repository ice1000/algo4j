package org.algo4j.util;

import org.jetbrains.annotations.TestOnly;
import org.junit.Test;

import static kotlin.test.AssertionsKt.assertTrue;
import static org.algo4j.util.ParallelQuickSorter.*;

public class MultiThreadingQuickSorterTest {
	@TestOnly
	@Test(timeout = 1000)
	public void test() {
		for (int i = 0; i < 10; ++i) {
			int[] a = new int[]{
					4, 233, 4, 3, 324, 423, 432, 432, 2, 432, 4, 32, 42442, 43, 234243, 43, 2, 4, 324, 23
			};
			MultiThreadingQuickSorterInt main = new MultiThreadingQuickSorterInt(a);
			main.forkJoinSort();
			int num = a.length - 2;
			for (int j = 0; j < num; ++j) {
				final int index = j;
				assertTrue(a[index] + ">" + a[index + 1], () -> a[index] <= a[index + 1]);
			}
		}
	}
}

package org.algo4j.util;

import org.junit.Test;

import static org.algo4j.util.ParallelQuickSorters.*;

public class MultiThreadingQuickSorterTest {
	@Test(timeout = 1000)
	public void test() {
		for (int i = 0; i < 10; ++i) {
			int[] a = new int[]{
					4, 233, 4, 3, 324, 423, 432, 432, 2, 432, 4, 32, 42442, 43, 234243, 43, 2, 4, 324, 23
			};
			MultiThreadingQuickSorterInt main = new MultiThreadingQuickSorterInt(a);
			main.forkJoinSort();
			int num = a.length - 2;
			for (int j = 0; j < num; ++j)
				if (a[j] > a[j + 1])
					throw new RuntimeException(a[j] + ">" + a[j + 1]);
		}
	}
}

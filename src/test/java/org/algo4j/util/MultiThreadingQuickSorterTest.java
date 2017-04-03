package org.algo4j.util;

import org.junit.Test;

public class MultiThreadingQuickSorterTest {
	@Test(timeout = 1000)
	public void test() {
		for (int i = 0; i < 10; i++) {
			int[] a = new int[]{
					4, 233, 4, 3, 324, 423, 432, 432, 2, 432, 4, 32, 42442, 43, 234243, 43, 2, 4, 324, 23
			};
			SeqUtils.MultiThreadingQuickSorterInt main = new SeqUtils.MultiThreadingQuickSorterInt(a);
			main.forkJoinSort();
			int num = a.length - 2;
			for (int i1 = 0; i1 < num; i1++)
				if (a[i1] > a[i1 + 1])
					throw new RuntimeException(a[i1] + ">" + a[i1 + 1]);
		}
	}
}

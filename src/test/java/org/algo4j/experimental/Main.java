package org.algo4j.experimental;

import org.junit.Test;

import static org.algo4j.util.SeqUtils.MultiThreadingQuickSorterInt;

public class Main {
	@Test
	public void test() {
		for (int i = 0; i < 10; i++) {
			MultiThreadingQuickSorterInt main = new MultiThreadingQuickSorterInt(new int[]{
					4, 233, 4, 3, 324, 423, 432, 432, 2, 432, 4, 32, 42442, 43, 234243, 43, 2, 4, 324, 23
			});
			main.forkJoinSort();
			main.checkSort();
		}
	}
}
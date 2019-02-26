package org.algo4j.tree.seg;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.BiFunction;

import static org.junit.Assert.*;

public class NonRecursiveSegmentTreeTest {

	@Test
	public void query() {
		/*
		 Minimum Recording
		 */
		SegmentTree<Integer> seg = new NonRecursiveSegmentTree<>(new Integer[]{5, 3, 2, 9, 7, 8, 6, 4}, Comparator.reverseOrder());
		assertEquals((int) seg.query(0, 2), 2);
		assertEquals((int) seg.query(1, 3), 2);
		/*
		 A Lambda Stands for `sum`
		 */
		seg = new NonRecursiveSegmentTree<>(new Integer[]{5, 3, 2, 9, 7, 8, 6, 4}, (BiFunction<Integer, Integer, Integer>) (a, b) -> a + b);
		assertEquals((int) seg.query(0, 2), 10);
		assertEquals((int) seg.query(1, 3), 14);
		assertEquals((int) seg.query(2, 6), 32);
	}

	@Test
	public void largerDataset() {
		SegmentTree<Integer> seg = new NonRecursiveSegmentTree<>
				(new Integer[]{5, 3, 2, 9, 7, 8, 6, 4, 6, 10, 25, 3, 7, -3, 5, 6},
						(BiFunction<Integer, Integer, Integer>) (a, b) -> a + b);
		assertEquals((int) seg.query(3, 10), 75);
	}

	@Test
	public void non2Pow() {
		SegmentTree<Integer> seg = new NonRecursiveSegmentTree<>
				(new Integer[]{5, 3, 2, 9, 7},
						(BiFunction<Integer, Integer, Integer>) (a, b) -> a + b);
		assertEquals((int) seg.query(2, 3), 11);
		seg = new NonRecursiveSegmentTree<>
				(new Integer[]{5, 3, 2, 9, 7, -3}, Comparator.naturalOrder());
		assertEquals((int) seg.query(2, 5), 9);
	}

	@Test
	public void testDefect() { /// probable defect (but wasn't actually existing)
		NonRecursiveSegmentTree<Integer> seg = new NonRecursiveSegmentTree<>
				(new Integer[]{5, 3, 2, 9, 7, 8, 10, 2, -1},
						(BiFunction<Integer, Integer, Integer>) (a, b) -> a + b);
		assertEquals((int) seg.query(2, 5), 26);
		seg = new NonRecursiveSegmentTree<>
				(new Integer[]{5, 3, 2, 9, 7, -3}, Comparator.naturalOrder());
		assertEquals((int) seg.query(2, 5), 9);
		seg = new NonRecursiveSegmentTree<>
				(new Integer[]{5, 3, 2, 9, 7, 8, 6, 4, 6, 10, 25, 3, 7, -3, 5, 6, 10},
						(BiFunction<Integer, Integer, Integer>) (a, b) -> a + b);
		seg.set(1, 5);
		seg.set(0, 7);
		assertEquals((int) seg.query(0, 10), 89);
	}


	@Test
	public void set() {
		/*
		 Minimum Recording
		 */
		SegmentTree<Integer> seg = new NonRecursiveSegmentTree<>(new Integer[]{5, 3, 2, 9, 7, 8, 6, 4}, Comparator.reverseOrder());
		seg.set(1, 2, 20);
		assertEquals((int) seg.query(0, 2), 5);
		assertEquals((int) seg.query(1, 3), 9);
		/*
		 A Lambda Stands for `sum`
		 */
		seg = new NonRecursiveSegmentTree<>(new Integer[]{5, 3, 2, 9, 7, 8, 6, 4}, (BiFunction<Integer, Integer, Integer>) (a, b) -> a + b);
		assertEquals((int) seg.query(0, 2), 10);
		seg.set(1, 3, 5);
		assertEquals((int) seg.query(1, 3), 15);
	}
}
package org.algo4j.tree.seg;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.BiFunction;

import static org.junit.Assert.*;

/**
 * Created by Phosphorus15 on 2019/2/23.
 *
 * @author Phosphorus15
 */
public class RecursiveSegmentTreeTest {

	@Test
	public void query() {
		/*
		 Minimum Recording
		 */
		SegmentTree<Integer> seg = new RecursiveSegmentTree<>(new Integer[]{5, 3, 2, 9, 7, 8}, Comparator.reverseOrder());
		assertEquals((int) seg.query(0, 2), 2);
		assertEquals((int) seg.query(1, 3), 2);
		/*
		 A Lambda Stands for `sum`
		 */
		seg = new RecursiveSegmentTree<>(new Integer[]{5, 3, 2, 9, 7, 8}, (BiFunction<Integer, Integer, Integer>) (a, b) -> a + b);
		assertEquals((int) seg.query(0, 2), 10);
		assertEquals((int) seg.query(1, 3), 14);
	}

	@Test
	public void set() {
		/*
		 Minimum Recording
		 */
		SegmentTree<Integer> seg = new RecursiveSegmentTree<>(new Integer[]{5, 3, 2, 9, 7, 8}, Comparator.reverseOrder());
		seg.set(1, 2, 20);
		assertEquals((int) seg.query(0, 2), 5);
		assertEquals((int) seg.query(1, 3), 9);
		/*
		 A Lambda Stands for `sum`
		 */
		seg = new RecursiveSegmentTree<>(new Integer[]{5, 3, 2, 9, 7, 8}, (BiFunction<Integer, Integer, Integer>) (a, b) -> a + b);
		assertEquals((int) seg.query(0, 2), 10);
		seg.set(1, 3, 5);
		assertEquals((int) seg.query(1, 3), 15);
	}

}

package org.algo4j.tree.seg;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.BiFunction;

import static org.junit.Assert.*;

/**
 * Created by Phosphorus15 on 2019/3/1.
 *
 * @author Phosphorus15
 */
public class DurableSegmentTreeTest {

	@Test
	public void set() {
		/*
		 Minimum Recording
		 */
		DurableSegmentTree<Integer> seg = new DurableSegmentTree<>(new Integer[]{5, 3, 2, 9, 7, 8}, Comparator.reverseOrder());
		seg.set(1, 2, 20);
		seg.set(3, 5, 2);
		assertEquals((int) seg.query(0, 2), 5);
		assertEquals((int) seg.query(1, 3, 0), 2); // historical reference
		/*
		 A Lambda Stands for `sum`
		 */
		seg = new DurableSegmentTree<>(new Integer[]{5, 3, 2, 9, 7, 8}, (BiFunction<Integer, Integer, Integer>) (a, b) -> a + b);
		seg.set(1, 3, 5);
		assertEquals((int) seg.query(0, 2), 15);
		seg.set(1, 3, 6);
		assertEquals((int) seg.query(1, 3), 18);
		assertEquals((int) seg.query(0, 3, 1), 20); // historical reference
		assertEquals(seg.getVariants(), 2);
	}

	@Test
	public void update() {
		/*
		 A Lambda Stands for `sum`
		 */
		DurableSegmentTree<Integer> seg = new DurableSegmentTree<>(new Integer[]{5, 3, 2, 9, 7, 8}, (BiFunction<Integer, Integer, Integer>) (a, b) -> a + b);
		seg.update(1, 3, (i) -> (i + 5)); // value update
		assertEquals((int) seg.query(0, 2), 20);
		seg.update(1, 3, (i) -> (i << 1));
		assertEquals((int) seg.query(1, 3), 58);
		assertEquals((int) seg.query(0, 3, 1), 34); // historical reference
		assertEquals(seg.getVariants(), 2);
	}
}

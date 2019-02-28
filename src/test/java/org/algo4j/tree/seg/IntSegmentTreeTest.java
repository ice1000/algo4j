package org.algo4j.tree.seg;

import org.algo4j.util.Loader;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Phosphorus15 on 2019/3/1.
 *
 * @author Phosphorus15
 */
public class IntSegmentTreeTest {

	@Before
	public void setupJNI() {
		Loader.loadJni();
	}

	@Test
	public void query() {
		/*
		 Minimum Recording
		 */
		SegmentTree<Integer> seg = new IntSegmentTree(IntSegmentTree.Mode.MIN, 5, 3, 2, 9, 7, 8, 6, 4);
		assertEquals((int) seg.query(0, 2), 2);
		assertEquals((int) seg.query(1, 3), 2);
		/*
		 A Lambda Stands for `sum`
		 */
		seg = new IntSegmentTree(5, 3, 2, 9, 7, 8, 6, 4);
		assertEquals((int) seg.query(0, 2), 10);
		assertEquals((int) seg.query(1, 3), 14);
		assertEquals((int) seg.query(2, 6), 32);
	}

	@Test
	public void set() {
		/*
		 Minimum Recording
		 */
		SegmentTree<Integer> seg = new IntSegmentTree(IntSegmentTree.Mode.MIN, 5, 3, 2, 9, 7, 8, 6, 4);
		seg.set(1, 2, 20);
		assertEquals((int) seg.query(0, 2), 5);
		assertEquals((int) seg.query(1, 3), 9);
		/*
		 A Lambda Stands for `sum`
		 */
		seg = new IntSegmentTree(5, 3, 2, 9, 7, 8, 6, 4);
		assertEquals((int) seg.query(0, 2), 10);
		seg.set(1, 3, 5);
		assertEquals((int) seg.query(1, 3), 15);
	}

}
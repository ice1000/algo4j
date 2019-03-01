package org.algo4j.math;

import org.algo4j.util.Loader;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class VectorTest {

	@Before
	public void loadNative() {
		Loader.loadJni();
	}

	@Test
	public void size() {
		Vector vector = new Vector(1, 3, 5, 7, 9);
		assertEquals(5, vector.size());
		vector.free(); // free allocated memory
	}

	@Test
	public void set() {
		Vector vector = new Vector(1, 3, 5, 7, 9);
		vector.set(2, Math.E);
		assertEquals(Math.E, vector.get(2), 1e-6);
		assertEquals(9, vector.get(4), 1e-6);
		vector.free();
	}

	@Test
	public void get() {
		Vector vector = new Vector(1, 3, 5, 7, 9);
		assertEquals(5, vector.get(2), 1e-6);
		assertEquals(9, vector.get(4), 1e-6);
		vector.free();
	}

	@Test
	public void add() {
		Vector vector = new Vector(1, 3, 5, 7, 9, 3.5);
		vector.set(2, Math.E);
		vector.add(Math.PI);
		assertEquals(Math.E + Math.PI, vector.get(2), 1e-6);
		assertEquals(9 + Math.PI, vector.get(4), 1e-6);
		vector.free();
	}

	@Test
	public void multiply() {
		Vector vector = new Vector(1, 3, 5, 7, 9, 3.5);
		vector.set(2, Math.E);
		vector.multiply(Math.PI);
		assertEquals(Math.E * Math.PI, vector.get(2), 1e-6);
		assertEquals(9 * Math.PI, vector.get(4), 1e-6);
		vector.free();
	}

	@Test
	public void add1() {
		Vector a = new Vector(1, 3, 5, 7, 9);
		Vector b = new Vector(2, 4, 6, 8, 10);
		a.add(b);
		assertEquals(new Vector(3, 7, 11, 15, 19), a);
		a.free();
		b.free();
	}

	@Test
	public void multiply1() {
		Vector a = new Vector(1, 3, 5, 7, 9);
		Vector b = new Vector(2, 4, 6, 8, 10);
		a.multiply(b);
		assertEquals(new Vector(2, 12, 30, 56, 90), a);
		a.free();
		b.free();
	}

	@Test
	public void product() {
		{ // vertical test
			Vector a = new Vector(1, 1);
			Vector b = new Vector(-1, 1);
			assertEquals(0, a.product(b), 1e-6);
			a.free();
			b.free();
		}
		{ // calculation test
			Vector a = new Vector(1, 3, 5, 7, 9);
			Vector b = new Vector(2, 4, 6, 8, 10);
			assertEquals(190, a.product(b), 1e-6);
			a.free();
			b.free();
		}
	}

	@Test
	public void testClone() {
		Vector b = new Vector(2, 4, 6, 8, 10);
		assertEquals(b, b.clone());
		b.free();
	}

}

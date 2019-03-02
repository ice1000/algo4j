package org.algo4j.math;

import org.algo4j.util.Loader;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MatrixTest {

	@Before
	public void loadNative() {
		Loader.loadJni();
	}

	@Test
	public void get() {
		Matrix matrix = new Matrix(3, 2, 1, 2, 3, 4, 5, 6);
		assertEquals(4, matrix.get(1, 1), 1e-6);
	}

	@Test
	public void set() {
		Matrix matrix = new Matrix(3, 2, 1, 2, 3, 4, 5, 6);
		matrix.set(2, 1, Math.PI * 2);
		assertEquals(Math.PI * 2, matrix.get(2, 1), 1e-6);
	}

	@Test
	public void transpose() {
		Matrix matrix = new Matrix(3, 2, 1, 2, 3, 4, 5, 6);
		Matrix trans = matrix.transpose();
		for (int i = 0; i < matrix.getColumnSize(); i++)
			for (int j = 0; j < matrix.getRowSize(); j++)
				assertEquals(matrix.get(i, j), trans.get(j, i), 1e-6);
	}

	@Test
	public void multiply() {
		Matrix a = new Matrix(5, 3, 0.275730, 0.674468, 0.386208
				, 0.132630, 0.208685, 0.526163
				, 0.500467, 0.651249, 0.800412
				, 0.413208, 0.097403, 0.976631
				, 0.670800, 0.522297, 0.477311);
		Matrix b = new Matrix(3, 4, 0.9250307, 0.1605670, 0.2812281, 0.2752695
				, 0.0697600, 0.9860913, 0.6392873, 0.0011043
				, 0.6803276, 0.5821460, 0.1797959, 0.8617866);
		Matrix d = new Matrix(5, 4, 0.56486, 0.93419, 0.57816, 0.40947
				, 0.49521, 0.53338, 0.26531, 0.49018
				, 1.05292, 1.18851, 0.70099, 0.82827
				, 1.05345, 0.73094, 0.35407, 0.95550
				, 0.98167, 0.90061, 0.60836, 0.59657);
		Matrix c = a.multiply(b);
		for (int i = 0; i < c.getColumnSize(); i++)
			for (int j = 0; j < c.getRowSize(); j++)
				assertEquals(d.get(i, j), c.get(i, j), 1e-5);
	}

	@Test
	public void invert() {
		/// this has not been implemented (I donno want to write elimination QAQ)
	}

	@Test
	public void determinant() {
		Matrix matrix = new Matrix(3, 3, 0.40369, 0.20153, 0.26441
				, 0.31985, 0.89547, 0.13681
				, 0.95652, 0.30882, 0.51028);
		assertEquals(-0.039473, matrix.determinant(), 1e-6);
		matrix = new Matrix(5, 5, 0.404526, 0.205084, 0.961041, 0.758535, 0.555151
				, 0.103887, 0.774324, 0.145928, 0.521567, 0.870215
				, 0.622476, 0.177125, 0.738509, 0.420508, 0.073294
				, 0.738376, 0.932024, 0.198226, 0.866489, 0.426019
				, 0.582799, 0.229735, 0.222221, 0.944432, 0.135883);
		assertEquals(-0.028243, matrix.determinant(), 1e-6);
	}
}

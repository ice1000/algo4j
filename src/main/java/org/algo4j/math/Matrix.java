package org.algo4j.math;

import org.algo4j.error.MatrixException;

/**
 * Matrix is composed of several Vectors ! (vectory !!!) Use Matrices wisely and it will become your best friend (one of).
 * <p>
 * Created by Phosphorus15 on 2019/3/1
 *
 * @author Phosphorus15
 */
@SuppressWarnings("WeakerAccess")
public class Matrix implements AutoCloseable, Cloneable {

	private long pointer;

	private final int m;

	private final int n;

	/**
	 * Initialize matrix with a double array, it would be folded in the form of rows
	 * <p>
	 * If not enough doubles was provided, no initialization would be done
	 *
	 * @param m    the column size (how many rows) of matrix
	 * @param n    the row size (how many columns) of matrix
	 * @param data initial data
	 */
	public Matrix(int m, int n, double... data) {
		this.m = m;
		this.n = n;
		this.pointer = newMatrix(m, n);
		if (data.length == m * n)
			for (int i = 0; i < m; i++)
				for (int j = 0; j < n; j++)
					set(i, j, data[i * n + j]);
	}

	private Matrix(int m, int n, long pointer) {
		this.pointer = pointer;
		this.m = m;
		this.n = n;
	}

	/**
	 * @return size of a row
	 */
	public int getRowSize() {
		return n;
	}

	/**
	 * @return size of a column
	 */
	public int getColumnSize() {
		return m;
	}

	public double get(int x, int y) {
		return get(pointer, x, y);
	}

	public void set(int x, int y, double value) {
		set(pointer, x, y, value);
	}

	public Matrix transpose() {
		return new Matrix(n, m, transpose(this.pointer));
	}

	public Matrix multiply(Matrix o) {
		return new Matrix(m, o.n, multiply(this.pointer, o.pointer));
	}

	/**
	 * Not implemented, DO NOT INVOKE!
	 *
	 * @return the inverse of current matrix
	 */
	public Matrix invert() {
		if (m != n) throw new MatrixException("Provided matrix is non-invertible");
		throw new UnsupportedOperationException("This has not been implemented");
	}

	/**
	 * Note that this implementation is very slow and takes up a lot memory.
	 * <p>
	 * TODO gonna fix it fatherly (with invert methods)
	 *
	 * @return determinant of this matrix
	 */
	public double determinant() {
		return determinant(this.pointer);
	}

	private static native long newMatrix(int m, int n);

	private static native long makeClone(long pointer);

	private native double get(long pointer, int x, int y);

	private native void set(long pointer, int x, int y, double value);

	private native long transpose(long pointer);

	private native long invert(long pointer);

	private native long multiply(long dest, long source);

	private native double determinant(long pointer);

	private native long free(long pointer);

	@Override
	public void close() {
		free(this.pointer);
	}

	@Override
	@SuppressWarnings("all")
	public Matrix clone() {
		return new Matrix(m, n, this.pointer);
	}

	@Override
	public int hashCode() {
		int init = m ^ n;
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
				init ^= Double.hashCode(get(i, j));
		return init;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Matrix) {
			if (m != ((Matrix) obj).m || n != ((Matrix) obj).n) return false;
			for (int i = 0; i < m; i++)
				for (int j = 0; j < n; j++)
					if (Math.abs(get(i, j) - ((Matrix) obj).get(i, j)) < 1e-6) return false;
		} else return false;
		return true;
	}
}

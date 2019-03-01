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
public class Matrix {

	private long pointer;

	private final int m;

	private final int n;

	public Matrix(int m, int n) {
		this.m = m;
		this.n = n;
		this.pointer = newMatrix(m, n);
	}

	private Matrix(long pointer) {
		this.pointer = pointer;
		m = getColumnSize();
		n = getRowSize();
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
		return new Matrix(transpose(this.pointer));
	}

	public Matrix multiply(Matrix o) {
		return new Matrix(multiply(this.pointer, o.pointer));
	}

	public Matrix invert() {
		if (m != n) throw new MatrixException("Provided matrix is non-invertible");
		return new Matrix(invert(this.pointer));
	}

	/**
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

	private native void getRowSize(long pointer);

	private native void getColumnSize(long pointer);

	private native double determinant(long pointer);

	private native long free(long pointer);

}

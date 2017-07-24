package org.algo4j.linear;

import org.algo4j.util.MatrixCaster;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;
import org.nd4j.linalg.ops.transforms.Transforms;

/**
 * Matrix class.
 *
 * @author Ray Eldath
 * @since 1.0.6
 */

@SuppressWarnings("unused")
public class Matrix {
	private INDArray data;

	public Matrix(int[][] data) {
		this.data = Nd4j.create(MatrixCaster.cast(data));
	}

	public Matrix(float[][] data) {
		this.data = Nd4j.create(data);
	}

	public Matrix(double[][] data) {
		this.data = Nd4j.create(data);
	}

	Matrix(INDArray array) {
		this.data = array;
	}

	public INDArray nativeData() {
		return data;
	}

	public Matrix addEach(int n) {
		return new Matrix(data.add(n));
	}

	public Matrix multiplyEach(int n) {
		return new Matrix(data.mul(n));
	}

	public Matrix minusEach(int n) {
		return new Matrix(data.subi(n));
	}

	public Matrix divideEach(int n) {
		return new Matrix(data.divi(n));
	}

	public Matrix add(ColumnVector vector) {
		return new Matrix(data.add(vector.nativeData()));
	}

	public Matrix add(RowVector vector) {
		return new Matrix(data.add(vector.nativeData()));
	}

	public Matrix multiply(ColumnVector vector) {
		return new Matrix(data.mul(vector.nativeData()));
	}

	public Matrix multiply(RowVector vector) {
		return new Matrix(data.mul(vector.nativeData()));
	}

	public Matrix minus(ColumnVector vector) {
		return new Matrix(data.sub(vector.nativeData()));
	}

	public Matrix minus(RowVector vector) {
		return new Matrix(data.sub(vector.nativeData()));
	}

	public Matrix divide(ColumnVector vector) {
		return new Matrix(data.div(vector.nativeData()));
	}

	public Matrix divide(RowVector vector) {
		return new Matrix(data.div(vector.nativeData()));
	}

	public Matrix sigmoid() {
		return new Matrix(Transforms.sigmoid(data));
	}

	public Matrix tanh() {
		return new Matrix(Transforms.tanh(data));
	}

	public Matrix abs() {
		return new Matrix(Transforms.abs(data));
	}

	public Matrix sqrt() {
		return new Matrix(Transforms.sqrt(data));
	}

	public Matrix exp() {
		return new Matrix(Transforms.exp(data));
	}

	public Matrix transpose() {
		return new Matrix(data.transpose());
	}

	public Matrix reshape(int rowN, int columnN) {
		return new Matrix(data.reshape(rowN, columnN));
	}

	public double get(int row, int column) {
		return data.getDouble(row, column);
	}

	public double[][] cast() {
		return MatrixCaster.cast(this);
	}

	@Override
	public String toString() {
		return "Matrix{" +
				"data=" + data.toString() +
				'}';
	}
}

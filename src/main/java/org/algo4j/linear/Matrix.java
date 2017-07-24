package org.algo4j.linear;

import org.algo4j.util.MatrixCaster;
import org.jetbrains.annotations.NotNull;
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

	public Matrix(@NotNull int[][] data) {
		this.data = Nd4j.create(MatrixCaster.cast(data));
	}

	public Matrix(@NotNull float[][] data) {
		this.data = Nd4j.create(data);
	}

	public Matrix(@NotNull double[][] data) {
		this.data = Nd4j.create(data);
	}

	Matrix(@NotNull INDArray array) {
		this.data = array;
	}

	@NotNull
	public INDArray nativeData() {
		return data;
	}

	@NotNull
	public Matrix addEach(int n) {
		return new Matrix(data.add(n));
	}

	@NotNull
	public Matrix multiplyEach(int n) {
		return new Matrix(data.mul(n));
	}

	@NotNull
	public Matrix minusEach(int n) {
		return new Matrix(data.subi(n));
	}

	@NotNull
	public Matrix divideEach(int n) {
		return new Matrix(data.divi(n));
	}

	@NotNull
	public Matrix add(@NotNull ColumnVector vector) {
		return new Matrix(data.add(vector.nativeData()));
	}

	@NotNull
	public Matrix add(@NotNull RowVector vector) {
		return new Matrix(data.add(vector.nativeData()));
	}

	@NotNull
	public Matrix multiply(@NotNull ColumnVector vector) {
		return new Matrix(data.mul(vector.nativeData()));
	}

	@NotNull
	public Matrix multiply(@NotNull RowVector vector) {
		return new Matrix(data.mul(vector.nativeData()));
	}

	@NotNull
	public Matrix minus(@NotNull ColumnVector vector) {
		return new Matrix(data.sub(vector.nativeData()));
	}

	@NotNull
	public Matrix minus(@NotNull RowVector vector) {
		return new Matrix(data.sub(vector.nativeData()));
	}

	@NotNull
	public Matrix divide(@NotNull ColumnVector vector) {
		return new Matrix(data.div(vector.nativeData()));
	}

	@NotNull
	public Matrix divide(@NotNull RowVector vector) {
		return new Matrix(data.div(vector.nativeData()));
	}

	@NotNull
	public Matrix sigmoid() {
		return new Matrix(Transforms.sigmoid(data));
	}

	@NotNull
	public Matrix tanh() {
		return new Matrix(Transforms.tanh(data));
	}

	@NotNull
	public Matrix abs() {
		return new Matrix(Transforms.abs(data));
	}

	@NotNull
	public Matrix sqrt() {
		return new Matrix(Transforms.sqrt(data));
	}

	@NotNull
	public Matrix exp() {
		return new Matrix(Transforms.exp(data));
	}

	@NotNull
	public Matrix transpose() {
		return new Matrix(data.transpose());
	}

	@NotNull
	public Matrix reshape(int rowN, int columnN) {
		return new Matrix(data.reshape(rowN, columnN));
	}

	public double get(int row, int column) {
		return data.getDouble(row, column);
	}

	@NotNull
	public double[][] cast() {
		return MatrixCaster.cast(this);
	}

	@Override
	@NotNull
	public String toString() {
		return "Matrix{data=" + data.toString() + "}";
	}
}

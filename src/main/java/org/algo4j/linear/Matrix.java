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

	public Matrix() {
		this.data = Nd4j.create();
	}

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
	public Matrix addEach(Number n) {
		return new Matrix(data.add(n));
	}

	@NotNull
	public Matrix multiplyEach(Number n) {
		return new Matrix(data.mul(n));
	}

	@NotNull
	public Matrix minusEach(Number n) {
		return new Matrix(data.subi(n));
	}

	@NotNull
	public Matrix divideEach(Number n) {
		return new Matrix(data.divi(n));
	}

	@NotNull
	public Matrix accumulate(@NotNull Matrix matrix) {
		return new Matrix(data.add(matrix.nativeData()));
	}

	@NotNull
	public Matrix accumulate(@NotNull ColumnVector vector) {
		return new Matrix(data.add(vector.nativeData()));
	}

	@NotNull
	public Matrix accumulate(@NotNull RowVector vector) {
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
	public Matrix multiply(@NotNull Matrix matrix) {
		return new Matrix(data.mul(matrix.nativeData()));
	}

	@NotNull
	public Matrix minus(@NotNull Matrix matrix) {
		return new Matrix(data.sub(matrix.nativeData()));
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
	public Matrix dot(@NotNull Matrix in) {
		return new Matrix(data.mmul(in.nativeData()));
	}

	@NotNull
	public Matrix sigmoid() {
		return new Matrix(Transforms.sigmoid(data));
	}

	@NotNull
	public Matrix tan() {
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

	@NotNull
	public Matrix negative() {
		return new Matrix(data.neg());
	}

	@NotNull
	public int[] shape() {
		return data.shape();
	}

	public double sum() {
		return (double) data.sumNumber();
	}

	public double get(int row, int column) {
		return data.getDouble(row, column);
	}

	public int rowN() {
		return data.rows();
	}

	public int columnN() {
		return data.columns();
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

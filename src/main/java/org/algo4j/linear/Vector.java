package org.algo4j.linear;

import org.jetbrains.annotations.NotNull;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;

abstract class Vector {
	INDArray array;

	Vector(boolean isColumnVector, @NotNull double[] data) {
		int n = data.length;
		array = isColumnVector ?
				Nd4j.create(data, new int[]{n, 1}) :
				Nd4j.create(data, new int[]{n});
	}

	Vector(@NotNull Matrix in, int dimension) {
		// pass.
	}

	public abstract double[] toArray();

	public abstract Matrix toMatrix();

	Vector(@NotNull INDArray data) {
		this.array = data;
	}

	public Matrix dot(@NotNull ColumnVector in) {
		return new Matrix(nativeData().mmul(in.nativeData()));
	}

	public int[] shape() {
		return array.shape();
	}

	INDArray nativeData() {
		return array;
	}
}

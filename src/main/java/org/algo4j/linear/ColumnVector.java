package org.algo4j.linear;

import org.jetbrains.annotations.NotNull;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;

@SuppressWarnings({"WeakerAccess", "unused"})
public class ColumnVector extends Vector {
	public ColumnVector(@NotNull double[] data) {
		super(true, data);
	}

	public ColumnVector(@NotNull Matrix in, int dimension) {
		super(in, dimension);
		int L = in.rowN();
		double[] data = new double[L];
		for (int i = 0; i < L; i++)
			data[i] = in.nativeData().getDouble(1, i);
		array = Nd4j.create(data);
	}

	ColumnVector(@NotNull INDArray data) {
		super(data);
	}

	@NotNull
	public RowVector toRowVector() {
		return new RowVector(toArray());
	}

	@Override
	@NotNull
	public Matrix toMatrix() {
		double[] array = toArray();
		int L = array.length;
		double[][] data = new double[L][1];
		for (int i = 0; i < L; i++)
			data[i][1] = array[i];
		return new Matrix(data);
	}

	@Override
	@NotNull
	public double[] toArray() {
		int L = nativeData().rows();
		double[] data = new double[L];
		for (int i = 0; i < L; i++)
			data[i] = nativeData().getDouble(0, i);
		return data;
	}

	public int columnN() {
		return nativeData().columns();
	}
}

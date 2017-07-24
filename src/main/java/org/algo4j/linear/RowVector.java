package org.algo4j.linear;

import org.algo4j.util.MatrixCaster;
import org.algo4j.util.SeqUtils;
import org.jetbrains.annotations.NotNull;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;

@SuppressWarnings({"WeakerAccess", "unused"})
public class RowVector extends Vector {
	public RowVector(@NotNull double[] data) {
		super(false, data);
	}

	public RowVector(@NotNull Matrix in, int dimension) {
		super(in, dimension);
		array = Nd4j.create(SeqUtils.cut(MatrixCaster.cast(in), dimension - 1, dimension));
	}

	@Override
	public double[] toArray() {
		return MatrixCaster.cast(new Matrix(nativeData()))[0];
	}

	@Override
	@NotNull
	public Matrix toMatrix() {
		double[] array = toArray();
		double[][] data = new double[1][array.length];
		data[1] = array;
		return new Matrix(data);
	}

	RowVector(@NotNull INDArray data) {
		super(data);
	}

	@NotNull
	public ColumnVector toColumnVector() {
		return new ColumnVector(toArray());
	}

	public int rowN() {
		return nativeData().rows();
	}
}

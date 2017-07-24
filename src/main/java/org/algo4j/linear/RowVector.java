package org.algo4j.linear;

import org.algo4j.util.MatrixCaster;

@SuppressWarnings({"WeakerAccess", "unused"})
public class RowVector extends Vector {
	public RowVector(double[] data) {
		super(false, data);
	}

	public ColumnVector toColumnVector() {
		return new ColumnVector(MatrixCaster.cast(new Matrix(nativeData()))[0]);
	}
}

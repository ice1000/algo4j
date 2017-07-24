package org.algo4j.linear;

@SuppressWarnings({"WeakerAccess", "unused"})
public class ColumnVector extends Vector {
	public ColumnVector(double[] data) {
		super(true, data);
	}

	public RowVector toRowVector() {
		int L = nativeData().rows();
		double[] data = new double[L];
		for (int i = 0; i < L; i++)
			data[i] = nativeData().getDouble(0, i);
		return new RowVector(data);
	}
}

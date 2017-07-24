package org.algo4j.linear;

import org.algo4j.util.MatrixCaster;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings({"WeakerAccess", "unused"})
public class RowVector extends Vector {
	public RowVector(@NotNull double[] data) {
		super(false, data);
	}

	@NotNull
	public ColumnVector toColumnVector() {
		return new ColumnVector(MatrixCaster.cast(new Matrix(nativeData()))[0]);
	}
}

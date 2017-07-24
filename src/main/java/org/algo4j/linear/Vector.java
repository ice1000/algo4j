package org.algo4j.linear;

import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;

class Vector {
	private INDArray array;

	Vector(boolean isColumnVector, double[] data) {
		int n = data.length;
		array = isColumnVector ?
				Nd4j.create(data, new int[]{n, 1}) :
				Nd4j.create(data, new int[]{n});
	}

	INDArray nativeData() {
		return array;
	}
}

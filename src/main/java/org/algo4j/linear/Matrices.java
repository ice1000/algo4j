package org.algo4j.linear;

import org.nd4j.linalg.factory.Nd4j;

public class Matrices {
	private Matrices() {
		throw new Error("do not instantiation me");
	}

	public static Matrix zeroes(int rowN, int columnN) {
		return new Matrix(Nd4j.zeros(rowN, columnN));
	}

	public static Matrix zeroes(int[] shape) {
		return zeroes(shape[0], shape[1]);
	}
}

package org.algo4j.util;

import org.algo4j.linear.Matrix;
import org.nd4j.linalg.api.ndarray.INDArray;

public class MatrixCaster {
	private MatrixCaster() {
		throw new Error("do not instantiation me");
	}

	public static float[][] cast(int[][] in) {
		int inL = in.length;
		float[][] out = new float[inL][in[0].length];

		for (int i = 0; i < inL; i++) {
			int[] n = in[i];
			for (int j = 0; j < n.length; j++)
				out[i][j] = n[j];
		}

		return out;
	}

	public static double[][] cast(Matrix inM) {
		INDArray in = inM.nativeData();
		int l = in.length();
		double[][] out = new double[l][in.size(0)];
		for (int i = 0; i < l; i++) {
			int n = in.size(i);
			for (int j = 0; j < n; j++)
				out[i][j] = in.getDouble(i, j);
		}
		return out;
	}
}

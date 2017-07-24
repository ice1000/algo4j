package org.algo4j.dl;

import org.algo4j.linear.Matrices;
import org.algo4j.linear.Matrix;
import org.algo4j.linear.RowVector;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.algo4j.util.SeqUtils.*;

/**
 * Implements the SGD algorithm.
 * <p>
 * <strong>* Not optimized, and omits many desirable features.</strong>
 * <p>
 * Part of code copied from
 * <a href="https://github.com/mnielsen/neural-networks-and-deep-learning/blob/master/src/network.py">
 * neural-networks-and-deep-learning</a> under MIT license.
 *
 * @author Ray Eldath
 * @since 1.0.6
 */
public class BasicSGD {
	private int layerN;
	@SuppressWarnings("FieldCanBeLocal")
	private int[] sizes;

	private RowVector[] biases;
	private Matrix[] weights;

	/**
	 * @param sizes contains the number of neurons in the
	 *              respective layers of the network. For example, if the list
	 *              was [2, 3, 1] then it would be a three-layer network, with the
	 *              first layer containing 2 neurons, the second layer 3 neurons,
	 *              and the third layer 1 neuron.
	 */
	public BasicSGD(int[] sizes) {
		Random random = new Random();
		this.layerN = sizes.length;
		this.sizes = sizes;

		int t = 0, tt = 0;
		for (int i = 1; i < layerN; i++)
			t += sizes[i];
		for (int i = 0; i < layerN - 1; i++)
			tt += sizes[i];

		this.biases = new RowVector[t];
		double[] dataTemp = new double[t];
		for (int i = 0; i < t; i++) {
			for (int j = 0; j < t; j++)
				dataTemp[j] = random.nextGaussian();
			this.biases[i] = new RowVector(dataTemp);
		}

		double[][] dataTmp = new double[tt][t];
		for (int i = 0; i < tt; i++)
			for (int j = 0; j < t; j++)
				dataTmp[i][j] = random.nextGaussian();

		this.weights = new Matrix[this.layerN];
		for (int i = 0; i < this.layerN; i++)
			this.weights[i] = new Matrix(dataTmp);
	}

	/**
	 * @param trainingData  data to training. Array of tuples {@code (double x, double y)}
	 * @param epoch         the number of epochs
	 * @param miniBatchSize the size of each mini-batch
	 * @param eta           the learning rate
	 */
	public void SGD(Pair<Double, Double>[] trainingData, int epoch, int miniBatchSize, int eta) {
		int N = trainingData.length;

		for (int i = 0; i < epoch; i++) {
			List<Pair<Double, Double>[]> miniBatches = new ArrayList<>();
			shuffle(trainingData);
			for (int k : new org.algo4j.util.Range(0, N, miniBatchSize))
				miniBatches.add(cut(trainingData, k, k + miniBatchSize));
			for (Pair<Double, Double>[] miniBatch : miniBatches)
				updateMiniBatch(miniBatch, eta);
		}
	}

	private void updateMiniBatch(Pair<Double, Double>[] miniBatch, int eta) {
		int N = miniBatch.length;
		int bL = this.biases.length;
		int wL = this.weights.length;
		Matrix[] nablaB = new Matrix[bL];
		Matrix[] nablaW = new Matrix[wL];

		int i = 0;
		for (RowVector b : this.biases)
			nablaB[i++] = Matrices.zeroes(b.shape());
		i = 0;
		for (Matrix m : this.weights)
			nablaW[i++] = Matrices.zeroes(m.shape());

		for (Pair<Double, Double> pair : miniBatch) {
			Matrix[] deltaNablaB = backprop(pair.A(), pair.B()).A(),
					deltaNablaW = backprop(pair.A(), pair.B()).B();

			i = 0;
			for (int o = 0; o < bL; o++)
				nablaB[o] = nablaB[o].accumulate(deltaNablaB[i++]);
			i = 0;
			for (int o = 0; o < bL; o++)
				nablaW[o] = nablaW[o].accumulate(deltaNablaW[i++]);
		}
		int f = 0;
		for (Pair<Matrix, Matrix> pair : zip(this.weights, nablaW))
			this.weights[f++] = pair.A().minus(pair.B().multiplyEach(eta / N));

		f = 0;
		for (Pair<RowVector, Matrix> pair : zip(this.biases, nablaB))
			this.weights[f++] = pair.A().toMatrix().minus(pair.B().multiplyEach(eta / N));
	}

	private Pair<Matrix[], Matrix[]> backprop(double x, double y) {
		int bL = this.biases.length;
		int wL = this.weights.length;
		Matrix[] nablaB = new Matrix[bL];
		Matrix[] nablaW = new Matrix[wL];

		int i = 0;
		for (RowVector thisBiase : this.biases)
			nablaB[i++] = Matrices.zeroes(1, thisBiase.rowN());
		i = 0;
		for (Matrix thisWeight : weights)
			nablaW[i++] = Matrices.zeroes(thisWeight.rowN(), thisWeight.columnN());
		List<Matrix> zs = new ArrayList<>();
		List<Double> activations = new ArrayList<>();
		activations.add(x);
		double activation = x;

		Matrix z;
		for (Pair<RowVector, Matrix> pairs : zip(this.biases, this.weights)) {
			z = pairs.B().multiplyEach(activation);
			zs.add(z);
			activation = sigmoid(z);
			activations.add(activation);
		}
		Matrix delta = cost(sigmoidPrime(lastOf(zs, 1).multiplyEach(lastOf(activations, 1))), y);
		nablaB[bL - 1] = delta;
		nablaW[wL - 1] = customDot(activations, delta);

		for (int l = 2; l < this.layerN; i++) {
			z = lastOf(zs, 1);
			Matrix sp = sigmoidPrime(z);
			delta = this.weights[this.weights.length - l + 1].transpose().dot(delta).multiply(sp);
			nablaB[bL - l] = delta;
			nablaW[wL - l] = customDot(activations, delta);
		}
		return new Pair<>(nablaB, nablaW);
	}

	private Matrix customDot(List<Double> doubles, Matrix matrix) {
		return matrix.dot(new RowVector(unbox(cut(
				doubles.toArray(new Double[]{}), 0, doubles.size() - 2))).toMatrix().transpose()
		);
	}

	private <T> T lastOf(List<T> in, int lastNum) {
		int N = in.size();
		return in.get(N - lastNum);
	}

	private double[] unbox(Double[] in) {
		int L = in.length;
		double[] out = new double[L];
		for (int i = 0; i < L; i++)
			out[i] = in[i];
		return out;
	}

	private Matrix cost(Matrix outActivations, double y) {
		return outActivations.minusEach(y);
	}

	private double sigmoid(Matrix z) {
		return z.sigmoid().sum();
	}

	private Matrix sigmoidPrime(Matrix z) {
		Matrix sigmoid = z.sigmoid();
		return z.sigmoid().multiply(sigmoid.minusEach(1).negative());
	}
}

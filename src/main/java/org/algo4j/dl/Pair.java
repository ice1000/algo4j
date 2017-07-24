package org.algo4j.dl;

public class Pair<X, Y> {
	private X A;
	private Y B;

	public Pair(X a, Y b) {
		A = a;
		B = b;
	}

	public X A() {
		return A;
	}

	public Y B() {
		return B;
	}
}

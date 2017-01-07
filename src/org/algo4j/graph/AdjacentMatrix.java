package org.algo4j.graph;

import org.algo4j.error.FrontStarGraphException;
import org.algo4j.math.MathUtils;
import org.algo4j.util.SeqUtils;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * Created by ice1000 on 2017/1/8.
 *
 * @author ice1000
 */
public final class AdjacentMatrix implements Graph {

	public final int length;
	private final int[] matrix;

	@SuppressWarnings("WeakerAccess")
	public static final int ORIGINAL_FILLING_VALUE = Integer.MAX_VALUE >> 1;

	@Contract(pure = true)
	public AdjacentMatrix(int length) {
		this.length = length;
		matrix = new int[length * length];
		for (int i = 0; i < matrix.length; i++) {
			matrix[i] = i % length == i / length
					? 0
					: ORIGINAL_FILLING_VALUE;
		}
	}

	private AdjacentMatrix(@NotNull int[] matrix) {
		this.matrix = matrix;
		this.length = ((int) MathUtils.sqrt(matrix.length));
	}

	@Override
	@NotNull
	@Contract(value = " -> !null", pure = true)
	public AdjacentMatrix clone() {
		return new AdjacentMatrix(SeqUtils.copy(matrix));
	}

	@NotNull
	@Contract(value = " -> !null", pure = true)
	public AdjacentMatrix floyd() {
		return new AdjacentMatrix(floyd(matrix));
	}

	@NotNull
	@Contract(pure = true)
	private static native int[] floyd(@NotNull int[] origin);

	@Override
	public void addEdge(int from, int to, int val) {
		if (from < 0 || to < 0 || from >= length || to >= length || from == to)
			throw FrontStarGraphException.numberInvalid();
		matrix[from * length + to] = val;
	}

	@Contract(pure = true)
	public int getDistance(int from, int to) {
		if (from < 0 || to < 0 || from >= length || to >= length)
			throw FrontStarGraphException.numberInvalid();
		return matrix[from * length + to];
	}

	@NotNull
	@Override
	@Contract(value = " -> !null", pure = true)
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < length; ++i) {
			for (int j = 0; j < length; ++j) {
				stringBuilder
						.append(getDistance(i, j) == ORIGINAL_FILLING_VALUE
								? "inf"
								: Integer.toString(getDistance(i, j)))
						.append("\t");
			}
			stringBuilder.append("\n");
		}
		return stringBuilder.toString();
	}
}

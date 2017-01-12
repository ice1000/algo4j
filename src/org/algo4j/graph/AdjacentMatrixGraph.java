package org.algo4j.graph;

import org.algo4j.error.GraphException;
import org.algo4j.math.MathUtils;
import org.algo4j.util.SeqUtils;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * Created by ice1000 on 2017/1/8.
 *
 * @author ice1000
 */
@SuppressWarnings({"WeakerAccess", "SameParameterValue"})
public final class AdjacentMatrixGraph implements
		Graph,
		Iterable<Edge> {

	public final int length;
	private final int[] matrix;

	@Contract(pure = true)
	public AdjacentMatrixGraph(int length) {
		if (length <= 0) throw new GraphException("length cannot be zero or negative!");
		this.length = length;
		matrix = new int[length * length];
		for (int i = 0; i < matrix.length; i++) {
			matrix[i] = i % length == i / length
					? 0
					: ORIGINAL_FILLING_VALUE;
		}
	}

	private AdjacentMatrixGraph(@NotNull int[] matrix) {
		this.matrix = matrix;
		this.length = ((int) MathUtils.sqrt(matrix.length));
	}

	@Override
	@NotNull
	@Contract(value = " -> !null", pure = true)
	public AdjacentMatrixGraph clone() {
		return new AdjacentMatrixGraph(SeqUtils.copy(matrix));
	}

	@NotNull
	@Contract(value = " -> !null", pure = true)
	public AdjacentMatrixGraph floyd() {
		return new AdjacentMatrixGraph(floyd(matrix));
	}

	@NotNull
	@Contract(pure = true)
	private static native int[] floyd(@NotNull int[] origin);

	/**
	 * weak add
	 *
	 * @param from pos1
	 * @param to   pos2
	 * @param val  value from pos1 to pos2
	 */
	@Override
	public synchronized void addEdge(int from, int to, int val) {
		addEdge(from, to, val, false);
	}

	public synchronized void overwriteEdge(int from, int to, int val) {
		addEdge(from, to, val, true);
	}

	/**
	 * add an edge
	 *
	 * @param from  pos1
	 * @param to    pos2
	 * @param val   value from pos1 to pos2
	 * @param force if true, overwrite the current edge.
	 *              if false, the edge value will be
	 *              the minimum of current value and given value.
	 * @throws GraphException if index out of bound
	 */
	public synchronized void addEdge(int from, int to, int val, boolean force) {
		if (from < 0 || to < 0 || from >= length || to >= length)
			throw GraphException.numberInvalid();
		if (force || val < matrix[from * length + to])
			matrix[from * length + to] = val;
	}

	@Contract(pure = true)
	public int getDistance(int from, int to) {
		if (from < 0 || to < 0 || from >= length || to >= length)
			throw GraphException.numberInvalid();
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

	@Contract(pure = true)
	public int size() {
		return length;
	}

	@Override
	@NotNull
	@Contract(value = " -> !null", pure = true)
	public Iterator<Edge> iterator() {
		return new AdjMatrixItr(this);
	}

	@Override
	public void forEach(@Nullable Consumer<? super Edge> action) {
		if (action != null) {
			for (int i = 0; i < length; ++i) {
				for (int j = 0; j < length; ++j) {
					action.accept(new Edge(
							i, j,
							getDistance(i, j)
					));
				}
			}
		}
	}

	public class AdjMatrixItr implements Iterator<Edge> {
		@NotNull
		private final AdjacentMatrixGraph context;
		private int cursorX = 0;
		private int cursorY = 0;

		@Contract(pure = true)
		public AdjMatrixItr(
				@NotNull AdjacentMatrixGraph context,
				int cursorX,
				int cursorY) {
			this.context = context;
			this.cursorX = cursorX;
			this.cursorY = cursorY;
		}

		@Contract(pure = true)
		public AdjMatrixItr(@NotNull AdjacentMatrixGraph context) {
			this(context, 0, 0);
		}

		@Override
		@Contract(pure = true)
		public boolean hasNext() {
			return cursorX >= context.size() && cursorY >= context.size();
		}

		@Override
		@Nullable
		public synchronized Edge next() {
			if (!hasNext()) return null;
			Edge edge = new Edge(
					cursorX,
					cursorY,
					context.getDistance(
							cursorX,
							cursorY
					)
			);
			++cursorX;
			if (cursorX >= context.size()) {
				cursorX = 0;
				++cursorY;
			}
			return edge;
		}

		@Override
		public synchronized void remove() {
			context.addEdge(
					cursorX,
					cursorY,
					ORIGINAL_FILLING_VALUE,
					true
			);
		}
	}
}

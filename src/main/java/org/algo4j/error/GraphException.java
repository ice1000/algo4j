package org.algo4j.error;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;

/**
 * Created by ice1000 on 2016/11/18.
 *
 * @author ice1000
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class GraphException extends RuntimeException {
	public GraphException() {
		this("Front star graph error!");
	}

	public GraphException(@NotNull @Nls String message) {
		super(message);
	}

	@NotNull
	@Contract(value = " -> !null", pure = true)
	public static GraphException indexOutBound() {
		return new GraphException("Index out of bound!");
	}

	@NotNull
	@Contract(value = " -> !null", pure = true)
	public static GraphException numberInvalid() {
		return new GraphException("node number is invalid!");
	}

	@NotNull
	@Contract(value = " -> !null", pure = true)
	public static GraphException cannotRemove() {
		return new GraphException("cannot remove an edge!");
	}

	@NotNull
	@Contract(value = " -> !null", pure = true)
	public static GraphException negativeLoop() {
		return new GraphException("trapped in a negative value loop!");
	}

	@NotNull
	@Contract(value = " -> !null", pure = true)
	public static GraphException tooManyEdges() {
		return new GraphException("too many edges!");
	}
}

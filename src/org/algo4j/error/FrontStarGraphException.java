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
public final class FrontStarGraphException extends RuntimeException {
	@Contract(pure = true)
	public FrontStarGraphException() {
		this("Front star graph error!");
	}

	@Contract(pure = true)
	public FrontStarGraphException(@NotNull @Nls String message) {
		super(message);
	}

	@NotNull
	@Contract(value = " -> !null", pure = true)
	public static FrontStarGraphException indexOutBound() {
		return new FrontStarGraphException("Index out of bound!");
	}

	@NotNull
	@Contract(value = " -> !null", pure = true)
	public static FrontStarGraphException numberInvalid() {
		return new FrontStarGraphException("node number is invalid!");
	}

	@NotNull
	@Contract(value = " -> !null", pure = true)
	public static FrontStarGraphException cannotRemove() {
		return new FrontStarGraphException("cannot remove an edge!");
	}

	@NotNull
	@Contract(value = " -> !null", pure = true)
	public static FrontStarGraphException negativeLoop() {
		return new FrontStarGraphException("trapped in a negative value loop!");
	}
}

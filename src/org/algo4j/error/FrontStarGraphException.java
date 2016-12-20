package org.algo4j.error;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * Created by ice1000 on 2016/11/18.
 *
 * @author ice1000
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public final class FrontStarGraphException extends RuntimeException {
	public FrontStarGraphException() {
		this("Front star graph error!");
	}

	public FrontStarGraphException(@NotNull String message) {
		super(message);
	}

	@NotNull
	@Contract(" -> !null")
	public static FrontStarGraphException indexOutBound() {
		return new FrontStarGraphException("Index out of bound!");
	}

	@NotNull
	@Contract(" -> !null")
	public static FrontStarGraphException numberInvalid() {
		return new FrontStarGraphException("node number is invalid!");
	}
}

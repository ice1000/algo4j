package org.algo4j.error;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * Created by ice1000 on 2016/11/19.
 *
 * @author ice1000
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public final class UnionSetException extends RuntimeException {
	public UnionSetException() {
		this("Union set error!");
	}

	public UnionSetException(@NotNull String message) {
		super(message);
	}

	@NotNull
	@Contract(" -> !null")
	public static UnionSetException indexOutBound() {
		return new UnionSetException("Index out of bound!");
	}
}

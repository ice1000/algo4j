package org.algo4j.error;

import org.algo4j.math.BigInt;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * Created by ice1000 on 2016/12/20.
 *
 * @author ice1000
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public final class DividedByZeroException extends ArithmeticException {
	public DividedByZeroException(@NotNull String msg) {
		super(msg);
	}

	public DividedByZeroException() {
		this("A number cannot be divided by zero");
	}

	@NotNull
	@Contract("_ -> !null")
	public static DividedByZeroException fromNumber(int num) {
		return new DividedByZeroException(num + " cannot be divided by zero!");
	}

	@NotNull
	@Contract("_ -> !null")
	public static DividedByZeroException fromNumber(BigInt num) {
		return new DividedByZeroException(num.toString() + " cannot be divided by zero!");
	}
}

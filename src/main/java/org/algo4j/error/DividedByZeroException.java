package org.algo4j.error;

import org.algo4j.math.BigInt;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;

/**
 * Created by ice1000 on 2016/12/20.
 *
 * @author ice1000
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class DividedByZeroException extends ArithmeticException {
	@Contract(pure = true)
	public DividedByZeroException(@NotNull @Nls String msg) {
		super(msg);
	}

	@Contract(pure = true)
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

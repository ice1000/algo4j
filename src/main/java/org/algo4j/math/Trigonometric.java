package org.algo4j.math;

import org.jetbrains.annotations.Contract;

/**
 * Created by ice1000 on 2016/11/24.
 *
 * @author ice1000
 */
@SuppressWarnings("WeakerAccess")
public final class Trigonometric {
	private Trigonometric() {
		throw new Error("do not instantiation me");
	}

	/**
	 * same as {@code java.lang.MathUtils.sin(double)}
	 *
	 * @return sin(a)
	 */
	@Contract(pure = true)
	public static native double sin(double a);

	/**
	 * same as {@code java.lang.MathUtils.cos(double)}
	 *
	 * @return cos(a)
	 */
	@Contract(pure = true)
	public static native double cos(double a);

	/**
	 * same as {@code java.lang.MathUtils.tan(double)}
	 *
	 * @return tan(a)
	 */
	@Contract(pure = true)
	public static native double tan(double a);

	/**
	 * @return cot(a)
	 */
	@Contract(pure = true)
	public static native double cot(double a);

	/**
	 * @return csc(a)
	 */
	@Contract(pure = true)
	public static native double csc(double a);

	/**
	 * @return sec(a)
	 */
	@Contract(pure = true)
	public static native double sec(double a);
}

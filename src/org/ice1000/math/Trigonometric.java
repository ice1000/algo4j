package org.ice1000.math;

/**
 * Created by ice1000 on 2016/11/24.
 *
 * @author ice1000
 */
public final class Trigonometric {
	private Trigonometric() {
	}


	/**
	 * same as {@code java.lang.MathUtils.sin(double)}
	 *
	 * @return sin(a)
	 */
	public static native double sin(double a);

	/**
	 * same as {@code java.lang.MathUtils.cos(double)}
	 *
	 * @return cos(a)
	 */
	public static native double cos(double a);

	/**
	 * same as {@code java.lang.MathUtils.tan(double)}
	 *
	 * @return tan(a)
	 */
	public static native double tan(double a);

	/**
	 * @return cot(a)
	 */
	public static native double cot(double a);

	/**
	 * @return csc(a)
	 */
	public static native double csc(double a);

	/**
	 * @return sec(a)
	 */
	public static native double sec(double a);
}

package org.ice1000.util;

/**
 * Created by ice1000 on 2016/11/16.
 *
 * @author ice1000
 */
public class Math {

	private Math() {
	}

	public static final double E = java.lang.Math.E;

	public static final double PI = java.lang.Math.PI;

	private static final int MAGIC_NUMBER = 0x5F3759DF;

	/**
	 * returns the greatest common divisor of {@code a} and {@code b}
	 *
	 * @return greatest common divisor of a and b
	 */
	public static native long gcd(long a, long b);

	/**
	 * returns the square root of a, replaced {@code java.lang.StrictMath.sqrt(double)}
	 *
	 * @return square root of a
	 */
	public static native double sqrt(double a);

	/**
	 * delegate to {@code java.lang.Math.sin(double)}
	 *
	 * @return sin(a)
	 * @see java.lang.Math
	 * @see java.lang.StrictMath
	 */
	public static double sin(double a) {
		return java.lang.Math.sin(a);
	}

	/**
	 * delegate to {@code java.lang.Math.cos(double)}
	 *
	 * @return cos(a)
	 * @see java.lang.Math
	 * @see java.lang.StrictMath
	 */
	public static double cos(double a) {
		return java.lang.Math.cos(a);
	}

	/**
	 * delegate to {@code java.lang.Math.tan(double)}
	 *
	 * @return tan(a)
	 * @see java.lang.Math
	 * @see java.lang.StrictMath
	 */
	public static double tan(double a) {
		return java.lang.Math.tan(a);
	}
}

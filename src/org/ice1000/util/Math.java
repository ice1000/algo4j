package org.ice1000.util;

/**
 * Math class
 * Created by ice1000 on 2016/11/16.
 *
 * @author ice1000
 */
@SuppressWarnings("WeakerAccess")
public final class Math {

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
	 * Returns the square root of a, replaced {@code java.lang.StrictMath.sqrt(double)}
	 * This is not so strict, for instance sqrt(100) will be 10.000036239624023
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

	/**
	 * delegate to {@code java.lang.Math.abs(double)}
	 *
	 * @return abstract value of a
	 */
	public static double abs(double a) {
		return java.lang.Math.abs(a);
	}

	/**
	 * delegate to {@code java.lang.Math.abs(double)}
	 *
	 * @return abstract value of a
	 */
	public static float abs(float a) {
		return java.lang.Math.abs(a);
	}

	/**
	 * delegate to {@code java.lang.Math.abs(double)}
	 *
	 * @return abstract value of a
	 */
	public static int abs(int a) {
		return java.lang.Math.abs(a);
	}

	/**
	 * delegate to {@code java.lang.Math.abs(double)}
	 *
	 * @return abstract value of a
	 */
	public static long abs(long a) {
		return java.lang.Math.abs(a);
	}

	/**
	 * delegate to {@code java.lang.Math.max(double)}
	 *
	 * @return the larger of {@code a} and {@code b}.
	 */
	public static long max(long a, long b) {
		return java.lang.Math.max(a, b);
	}

	/**
	 * delegate to {@code java.lang.Math.max(double)}
	 *
	 * @return the larger of {@code a} and {@code b}.
	 */
	public static float max(float a, float b) {
		return java.lang.Math.max(a, b);
	}

	/**
	 * delegate to {@code java.lang.Math.max(double)}
	 *
	 * @return the larger of {@code a} and {@code b}.
	 */
	public static double max(double a, double b) {
		return java.lang.Math.max(a, b);
	}

	/**
	 * delegate to {@code java.lang.Math.min(double)}
	 *
	 * @return the smaller of {@code a} and {@code b}.
	 */
	public static int min(int a, int b) {
		return java.lang.Math.min(a, b);
	}

	/**
	 * delegate to {@code java.lang.Math.min(double)}
	 *
	 * @return the smaller of {@code a} and {@code b}.
	 */
	public static long min(long a, long b) {
		return java.lang.Math.min(a, b);
	}

	/**
	 * delegate to {@code java.lang.Math.min(double)}
	 *
	 * @return the smaller of {@code a} and {@code b}.
	 */
	public static float min(float a, float b) {
		return java.lang.Math.min(a, b);
	}

	/**
	 * delegate to {@code java.lang.Math.min(double)}
	 *
	 * @return the smaller of {@code a} and {@code b}.
	 */
	public static double min(double a, double b) {
		return java.lang.Math.min(a, b);
	}
}

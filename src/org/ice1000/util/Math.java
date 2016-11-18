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
	 * This runs very fast, O(1)
	 * Returns the square root of a, replaced {@code java.lang.StrictMath.sqrt(double)}
	 * This is not so strict, for instance sqrt(100) will be 10.000036239624023.
	 *
	 * @return square root of a
	 */
	public static native double sqrt(double a);

	public static native double sqrtStrict(double a);

	/**
	 * same as {@code java.lang.Math.sin(double)}
	 *
	 * @return sin(a)
	 */
	public static native double sin(double a);

	/**
	 * same as {@code java.lang.Math.cos(double)}
	 *
	 * @return cos(a)
	 */
	public static native double cos(double a);

	/**
	 * same as {@code java.lang.Math.tan(double)}
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

	/**
	 * A fast algorithm to calculate (a * b) % m. O(log(b))
	 *
	 * @param a   param1
	 * @param b   param2
	 * @param mod mod
	 * @return a * b % m
	 */
	public static native long fastPlus(long a, long b, long mod);

	/**
	 * A fast algorithm to calculate (a ^ b) % m. O(2 * log(a) * log(b))
	 *
	 * @param a   base
	 * @param b   power
	 * @param mod mod
	 * @return a ^ b % m
	 */
	public static native long fastPower(long a, long b, long mod);

	/**
	 * same as {@code java.lang.Math.abs(double)}
	 *
	 * @return abstract value of a
	 */
	public static native double abs(double a);

	/**
	 * same as {@code java.lang.Math.abs(float)}
	 *
	 * @return abstract value of a
	 */
	public static native float abs(float a);

	/**
	 * same as {@code java.lang.Math.abs(int)}
	 *
	 * @return abstract value of a
	 */
	public static native int abs(int a);

	/**
	 * same as {@code java.lang.Math.abs(long)}
	 *
	 * @return abstract value of a
	 */
	public static native long abs(long a);

	/**
	 * same as {@code java.lang.Math.max(long)}
	 *
	 * @return the larger one of {@code a} and {@code b}.
	 */
	public static native long max(long a, long b);

	/**
	 * same as {@code java.lang.Math.max(int)}
	 *
	 * @return the larger of {@code a} and {@code b}.
	 */
	public static native long max(int a, int b);

	/**
	 * same as {@code java.lang.Math.max(float)}
	 *
	 * @return the larger of {@code a} and {@code b}.
	 */
	public static native float max(float a, float b);

	/**
	 * same as {@code java.lang.Math.max(double)}
	 *
	 * @return the larger of {@code a} and {@code b}.
	 */
	public static native double max(double a, double b);

	/**
	 * same as {@code java.lang.Math.min(int)}
	 *
	 * @return the smaller of {@code a} and {@code b}.
	 */
	public static native int min(int a, int b);

	/**
	 * same as {@code java.lang.Math.min(long)}
	 *
	 * @return the smaller of {@code a} and {@code b}.
	 */
	public static native long min(long a, long b);

	/**
	 * same as {@code java.lang.Math.min(float)}
	 *
	 * @return the smaller of {@code a} and {@code b}.
	 */
	public static native float min(float a, float b);

	/**
	 * same as {@code java.lang.Math.min(double)}
	 *
	 * @return the smaller of {@code a} and {@code b}.
	 */
	public static native double min(double a, double b);
}

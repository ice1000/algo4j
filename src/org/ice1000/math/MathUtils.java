package org.ice1000.math;

/**
 * MathUtils class
 * Created by ice1000 on 2016/11/16.
 *
 * @author ice1000
 */
@SuppressWarnings("WeakerAccess")
public final class MathUtils {

	private MathUtils() {
	}

	public static final double E = java.lang.Math.E;

	public static final double PI = java.lang.Math.PI;

	private static final int MAGIC_NUMBER = 0x5F3759DF;

	/**
	 * O(a) = log(a)
	 * returns the greatest common divisor of {@code a} and {@code b}
	 *
	 * @return greatest common divisor of a and b
	 */
	public static native long gcd(long a, long b);

	/**
	 * O(1)
	 * This is the sqrt written by Carmack
	 * Slower than sqrtStrict
	 * Returns the square root of a, replaced {@code java.lang.StrictMath.sqrt(double)}
	 * This is not so strict, for instance sqrt(100) will be 10.000036239624023.
	 *
	 * @return square root of a
	 */
	@Deprecated
	public static native double sqrt(double a);

	/**
	 * O(1)
	 * using CPU command directly to calculate sqrt
	 * Accurate and fast
	 *
	 * @return square root of a
	 */
	public static native double sqrtStrict(double a);

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
	 * same as {@code java.lang.MathUtils.abs(double)}
	 *
	 * @return abstract value of a
	 */
	public static native double abs(double a);

	/**
	 * same as {@code java.lang.MathUtils.abs(float)}
	 *
	 * @return abstract value of a
	 */
	public static native float abs(float a);

	/**
	 * same as {@code java.lang.MathUtils.abs(int)}
	 *
	 * @return abstract value of a
	 */
	public static native int abs(int a);

	/**
	 * same as {@code java.lang.MathUtils.abs(long)}
	 *
	 * @return abstract value of a
	 */
	public static native long abs(long a);

	/**
	 * same as {@code java.lang.MathUtils.max(long)}
	 *
	 * @return the larger one of {@code a} and {@code b}.
	 */
	public static native long max(long a, long b);

	/**
	 * same as {@code java.lang.MathUtils.max(int)}
	 *
	 * @return the larger of {@code a} and {@code b}.
	 */
	public static native long max(int a, int b);

	/**
	 * same as {@code java.lang.MathUtils.max(float)}
	 *
	 * @return the larger of {@code a} and {@code b}.
	 */
	public static native float max(float a, float b);

	/**
	 * same as {@code java.lang.MathUtils.max(double)}
	 *
	 * @return the larger of {@code a} and {@code b}.
	 */
	public static native double max(double a, double b);

	/**
	 * same as {@code java.lang.MathUtils.min(int)}
	 *
	 * @return the smaller of {@code a} and {@code b}.
	 */
	public static native int min(int a, int b);

	/**
	 * same as {@code java.lang.MathUtils.min(long)}
	 *
	 * @return the smaller of {@code a} and {@code b}.
	 */
	public static native long min(long a, long b);

	/**
	 * same as {@code java.lang.MathUtils.min(float)}
	 *
	 * @return the smaller of {@code a} and {@code b}.
	 */
	public static native float min(float a, float b);

	/**
	 * same as {@code java.lang.MathUtils.min(double)}
	 *
	 * @return the smaller of {@code a} and {@code b}.
	 */
	public static native double min(double a, double b);

	/**
	 * same as {@code java.lang.MathUtils.log(double)}
	 *
	 * @param a a param
	 * @return ln(a), base is e
	 */
	public static native double ln(double a);

	/**
	 * same as {@code java.lang.MathUtils.log10(double)}
	 *
	 * @param a a param
	 * @return lg(a), base is 10
	 */
	public static native double lg(double a);

	/**
	 * This function returns true if a is a prime number.
	 * Mention that if a is 1 or 0, it will return false.
	 * If a is a positive number, it will always return false.
	 *
	 * @param a an integer number
	 * @return if a is a prime number, returns true.
	 */
	public static native boolean isPrime(long a);

	/**
	 * return an array of primes.
	 *
	 * @param count the number of primes
	 * @return an array of primes
	 */
	public static native long[] getPrimes(int count);
}

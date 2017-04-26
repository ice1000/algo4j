package org.algo4j.math;

import org.algo4j.error.DividedByZeroException;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Arrays;

import static org.algo4j.math.MathUtils.abs;

/**
 * Big integer, functionally designed.
 * Created by ice1000 on 2016/12/13.
 *
 * @author ice1000
 */
@SuppressWarnings("WeakerAccess")
public class BigInt implements
		Comparable<BigInt>,
		Cloneable,
		Serializable {
	private final boolean sig;
	private final byte[] data;

	public static final BigInt ZERO = new BigInt(0);
	public static final BigInt ONE = new BigInt(1);
	public static final BigInt TWO = new BigInt(2);
	public static final BigInt TEN = new BigInt(10);
	public static final BigInt NEGA_TEN = new BigInt(-10);

	public BigInt(@NotNull @NonNls String origin) {
		boolean sigTemp;
		if (origin.startsWith("-")) {
			sigTemp = false;
			origin = origin.substring(1);
		} else
			sigTemp = true;
		byte[] ori = origin.getBytes();
		if (ori.length == 1 && ori[0] == '0')
			sigTemp = true;
		data = ori;
		sig = sigTemp;
	}

	public BigInt(@NotNull byte[] origin, boolean sig) {
		if (origin.length == 1 && origin[0] == '0')
			sig = true;
		data = origin;
		this.sig = sig;
	}

	public BigInt(int origin) {
		sig = origin >= 0;
		data = Integer.toString(abs(origin)).getBytes();
	}

	public BigInt(long origin) {
		sig = origin >= 0;
		data = Long.toString(abs(origin)).getBytes();
	}

	public BigInt(short origin) {
		sig = origin >= 0;
		data = Long.toString(abs(origin)).getBytes();
	}

	public BigInt(@Nullable BigInt anotherBigInt) {
		if (anotherBigInt == null)
			anotherBigInt = ZERO;
		sig = anotherBigInt.sig;
		data = anotherBigInt.data;
	}

	public BigInt(@Nullable BigInteger anotherBigInt) {
		this(anotherBigInt != null ?
				anotherBigInt.toString() :
				BigInteger.ZERO.toString());
	}

	/**
	 * plus
	 *
	 * @param anotherBigInt another big int
	 * @return this + anotherBigInt
	 */
	@NotNull
	@Contract(value = "_ -> !null", pure = true)
	public BigInt plus(@NotNull BigInt anotherBigInt) {
		if (sig == anotherBigInt.sig)
			return new BigInt(plus(data, anotherBigInt.data), sig);
		if (compareTo(data, anotherBigInt.data) > 0)
			return new BigInt(minus(data, anotherBigInt.data), sig);
		return new BigInt(minus(anotherBigInt.data, data), !sig);
	}

	/**
	 * minus
	 *
	 * @param anotherBigInt another big int
	 * @return this - anotherBigInt
	 */
	@NotNull
	@Contract(value = "_ -> !null", pure = true)
	public BigInt minus(@NotNull BigInt anotherBigInt) {
		if (sig != anotherBigInt.sig)
			return new BigInt(plus(data, anotherBigInt.data), sig);
		if (compareTo(data, anotherBigInt.data) > 0)
			return new BigInt(minus(data, anotherBigInt.data), sig);
		return new BigInt(minus(anotherBigInt.data, data), !sig);
	}

	/**
	 * times
	 *
	 * @param anotherBigInt another big int
	 * @return this * anotherBigInt
	 */
	@NotNull
	@Contract(value = "_ -> !null", pure = true)
	public BigInt times(@NotNull BigInt anotherBigInt) {
		if (TEN.equals(anotherBigInt))
			return timesTen();
		else if (NEGA_TEN.equals(anotherBigInt))
			return timesTen(!sig);
		else if (data.length + anotherBigInt.data.length <= 1_000)
			return new BigInt(timesBruteForce(data, anotherBigInt.data), sig == anotherBigInt.sig);
		else
			return new BigInt(times(data, anotherBigInt.data), sig == anotherBigInt.sig);
	}

	/**
	 * returns this * 10
	 *
	 * @return this * 10
	 */
	@NotNull
	@Contract(pure = true)
	public BigInt timesTen(boolean sig) {
		return new BigInt(times10(data), sig);
	}

	@NotNull
	@Contract(pure = true)
	public BigInt timesTen() {
		return timesTen(sig);
	}

	/**
	 * divide
	 *
	 * @param anotherBigInt another big int
	 * @return this / anotherBigInt
	 * @throws DividedByZeroException if you passed ZERO to this method.
	 */
	@NotNull
	@Contract(value = "_ -> !null", pure = true)
	public BigInt divide(@NotNull BigInt anotherBigInt) {
		if (ZERO.equals(anotherBigInt)) throw DividedByZeroException.fromNumber(this);
		return new BigInt(divide(data, anotherBigInt.data), sig == anotherBigInt.sig);
	}

	/**
	 * remainder
	 *
	 * @param anotherBigInt another big int
	 * @return this % anotherBigInt
	 * @throws DividedByZeroException if you passed ZERO to this method.
	 */
	@NotNull
	@Contract(value = "_ -> !null", pure = true)
	public BigInt rem(@NotNull BigInt anotherBigInt) {
		if (ZERO.equals(anotherBigInt)) return clone();
		return new BigInt(rem(data, anotherBigInt.data), sig);
	}

	/**
	 * power
	 *
	 * @param pow exponent to which this BigInt is to be raised.
	 * @return this ^ pow
	 */
	@NotNull
	@Contract(value = "_ -> !null", pure = true)
	public BigInt pow(int pow) {
		return new BigInt(pow(data, pow), (pow & 1) == 1 && !sig);
	}

	/**
	 * A fast algorithm to calculate (a ^ b) % m. O(2 * log(a) * log(b))
	 *
	 * @param pow power
	 * @param mod mod
	 * @return a ^ b % m
	 */
	@Contract(pure = true)
	public int fastPower(int pow, int mod) {
		return fastPower(data, pow, mod);
	}

	@NotNull
	@Contract(value = "!null, !null -> !null", pure = true)
	private static native byte[] plus(@NotNull byte[] a, @NotNull byte[] b);

	@NotNull
	@Contract(value = "!null, !null -> !null", pure = true)
	private static native byte[] times(@NotNull byte[] a, @NotNull byte[] b);

	@NotNull
	@Contract(value = "!null, !null -> !null", pure = true)
	private static native byte[] timesBruteForce(@NotNull byte[] a, @NotNull byte[] b);

	@NotNull
	@Contract(value = "!null -> !null", pure = true)
	private static native byte[] times10(@NotNull byte[] a);

	@NotNull
	@Contract(value = "!null, !null -> !null", pure = true)
	private static native byte[] divide(@NotNull byte[] a, @NotNull byte[] b);

	@NotNull
	@Contract(value = "!null, !null -> !null", pure = true)
	private static native byte[] rem(@NotNull byte[] a, @NotNull byte[] b);

	@NotNull
	@Contract(value = "!null, !null -> !null", pure = true)
	private static native byte[] minus(@NotNull byte[] a, @NotNull byte[] b);

	@NotNull
	@Contract(value = "!null, _ -> !null", pure = true)
	private static native byte[] pow(@NotNull byte[] a, int pow);

	@Contract(pure = true)
	public static native int fastPower(@NotNull byte[] a, int b, int mod);

	@Contract(pure = true)
	private static native int compareTo(@NotNull byte[] a, @NotNull byte[] b);

	@SuppressWarnings("MethodDoesntCallSuperMethod")
	@Override
	@NotNull
	@Contract(" -> !null")
	public BigInt clone() {
		return new BigInt(data, sig);
	}

	@Override
	@NotNull
	@NonNls
	@Contract(value = "-> !null", pure = true)
	public String toString() {
		return (sig ? "" : "-") + new String(data);
	}

	@Override
	@Contract(value = "null -> false", pure = true)
	@SuppressWarnings("SimplifiableIfStatement")
	public boolean equals(@Nullable Object obj) {
		if (obj == null || !(obj instanceof BigInt)) return false;
		if (obj == this) return true;
		return compareTo((BigInt) obj) == 0;
	}

	@Override
	@Contract(pure = true)
	public int hashCode() {
		return (Arrays.hashCode(data) << 1) + (sig ? 1 : 0);
	}

	/**
	 * compare
	 *
	 * @param o another big int
	 * @return 1 if this > o, -1 if this < o, 0 if this == 0
	 */
	@Override
	@SuppressWarnings("NullableProblems")
	@Contract(pure = true)
	public int compareTo(@NotNull BigInt o) {
		if (this.sig == o.sig)
			return compareTo(this.data, o.data) * (sig ? 1 : -1);
		if (this.sig)
			return 1;
		else return -1;
	}
}

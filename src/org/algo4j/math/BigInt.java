package org.algo4j.math;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;

import static org.algo4j.math.MathUtils.abs;

/**
 * Big integer, functionally designed.
 * Created by ice1000 on 2016/12/13.
 *
 * @author ice1000
 */
public final class BigInt {
	private final boolean sig;
	private final byte[] data;

	public static final BigInt ZERO = new BigInt(0);

	public BigInt(@NotNull String origin) {
		if (origin.startsWith("-")) {
			sig = false;
			origin = origin.substring(1);
		} else {
			sig = true;
		}
		data = origin.getBytes();
	}

	public BigInt(@NotNull byte[] origin, boolean sig) {
		if (origin.length == 1 && origin[0] == '0') sig = true;
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

	public BigInt(@NotNull BigInt bigInt) {
		sig = bigInt.sig;
		data = bigInt.data;
	}

	public BigInt plus(@NotNull BigInt bigInt) {
		if (sig == bigInt.sig)
			return new BigInt(plus(data, bigInt.data), sig);
		if (compareTo(data, bigInt.data) > 0)
			return new BigInt(minus(data, bigInt.data), sig);
		return new BigInt(minus(bigInt.data, data), !sig);
	}

	public BigInt minus(@NotNull BigInt bigInt) {
		if (sig != bigInt.sig)
			return new BigInt(plus(data, bigInt.data), sig);
		if (compareTo(data, bigInt.data) > 0)
			return new BigInt(minus(data, bigInt.data), sig);
		return new BigInt(minus(bigInt.data, data), !sig);
	}

	@NotNull
	@Contract("_ -> !null")
	public BigInt times(@NotNull BigInt bigInt) {
		return new BigInt(times(data, bigInt.data), sig == bigInt.sig);
	}

	@NotNull
	@Contract("_ -> !null")
	public BigInt divide(@NotNull BigInt bigInt) {
		return new BigInt(divide(data, bigInt.data), sig == bigInt.sig);
	}

	@NotNull
	@Contract("_ -> !null")
	public BigInt pow(int pow) {
		return new BigInt(pow(data, pow), (pow & 1) == 1 && !sig);
	}

	private static native byte[] plus(byte[] a, byte[] b);

	private static native byte[] times(byte[] a, byte[] b);

	private static native byte[] divide(byte[] a, byte[] b);

	private static native byte[] minus(byte[] a, byte[] b);

	private static native byte[] pow(byte[] a, int pow);

	private static native int compareTo(byte[] a, byte[] b);

	@Override
	@NotNull
	@Contract(" -> !null")
	public BigInt clone() {
		return new BigInt(data, sig);
	}

	@Override
	@NotNull
	@NonNls
	public String toString() {
		return (sig ? "" : "-") + new String(data);
	}

	@Override
	@Contract("null -> false")
	public boolean equals(@Nullable Object obj) {
		return obj != null && (super.equals(obj) || obj instanceof BigInt && compareTo((BigInt) obj) == 0);
	}

	@Override
	@Contract(pure = true)
	public int hashCode() {
		return (Arrays.hashCode(data) << 1) + (sig ? 1 : 0);
	}

	@Override
	protected void finalize() {
	}

	/**
	 * compare
	 *
	 * @param o another big int
	 * @return 1 if this > o, -1 if this < o, 0 if this == 0
	 */
	@SuppressWarnings("NullableProblems")
	public int compareTo(@NotNull BigInt o) {
		if (this.sig == o.sig)
			return compareTo(this.data, o.data) * (sig ? 1 : -1);
		if (this.sig) return 1;
		else return -1;
	}
}

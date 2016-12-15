package org.algo4j.util;

/**
 * Created by ice1000 on 2016/11/18.
 *
 * @author ice1000
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public final class SeqUtils {
	private SeqUtils() {
	}

	/**
	 * O(length) = length * 2 + log(length)
	 * to do discretization to the given array.
	 *
	 * @param data the array to be discretization.
	 */
	public static native void discretization(long[] data);

	/**
	 * @see SeqUtils#discretization(long[])
	 */
	public static native void discretization(int[] data);

	/**
	 * @see SeqUtils#discretization(long[])
	 */
	public static native void discretization(float[] data);

	/**
	 * @see SeqUtils#discretization(long[])
	 */
	public static native void discretization(double[] data);

	/**
	 * O(length) = 2 * log(length)
	 * returns the inversion number of the given array.
	 *
	 * @param data given array
	 * @return inversion number
	 */
	public static native long inversion(int[] data);

	/**
	 * @see SeqUtils#inversion(int[])
	 */
	public static native long inversion(long[] data);

	/**
	 * @see SeqUtils#inversion(int[])
	 */
	public static native long inversion(float[] data);

	/**
	 * @see SeqUtils#inversion(int[])
	 */
	public static native long inversion(double[] data);

	/**
	 * O(len) = len ^ 2
	 * bubble sort
	 *
	 * @param data the array to be sort
	 */
	public static native void sortBubble(int[] data);

	/**
	 * @see SeqUtils#sortBubble(int[])
	 */
	public static native void sortBubble(long[] data);

	/**
	 * @see SeqUtils#sortBubble(int[])
	 */
	public static native void sortBubble(float[] data);

	/**
	 * @see SeqUtils#sortBubble(int[])
	 */
	public static native void sortBubble(double[] data);

	/**
	 * O(len) = { long(len), len ^ 2 } depends on the array
	 * quick sort
	 *
	 * @param data the array to be sort
	 */
	public static native void sortQuick(int[] data);

	/**
	 * @see SeqUtils#sortQuick(int[])
	 */
	public static native void sortQuick(long[] data);

	/**
	 * @see SeqUtils#sortQuick(int[])
	 */
	public static native void sortQuick(float[] data);

	/**
	 * @see SeqUtils#sortQuick(int[])
	 */
	public static native void sortQuick(double[] data);

	public static native void sortInsertion(int[] data);

	public static native void sortInsertion(long[] data);

	public static native void sortInsertion(float[] data);

	public static native void sortInsertion(double[] data);

	public static native void sortMerge(int[] data);

	public static native void sortMerge(long[] data);

	public static native void sortMerge(float[] data);

	public static native void sortMerge(double[] data);

	public static native void sortComb(int[] data);

	public static native void sortComb(long[] data);

	public static native void sortComb(float[] data);

	public static native void sortComb(double[] data);

	public static native void sortSelection(int[] data);

	public static native void sortSelection(long[] data);

	public static native void sortSelection(float[] data);

	public static native void sortSelection(double[] data);

	public static native void sortCocktail(int[] data);

	public static native void sortCocktail(long[] data);

	public static native void sortCocktail(float[] data);

	public static native void sortCocktail(double[] data);

	/**
	 * Returns a string representation of the contents of the specified array.
	 */
	public static <T> String toString(T[] a) {
		if (a == null) return "null";
		if (a.length - 1 == -1) return "[]";

		StringBuilder b = new StringBuilder();
		b.append("[<");
		for (int i = 0; ; ++i) {
			b.append(a[i].toString());
			if (i == a.length - 1) return b.append(">]").toString();
			b.append(">, <");
		}
	}

	/**
	 * Returns a string representation of the contents of the specified array.
	 */
	public static String toString(long[] a) {
		if (a == null) return "null";
		if (a.length - 1 == -1) return "[]";

		StringBuilder b = new StringBuilder();
		b.append("[<");
		for (int i = 0; ; ++i) {
			b.append(a[i]);
			if (i == a.length - 1) return b.append(">]").toString();
			b.append(">, <");
		}
	}

	/**
	 * Returns a string representation of the contents of the specified array.
	 */
	public static String toString(int[] a) {
		if (a == null) return "null";
		if (a.length - 1 == -1) return "[]";

		StringBuilder b = new StringBuilder();
		b.append("[<");
		for (int i = 0; ; ++i) {
			b.append(a[i]);
			if (i == a.length - 1) return b.append(">]").toString();
			b.append(">, <");
		}
	}

	/**
	 * Returns a string representation of the contents of the specified array.
	 */
	public static String toString(byte[] a) {
		if (a == null) return "null";
		if (a.length - 1 == -1) return "[]";

		StringBuilder b = new StringBuilder();
		b.append("[<");
		for (int i = 0; ; ++i) {
			b.append(a[i]);
			if (i == a.length - 1) return b.append(">]").toString();
			b.append(">, <");
		}
	}

	/**
	 * Returns a string representation of the contents of the specified array.
	 */
	public static String toString(float[] a) {
		if (a == null) return "null";
		if (a.length - 1 == -1) return "[]";

		StringBuilder b = new StringBuilder();
		b.append("[<");
		for (int i = 0; ; ++i) {
			b.append(a[i]);
			if (i == a.length - 1) return b.append(">]").toString();
			b.append(">, <");
		}
	}

	/**
	 * Returns a string representation of the contents of the specified array.
	 */
	public static String toString(double[] a) {
		if (a == null) return "null";
		if (a.length - 1 == -1) return "[]";

		StringBuilder b = new StringBuilder();
		b.append("[<");
		for (int i = 0; ; ++i) {
			b.append(a[i]);
			if (i == a.length - 1) return b.append(">]").toString();
			b.append(">, <");
		}
	}

	/**
	 * Returns a string representation of the contents of the specified array.
	 */
	public static String toString(short[] a) {
		if (a == null) return "null";
		if (a.length - 1 == -1) return "[]";

		StringBuilder b = new StringBuilder();
		b.append("[<");
		for (int i = 0; ; ++i) {
			b.append(a[i]);
			if (i == a.length - 1) return b.append(">]").toString();
			b.append(">, <");
		}
	}

	/**
	 * Returns a string representation of the contents of the specified array.
	 */
	public static String toString(char[] a) {
		if (a == null) return "null";
		if (a.length - 1 == -1) return "[]";

		StringBuilder b = new StringBuilder();
		b.append("[<");
		for (int i = 0; ; ++i) {
			b.append(a[i]);
			if (i == a.length - 1) return b.append(">]").toString();
			b.append(">, <");
		}
	}

}

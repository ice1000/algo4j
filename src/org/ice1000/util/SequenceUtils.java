package org.ice1000.util;

/**
 * Created by ice1000 on 2016/11/18.
 *
 * @author ice1000
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public final class SequenceUtils {
	private SequenceUtils() {
	}

	private static native void discretization(long[] data, int length);

	public static void discretization(long[] data) {
		discretization(data, data.length);
	}

	private static native void discretization(int[] data, int length);

	public static void discretization(int[] data) {
		discretization(data, data.length);
	}

	private static native void discretization(float[] data, int length);

	public static void discretization(float[] data) {
		discretization(data, data.length);
	}

	private static native void discretization(double[] data, int length);

	public static void discretization(double[] data) {
		discretization(data, data.length);
	}

	private static native void sortBubble(int[] data, int length);

	public static void sortBubble(int[] data) {
		sortBubble(data, data.length);
	}

	private static native void sortBubble(long[] data, int length);

	public static void sortBubble(long[] data) {
		sortBubble(data, data.length);
	}

	private static native void sortBubble(float[] data, int length);

	public static void sortBubble(float[] data) {
		sortBubble(data, data.length);
	}

	private static native void sortBubble(double[] data, int length);

	public static void sortBubble(double[] data) {
		sortBubble(data, data.length);
	}

	private static native void sortQuick(int[] data, int length);

	public static void sortQuick(int[] data) {
		sortQuick(data, data.length);
	}

	private static native void sortQuick(long[] data, int length);

	public static void sortQuick(long[] data) {
		sortQuick(data, data.length);
	}

	private static native void sortQuick(float[] data, int length);

	public static void sortQuick(float[] data) {
		sortQuick(data, data.length);
	}

	private static native void sortQuick(double[] data, int length);

	public static void sortQuick(double[] data) {
		sortQuick(data, data.length);
	}

	private static native void sortInsertion(int[] data, int length);

	public static void sortInsertion(int[] data) {
		sortInsertion(data, data.length);
	}

	private static native void sortInsertion(long[] data, int length);

	public static void sortInsertion(long[] data) {
		sortInsertion(data, data.length);
	}

	private static native void sortInsertion(float[] data, int length);

	public static void sortInsertion(float[] data) {
		sortInsertion(data, data.length);
	}

	private static native void sortInsertion(double[] data, int length);

	public static void sortInsertion(double[] data) {
		sortInsertion(data, data.length);
	}

	public static native void sortMerge(int[] data, int length);

	public static void sortMerge(int[] data) {
		sortMerge(data, data.length);
	}

	public static native void sortMerge(long[] data, int length);

	public static void sortMerge(long[] data) {
		sortMerge(data, data.length);
	}

	public static native void sortMerge(float[] data, int length);

	public static void sortMerge(float[] data) {
		sortMerge(data, data.length);
	}

	public static native void sortMerge(double[] data, int length);

	public static void sortMerge(double[] data) {
		sortMerge(data, data.length);
	}

	public static native void sortComb(int[] data, int length);

	public static void sortComb(int[] data) {
		sortComb(data, data.length);
	}

	public static native void sortComb(long[] data, int length);

	public static void sortComb(long[] data) {
		sortComb(data, data.length);
	}

	public static native void sortComb(float[] data, int length);

	public static void sortComb(float[] data) {
		sortComb(data, data.length);
	}

	public static native void sortComb(double[] data, int length);

	public static void sortComb(double[] data) {
		sortComb(data, data.length);
	}

	public static native void sortSelection(int[] data, int length);

	public static void sortSelection(int[] data) {
		sortSelection(data, data.length);
	}

	public static native void sortSelection(long[] data, int length);

	public static void sortSelection(long[] data) {
		sortSelection(data, data.length);
	}

	public static native void sortSelection(float[] data, int length);

	public static void sortSelection(float[] data) {
		sortSelection(data, data.length);
	}

	public static native void sortSelection(double[] data, int length);

	public static void sortSelection(double[] data) {
		sortSelection(data, data.length);
	}

	public static native void sortCocktail(int[] data, int length);

	public static void sortCocktail(int[] data) {
		sortCocktail(data, data.length);
	}

	public static native void sortCocktail(long[] data, int length);

	public static void sortCocktail(long[] data) {
		sortCocktail(data, data.length);
	}

	public static native void sortCocktail(float[] data, int length);

	public static void sortCocktail(float[] data) {
		sortCocktail(data, data.length);
	}

	public static native void sortCocktail(double[] data, int length);

	public static void sortCocktail(double[] data) {
		sortCocktail(data, data.length);
	}

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

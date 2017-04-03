package org.algo4j.util;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.TimeUnit;

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
	public static native void discretization(@NotNull long[] data);

	/**
	 * @see SeqUtils#discretization(long[])
	 */
	public static native void discretization(@NotNull int[] data);

	/**
	 * @see SeqUtils#discretization(long[])
	 */
	public static native void discretization(@NotNull float[] data);

	/**
	 * @see SeqUtils#discretization(long[])
	 */
	public static native void discretization(@NotNull double[] data);

	/**
	 * O(length) = 2 * log(length)
	 * returns the inversion number of the given array.
	 *
	 * @param data given array
	 * @return inversion number
	 */
	@Contract(pure = true)
	public static native long inversion(@NotNull int[] data);

	/**
	 * @see SeqUtils#inversion(int[])
	 */
	@Contract(pure = true)
	public static native long inversion(@NotNull long[] data);

	/**
	 * @see SeqUtils#inversion(int[])
	 */
	@Contract(pure = true)
	public static native long inversion(@NotNull float[] data);

	/**
	 * @see SeqUtils#inversion(int[])
	 */
	@Contract(pure = true)
	public static native long inversion(@NotNull double[] data);

	/**
	 * O(len) = len ^ 2
	 * bubble sort
	 *
	 * @param data the array to be sort
	 */
	public static native void sortBubble(@NotNull int[] data);

	/**
	 * @see SeqUtils#sortBubble(int[])
	 */
	public static native void sortBubble(@NotNull long[] data);

	/**
	 * @see SeqUtils#sortBubble(int[])
	 */
	public static native void sortBubble(@NotNull float[] data);

	/**
	 * @see SeqUtils#sortBubble(int[])
	 */
	public static native void sortBubble(@NotNull double[] data);

	/**
	 * O(len) = { long(len), len ^ 2 } depends on the array
	 * quick sort
	 *
	 * @param data the array to be sort
	 */
	public static native void sortQuick(@NotNull int[] data);

	/**
	 * @see SeqUtils#sortQuick(int[])
	 */
	public static native void sortQuick(@NotNull long[] data);

	/**
	 * @see SeqUtils#sortQuick(int[])
	 */
	public static native void sortQuick(@NotNull float[] data);

	/**
	 * @see SeqUtils#sortQuick(int[])
	 */
	public static native void sortQuick(@NotNull double[] data);

	public static native void sortInsertion(@NotNull int[] data);

	public static native void sortInsertion(@NotNull long[] data);

	public static native void sortInsertion(@NotNull float[] data);

	public static native void sortInsertion(@NotNull double[] data);

	public static native void sortMerge(@NotNull int[] data);

	public static native void sortMerge(@NotNull long[] data);

	public static native void sortMerge(@NotNull float[] data);

	public static native void sortMerge(@NotNull double[] data);

	public static native void sortComb(@NotNull int[] data);

	public static native void sortComb(@NotNull long[] data);

	public static native void sortComb(@NotNull float[] data);

	public static native void sortComb(@NotNull double[] data);

	public static native void sortSelection(@NotNull int[] data);

	public static native void sortSelection(@NotNull long[] data);

	public static native void sortSelection(@NotNull float[] data);

	public static native void sortSelection(@NotNull double[] data);

	public static native void sortCocktail(@NotNull int[] data);

	public static native void sortCocktail(@NotNull long[] data);

	public static native void sortCocktail(@NotNull float[] data);

	public static native void sortCocktail(@NotNull double[] data);

	/**
	 * Returns a string representation of the contents of the specified array.
	 */
	@NonNls
	@NotNull
	@Contract(pure = true)
	@SuppressWarnings({"ConstantConditions", "ResultOfMethodCallIgnored"})
	public static <T> String toString(@Nullable T[] a) {
		if (a == null) return "null";
		if (a.length - 1 == -1) return "[]";

		StringBuilder b = new StringBuilder();
		b.append("[<");
		for (int i = 0; ; ++i) {
			if (a[i] != null) a[i].toString();
			else b.append("null");
			if (i == a.length - 1) return b.append(">]").toString();
			b.append(">, <");
		}
	}

	/**
	 * Returns a string representation of the contents of the specified array.
	 */
	@NonNls
	@NotNull
	@Contract(value = "_ -> !null", pure = true)
	public static String toString(@Nullable long[] a) {
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
	@NonNls
	@NotNull
	@Contract(value = "_ -> !null", pure = true)
	public static String toString(@Nullable int[] a) {
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
	@NonNls
	@NotNull
	@Contract(value = "_ -> !null", pure = true)
	public static String toString(@Nullable byte[] a) {
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
	@NonNls
	@NotNull
	@Contract(value = "_ -> !null", pure = true)
	public static String toString(@Nullable float[] a) {
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
	@NonNls
	@NotNull
	@Contract(value = "_ -> !null", pure = true)
	public static String toString(@Nullable double[] a) {
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
	@NonNls
	@NotNull
	@Contract(value = "_ -> !null", pure = true)
	public static String toString(@Nullable short[] a) {
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
	@NonNls
	@NotNull
	@Contract(value = "_ -> !null", pure = true)
	public static String toString(@Nullable char[] a) {
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
	 * returns a copy of an array
	 *
	 * @param data the data
	 * @return the copy of the array
	 */
	@Nullable
	@Contract(value = "!null -> !null; null -> null", pure = true)
	public static native int[] copy(@Nullable int[] data);

	/**
	 * returns a copy of an array
	 *
	 * @param data the data
	 * @return the copy of the array
	 */
	@Nullable
	@Contract(value = "!null -> !null; null -> null", pure = true)
	public static native long[] copy(@Nullable long[] data);

	/**
	 * returns a copy of an array
	 *
	 * @param data the data
	 * @return the copy of the array
	 */
	@Nullable
	@Contract(value = "!null -> !null; null -> null", pure = true)
	public static native float[] copy(@Nullable float[] data);

	/**
	 * returns a copy of an array
	 *
	 * @param data the data
	 * @return the copy of the array
	 */
	@Nullable
	@Contract(value = "!null -> !null; null -> null", pure = true)
	public static native double[] copy(@Nullable double[] data);

	/**
	 * returns a copy of an array
	 *
	 * @param data the data
	 * @return the copy of the array
	 */
	@Nullable
	@Contract(value = "!null -> !null; null -> null", pure = true)
	public static native short[] copy(@Nullable short[] data);

	/**
	 * returns a copy of an array
	 *
	 * @param data the data
	 * @return the copy of the array
	 */
	@Nullable
	@Contract(value = "!null -> !null; null -> null", pure = true)
	public static native byte[] copy(@Nullable byte[] data);

	/**
	 * returns a copy of an array
	 *
	 * @param data the data
	 * @return the copy of the array
	 */
	@Nullable
	@Contract(value = "!null -> !null; null -> null", pure = true)
	public static native boolean[] copy(@Nullable boolean[] data);

	/**
	 * returns a copy of an array
	 *
	 * @param data the data
	 * @return the copy of the array
	 */
	@Nullable
	@Contract(value = "!null -> !null; null -> null", pure = true)
	public static native boolean[] copy(@Nullable char[] data);

////fuck Cloneable
//	@Nullable
//	@Contract(value = "!null -> !null; null -> null", pure = true)
//	public static Cloneable[] copy(@Nullable Cloneable[] in) {
//		if (in == null) return null;
//		if (in.length == 0) return in.clone();
//		Cloneable[] ret = new Cloneable[in.length];
//		for (int i = 0; i < in.length; i++) {
//			ret[i] = in[i].clone();
//		}
//		return ret;
//	}

	/**
	 * kmp algorithm
	 *
	 * @param a sequence a (longer)
	 * @param b sequence b (shorter)
	 * @return how many times does b appears in a.
	 */
	@Contract(pure = true)
	public static native int kmp(@NotNull byte[] a, @NotNull byte[] b);

	/**
	 * @see SeqUtils#kmp(byte[], byte[])
	 */
	@Contract(pure = true)
	public static native int kmp(@NotNull int[] a, @NotNull int[] b);

	/**
	 * @see SeqUtils#kmp(byte[], byte[])
	 */
	@Contract(pure = true)
	public static native int kmp(@NotNull long[] a, @NotNull long[] b);

	/**
	 * @see SeqUtils#kmp(byte[], byte[])
	 */
	@Contract(pure = true)
	public static native int kmp(@NotNull char[] a, @NotNull char[] b);

	/**
	 * @see SeqUtils#kmp(byte[], byte[])
	 */
	@Contract(pure = true)
	public static int kmp(@NotNull String a, @NotNull String b) {
		return kmp(
				a.getBytes(),
				b.getBytes()
		);
	}

	public static class MultiThreadingQuickSorterInt {
		private final int flag;
		private final int[] array;

		public MultiThreadingQuickSorterInt(int[] array, int flag) {
			this.array = array;
			this.flag = flag;
		}

		public MultiThreadingQuickSorterInt(int[] array) {
			this(array, array.length / 1_000);
		}

		public void forkJoinSort() {
			ForkJoinPool forkJoinPool = new ForkJoinPool();
			forkJoinPool.submit(new SortTask(array, flag));
			forkJoinPool.shutdown();
			try {
				forkJoinPool.awaitTermination(10_000, TimeUnit.SECONDS);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		public void checkSort() {
			int num = array.length - 2;
			for (int i = 0; i < num; i++)
				if (array[i] > array[i + 1])
					throw new RuntimeException(array[i] + ">" + array[i + 1]);
		}

		private class SortTask extends RecursiveAction {
			private final int[] array;
			private final int start;
			private final int end;
			private final int flag;

			SortTask(int[] array, int flag) {
				this(array, 0, array.length - 1, flag);
			}

			private SortTask(int[] array, int start, int end, int flag) {
				this.array = array;
				this.start = start;
				this.end = end;
				this.flag = flag;
			}

			@Override
			protected void compute() {
				if (end - start < flag) {
					Arrays.sort(array, start, end + 1);
				} else {
					int pivot = partition(array, start, end);
					if (start < pivot - 1) new SortTask(array, start, pivot - 1, flag).fork();
					if (pivot + 1 < end) new SortTask(array, pivot + 1, end, flag).fork();
				}
			}

			private int partition(int[] array, int start, int end) {
				int i = start;
				int j = end;
				if (j - i > 2) {
					if ((array[i] < array[j - i] && array[j - i] < array[j])
							|| (array[j] < array[j - i] && array[j - i] < array[i])) {
						int t = array[i];
						array[i] = array[j - i];
						array[j - i] = t;
					} else {
						if ((array[i] < array[j] && array[j] < array[j - i])
								|| (array[j - i] < array[j] && array[j] < array[i])) {
							int t = array[i];
							array[i] = array[j];
							array[j] = t;
						}
					}
				}
				int pivot = array[i];
				while (i < j) {
					while (i < j && array[j] > pivot) j--;
					if (i < j) array[i++] = array[j];
					while (i < j && array[i] < pivot) i++;
					if (i < j) array[j--] = array[i];
				}
				array[i] = pivot;
				return i;
			}
		}
	}


	public static class MultiThreadingQuickSorterFloat {
		private final int flag;
		private final float[] array;

		public MultiThreadingQuickSorterFloat(float[] array, int flag) {
			this.array = array;
			this.flag = flag;
		}

		public MultiThreadingQuickSorterFloat(float[] array) {
			this(array, array.length / 1_000);
		}

		public void forkJoinSort() {
			ForkJoinPool forkJoinPool = new ForkJoinPool();
			forkJoinPool.submit(new SortTask(array, flag));
			forkJoinPool.shutdown();
			try {
				forkJoinPool.awaitTermination(10_000, TimeUnit.SECONDS);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		public void checkSort() {
			int num = array.length - 2;
			for (int i = 0; i < num; i++)
				if (array[i] > array[i + 1])
					throw new RuntimeException(array[i] + ">" + array[i + 1]);
		}

		private class SortTask extends RecursiveAction {
			private final float[] array;
			private final int start;
			private final int end;
			private final int flag;

			SortTask(float[] array, int flag) {
				this(array, 0, array.length - 1, flag);
			}

			private SortTask(float[] array, int start, int end, int flag) {
				this.array = array;
				this.start = start;
				this.end = end;
				this.flag = flag;
			}

			@Override
			protected void compute() {
				if (end - start < flag) {
					Arrays.sort(array, start, end + 1);
				} else {
					int pivot = partition(array, start, end);
					if (start < pivot - 1) new SortTask(array, start, pivot - 1, flag).fork();
					if (pivot + 1 < end) new SortTask(array, pivot + 1, end, flag).fork();
				}
			}

			private int partition(float[] array, int start, int end) {
				int i = start;
				int j = end;
				if (j - i > 2) {
					if ((array[i] < array[j - i] && array[j - i] < array[j])
							|| (array[j] < array[j - i] && array[j - i] < array[i])) {
						float t = array[i];
						array[i] = array[j - i];
						array[j - i] = t;
					} else {
						if ((array[i] < array[j] && array[j] < array[j - i])
								|| (array[j - i] < array[j] && array[j] < array[i])) {
							float t = array[i];
							array[i] = array[j];
							array[j] = t;
						}
					}
				}
				float pivot = array[i];
				while (i < j) {
					while (i < j && array[j] > pivot) j--;
					if (i < j) array[i++] = array[j];
					while (i < j && array[i] < pivot) i++;
					if (i < j) array[j--] = array[i];
				}
				array[i] = pivot;
				return i;
			}
		}
	}


	public static class MultiThreadingQuickSorterDouble {
		private final int flag;
		private final double[] array;

		public MultiThreadingQuickSorterDouble(double[] array, int flag) {
			this.array = array;
			this.flag = flag;
		}

		public MultiThreadingQuickSorterDouble(double[] array) {
			this(array, array.length / 1_000);
		}

		public void forkJoinSort() {
			ForkJoinPool forkJoinPool = new ForkJoinPool();
			forkJoinPool.submit(new SortTask(array, flag));
			forkJoinPool.shutdown();
			try {
				forkJoinPool.awaitTermination(10_000, TimeUnit.SECONDS);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		public void checkSort() {
			int num = array.length - 2;
			for (int i = 0; i < num; i++)
				if (array[i] > array[i + 1])
					throw new RuntimeException(array[i] + ">" + array[i + 1]);
		}

		private class SortTask extends RecursiveAction {
			private final double[] array;
			private final int start;
			private final int end;
			private final int flag;

			SortTask(double[] array, int flag) {
				this(array, 0, array.length - 1, flag);
			}

			private SortTask(double[] array, int start, int end, int flag) {
				this.array = array;
				this.start = start;
				this.end = end;
				this.flag = flag;
			}

			@Override
			protected void compute() {
				if (end - start < flag) {
					Arrays.sort(array, start, end + 1);
				} else {
					int pivot = partition(array, start, end);
					if (start < pivot - 1) new SortTask(array, start, pivot - 1, flag).fork();
					if (pivot + 1 < end) new SortTask(array, pivot + 1, end, flag).fork();
				}
			}

			private int partition(double[] array, int start, int end) {
				int i = start;
				int j = end;
				if (j - i > 2) {
					if ((array[i] < array[j - i] && array[j - i] < array[j])
							|| (array[j] < array[j - i] && array[j - i] < array[i])) {
						double t = array[i];
						array[i] = array[j - i];
						array[j - i] = t;
					} else {
						if ((array[i] < array[j] && array[j] < array[j - i])
								|| (array[j - i] < array[j] && array[j] < array[i])) {
							double t = array[i];
							array[i] = array[j];
							array[j] = t;
						}
					}
				}
				double pivot = array[i];
				while (i < j) {
					while (i < j && array[j] > pivot) j--;
					if (i < j) array[i++] = array[j];
					while (i < j && array[i] < pivot) i++;
					if (i < j) array[j--] = array[i];
				}
				array[i] = pivot;
				return i;
			}
		}
	}


	public static class MultiThreadingQuickSorterLong {
		private final int flag;
		private final long[] array;

		public MultiThreadingQuickSorterLong(long[] array, int flag) {
			this.array = array;
			this.flag = flag;
		}

		public MultiThreadingQuickSorterLong(long[] array) {
			this(array, array.length / 1_000);
		}

		public void forkJoinSort() {
			ForkJoinPool forkJoinPool = new ForkJoinPool();
			forkJoinPool.submit(new SortTask(array, flag));
			forkJoinPool.shutdown();
			try {
				forkJoinPool.awaitTermination(10_000, TimeUnit.SECONDS);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		public void checkSort() {
			int num = array.length - 2;
			for (int i = 0; i < num; i++)
				if (array[i] > array[i + 1])
					throw new RuntimeException(array[i] + ">" + array[i + 1]);
		}

		private class SortTask extends RecursiveAction {
			private final long[] array;
			private final int start;
			private final int end;
			private final int flag;

			SortTask(long[] array, int flag) {
				this(array, 0, array.length - 1, flag);
			}

			private SortTask(long[] array, int start, int end, int flag) {
				this.array = array;
				this.start = start;
				this.end = end;
				this.flag = flag;
			}

			@Override
			protected void compute() {
				if (end - start < flag) {
					Arrays.sort(array, start, end + 1);
				} else {
					int pivot = partition(array, start, end);
					if (start < pivot - 1) new SortTask(array, start, pivot - 1, flag).fork();
					if (pivot + 1 < end) new SortTask(array, pivot + 1, end, flag).fork();
				}
			}

			private int partition(long[] array, int start, int end) {
				int i = start;
				int j = end;
				if (j - i > 2) {
					if ((array[i] < array[j - i] && array[j - i] < array[j])
							|| (array[j] < array[j - i] && array[j - i] < array[i])) {
						long t = array[i];
						array[i] = array[j - i];
						array[j - i] = t;
					} else {
						if ((array[i] < array[j] && array[j] < array[j - i])
								|| (array[j - i] < array[j] && array[j] < array[i])) {
							long t = array[i];
							array[i] = array[j];
							array[j] = t;
						}
					}
				}
				long pivot = array[i];
				while (i < j) {
					while (i < j && array[j] > pivot) j--;
					if (i < j) array[i++] = array[j];
					while (i < j && array[i] < pivot) i++;
					if (i < j) array[j--] = array[i];
				}
				array[i] = pivot;
				return i;
			}
		}
	}
}

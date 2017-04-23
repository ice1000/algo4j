package org.algo4j.util;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.TimeUnit;

/**
 * Multi-Threading Quick Sort
 * Created by ice1000 on 2017/4/3.
 *
 * @author ice1000
 */
@SuppressWarnings("ALL")
public interface ParallelQuickSorter {

	/**
	 * start sorting
	 */
	void forkJoinSort();

	public static class MultiThreadingQuickSorterInt implements ParallelQuickSorter {
		private final int flag;
		private final int[] array;

		public MultiThreadingQuickSorterInt(int[] array, int flag) {
			this.array = array;
			this.flag = flag;
		}

		public MultiThreadingQuickSorterInt(int[] array) {
			this(array, array.length / 1_000);
		}

		@Override
		public void forkJoinSort() {
			ForkJoinPool forkJoinPool = new ForkJoinPool();
			forkJoinPool.submit(new SortTask(array, 0, array.length - 1, flag));
			forkJoinPool.shutdown();
			try {
				forkJoinPool.awaitTermination(10_000, TimeUnit.SECONDS);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}


//		Arrays.sort is much faster
//		private static void sortQuickInRange(
//				@NotNull int[] data,
//				int left,
//				int right) {
//			if (left >= right) return;
//			int i = left;
//			int j = right;
//			int temp = data[left];
//			while (i < j) {
//				while ((i < j) && (temp < data[j] || temp == data[j])) --j;
//				while ((i < j) && !(temp < data[i])) ++i;
//				if (i < j) {
//					int tmp = data[i];
//					data[i] = data[j];
//					data[j] = tmp;
//				}
//			}
//			data[left] = data[i];
//			data[i] = temp;
//			sortQuickInRange(data, left, i - 1);
//			sortQuickInRange(data, i + 1, right);
//		}

		private class SortTask extends RecursiveAction {
			private final int[] array;
			private final int start;
			private final int end;
			private final int flag;

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
//					Arrays.sort is much faster
//					sortQuickInRange(array, start, end + 1);
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

	public static class MultiThreadingQuickSorterFloat implements ParallelQuickSorter {
		private final int flag;
		private final float[] array;

		public MultiThreadingQuickSorterFloat(float[] array, int flag) {
			this.array = array;
			this.flag = flag;
		}

		public MultiThreadingQuickSorterFloat(float[] array) {
			this(array, array.length / 1_000);
		}

		@Override
		public void forkJoinSort() {
			ForkJoinPool forkJoinPool = new ForkJoinPool();
			forkJoinPool.submit(new SortTask(array, 0, array.length - 1, flag));
			forkJoinPool.shutdown();
			try {
				forkJoinPool.awaitTermination(10_000, TimeUnit.SECONDS);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		private class SortTask extends RecursiveAction {
			private final float[] array;
			private final int start;
			private final int end;
			private final int flag;

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

	public static class MultiThreadingQuickSorterDouble implements ParallelQuickSorter {
		private final int flag;
		private final double[] array;

		public MultiThreadingQuickSorterDouble(double[] array, int flag) {
			this.array = array;
			this.flag = flag;
		}

		public MultiThreadingQuickSorterDouble(double[] array) {
			this(array, array.length / 1_000);
		}

		@Override
		public void forkJoinSort() {
			ForkJoinPool forkJoinPool = new ForkJoinPool();
			forkJoinPool.submit(new SortTask(array, 0, array.length - 1, flag));
			forkJoinPool.shutdown();
			try {
				forkJoinPool.awaitTermination(10_000, TimeUnit.SECONDS);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		private class SortTask extends RecursiveAction {
			private final double[] array;
			private final int start;
			private final int end;
			private final int flag;

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

	public static class MultiThreadingQuickSorterLong implements ParallelQuickSorter {
		private final int flag;
		private final long[] array;

		public MultiThreadingQuickSorterLong(long[] array, int flag) {
			this.array = array;
			this.flag = flag;
		}

		public MultiThreadingQuickSorterLong(long[] array) {
			this(array, array.length / 1_000);
		}

		@Override
		public void forkJoinSort() {
			ForkJoinPool forkJoinPool = new ForkJoinPool();
			forkJoinPool.submit(new SortTask(array, 0, array.length - 1, flag));
			forkJoinPool.shutdown();
			try {
				forkJoinPool.awaitTermination(10_000, TimeUnit.SECONDS);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		private class SortTask extends RecursiveAction {
			private final long[] array;
			private final int start;
			private final int end;
			private final int flag;

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

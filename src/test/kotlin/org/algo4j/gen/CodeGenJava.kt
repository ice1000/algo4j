package org.algo4j.gen

import org.algo4j.test.println

/**
 * Created by ice1000 on 2016/12/6.
 *
 * @author ice1000
 */

fun gen1() {
	listOf(
			"discretization",
			"sortBubble",
			"sortComb",
			"sortSelection",
			"sortCocktail",
			"sortInsertion",
			"sortMerge",
			"sortQuick"
	).forEach { name ->
		listOf("int", "long", "float", "double").forEach { type ->
			"""
	private static native void $name($type[] data, int length);

	public static void $name($type[] data) {
		$name(data, data.length);
	}""".println()
		}
	}
	listOf(
			"inversion",
			"sum",
			"avg",
			"max",
			"min",
			"copy"
	).forEach { ass ->
		listOf("int", "long", "float", "double", "short", "byte").forEach { we ->
			"""
	@Nullable
	@Contract(value = "!null -> !null; null -> null", pure = true)
	public static native $we[] $ass(@Nullable $we[] data);""".println()
		}
	}
}

fun gen2() {
	listOf("int", "float", "double", "long").forEach { typename ->
		"""
	public static class MultiThreadingQuickSorter {
		private final int flag;
		private final $typename[] array;

		public MultiThreadingQuickSorter($typename[] array, int flag) {
			this.array = array;
			this.flag = flag;
		}

		public MultiThreadingQuickSorter($typename[] array) {
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
			private final $typename[] array;
			private final int start;
			private final int end;
			private final int flag;

			SortTask($typename[] array, int flag) {
				this(array, 0, array.length - 1, flag);
			}

			private SortTask($typename[] array, int start, int end, int flag) {
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

			private int partition($typename[] array, int start, int end) {
				int i = start;
				int j = end;
				if (j - i > 2) {
					if ((array[i] < array[j - i] && array[j - i] < array[j])
							|| (array[j] < array[j - i] && array[j - i] < array[i])) {
						$typename t = array[i];
						array[i] = array[j - i];
						array[j - i] = t;
					} else {
						if ((array[i] < array[j] && array[j] < array[j - i])
								|| (array[j - i] < array[j] && array[j] < array[i])) {
							$typename t = array[i];
							array[i] = array[j];
							array[j] = t;
						}
					}
				}
				$typename pivot = array[i];
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
""".println()
	}
}

fun main(args: Array<String>) {
	println("running code generation")
	gen2()
}


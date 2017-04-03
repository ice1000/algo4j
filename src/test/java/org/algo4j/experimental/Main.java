package org.algo4j.experimental;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
	private final int flag;
	private final int[] array;
	private final AtomicInteger threadCount;

	public Main(int flag, int len) {
		this.flag = flag;
		array = new int[len];
		Random random = new Random(System.currentTimeMillis());
		for (int i = 0; i < array.length; ++i) array[i] = random.nextInt();
		threadCount = new AtomicInteger(100);
	}

	public static void main(String[] args) throws IOException,
			InterruptedException {
		Main main = new Main(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
		main.forkJoinSort();
		main.checkSort();
	}

	@SuppressWarnings("WeakerAccess")
	public void forkJoinSort() {
		long beginTime = System.currentTimeMillis();
		ForkJoinPool forkJoinPool = new ForkJoinPool();
		forkJoinPool.submit(new SortTask(array));
		forkJoinPool.shutdown();
		try {
			forkJoinPool.awaitTermination(10_000, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		long endTime = System.currentTimeMillis();
		System.out.println("sort file:" + (endTime - beginTime) + "ms");
	}


	public void sort() {
		long beginTime = System.currentTimeMillis();
		sort(array, 0, array.length - 1);
		long endTime = System.currentTimeMillis();
		System.out.println("sort file:" + (endTime - beginTime) + "ms");
	}

	@SuppressWarnings("WeakerAccess")
	public void checkSort() {
		long beginTime = System.currentTimeMillis();
		boolean flag = true;
		int num = array.length - 2;
		for (int i = 0; i < num; i++) {
			if (array[i] > array[i + 1]) {
				System.out.println(array[i] + ">" + array[i + 1]);
				flag = false;
				break;
			}
		}
		long endTime = System.currentTimeMillis();
		System.out.println("check sort file " + flag + ":" + (endTime - beginTime) + "ms");
	}

	public void sort(final int a[], final int low, final int high) {
		if (high - low < flag) {
			Arrays.sort(a, low, high + 1);
			return;
		}
		int i = low;
		int j = high;
		if (j - i > 2) {
			if ((a[i] < a[j - i] && a[j - i] < a[j])
					|| (a[j] < a[j - i] && a[j - i] < a[i])) {
				int t = a[i];
				a[i] = a[j - i];
				a[j - i] = t;
			} else {
				if ((a[i] < a[j] && a[j] < a[j - i])
						|| (a[j - i] < a[j] && a[j] < a[i])) {
					int t = a[i];
					a[i] = a[j];
					a[j] = t;
				}
			}
		}
		int pivot = a[low];
		while (i < j) {
			while (i < j && a[j] > pivot) j--;
			if (i < j) a[i++] = a[j];
			while (i < j && a[i] < pivot) i++;
			if (i < j) a[j--] = a[i];
		}
		a[i] = pivot;
		List<Thread> threads = new ArrayList<>();
		final int imm = i - 1;
		if (low < imm) {
			if (threadCount.get() > 0 && imm - low > flag) {
				Thread t = new Thread() {
					{
						threadCount.decrementAndGet();
					}

					@Override
					public void run() {
						sort(a, low, imm);
						threadCount.addAndGet(1);
					}
				};
				t.start();
				threads.add(t);
			} else Arrays.sort(a, low, imm + 1);
		}
		final int ipp = i + 1;
		if (high > ipp) {
			if (threadCount.get() > 0 && high - ipp > flag) {
				Thread t = new Thread() {
					{
						threadCount.decrementAndGet();
					}

					@Override
					public void run() {
						sort(a, ipp, high);
						threadCount.addAndGet(1);
					}
				};
				t.start();
				threads.add(t);
			} else Arrays.sort(a, ipp, high + 1);
		}

		try {
			for (Thread t : threads) t.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

@SuppressWarnings("serial")
class SortTask extends RecursiveAction {
	private final int[] array;
	private final int start;
	private final int end;

	SortTask(int[] array) {
		this(array, 0, array.length - 1);
	}

	private SortTask(int[] array, int start, int end) {
		this.array = array;
		this.start = start;
		this.end = end;
	}

	@Override
	protected void compute() {
		int threshold = 300_0000;
		if (end - start < threshold) {
			Arrays.sort(array, start, end + 1);
		} else {
			int pivot = partition(array, start, end);
			SortTask left = null;
			SortTask right = null;
			if (start < pivot - 1) left = new SortTask(array, start, pivot - 1);
			if (pivot + 1 < end) right = new SortTask(array, pivot + 1, end);
			if (left != null) left.fork();
			if (right != null) right.fork();
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

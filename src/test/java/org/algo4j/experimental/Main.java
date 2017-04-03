package org.algo4j.experimental;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.TimeUnit;

public class Main {
	private final int flag;
	private final float[] array;

	private Main(int flag, int len) {
		this.flag = flag;
		this.array = new float[len];
		Random random = new Random(System.currentTimeMillis());
		for (int i = 0; i < array.length; ++i) array[i] = random.nextFloat() * 0x1000;
	}

	public static void main(String[] args) throws IOException,
			InterruptedException {
		for (int i = 0; i < 10; i++) {
			Main main = new Main(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
			main.forkJoinSort();
			main.checkSort();
		}
	}

	@SuppressWarnings("WeakerAccess")
	public void forkJoinSort() {
		long beginTime = System.currentTimeMillis();
		ForkJoinPool forkJoinPool = new ForkJoinPool();
		forkJoinPool.submit(new SortTask(array, flag));
		forkJoinPool.shutdown();
		try {
			forkJoinPool.awaitTermination(10_000, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
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

}

@SuppressWarnings("serial")
class SortTask extends RecursiveAction {
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

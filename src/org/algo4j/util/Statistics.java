package org.algo4j.util;

/**
 * Created by ice1000 on 2016/12/13.
 *
 * @author ice1000
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public final class Statistics {
	private Statistics() {
	}

	private static native int sum(int[] data, int length);

	public static int sum(int[] data) {
		return sum(data, data.length);
	}

	private static native long sum(long[] data, int length);

	public static long sum(long[] data) {
		return sum(data, data.length);
	}

	private static native float sum(float[] data, int length);

	public static float sum(float[] data) {
		return sum(data, data.length);
	}

	private static native double sum(double[] data, int length);

	public static double sum(double[] data) {
		return sum(data, data.length);
	}

	private static native double avg(int[] data, int length);

	public static double avg(int[] data) {
		return avg(data, data.length);
	}

	private static native double avg(long[] data, int length);

	public static double avg(long[] data) {
		return avg(data, data.length);
	}

	private static native double avg(float[] data, int length);

	public static double avg(float[] data) {
		return avg(data, data.length);
	}

	private static native double avg(double[] data, int length);

	public static double avg(double[] data) {
		return avg(data, data.length);
	}

	private static native int max(int[] data, int length);

	public static int max(int[] data) {
		return max(data, data.length);
	}

	private static native long max(long[] data, int length);

	public static long max(long[] data) {
		return max(data, data.length);
	}

	private static native float max(float[] data, int length);

	public static float max(float[] data) {
		return max(data, data.length);
	}

	private static native double max(double[] data, int length);

	public static double max(double[] data) {
		return max(data, data.length);
	}

	private static native int min(int[] data, int length);

	public static int min(int[] data) {
		return min(data, data.length);
	}

	private static native long min(long[] data, int length);

	public static long min(long[] data) {
		return min(data, data.length);
	}

	private static native float min(float[] data, int length);

	public static float min(float[] data) {
		return min(data, data.length);
	}

	private static native double min(double[] data, int length);

	public static double min(double[] data) {
		return min(data, data.length);
	}

	private static native double stdDiv(int[] data, int length);

	public static double stdDiv(int[] data) {
		return stdDiv(data, data.length);
	}

	private static native double stdDiv(long[] data, int length);

	public static double stdDiv(long[] data) {
		return stdDiv(data, data.length);
	}

	private static native double stdDiv(float[] data, int length);

	public static double stdDiv(float[] data) {
		return stdDiv(data, data.length);
	}

	private static native double stdDiv(double[] data, int length);

	public static double stdDiv(double[] data) {
		return stdDiv(data, data.length);
	}
}

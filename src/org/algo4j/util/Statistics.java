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

	public static native int sum(int[] data);

	public static native long sum(long[] data);

	public static native float sum(float[] data);

	public static native double sum(double[] data);

	public static native double avg(int[] data);

	public static native double avg(long[] data);

	public static native double avg(float[] data);

	public static native double avg(double[] data);

	public static native int max(int[] data);

	public static native long max(long[] data);

	public static native float max(float[] data);

	public static native double max(double[] data);

	public static native int min(int[] data);

	public static native long min(long[] data);

	public static native float min(float[] data);

	public static native double min(double[] data);

	public static native double stdDiv(int[] data);

	public static native double stdDiv(long[] data);

	public static native double stdDiv(float[] data);

	public static native double stdDiv(double[] data);
}

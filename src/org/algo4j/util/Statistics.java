package org.algo4j.util;

import org.jetbrains.annotations.NotNull;

/**
 * Created by ice1000 on 2016/12/13.
 *
 * @author ice1000
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public final class Statistics {
	private Statistics() {
	}

	public static native int sum(@NotNull int[] data);

	public static native long sum(@NotNull long[] data);

	public static native float sum(@NotNull float[] data);

	public static native double sum(@NotNull double[] data);

	public static native double avg(@NotNull int[] data);

	public static native double avg(@NotNull long[] data);

	public static native double avg(@NotNull float[] data);

	public static native double avg(@NotNull double[] data);

	public static native int max(@NotNull int[] data);

	public static native long max(@NotNull long[] data);

	public static native float max(@NotNull float[] data);

	public static native double max(@NotNull double[] data);

	public static native int min(@NotNull int[] data);

	public static native long min(@NotNull long[] data);

	public static native float min(@NotNull float[] data);

	public static native double min(@NotNull double[] data);

	public static native double stdDiv(@NotNull int[] data);

	public static native double stdDiv(@NotNull long[] data);

	public static native double stdDiv(@NotNull float[] data);

	public static native double stdDiv(@NotNull double[] data);
}

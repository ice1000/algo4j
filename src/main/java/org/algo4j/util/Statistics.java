package org.algo4j.util;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * Created by ice1000 on 2016/12/13.
 *
 * @author ice1000
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public final class Statistics {
	private Statistics() {
		throw new Error("do not instantiation me");
	}

	@Contract(pure = true)
	public static native int sum(@NotNull int[] data);

	@Contract(pure = true)
	public static native long sum(@NotNull long[] data);

	@Contract(pure = true)
	public static native float sum(@NotNull float[] data);

	@Contract(pure = true)
	public static native double sum(@NotNull double[] data);

	@Contract(pure = true)
	public static native double avg(@NotNull int[] data);

	@Contract(pure = true)
	public static native double avg(@NotNull long[] data);

	@Contract(pure = true)
	public static native double avg(@NotNull float[] data);

	@Contract(pure = true)
	public static native double avg(@NotNull double[] data);

	@Contract(pure = true)
	public static native int max(@NotNull int[] data);

	@Contract(pure = true)
	public static native long max(@NotNull long[] data);

	@Contract(pure = true)
	public static native float max(@NotNull float[] data);

	@Contract(pure = true)
	public static native double max(@NotNull double[] data);

	@Contract(pure = true)
	public static native int min(@NotNull int[] data);

	@Contract(pure = true)
	public static native long min(@NotNull long[] data);

	@Contract(pure = true)
	public static native float min(@NotNull float[] data);

	@Contract(pure = true)
	public static native double min(@NotNull double[] data);

	@Contract(pure = true)
	public static native double stdDiv(@NotNull int[] data);

	@Contract(pure = true)
	public static native double stdDiv(@NotNull long[] data);

	@Contract(pure = true)
	public static native double stdDiv(@NotNull float[] data);

	@Contract(pure = true)
	public static native double stdDiv(@NotNull double[] data);
}

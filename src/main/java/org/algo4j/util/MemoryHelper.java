package org.algo4j.util;

/**
 * A memory allocator using the new/delete management policy
 * <p>
 * Created by Phosphorus15 on 2019/3/1
 *
 * @author Phosphorus15
 */
public class MemoryHelper {

	public native static long allocateDoubles(int length);

	public native static void fillDoubles(long ptr, double[] array);

	public native static double getDouble(long ptr, int offset);

	public native static void setDouble(long ptr, int offset, double value);

	public native static void copyDoubles(long source, long dest, int length);

	public native static void free(long pointer);

}

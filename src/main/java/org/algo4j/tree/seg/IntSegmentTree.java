package org.algo4j.tree.seg;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

/**
 * Non-Recursive native implementation, expected to be the fasted above all. custom comparator/updater not supported
 * <p>
 * Use it for INTENSE application
 * <p>
 * Created by Phosphorus15 on 2019/2/24.
 *
 * @author Phosphorus15
 */
public class IntSegmentTree implements SegmentTree<Integer> {

	public enum Mode {
		MAX, MIN, SUM
	}

	protected final int[] data;

	private final int[] segments;

	private final Mode mode;

	private final int length;

	@SuppressWarnings("all")
	public IntSegmentTree(@NotNull int... data) {
		this(Mode.SUM, data);
	}

	@SuppressWarnings("all")
	public IntSegmentTree(Mode mode, @NotNull int... data) {
		this.data = data;
		length = data.length;
		segments = new int[length << 1];
		this.mode = mode;
		makeSeg(mode.ordinal(), data, segments, length);
	}

	@Override
	public Integer query(int l, int r) {
		return query(mode.ordinal(), l, r, segments, length);
	}

	@Override
	public void set(int l, int r, Integer value) {
		set(mode.ordinal(), l, r, segments, length, value);
	}

	@Override
	public int size() {
		return length;
	}

	/*
	  TODO Await implementation
	 */
	protected native void set(int mode, int l, int r, int[] segments, int length, int value);

	protected native void makeSeg(int mode, int[] data, int[] segments, int length);

	protected native int query(int mode, int l, int r, int[] segments, int length);

}

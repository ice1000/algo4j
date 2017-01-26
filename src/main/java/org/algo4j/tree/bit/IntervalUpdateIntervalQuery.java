package org.algo4j.tree.bit;

import org.algo4j.error.BinaryIndexedTreeException;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Created by ice1000 on 2016/11/18.
 *
 * @author ice1000
 */
@SuppressWarnings("WeakerAccess")
public final class IntervalUpdateIntervalQuery implements
		Cloneable {

	private final BinaryIndexedTree bit1;
	private final BinaryIndexedTree bit2;
	public final int length;

	public IntervalUpdateIntervalQuery(int length) {
		this.length = length + 1;
		bit1 = new BinaryIndexedTree(this.length);
		bit2 = new BinaryIndexedTree(this.length);
	}

	public IntervalUpdateIntervalQuery(@NotNull long... originValues) {
		this(originValues.length);
		long lastValue = 0;
		for (int i = 0; i < originValues.length; ++i) {
			bit1.add(i + 1, originValues[i] - lastValue);
			bit2.add(i + 1, i * (originValues[i] - lastValue));
			lastValue = originValues[i];
		}
	}

	private IntervalUpdateIntervalQuery(
			@NotNull BinaryIndexedTree bit1,
			@NotNull BinaryIndexedTree bit2) {
		this.bit1 = bit1;
		this.bit2 = bit2;
		this.length = bit1.length;
	}

	/**
	 * O(n) = 4 * log(n)
	 * update all values in [begin, end]
	 * begin >= 1, end <= length
	 *
	 * @param begin left bound of [begin, end], >= 1
	 * @param end   right bound of [begin, end] <= length
	 * @param value every element in [begin, end] will 'plus assign' value.
	 */
	public synchronized void update(int begin, int end, long value) {
		if (end < begin) throw new BinaryIndexedTreeException("end should be smaller than begin!");
		bit1.add(begin, value);
		bit1.add(end + 1, -value);
		bit2.add(begin, value * (begin - 1));
		bit2.add(end + 1, -value * end);
	}

	/**
	 * O(n) = 4 * log(n)
	 * returns sum(right) - sum(left). Mention that it's (left, right]
	 *
	 * @param begin left bound of (left, right]
	 * @param end   right bound of (left, right]
	 * @return sum(right) - sum(left)
	 */
	@Contract(pure = true)
	public long query(int begin, int end) {
		if (end < begin) throw new BinaryIndexedTreeException("end should be smaller than begin!");
		return (end * bit1.sum(end) - bit2.sum(end)) -
				((begin - 1) * bit1.sum(begin - 1) - bit2.sum(begin - 1));
	}

	@Override
	@Contract(value = "null -> false", pure = true)
	public boolean equals(@Nullable Object obj) {
		if (obj == null || !(obj instanceof IntervalUpdateIntervalQuery)) return false;
		if (obj == this) return true;
		IntervalUpdateIntervalQuery o = (IntervalUpdateIntervalQuery) obj;
		return this.bit1.equals(o.bit1) && this.bit2.equals(o.bit2);
	}

	@Override
	@NotNull
	@Contract(value = " -> !null", pure = true)
	public IntervalUpdateIntervalQuery clone() {
		return new IntervalUpdateIntervalQuery(
				bit1.clone(),
				bit2.clone()
		);
	}
}

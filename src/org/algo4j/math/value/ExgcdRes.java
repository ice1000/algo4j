package org.algo4j.math.value;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.Serializable;

/**
 * Created by ice1000 on 2016/12/10.
 *
 * @author ice1000
 */
@SuppressWarnings("WeakerAccess")
public final class ExgcdRes implements
		Serializable,
		Cloneable {
	private final long c;
	private final long x;
	private final long y;

	@Contract(pure = true)
	public ExgcdRes(@NotNull long[] data) {
		this(data[0], data[1], data[2]);
	}

	@Contract(pure = true)
	public ExgcdRes(long c, long x, long y) {
		this.c = c;
		this.x = x;
		this.y = y;
	}

	@Contract(pure = true)
	public long getC() {
		return c;
	}

	@Contract(pure = true)
	public long getX() {
		return x;
	}

	@Contract(pure = true)
	public long getY() {
		return y;
	}

	@Override
	@Contract(value = "null -> false", pure = true)
	public boolean equals(@Nullable Object obj) {
		if (obj == null || !(obj instanceof ExgcdRes)) return false;
		if (this == obj) return true;
		ExgcdRes o = (ExgcdRes) obj;
		return getC() == o.c && getX() == o.x && getY() == o.y;
	}

	@Override
	@NotNull
	@Contract(value = " -> !null", pure = true)
	public ExgcdRes clone() {
		return new ExgcdRes(c, x, y);
	}
}

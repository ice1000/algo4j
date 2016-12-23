package org.algo4j.math.value;

/**
 * Created by ice1000 on 2016/12/10.
 *
 * @author ice1000
 */
@SuppressWarnings({"WeakerAccess", "SpellCheckingInspection"})
public class ExgcdRes {
	private long c;
	private long x;
	private long y;

	public ExgcdRes(long[] data) {
		this(data[0], data[1], data[2]);
	}

	public ExgcdRes(long c, long x, long y) {
		this.c = c;
		this.x = x;
		this.y = y;
	}

	public long getC() {
		return c;
	}

	public long getX() {
		return x;
	}

	public long getY() {
		return y;
	}
}

package org.algo4j.math.value;

/**
 * Created by ice1000 on 2016/12/10.
 *
 * @author ice1000
 */
public class ExgcdRes {
	private long c;
	private long x;
	private long y;

	public ExgcdRes(long c, long x, long y) {
		this.c = c;
		this.x = x;
		this.y = y;
	}
	
	public ExgcdRes(long[] data) {
		c = data[0];
		x = data[1];
		y = data[2];
	}

	public long getC() {
		return c;
	}

	public void setC(long c) {
		this.c = c;
	}

	public long getX() {
		return x;
	}

	public void setX(long x) {
		this.x = x;
	}

	public long getY() {
		return y;
	}

	public void setY(long y) {
		this.y = y;
	}
}

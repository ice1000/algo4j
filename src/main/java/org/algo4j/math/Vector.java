package org.algo4j.math;

import org.algo4j.util.MemoryHelper;

import java.nio.DoubleBuffer;

/**
 * This vector is a double container for mathematical use, all of its memory is directory allocated and should be freed after use
 * <p>
 * Created by Phosphorus15 on 2019/3/1
 *
 * @author Phosphorus15
 */
@SuppressWarnings("WeakerAccess")
public class Vector implements Cloneable {

	private final long pointer;

	private final int length;

	public Vector(int length) {
		this.pointer = MemoryHelper.allocateDoubles(length);
		this.length = length;
	}

	public Vector(double... array) {
		this(array.length);
		MemoryHelper.fillDoubles(this.pointer, array);
	}

	public Vector(Vector vector) {
		this(vector.size());
		MemoryHelper.copyDoubles(vector.pointer, this.pointer, length);
	}

	public int size() {
		return length;
	}

	public void set(int x, double value) {
		MemoryHelper.setDouble(this.pointer, x, value);
	}

	public double get(int x) {
		return MemoryHelper.getDouble(this.pointer, x);
	}

	public void add(double value) {
		add(this.pointer, value, this.length);
	}

	public void multiply(double value) {
		multiply(this.pointer, value, this.length);
	}

	public void add(Vector obj) {
		if (obj.length == this.length) add(this.pointer, obj.pointer, this.length);
		else throw new IllegalArgumentException("Provided vectors must be of the same size");
	}

	public void multiply(Vector obj) {
		if (obj.length == this.length) multiply(this.pointer, obj.pointer, this.length);
		else throw new IllegalArgumentException("Provided vectors must be of the same size");
	}

	public double product(Vector obj) {
		return this.product(obj.pointer, this.pointer, this.length);
	}

	private native void add(long pointer, double value, int length);

	private native void add(long dest, long source, int length);

	private native void multiply(long pointer, double value, int length);

	private native void multiply(long dest, long source, int length);

	private native double product(long x, long y, int length);

	/**
	 * Invoke after use
	 */
	public void free() {
		MemoryHelper.free(this.pointer);
	}

	@Override
	@SuppressWarnings("all")
	protected Vector clone() {
		return new Vector(this);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Vector) {
			if (((Vector) obj).size() != length) return false;
			for (int i = 0; i < length; i++)
				if (Math.abs(get(i) - ((Vector) obj).get(i)) > 1e-6) return false;
		} else return false;
		return true;
	}

	@Override
	public int hashCode() {
		int base = size();
		for (int i = 0; i < length; i++) {
			base ^= Double.hashCode(get(i));
		}
		return base;
	}

	@Override
	public String toString() {
		StringBuilder base = new StringBuilder("Vec" + length + " (");
		for (int i = 0; i < length; i++) {
			base.append(get(i)).append(", ");
		}
		if (length > 0) base.delete(base.length() - 2, base.length());
		base.append(')');
		return base.toString();
	}
}

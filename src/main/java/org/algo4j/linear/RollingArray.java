package org.algo4j.linear;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by ice1000 on 2017/2/1.
 *
 * @author ice1000
 */
@SuppressWarnings("unchecked")
public class RollingArray<T> implements Container<T> {

	private final Object[] data;
	private final int maxLen;
	private int index;

	public RollingArray(int maxLen) {
		this.maxLen = maxLen;
		data = new Object[maxLen];
	}

	private RollingArray(T[] data, int maxLen, int index) {
		this.maxLen = maxLen;
		this.data = data;
		this.index = index;
	}

	@Override
	public int size() {
		return maxLen;
	}

	@Nullable
	@Override
	public T get(int index) {
		return (T) data[index % maxLen];
	}

	@Override
	public void set(int index, @Nullable T element) {
		data[index % maxLen] = element;
	}

	@Override
	public void push(@NotNull T obj) {
		data[index++ % maxLen] = obj;
	}

	@Nullable
	@Override
	public T top() {
		return empty() ? null : (T) data[(index - 1) % maxLen];
	}

	@Override
	public void pop() {
		--index;
	}

	@Override
	public RollingArray<T> clone() {
		return new RollingArray<>((T[]) data.clone(), maxLen, index);
	}

	@Override
	public Iterator iterator() {
		return new RollingArrItr<>(this);
	}

	public class RollingArrItr<E> implements Iterator<E> {
		private int cursor;
		private final RollingArray<E> arr;

		public RollingArrItr(@NotNull RollingArray<E> arr) {
			this.arr = arr;
			cursor = 0;
		}

		@Override
		public boolean hasNext() {
			return true;
		}

		@Nullable
		@Override
		public E next() {
			if (!hasNext()) throw new NoSuchElementException();
			return arr.get(cursor++);
		}

		@Override
		public void remove() {
			arr.set(cursor++, null);
		}
	}
}

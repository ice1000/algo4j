package org.algo4j.linear;

import org.algo4j.error.QueueException;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

/**
 * Created by ice1000 on 2017/1/11.
 *
 * @author ice1000
 */
@SuppressWarnings("ALL")
public class Queue<T> implements
		Container<T> {

	private final Object[] data;
	private final int maxLen;
	private int begin;
	private int end;

	public Queue() {
		this(1000);
	}

	public Queue(int maxLen) {
		this.maxLen = maxLen;
		data = new Object[maxLen];
		begin = 0;
		end = 0;
	}

	private Queue(@NotNull T[] data, int begin, int end) {
		this.data = data;
		this.maxLen = data.length;
		this.begin = begin;
		this.end = end;
	}

	@Override
	@Contract(pure = true)
	public int size() {
		return end - begin;
	}

	@Nullable
	@Override
	public T get(int index) {
		return (empty() || index >= size()) ? null : (T) data[(begin + index) % maxLen];
	}

	@Nullable
	@Override
	public void set(int index, T element) {
		if (empty() || index >= size()) {
			throw QueueException.overflow();
		}
		data[index] = element;
	}

	/**
	 * push an object
	 *
	 * @param obj object
	 * @throws QueueException if queue overflow
	 */
	@Override
	public void push(@NotNull T obj) {
		if (size() >= maxLen) {
			throw QueueException.overflow();
		} else {
			data[end++ % maxLen] = obj;
		}
	}

	@Override
	@NotNull
	@Contract(value = " -> !null", pure = true)
	public Container<T> clone() {
		return new Queue<>((T[]) data, begin, end);
	}

	@Override
	public void pop() {
		++begin;
	}

	@Override
	@Nullable
	@Contract(pure = true)
	public T top() {
		return empty() ? null : (T) data[begin % maxLen];
	}

	@Override
	@NotNull
	@Contract(value = " -> !null", pure = true)
	public Iterator<T> iterator() {
		return new QueueItr(this);
	}

	@Override
	public void forEach(@NotNull Consumer<? super T> action) {
		for (int cursor = begin; cursor <= end; ++cursor) {
			action.accept((T) data[cursor % maxLen]);
		}
	}

	public class QueueItr<E> implements Iterator<E> {
		private int cursor;
		private Queue<E> context;

		public QueueItr(@NotNull Queue<E> queue) {
			cursor = queue.begin;
			context = queue;
		}

		@Override
		@Contract(pure = true)
		public boolean hasNext() {
			return cursor < context.end;
		}

		@Nullable
		@Override
		public E next() {
			if (hasNext())
				return (E) context.data[cursor++ % context.maxLen];
			else
				throw new NoSuchElementException();
		}
	}

}

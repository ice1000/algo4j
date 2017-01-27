package org.algo4j.linear;

import org.algo4j.error.StackException;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * Created by ice1000 on 2017/1/10.
 *
 * @author ice1000
 */
@SuppressWarnings("ALL")
public class Stack<T> implements
		Container<T> {
	private final Object[] data;
	private final int maxLen;
	private int cursor;

	public Stack() {
		this(1000);
	}

	public Stack(int maxLen) {
		this.maxLen = maxLen;
		data = new Object[maxLen];
		cursor = 0;
	}

	private Stack(@NotNull T[] data, int maxLen, int cursor) {
		this.data = data;
		this.maxLen = maxLen;
		this.cursor = cursor;
//		java.util.Stack
	}

	@Override
	@Contract(pure = true)
	public int size() {
		return cursor;
	}

	@Override
	@Contract(pure = true)
	public boolean empty() {
		return size() <= 0;
	}

	@Override
	@Nullable
	@Contract(pure = true)
	public T top() {
		return empty() ? null : (T) data[cursor - 1];
	}

	@Override
	@Nullable
	public T pop() {
		return empty() ? null : (T) data[--cursor];
	}

	/**
	 * push an object
	 *
	 * @param obj object
	 * @throws StackException if stack overflow
	 */
	@Override
	public void push(@NotNull T obj) {
		if (cursor > maxLen) {
			throw StackException.overflow();
		} else {
			data[cursor++] = obj;
		}
	}

	@Override
	@NotNull
	@Contract(" -> !null")
	public Stack<T> clone() {
		return new Stack<>((T[]) data.clone(), maxLen, cursor);
	}

	@Override
	public void forEach(@NotNull Consumer<? super T> action) {
		for (int i = 0; i < cursor; ++i) {
			action.accept((T) data[i % maxLen]);
		}
	}

	@Override
	@NotNull
	@Contract(value = " -> !null", pure = true)
	public Iterator<T> iterator() {
		return new StackItr(this);
	}

	public class StackItr<E> implements Iterator<E> {
		private int cursor;
		private Stack<E> context;

		public StackItr(@NotNull Stack<E> queue) {
			cursor = 0;
			context = queue;
		}

		@Override
		@Contract(pure = true)
		public boolean hasNext() {
			return cursor < context.size();
		}

		@Nullable
		@Override
		public E next() {
			return hasNext() ? (E) context.data[cursor++] : null;
		}
	}
}

package org.algo4j.linear;

import org.algo4j.error.QueueException;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * Created by ice1000 on 2017/1/27.
 *
 * @author ice1000
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class IntQueue implements IntContainer {
	private final int[] data;
	private final int maxLen;
	private int begin;
	private int end;

	public IntQueue() {
		this(1000);
	}

	public IntQueue(int maxLen) {
		this.maxLen = maxLen;
		data = new int[maxLen];
		begin = 0;
		end = 0;
	}

	private IntQueue(@NotNull int[] data, int begin, int end) {
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

	@Override
	@Contract(pure = true)
	public boolean empty() {
		return size() <= 0;
	}

	/**
	 * push an object
	 *
	 * @param obj object
	 * @throws QueueException if queue overflow
	 */
	@Override
	public void push(int obj) {
		if (size() >= maxLen) {
			throw QueueException.overflow();
		} else {
			data[end++ % maxLen] = obj;
		}
	}

	@Override
	@NotNull
	@Contract(value = " -> !null", pure = true)
	public IntQueue clone() {
		return new IntQueue(data, begin, end);
	}

	@Override
	public void pop() {
		if (!empty()) ++begin;
		else throw QueueException.overflow();
	}

	@Override
	@Contract(pure = true)
	public int top() {
		if (empty()) throw QueueException.overflow();
		return data[begin % maxLen];
	}

}

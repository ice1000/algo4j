package org.algo4j.tree.heap;

import org.algo4j.error.HeapException;
import org.algo4j.util.SeqUtils;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * minimum binary heap
 * Created by ice1000 on 2017/1/18.
 *
 * @author ice1000
 */
@SuppressWarnings("WeakerAccess")
public class MinHeap implements
		Cloneable {
	protected final int[] data;
	private final int length;
	private int cursor;

	protected MinHeap(@NotNull int... data) {
		this.length = data.length;
		this.data = data;
		this.cursor = data.length;
	}

	public MinHeap(int length) {
		this.data = new int[length + 1];
		this.data[0] = -1;
		this.length = length;
		this.cursor = 0;
	}

	@Contract(pure = true)
	public int getElementAt(int index) {
		if (index <= 0 || index > size()) throw HeapException.overflow();
		return data[index];
	}

	@Contract(pure = true)
	public int size() {
		return cursor;
	}

	@NotNull
	@Contract(value = "!null -> !null", pure = true)
	protected static native int[] makeHeap(@NotNull int[] origin);

	private static native void push(
			@NotNull int[] data,
			int cursor,
			int element
	);

	@SuppressWarnings("SameParameterValue")
	private static native void minHeapify(
			@NotNull int[] data,
			int cursor,
			int index
	);

	@Contract(pure = true)
	public boolean empty() {
		return cursor <= 0;
	}

	public void push(int element) {
		if (cursor > length) throw HeapException.overflow();
//		else if (empty()) {
//			data[1] = element;
//			++cursor;
//		}
//		else if (empty()) data[cursor++] = element;
		else push(data, ++cursor, element);
	}

	public int peek() {
		int ret = top();
		pop();
		return ret;
	}

	public int top() {
		return data[1];
	}

	public void pop() {
		data[1] = data[cursor];
		minHeapify(data, --cursor, 1);
	}

	@NotNull
	@Contract("_ -> !null")
	public static MinHeap make(int... origin) {
		return new MinHeap(makeHeap(origin));
	}

	@Override
	@NotNull
	@Contract(pure = true)
	@SuppressWarnings("MethodDoesntCallSuperMethod")
	public MinHeap clone() {
		return new MinHeap(SeqUtils.copy(data));
	}

	@Override
	@Contract(value = "null -> false", pure = true)
	public boolean equals(@Nullable Object obj) {
		if (obj == null || !(obj instanceof MinHeap)) return false;
		if (obj == this) return true;
		MinHeap o = (MinHeap) obj;
		if (o.length != this.length) return false;
		for (int i = 0; i < this.length; ++i) if (this.data[i] != o.data[i]) return false;
		return true;
	}
}

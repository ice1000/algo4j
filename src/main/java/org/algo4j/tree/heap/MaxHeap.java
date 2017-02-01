package org.algo4j.tree.heap;

import org.algo4j.error.HeapException;
import org.algo4j.util.SeqUtils;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * maximum binary heap
 * Created by ice1000 on 2017/1/31.
 *
 * @author ice1000
 */
@SuppressWarnings("WeakerAccess")
public class MaxHeap implements
		Heap {
	protected final int[] data;
	private final int length;
	private int cursor;

	private MaxHeap(@NotNull int... data) {
		this.length = data.length;
		this.data = data;
		this.cursor = data.length;
	}

	public MaxHeap(int length) {
		this.data = new int[length + 1];
		this.data[0] = -1;
		this.length = length;
		this.cursor = 0;
	}

	@Override
	@Contract(pure = true)
	public int getElementAt(int index) {
		if (index <= 0 || index > size()) throw HeapException.overflow();
		return data[index];
	}

	@Override
	@Contract(pure = true)
	public int size() {
		return cursor - 1;
	}

	@NotNull
	@Contract(value = "!null -> !null", pure = true)
	private static native int[] makeHeap(@NotNull int[] origin);

	private static native void insert(
			@NotNull int[] data,
			int cursor,
			int element
	);

	@SuppressWarnings("SameParameterValue")
	private static native void maxHeapify(
			@NotNull int[] data,
			int cursor,
			int index
	);

	@Override
	@Contract(pure = true)
	public boolean empty() {
		return cursor <= 1;
	}

	@Override
	public void push(int element) {
		if (cursor > length) throw HeapException.overflow();
//		else if (empty()) {
//			data[1] = element;
//			++cursor;
//		}
//		else if (empty()) data[cursor++] = element;
		else insert(data, ++cursor, element);
	}

	@Override
	public int top() {
		return data[1];
	}

	@Override
	public void pop() {
		data[1] = data[size()];
		maxHeapify(data, --cursor, 1);
	}

	@NotNull
	@Contract("_ -> !null")
	public static MaxHeap make(int... origin) {
		return new MaxHeap(makeHeap(origin));
	}

	@Override
	@NotNull
	@Contract(pure = true)
	@SuppressWarnings("MethodDoesntCallSuperMethod")
	public MaxHeap clone() {
		return new MaxHeap(SeqUtils.copy(data));
	}

	@Override
	@Contract(value = "null -> false", pure = true)
	public boolean equals(@Nullable Object obj) {
		if (obj == null || !(obj instanceof MaxHeap)) return false;
		if (obj == this) return true;
		MaxHeap o = (MaxHeap) obj;
		if (o.size() != this.size()) return false;
		for (int i = 1; i <= this.size(); ++i) if (this.data[i] != o.data[i]) return false;
		return true;
	}
}

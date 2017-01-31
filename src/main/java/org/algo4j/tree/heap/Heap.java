package org.algo4j.tree.heap;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * Created by ice1000 on 2017/1/31.
 *
 * @author ice1000
 */
public interface Heap extends Cloneable {
	@Contract(pure = true)
	int getElementAt(int index);

	@Contract(pure = true)
	int size();

	@Contract(pure = true)
	boolean empty();

	void push(int element);

	default int peek() {
		int ret = top();
		pop();
		return ret;
	}

	@Contract(pure = true)
	int top();

	void pop();

	@NotNull
	@Contract(pure = true)
	MinHeap clone();
}

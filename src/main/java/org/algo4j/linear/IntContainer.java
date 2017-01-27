package org.algo4j.linear;

import org.jetbrains.annotations.Contract;

/**
 * Created by ice1000 on 2017/1/27.
 *
 * @author ice1000
 */
public interface IntContainer {
	@Contract(pure = true)
	int size();

	@Contract(pure = true)
	boolean empty();

	void push(int element);

	@Contract(pure = true)
	int top();

	void pop();

	default int peek() {
		int ret = top();
		pop();
		return ret;
	}

	@Contract(pure = true)
	IntContainer clone();
}

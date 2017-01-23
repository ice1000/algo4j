package org.algo4j.linear;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.Serializable;

/**
 * Created by ice1000 on 2017/1/11.
 *
 * @author ice1000
 */
public interface Container<T> extends
		Cloneable,
		Serializable,
		Iterable<T> {
	@Contract(pure = true)
	int size();

	@Contract(pure = true)
	boolean empty();

	void push(@NotNull T obj);

	@Nullable
	@Contract(pure = true)
	T front();

	@Nullable
	T pop();

	@Contract(pure = true)
	Container<T> clone();
}

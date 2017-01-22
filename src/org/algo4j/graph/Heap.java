package org.algo4j.graph;

import org.algo4j.util.SeqUtils;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Created by ice1000 on 2017/1/18.
 *
 * @author ice1000
 */
public class Heap implements
		Cloneable {
	private final int[] data;
	private final int length;

	public Heap(@NotNull int... data) {
		this.data = data;
		this.length = data.length;
	}

	@NotNull
	@Contract("!null -> !null")
	private static native int[] makeHeap(@NotNull int[] origin);

	@NotNull
	@Contract("_ -> !null")
	public static Heap make(int... origin) {
		return new Heap(origin);
	}

	@Override
	@NotNull
	@Contract(pure = true)
	@SuppressWarnings("MethodDoesntCallSuperMethod")
	public Heap clone() {
		return new Heap(SeqUtils.copy(data));
	}

	@Override
	@Contract(value = "null -> false", pure = true)
	public boolean equals(@Nullable Object obj) {
		if (obj == null || !(obj instanceof Heap)) return false;
		if (obj == this) return true;
		Heap o = (Heap) obj;
		if (o.length != this.length) return false;
		for (int i = 0; i < this.length; ++i) if (this.data[i] != o.data[i]) return false;
		return true;
	}
}

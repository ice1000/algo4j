package org.algo4j.graph;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * Created by ice1000 on 2017/1/18.
 *
 * @author ice1000
 */
public class Heap {
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
}

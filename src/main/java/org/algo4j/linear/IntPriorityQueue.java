package org.algo4j.linear;

import org.algo4j.tree.heap.MinHeap;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * Created by ice1000 on 2017/1/27.
 *
 * @author ice1000
 */
@SuppressWarnings("WeakerAccess")
public class IntPriorityQueue extends MinHeap implements IntContainer {
	protected IntPriorityQueue(@NotNull int... data) {
		super(data);
	}

	@NotNull
	@Contract("_ -> !null")
	public static IntPriorityQueue make(@NotNull int... origin) {
		return new IntPriorityQueue(MinHeap.makeHeap(origin));
	}

	@NotNull
	@Override
	public IntPriorityQueue clone() {
		return new IntPriorityQueue(data);
	}
}

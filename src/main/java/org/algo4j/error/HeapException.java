package org.algo4j.error;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;

/**
 * Created by ice1000 on 2017/1/24.
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class HeapException extends RuntimeException {
	public HeapException(@NotNull @Nls String message) {
		super(message);
	}

	public HeapException() {
		this("MinHeap error!");
	}

	@NotNull
	@Contract(" -> !null")
	public static HeapException overflow() {
		return new HeapException("MinHeap overflow!");
	}
}

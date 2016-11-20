package org.ice1000.error;

/**
 * Created by ice1000 on 2016/11/17.
 *
 * @author ice1000
 */
public final class BinaryIndexedTreeException extends RuntimeException {
	public BinaryIndexedTreeException() {
		this("Binary indexed tree error!");
	}

	public BinaryIndexedTreeException(String message) {
		super(message);
	}

	public static BinaryIndexedTreeException indexOutBound() {
		return new BinaryIndexedTreeException("Index out of bound!");
	}
}

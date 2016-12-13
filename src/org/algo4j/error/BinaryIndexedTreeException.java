package org.algo4j.error;

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

	public static BinaryIndexedTreeException indexOutBound(int index) {
		return new BinaryIndexedTreeException("Index " + index + " out of bound!");
	}

	public static BinaryIndexedTreeException indexOutBound() {
		return new BinaryIndexedTreeException("Index out of bound!");
	}
}

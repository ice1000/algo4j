package org.ice1000.error;

/**
 * Created by ice1000 on 2016/11/19.
 *
 * @author ice1000
 */
public final class UnionSetException extends RuntimeException {
	public UnionSetException() {
		this("Union set error!");
	}

	public UnionSetException(String message) {
		super(message);
	}

	public static UnionSetException indexOutBound() {
		return new UnionSetException("Index out of bound!");
	}
}

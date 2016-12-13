package org.algo4j.error;

/**
 * Created by ice1000 on 2016/11/18.
 *
 * @author ice1000
 */
public final class FrontStarGraphException extends RuntimeException {
	public FrontStarGraphException() {
		this("Front star graph error!");
	}

	public FrontStarGraphException(String message) {
		super(message);
	}

	public static FrontStarGraphException indexOutBound() {
		return new FrontStarGraphException("Index out of bound!");
	}

	public static FrontStarGraphException numberInvalid() {
		return new FrontStarGraphException("node number is invalid!");
	}
}

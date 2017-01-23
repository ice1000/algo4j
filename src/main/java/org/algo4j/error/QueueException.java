package org.algo4j.error;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;

/**
 * Created by ice1000 on 2017/1/10.
 *
 * @author ice1000
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class QueueException extends RuntimeException {
	public QueueException(@NotNull @Nls String message) {
		super(message);
	}

	public QueueException() {
		this("Queue error!");
	}

	@Contract(pure = true)
	public static QueueException overflow() {
		return new QueueException("queue overflow!");
	}
}

package org.algo4j.error;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;

/**
 * Created by ice1000 on 2017/1/30.
 *
 * @author ice1000
 */
@SuppressWarnings("WeakerAccess")
public class TrieException extends RuntimeException {
	public TrieException() {
		this("trie error!");
	}

	public TrieException(@NotNull @Nls String message) {
		super(message);
	}

	@NotNull
	@Contract("_ -> !null")
	public static TrieException illegalCharacter(char a) {
		return new TrieException("illegal character inserted: " + a + "!");
	}

	@NotNull
	@Contract(" -> !null")
	public static TrieException illegalCharacter() {
		return illegalCharacter(' ');
	}
}

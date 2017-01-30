package org.algo4j.tree;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

/**
 * Trie tree, supporting smaller case letters and space.
 * Created by ice1000 on 2017/1/30.
 *
 * @author ice1000
 */
@SuppressWarnings("WeakerAccess")
public class Trie {
	private long triePointer;

	private static native long createTrie();

	private static native long deleteTrie(long triePointer);

	public Trie() {
		triePointer = createTrie();
	}

	private native void insert(long ptr, @NotNull byte[] word);

	public void insert(@NotNull @NonNls String word) {
		insert(word.getBytes());
	}

	public void insert(@NotNull byte[] word) {
		insert(triePointer, word);
	}

	private native void remove(long ptr, @NotNull byte[] word);

	public void remove(@NotNull @NonNls String word) {
		remove(word.getBytes());
	}

	public void remove(@NotNull byte[] word) {
		remove(triePointer, word);
	}

	@Contract(pure = true)
	private native boolean contains(long ptr, @NotNull byte[] word);

	@Contract(pure = true)
	public boolean contains(@NotNull @NonNls String word) {
		return contains(word.getBytes());
	}

	@Contract(pure = true)
	public boolean contains(@NotNull byte[] word) {
		return contains(triePointer, word);
	}

	@Contract(pure = true)
	private native boolean containsPrefix(long ptr, @NotNull byte[] word);

	@Contract(pure = true)
	public boolean containsPrefix(@NotNull @NonNls String word) {
		return containsPrefix(word.getBytes());
	}

	@Contract(pure = true)
	public boolean containsPrefix(@NotNull byte[] word) {
		return containsPrefix(triePointer, word);
	}

	@Override
	public void finalize() {
		deleteTrie(triePointer);
	}
}

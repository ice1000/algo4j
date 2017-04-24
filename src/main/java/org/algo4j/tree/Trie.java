package org.algo4j.tree;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Trie tree, supporting smaller case letters and space.
 * Created by ice1000 on 2017/1/30.
 *
 * @author ice1000
 */
@SuppressWarnings("WeakerAccess")
public class Trie<T> {
	private long triePointer;

	private static native long createTrie();

	private static native long deleteTrie(long triePointer);

	public Trie() {
		triePointer = createTrie();
	}

	private native void set(long ptr, @NotNull byte[] word, @NotNull T obj);

	/**
	 * set a word.
	 * if obj is null, this will call the remove method.
	 *
	 * @param word the word.
	 * @param obj  object to put
	 */
	public void set(@NotNull @NonNls String word, @Nullable T obj) {
		set(word.getBytes(), obj);
	}

	/**
	 * #{@inheritDoc}
	 */
	public void set(@NotNull byte[] word, @Nullable T obj) {
		if (null != obj) set(triePointer, word, obj);
		else remove(triePointer, word);
	}

	private native void remove(long ptr, @NotNull byte[] word);

	/**
	 * remove a word.
	 * same as 'set(word, null)'
	 *
	 * @param word the word.
	 */
	public void remove(@NotNull @NonNls String word) {
		remove(word.getBytes());
	}

	/**
	 * #{@inheritDoc}
	 */
	public void remove(@NotNull byte[] word) {
		remove(triePointer, word);
	}

	@Nullable
	@Contract(pure = true)
	private native T get(long ptr, @NotNull byte[] word);

	/**
	 * if the tree has the complete word: word.
	 * example:
	 * add 'ice1000'
	 * then get("ice") will return false.
	 * then get("ice1000") will return true.
	 *
	 * @param word a char sequence which get smaller letters
	 *             and spaces only.
	 * @return true if the tree has the complete word: word.
	 */
	@Nullable
	@Contract(pure = true)
	public T get(@NotNull @NonNls String word) {
		return get(word.getBytes());
	}

	/**
	 * #{@inheritDoc}
	 */
	@Nullable
	@Contract(pure = true)
	public T get(@NotNull byte[] word) {
		return get(triePointer, word);
	}

	/**
	 * this will release the memory!
	 * because {@link Trie} has get around
	 * the GC system of JVM, so you have to
	 * release the memory manually.
	 */
	public void delete() {
		deleteTrie(triePointer);
	}
}

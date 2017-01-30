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

	/**
	 * insert a word.
	 *
	 * @param word the word.
	 */
	public void insert(@NotNull @NonNls String word) {
		insert(word.getBytes());
	}

	/**
	 * #{@inheritDoc}
	 */
	public void insert(@NotNull byte[] word) {
		insert(triePointer, word);
	}

	private native void remove(long ptr, @NotNull byte[] word);

	/**
	 * remove a word.
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

	@Contract(pure = true)
	private native boolean contains(long ptr, @NotNull byte[] word);

	/**
	 * if the tree has the complete word: word.
	 * example:
	 * add 'ice1000'
	 * then contains("ice") will return false.
	 * then contains("ice1000") will return true.
	 *
	 * @param word a char sequence which contains smaller letters
	 *             and spaces only.
	 * @return true if the tree has the complete word: word.
	 */
	@Contract(pure = true)
	public boolean contains(@NotNull @NonNls String word) {
		return contains(word.getBytes());
	}

	/**
	 * #{@inheritDoc}
	 */
	@Contract(pure = true)
	public boolean contains(@NotNull byte[] word) {
		return contains(triePointer, word);
	}

	@Contract(pure = true)
	private native boolean containsPrefix(long ptr, @NotNull byte[] word);

	/**
	 * if the tree has the prefix: word.
	 * example:
	 * add 'ice1000'
	 * then containsPrefix("ice") will return true.
	 *
	 * @param word a char sequence which contains smaller letters
	 *             and spaces only.
	 * @return true if the tree has the prefix: word.
	 */
	@Contract(pure = true)
	public boolean containsPrefix(@NotNull @NonNls String word) {
		return containsPrefix(word.getBytes());
	}

	/**
	 * #{@inheritDoc}
	 */
	@Contract(pure = true)
	public boolean containsPrefix(@NotNull byte[] word) {
		return containsPrefix(triePointer, word);
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

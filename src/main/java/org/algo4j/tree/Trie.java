package org.algo4j.tree;

/**
 * Created by ice1000 on 2017/1/30.
 *
 * @author ice1000
 */
@SuppressWarnings("WeakerAccess")
public class Trie {
	private long triePointer;

	private static native long createTrie();

	public Trie() {
		triePointer = createTrie();
	}

	private native void insert(long ptr, byte[] word);

	public void insert(String word) {
		insert(word.getBytes());
	}

	public void insert(byte[] word) {
		insert(triePointer, word);
	}

	private native void remove(long ptr, byte[] word);

	public void remove(String word) {
		insert(word.getBytes());
	}

	public void remove(byte[] word) {
		insert(triePointer, word);
	}

	private native boolean contains(long ptr, byte[] word);

	private boolean contains(String word) {
		return contains(word.getBytes());
	}

	private boolean contains(byte[] word) {
		return contains(triePointer, word);
	}
}

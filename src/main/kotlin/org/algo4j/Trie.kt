@file:JvmName("Extension")
@file:JvmMultifileClass

/**
 * Created by ice1000 on 2017/1/30.
 *
 * @author ice1000
 */
package org.algo4j

import org.algo4j.tree.Trie
import org.jetbrains.annotations.Contract

@Contract(pure = false)
operator fun Trie.plusAssign(word: String) =
		insert(word)

@Contract(pure = false)
operator fun Trie.plusAssign(word: ByteArray) =
		insert(word)

@Contract(pure = false)
operator fun Trie.minusAssign(word: String) =
		remove(word)

@Contract(pure = false)
operator fun Trie.minusAssign(word: ByteArray) =
		remove(word)


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
operator fun <T> Trie<T>.contains(word: String) =
		null != get(word)

@Contract(pure = false)
operator fun <T> Trie<T>.contains(word: ByteArray) =
		null != get(word)

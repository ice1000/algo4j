package org.algo4j.tree

import org.algo4j.util.Loader
import org.jetbrains.annotations.TestOnly
import org.junit.BeforeClass
import org.junit.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

/**
 * Created by ice1000 on 2017/1/30.

 * @author ice1000
 */
class TrieTest {
	@TestOnly
	@Test(timeout = 1000)
	fun testInsert() {
		val trie = Trie()
		assertFalse { trie.contains("boy next door") }
		trie.insert("boy next door")
		assertTrue { trie.contains("boy next door") }
		assertFalse { trie.contains("the deep dark fantasy") }
		assertFalse { trie.contains("boy next doors") }
		assertFalse { trie.contains("boy next doo") }
	}

	@TestOnly
	@Test(timeout = 1000)
	fun testContainsPrefix() {
		val trie = Trie()
		assertFalse { trie.containsPrefix("boy next") }
		trie.insert("boy next door")
		assertTrue { trie.containsPrefix("boy next") }
	}

	@TestOnly
	@Test(timeout = 1000)
	fun testRemove() {
		val trie = Trie()
		assertFalse { trie.contains("my name is van") }
		trie.insert("my name is van")
		assertTrue { trie.contains("my name is van") }
		trie.remove("my name is van")
		assertFalse { trie.contains("my name is van") }
	}

	companion object {
		@TestOnly
		@JvmStatic
		@BeforeClass
		fun init() {
			System.loadLibrary(Loader.JNI_LIB_NAME)
		}
	}
}
package org.algo4j.tree

import org.algo4j.plusAssign
import org.algo4j.test.optional
import org.algo4j.util.Loader
import org.jetbrains.annotations.TestOnly
import org.junit.BeforeClass
import kotlin.test.assertFalse
import kotlin.test.assertTrue

/**
 * Created by ice1000 on 2017/1/30.

 * @author ice1000
 */
class TrieTest {
	@TestOnly
//	@Test(timeout = 1000)
	fun testInsert() {
		val trie = Trie()
		assertFalse { "boy next door" in trie }
		trie += "boy next door"
		assertTrue { "boy next door" in trie }
		assertFalse { "the deep dark fantasy" in trie }
		assertFalse { "boy next doors" in trie }
		assertFalse { "boy next doo" in trie }
//		trie.delete()
	}

	@TestOnly
//	@Test(timeout = 1000)
	fun testContainsPrefix() {
		optional(false) {
			val trie = Trie()
			assertFalse { trie.containsPrefix("ass we") }
			trie += "ass we can"
			assertTrue { trie.containsPrefix("ass we") }
//			trie.delete()
		}
	}

	@TestOnly
//	@Test(timeout = 1000)
	fun testRemove() {
		val trie = Trie()
		assertFalse { "my name is van" in trie }
		trie.insert("my name is van")
		assertTrue { "my name is van" in trie }
		trie.remove("my name is van")
		assertFalse { "my name is van" in trie }
//		trie.delete()
	}

	companion object {
		@TestOnly
		@JvmStatic
		@BeforeClass
		fun init() = Loader.loadJni()
	}
}
package org.algo4j.tree

import org.algo4j.contains
import org.algo4j.set
import org.algo4j.util.Loader
import org.jetbrains.annotations.TestOnly
import org.junit.BeforeClass
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertNull
import kotlin.test.assertTrue

/**
 * Created by ice1000 on 2017/1/30.

 * @author ice1000
 */
class TrieTest {
	@TestOnly
	@Test(timeout = 1000)
	fun testInsert() {
		val trie = Trie<Boolean>()
		assertFalse { "boy next door" in trie }
		trie["boy next door"] = true
		assertTrue { "boy next door" in trie }
		assertFalse { "the deep dark fantasy" in trie }
		assertFalse { "boy next doors" in trie }
		assertFalse { "boy next doo" in trie }
		trie.clear()
	}

	@TestOnly
	@Test(timeout = 1000)
	fun testContainsPrefix() {
		val trie = Trie<Int>()
		assertFalse { "ass we" in trie }
		trie["ass we can"] = 233
		assertFalse { "ass we" in trie }
		assertTrue { "ass we can" in trie }
		assertEquals(233, trie["ass we can"])
		trie.clear()
	}

	@TestOnly
	@Test(timeout = 1000)
	fun testContains() {
		val trie = Trie<Any>()
		assertFalse { " My Name Is Van []" in trie }
		val obj = Any()
		trie[" My Name Is Van []"] = obj
		assertTrue { " My Name Is Van []" in trie }
		assertEquals(obj, trie[" My Name Is Van []"])
		trie.put(" My Name Is Van []", null)
		assertNull(trie[" My Name Is Van []"])
		assertFalse { " My Name Is Van []" in trie }
		trie.clear()
	}

	@TestOnly
	@Test(timeout = 1000)
	fun testRemove() {
		val trie = Trie<Int>()
		assertFalse { "my name is van" in trie }
		trie["my name is van"] = 1024
		assertTrue { "my name is van" in trie }
		trie["my name is van"] = null
		assertFalse { "my name is van" in trie }
		trie.clear()
	}

	companion object {
		@TestOnly
		@JvmStatic
		@BeforeClass
		fun init() = Loader.loadJni()
	}
}

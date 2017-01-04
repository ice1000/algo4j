package org.algo4j.win

import org.algo4j.util.Loader
import org.jetbrains.annotations.TestOnly
import org.junit.BeforeClass
import org.junit.Test

/**
 * Created by ice1000 on 2016/12/18.

 * @author ice1000
 */
@TestOnly
class WinAPITest {
	@TestOnly
	@Test(timeout = 100)
	fun beep() {
		WinAPI.beep(2333, 1)
	}

	@TestOnly
	companion object Initializer {
		@JvmStatic
		@BeforeClass
		fun init() {
			Loader.load()
		}
	}
}

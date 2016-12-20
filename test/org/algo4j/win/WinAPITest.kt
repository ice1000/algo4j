package org.algo4j.win

import org.junit.BeforeClass
import org.junit.Test

/**
 * Created by ice1000 on 2016/12/18.

 * @author ice1000
 */
class WinAPITest {
	@Test(timeout = 100)
	fun beep() {
		WinAPI.beep(2333, 1)
	}

	companion object Initializer {
		@JvmStatic
		@BeforeClass
		fun init() {
			System.loadLibrary("jni")
		}
	}
}

package org.algo4j.win

import org.algo4j.test.println
import org.algo4j.util.Loader
import org.jetbrains.annotations.TestOnly
import org.junit.BeforeClass

/**
 * Created by ice1000 on 2016/12/18.

 * @author ice1000
 */
object WinAPITest {
	@TestOnly
	fun beep() {
		WinAPI.beep(2333, 500)
		WinAPI.beep(1233, 500)
		WinAPI.beep(3500, 500)
	}

	@TestOnly
	fun messageBoxA() {
		WinAPI.messageBoxA("ass we can", "boy next door", WinAPI.MessageBoxType.MB_ICONSTOP)
				.println()
		WinAPI.messageBoxA("deep dark fantasy", "oh my shoulder", WinAPI.MessageBoxType.MB_DEFBUTTON3)
				.println()
		WinAPI.messageBoxA("hey boy", "you get the wrong door", WinAPI.MessageBoxType.MB_DEFBUTTON3)
				.println()
		WinAPI.messageBoxA("fuck you", "ah fuck you", WinAPI.MessageBoxType.MB_HELP)
				.println()
		WinAPI.messageBoxA("change the", "boss of this gym", WinAPI.MessageBoxType.MB_DEFMASK)
				.println()
	}

	@JvmStatic
	@BeforeClass
	fun init() {
		Loader.loadJni()
	}

	@JvmStatic
	fun main(args: Array<String>) {
		init()
		beep()
		messageBoxA()
	}
}

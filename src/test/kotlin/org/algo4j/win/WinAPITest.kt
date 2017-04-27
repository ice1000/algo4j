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

	/**
	 * from http://blog.csdn.net/kevin1491/article/details/49837289
	 * 小酒窝/长睫毛/迷人的无可救药
	 */
	@TestOnly
	fun beepXiaoJiuWo() {
		listOf(Pair(659, 625),
				Pair(659, 250), Pair(698, 500), Pair(659, 250), Pair(578, 250), Pair(578, 625), Pair(578, 250),
				Pair(784, 500), Pair(578, 250), Pair(523, 250), Pair(523, 625), Pair(523, 250), Pair(880, 500),
				Pair(784, 500), Pair(659, 625), Pair(698, 125), Pair(659, 125), Pair(578, 500), Pair(578, 500),
				Pair(659, 625), Pair(659, 250), Pair(698, 500), Pair(784, 250), Pair(659, 250), Pair(784, 625),
				Pair(784, 250), Pair(1175, 500), Pair(988, 250), Pair(1046, 250), Pair(1046, 1000), Pair(1046, 250),
				Pair(988, 250), Pair(880, 250), Pair(988, 250), Pair(1046, 625), Pair(988, 250), Pair(1046, 1000),
				Pair(1046, 250), Pair(988, 250), Pair(1046, 250), Pair(988, 250), Pair(1046, 500), Pair(659, 250),
				Pair(784, 250), Pair(784, 1250), Pair(880, 250), Pair(988, 250), Pair(1046, 250), Pair(988, 250),
				Pair(1046, 250), Pair(988, 250), Pair(1046, 500), Pair(1175, 500), Pair(1318, 500), Pair(1318, 1500),
				Pair(880, 250), Pair(988, 250), Pair(1046, 250), Pair(988, 250), Pair(1046, 250), Pair(988, 250),
				Pair(1046, 500), Pair(1318, 500), Pair(988, 250), Pair(880, 250), Pair(988, 250), Pair(880, 250),
				Pair(988, 250), Pair(784, 250), Pair(784, 250), Pair(1046, 250), Pair(1046, 1000), Pair(1318, 375),
				Pair(1397, 125), Pair(1397, 250), Pair(1318, 250), Pair(1175, 1000), Pair(0, 250), Pair(784, 250),
				Pair(1046, 250), Pair(1175, 250), Pair(1318, 250), Pair(1046, 250), Pair(1046, 250), Pair(784, 250),
				Pair(784, 500), Pair(784, 250), Pair(1318, 250), Pair(1175, 250), Pair(1318, 250), Pair(1175, 250),
				Pair(1046, 250), Pair(784, 250), Pair(784, 250), Pair(880, 250), Pair(988, 250), Pair(1046, 250),
				Pair(880, 250), Pair(880, 250), Pair(659, 250), Pair(659, 500), Pair(0, 250), Pair(988, 250),
				Pair(1046, 250), Pair(988, 250), Pair(1046, 250), Pair(1175, 250), Pair(880, 250), Pair(784, 250),
				Pair(784, 500), Pair(880, 500), Pair(784, 250), Pair(880, 250), Pair(988, 500), Pair(1318, 250),
				Pair(1397, 250), Pair(1318, 250), Pair(1397, 250), Pair(1318, 250), Pair(1175, 250), Pair(1175, 250),
				Pair(1046, 500), Pair(784, 250), Pair(784, 250), Pair(698, 250), Pair(698, 250), Pair(1046, 250),
				Pair(1046, 250), Pair(1318, 250), Pair(1318, 250), Pair(1046, 250), Pair(1175, 1000), Pair(0, 250),
				Pair(784, 250), Pair(1046, 250), Pair(1175, 250), Pair(1318, 250), Pair(1046, 250), Pair(1046, 250),
				Pair(784, 250), Pair(784, 500), Pair(784, 250), Pair(1318, 250), Pair(1175, 250),
				Pair(1318, 250), Pair(1175, 250), Pair(1046, 250), Pair(784, 250), Pair(784, 250),
				Pair(880, 250), Pair(988, 250), Pair(1046, 250), Pair(880, 250), Pair(880, 250), Pair(659, 250),
				Pair(659, 500), Pair(659, 250), Pair(988, 250), Pair(1046, 250), Pair(988, 250), Pair(1046, 250),
				Pair(1175, 250), Pair(880, 250), Pair(784, 250),
				Pair(784, 500), Pair(880, 250), Pair(988, 250), Pair(1046, 250), Pair(1175, 500), Pair(1318, 250),
				Pair(1397, 250), Pair(1318, 250), Pair(1397, 250), Pair(1175, 250), Pair(1046, 250), Pair(1175, 250),
				Pair(1046, 250), Pair(1046, 500), Pair(1175, 250), Pair(1046, 250), Pair(1175, 250), Pair(880, 250),
				Pair(1046, 500), Pair(1175, 250), Pair(1046, 250), Pair(1046, 2000), Pair(1175, 250), Pair(1046, 250),
				Pair(1175, 250), Pair(880, 250), Pair(988, 500), Pair(988, 250), Pair(1046, 250), Pair(1046, 2000))
				.forEach { (freq, dur) -> WinAPI.beep(freq, dur) }
	}

	/**
	 * from http://www.cnblogs.com/morewindows/archive/2011/08/15/2139544.html
	 * 祝你生日快乐
	 */
	@TestOnly
	fun beep2() {
		listOf(392, 392, 440, 392, 523, 494,
				392, 392, 440, 392, 587, 523,
				392, 392, 784, 659, 523, 494, 440,
				689, 689, 523, 587, 523
		).zip(listOf(
				375, 125, 500, 500, 500, 1000,
				375, 125, 500, 500, 500, 1000,
				375, 125, 500, 500, 500, 500, 1000,
				375, 125, 500, 500, 500, 1000
		)).forEach { (freq, dur) -> WinAPI.beep(freq, dur) }
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

	fun batteryStatus() {
		WinAPI.getSystemPowerStatus().run {
			println("电源状态: $acLineStatus ")
			println("电池状态: $batteryFlag ")
			println("电量百分比: $batteryLifePercent %")
			println("剩余电量: $batteryLifeTime s")
			println("总电量: $batteryFullLifeTime s")
		}
	}

	@JvmStatic
	fun main(args: Array<String>) {
		init()
		batteryStatus()
		messageBoxA()
		beep2()
//		beepXiaoJiuWo()
	}
}

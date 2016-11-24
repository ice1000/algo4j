package org.ice1000.math

import org.junit.Assert.assertEquals
import org.junit.BeforeClass
import org.junit.Test
import java.util.*

/**
 * Created by ice1000 on 2016/11/24.

 * @author ice1000
 */
class TrigonometricTest {

	companion object {
		@BeforeClass
		@JvmStatic
		fun loadJniLibrary() {
			System.loadLibrary("jni")
		}
	}

	@Test(timeout = 100)
	fun triangleTest() {
		val random = Random(System.currentTimeMillis())
		var timesOfTesting = 5000
		println("$timesOfTesting test cases")
		while (timesOfTesting-- > 0) {
			val temp = random.nextDouble()
			assertEquals(Trigonometric.sin(temp), java.lang.Math.sin(temp), 1e-15)
			assertEquals(Trigonometric.cos(temp), java.lang.Math.cos(temp), 1e-15)
			assertEquals(Trigonometric.tan(temp), java.lang.Math.tan(temp), 1e-15)
			assertEquals(Trigonometric.tan(temp), java.lang.Math.tan(temp), 1e-15)
			assertEquals(Trigonometric.tan(temp) * Trigonometric.cot(temp), 1.0, 1e-15)
			assertEquals(Trigonometric.cos(temp) * Trigonometric.sec(temp), 1.0, 1e-15)
			assertEquals(Trigonometric.sin(temp) * Trigonometric.csc(temp), 1.0, 1e-15)
		}
		println("test passed")
	}

}

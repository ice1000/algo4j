package org.ice1000.math

import org.ice1000.test.loop
import org.junit.Assert.assertEquals
import org.junit.BeforeClass
import org.junit.Test
import java.util.*

/**
 * Created by ice1000 on 2016/11/24.

 * @author ice1000
 */
class TrigonometricTest {

	companion object Initializer {
		@BeforeClass
		@JvmStatic
		fun loadJniLibrary() {
			System.loadLibrary("jni")
		}
	}

	@Test(timeout = 100)
	fun triangleTest() {
		val random = Random(System.currentTimeMillis())
		val timesOfTesting = 5000
		println("$timesOfTesting test cases")
		loop (timesOfTesting) {
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

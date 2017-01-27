package org.algo4j.math

import org.algo4j.test.test
import org.algo4j.util.Loader
import org.junit.Assert.assertEquals
import org.junit.BeforeClass
import org.junit.Test
import java.util.*

/**
 * Created by algo4j on 2016/11/24.

 * @author algo4j
 */
class TrigonometricTest {

	companion object Initializer {
		@BeforeClass
		@JvmStatic
		fun loadJniLibrary() {
			System.loadLibrary(Loader.JNI_LIB_NAME)
		}
	}

	@Test(timeout = 500)
	fun triangleTest() {
		val random = Random(System.currentTimeMillis())
		test(5000) {
			val temp = random.nextDouble()
			assertEquals(Trigonometric.sin(temp), java.lang.Math.sin(temp), 1e-15)
			assertEquals(Trigonometric.cos(temp), java.lang.Math.cos(temp), 1e-15)
			assertEquals(Trigonometric.tan(temp), java.lang.Math.tan(temp), 1e-15)
			assertEquals(Trigonometric.tan(temp), java.lang.Math.tan(temp), 1e-15)
			assertEquals(Trigonometric.tan(temp) * Trigonometric.cot(temp), 1.0, 1e-15)
			assertEquals(Trigonometric.cos(temp) * Trigonometric.sec(temp), 1.0, 1e-15)
			assertEquals(Trigonometric.sin(temp) * Trigonometric.csc(temp), 1.0, 1e-15)
		}
	}

}

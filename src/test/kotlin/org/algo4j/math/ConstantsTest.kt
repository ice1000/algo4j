package org.algo4j.math

import org.algo4j.math.Constants.PLANK_CONSTANT
import org.algo4j.test.println
import org.jetbrains.annotations.TestOnly
import org.junit.Test

/**
 * Created by ice1000 on 2016/12/18.

 * @author ice1000
 */
class ConstantsTest {
	@TestOnly
	@Test(timeout = 10)
	fun outputConstants() {
		(1e35 * PLANK_CONSTANT).println()
	}
}

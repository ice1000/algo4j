package org.ice1000.util;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;

/**
 * Created by ice1000 on 2016/11/16.
 *
 * @author ice1000
 */
public class MathTest {
	@Test
	public void gcd() {
		assertEquals(Math.gcd(12, 15), 3);
		assertEquals(Math.gcd(12, 16), 4);
		assertEquals(Math.gcd(15, 20), 5);
		assertEquals(Math.gcd(100, 1000), 100);
		assertEquals(Math.gcd(1000, 100), 100);
		assertEquals(Math.gcd(1, 1), 1);
	}

	@Test
	@SuppressWarnings("deprecation")
	public void sqrt() {
		Random random = new Random(System.currentTimeMillis());
		int timesOfTesting = 1000;
		while (timesOfTesting --> 0) {
			double temp = random.nextDouble();
			assertEquals(Math.sqrt(temp), java.lang.Math.sqrt(temp));
		}
	}

}
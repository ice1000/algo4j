package org.algo4j.win;

import org.jetbrains.annotations.Contract;

/**
 * For Windows only
 * Created by ice1000 on 2016/12/18.
 *
 * @author ice1000
 */
@SuppressWarnings("WeakerAccess")
public final class WinAPI {
	@Contract(pure = true)
	private WinAPI() {
	}

	public static native void beep(int frequency, int duration);
}

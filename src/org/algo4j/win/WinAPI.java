package org.algo4j.win;

/**
 * Created by ice1000 on 2016/12/18.
 *
 * @author ice1000
 */
public final class WinAPI {
	private WinAPI() {
	}

	public static native void beep(int frequency, int duration);
}

package org.algo4j.util;

import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import sun.reflect.CallerSensitive;

/**
 * To load the JNI library
 * Created by ice1000 on 2017/1/6.
 *
 * @author ice1000
 */
@SuppressWarnings("WeakerAccess")
public final class Loader {
	static {
		load();
	}

	public static final String JNI_LIB_NAME = "jni";
	private static boolean loaded = false;

	@CallerSensitive
	public static void load() {
		if (loaded) return;
		loaded = true;
		loadJni(JNI_LIB_NAME);
	}

	@CallerSensitive
	@SuppressWarnings("SameParameterValue")
	private static void loadJni(@NotNull @NonNls String __) {
		if (loaded) return;
		loaded = true;
		System.loadLibrary(__);
	}
}

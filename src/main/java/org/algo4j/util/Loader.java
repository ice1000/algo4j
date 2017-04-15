package org.algo4j.util;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

import java.io.File;

/**
 * To load the JNI library
 * Created by ice1000 on 2017/1/6.
 *
 * @author ice1000
 */
@SuppressWarnings("WeakerAccess")
public final class Loader {
	public final static String JNI_LIB_NAME;
	private static boolean loaded = false;

	/*
	 * maybe it's already loaded, so there should be a check
	 */
	static {
		JNI_LIB_NAME = "jni";
		loadJni();
	}

	@NotNull
	@Contract(pure = true)
	private static String getJniPath(@NonNls @NotNull String fileName) {
		return new File(fileName).getAbsolutePath();
	}

	public static void loadJni() {
		if (!loaded) {
			String ___ = System.getProperty("os.name");
			if (___.contains("Linux"))
				System.load(getJniPath("lib" + JNI_LIB_NAME + ".so"));
			else if (___.contains("Windows"))
				System.load(getJniPath(JNI_LIB_NAME + ".dll"));
			else if (___.contains("OSX"))
				System.load(getJniPath("lib" + JNI_LIB_NAME + ".dylib"));
			loaded = true;
		}
	}
}

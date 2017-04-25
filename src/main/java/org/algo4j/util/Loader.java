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
		JNI_LIB_NAME = "libjni";
		loadJni();
	}

	@NotNull
	@Contract(pure = true)
	private static String libraryName(@NonNls @NotNull String libName) {
		String ___ = System.getProperty("os.name");
		String fileName;
		if (___.contains("Linux"))
			fileName = libName + ".so";
		else if (___.contains("Windows"))
			fileName = libName + ".dll";
		else // if (___.contains("OSX"))
			fileName = libName + ".dylib";
//		else fileName = libName;
		return new File(fileName).getAbsolutePath();
	}

	public static void loadJni() {
		if (!loaded) {
			System.load(libraryName(JNI_LIB_NAME));
			loaded = true;
		}
	}
}

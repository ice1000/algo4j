package org.algo4j.util;

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
	public final static @NotNull String JNI_LIB_NAME;
	private static boolean loaded = false;

	/*
	 * maybe it's already loaded, so there should be a check
	 */
	static {
		JNI_LIB_NAME = "libjni";
		loadJni();
	}

	public static void loadJni() {
		if (!loaded) {
			System.load(new File(System.mapLibraryName(JNI_LIB_NAME)).getAbsolutePath());
			loaded = true;
		}
	}
}

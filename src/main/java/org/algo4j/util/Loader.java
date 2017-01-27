package org.algo4j.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * To load the JNI library
 * Created by ice1000 on 2017/1/6.
 *
 * @author ice1000
 */
@SuppressWarnings("WeakerAccess")
public final class Loader {
	private static final String LIB_BIN;
	public final static String JNI_LIB_NAME;

	/*
	 * maybe it's already loaded, so there should be a check
	 */
	static {
		LIB_BIN = "/lib-bin/";
		JNI_LIB_NAME = "jni";
		try {
			System.loadLibrary(JNI_LIB_NAME);
		} catch (UnsatisfiedLinkError e) {
			loadLib(JNI_LIB_NAME);
		}
	}

	/**
	 * Puts library to temp dir and loads to memory
	 */
	private static void loadLib(String ___) {
		String __ = ___ + ".dll";
		try {
			InputStream in = Loader.class.getResourceAsStream(LIB_BIN + __);
			File fileOut = new File(__);
			OutputStream out = new FileOutputStream(fileOut);
			byte[] ____ = new byte[0xFFFF];
			while (-1 != in.read(____)) out.write(____);
			in.close();
			out.close();
			System.load(fileOut.toString());
		} catch (Exception ignored) {
		}
	}
}

package org.algo4j.win;

/**
 * For Windows only
 * Created by ice1000 on 2016/12/18.
 *
 * @author ice1000
 */
@SuppressWarnings("WeakerAccess")
public final class WinAPI {
	private WinAPI() {
	}

	/**
	 * copied from 'winuser.h'
	 */
	public static class MessageBoxType {
		public static final int MB_OK = 0x00000000;
		public static final int MB_OKCANCEL = 0x00000001;
		public static final int MB_ABORTRETRYIGNORE = 0x00000002;
		public static final int MB_YESNOCANCEL = 0x00000003;
		public static final int MB_YESNO = 0x00000004;
		public static final int MB_RETRYCANCEL = 0x00000005;
		public static final int MB_CANCELTRYCONTINUE = 0x00000006;
		public static final int MB_ICONHAND = 0x00000010;
		public static final int MB_ICONQUESTION = 0x00000020;
		public static final int MB_ICONEXCLAMATION = 0x00000030;
		public static final int MB_ICONASTERISK = 0x00000040;
		public static final int MB_USERICON = 0x00000080;
		public static final int MB_ICONINFORMATION = MB_ICONASTERISK;
		public static final int MB_ICONWARNING = MB_ICONEXCLAMATION;
		public static final int MB_ICONSTOP = MB_ICONHAND;
		public static final int MB_ICONERROR = MB_ICONHAND;

		public static final int MB_DEFBUTTON1 = 0x00000000;
		public static final int MB_DEFBUTTON2 = 0x00000100;
		public static final int MB_DEFBUTTON3 = 0x00000200;
		public static final int MB_DEFBUTTON4 = 0x00000300;
		public static final int MB_APPLMODAL = 0x00000000;
		public static final int MB_SYSTEMMODAL = 0x00001000;
		public static final int MB_TASKMODAL = 0x00002000;
		public static final int MB_HELP = 0x00004000;
		public static final int MB_NOFOCUS = 0x00008000;
		public static final int MB_SETFOREGROUND = 0x00010000;
		public static final int MB_DEFAULT_DESKTOP_ONLY = 0x00020000;
		public static final int MB_TOPMOST = 0x00040000;
		public static final int MB_RIGHT = 0x00080000;
		public static final int MB_RTLREADING = 0x00100000;
		public static final int MB_SERVICE_NOTIFICATION = 0x00200000;
		public static final int MB_SERVICE_NOTIFICATION_NT3X = 0x00040000;
		public static final int MB_TYPEMASK = 0x0000000F;
		public static final int MB_ICONMASK = 0x000000F0;
		public static final int MB_DEFMASK = 0x00000F00;
		public static final int MB_MODEMASK = 0x00003000;
		public static final int MB_MISCMASK = 0x0000C000;
	}

	/**
	 * beep
	 * Win32API: Beep(DWORD, DWORD)
	 *
	 * @param frequency beeping frequency
	 * @param duration  beeping duration
	 */
	public static native boolean beep(int frequency, int duration);

	private static native int messageBoxA(byte[] title, byte[] message, int type);

	/**
	 * display a message box
	 *
	 * @param title   message box title
	 * @param message message
	 */
	public static int messageBoxA(String title, String message, int type) {
		return messageBoxA(title.getBytes(), message.getBytes(), type);
	}

	public static int messageBoxA(String title, String message) {
		return messageBoxA(title.getBytes(), message.getBytes(), MessageBoxType.MB_ICONINFORMATION);
	}
}

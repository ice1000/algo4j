package org.algo4j.win;

import org.jetbrains.annotations.NotNull;

/**
 * For Windows only
 * Invoking windows api by C++
 * <p>
 * These functions are not available for non-windows systems.
 * <p>
 * Created by ice1000 on 2016/12/18.
 *
 * @author ice1000
 */
@SuppressWarnings("WeakerAccess")
public final class WinAPI {
	private WinAPI() {
		throw new Error("do not instantiation me");
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
	 * music utils
	 */
	public static class BeepUtils {
		public static final int d1 = 262;
		public static final int d1_ = 277;
		public static final int d2 = 294;
		public static final int d2_ = 311;
		public static final int d3 = 330;
		public static final int d4 = 349;
		public static final int d5 = 392;
		public static final int d5_ = 415;
		public static final int d6 = 440;
		public static final int d6_ = 466;
		public static final int d7 = 494;
		public static final int z1 = 523;
		public static final int z1_ = 554;
		public static final int z2 = 578;
		public static final int z2_ = 622;
		public static final int z3 = 659;
		public static final int z4 = 698;
		public static final int z4_ = 740;
		public static final int z5 = 784;
		public static final int z5_ = 831;
		public static final int z6 = 880;
		public static final int z6_ = 932;
		public static final int z7 = 988;
		public static final int g1 = 1046;
		public static final int g1_ = 1109;
		public static final int g2 = 1175;
		public static final int g2_ = 1245;
		public static final int g3 = 1318;
		public static final int g4 = 1397;
		public static final int g4_ = 1480;
		public static final int g5 = 1568;
		public static final int g5_ = 1661;
		public static final int g6 = 1760;
		public static final int g6_ = 1865;
		public static final int g7 = 1976;
	}

	/**
	 * power status
	 */
	public static class PowerStatus {
		/**
		 * 0: offline
		 * 1: online
		 * -1: unknown status
		 */
		public final int acLineStatus;

		/**
		 * 1: high (>= 66%)
		 * 2: low (<= 33%)
		 * 4: critical (<= 5%)
		 * 8: charging
		 * 128: no battery
		 * -1: unknown
		 */
		public final int batteryFlag;

		/**
		 * -1: unknown
		 * else: The percentage of battery charge remaining
		 */
		public final int batteryLifePercent;

		/** seconds you can use from now */
		public final int batteryLifeTime;

		/** seconds you can use from full */
		public final int batteryFullLifeTime;

		public PowerStatus(
				int acLineStatus,
				int batteryFlag,
				int batteryLifePercent,
				int batteryLifeTime,
				int batteryFullLifeTime) {
			this.acLineStatus = acLineStatus;
			this.batteryFlag = batteryFlag;
			this.batteryLifePercent = batteryLifePercent;
			this.batteryLifeTime = batteryLifeTime;
			this.batteryFullLifeTime = batteryFullLifeTime;
		}
	}

	/**
	 * beep
	 * Win32API: Beep(DWORD, DWORD)
	 *
	 * @param frequency beeping frequency
	 * @param duration  beeping duration
	 * @see WinAPI.BeepUtils
	 */
	public static native boolean beep(int frequency, int duration);

	private static native int messageBoxA(byte[] title, byte[] message, int type);

	/**
	 * display a message box
	 * Win32API: MessageBoxA(HWND, LPCSTR, LPCSTR, UINT)
	 *
	 * @param title   message box title
	 * @param message message
	 * @see WinAPI.MessageBoxType
	 */
	public static int messageBoxA(String title, String message, int type) {
		return messageBoxA(title.getBytes(), message.getBytes(), type);
	}

	/** #{@inheritDoc} */
	public static int messageBoxA(String title, String message) {
		return messageBoxA(title.getBytes(), message.getBytes(), MessageBoxType.MB_ICONINFORMATION);
	}

	/**
	 * get system power(battery) status
	 * Win32API: GetSystemPowerStatus(LPSYSTEM_POWER_STATUS)
	 *
	 * @return your battery status
	 * @see WinAPI.PowerStatus
	 */
	@NotNull
	public static PowerStatus getSystemPowerStatus() {
		int[] data = getPowerStatus();
		return new PowerStatus(data[0], data[1], data[2], data[3], data[4]);
	}

	@NotNull
	private static native int[] getPowerStatus();
}

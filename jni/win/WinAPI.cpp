
#include "WinAPI.h"
#include "../global/basics.hpp"
#include <windows.h>

#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCUnusedGlobalDeclarationInspection"

JNIEXPORT auto JNICALL Java_org_algo4j_win_WinAPI_beep(
		JNIEnv *,
		jclass,
		jint freq,
		jint duration) -> jboolean {
	return Beep(static_cast<DWORD>(freq), static_cast<DWORD>(duration)) ? JNI_TRUE : JNI_FALSE;
}

JNIEXPORT auto JNICALL Java_org_algo4j_win_WinAPI_messageBoxA(
		JNIEnv *env,
		jclass,
		jbyteArray _title,
		jbyteArray _message,
		jint type) -> jint {
	__JNI__FUNCTION__INIT__
	__get(Byte, title);
	__get(Byte, message);
	title[__len(title)] = '\0';
	message[__len(message)] = '\0';
	auto ret = MessageBoxA(NULL, (LPCSTR) message, (LPCSTR) title, static_cast<UINT>(type));
	__JNI__FUNCTION__CLEAN__
	return ret;
}

JNIEXPORT auto JNICALL Java_org_algo4j_win_WinAPI_getPowerStatus(
		JNIEnv *env,
		jclass) -> jintArray {
	__JNI__FUNCTION__INIT__
	SYSTEM_POWER_STATUS s;
	GetSystemPowerStatus(&s);
	auto ret = new jint[5];
	ret[0] = static_cast<jint>(s.ACLineStatus); // 电源状态
	ret[1] = static_cast<jint>(s.BatteryFlag); // 电池状态
	ret[2] = static_cast<jint>(s.BatteryLifePercent); // 电量百分比
	ret[3] = static_cast<jint>(s.BatteryLifeTime); // 剩余能量
	ret[4] = static_cast<jint>(s.BatteryFullLifeTime); // 总能量
	__new(Int, ret, 5)
	__set(Int, ret, 5)
	delete ret;
	__JNI__FUNCTION__CLEAN__
	return _ret;
}


#pragma clang diagnostic pop

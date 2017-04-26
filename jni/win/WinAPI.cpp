
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
	auto ret = MessageBoxA(NULL, (LPCSTR) message, (LPCSTR) title, type);
	__JNI__FUNCTION__CLEAN__
	return ret;
}

#pragma clang diagnostic pop

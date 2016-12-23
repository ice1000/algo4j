
#include "WinAPI.h"

#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCUnusedGlobalDeclarationInspection"

using algo4j_win::beep;

JNIEXPORT auto JNICALL Java_org_algo4j_win_WinAPI_beep(
		JNIEnv *,
		jclass,
		jint freq,
		jint duration) -> void {
	beep(
			static_cast<unsigned long>(freq),
			static_cast<unsigned long>(duration)
	);
}

#pragma clang diagnostic pop

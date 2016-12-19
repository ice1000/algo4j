
#include "WinAPI.h"

using algo4j_win::beep;

JNIEXPORT auto JNICALL Java_org_algo4j_win_WinAPI_beep(
		JNIEnv *,
		jclass,
		jint freq,
		jint duration) -> void {
	beep(freq, duration);
}



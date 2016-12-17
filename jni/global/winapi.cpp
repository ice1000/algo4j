//
// Created by ice1000 on 2016/12/10.
//

#include "winapi.h"

auto algo4j_win::beep(unsigned long freq, unsigned long duration) -> void {
	Beep(static_cast<DWORD>(freq), static_cast<DWORD>(duration));
}


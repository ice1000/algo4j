@echo off

title Compiling jni library

mingw32-make -f Build.win all

echo ================================================
echo ================================================
echo =========                              =========
echo =========                              =========
echo =========   Compile mission complete.  =========
echo =========                              =========
echo =========                              =========
echo ================================================
echo ================================================


if "%1"=="nc" (
	goto mov
) else (
	call clean.bat
)

:mov

if exist jni.dll (
	move jni.dll ../
)

if exist jni32.dll (
	move jni32.dll ../
)

echo Have a nice day with jni. : )

if "%2"=="np" (
	goto end
) else (pause)

:end

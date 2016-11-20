@echo off
title building jni library

call compile.bat

if "%1"=="nc" (
	goto mov
) else (
	call clean.bat
)

:mov
move jni.dll ../

echo ================================================
echo ================================================
echo ==========                            ==========
echo ==========                            ==========
echo ==========       Build complete       ==========
echo ==========                            ==========
echo ==========                            ==========
echo ================================================
echo ================================================
echo Have a nice day with jni. : )

if "%2"=="np" (
	goto end
) else (pause)

:end

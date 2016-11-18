@echo off
title building jni library

call compile.bat
call clean.bat

move jni.dll ../

echo ================================================
echo ================================================
echo ==========                            ==========
echo ==========                            ==========
echo ==========       Build success        ==========
echo ==========                            ==========
echo ==========                            ==========
echo ================================================
echo ================================================
echo Have a nice day with jni. : )

pause

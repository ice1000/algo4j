@echo off
title building jni library

call compile.bat
call clean.bat

move jni.dll ../

echo Build mission complete.
echo Have a nice day with jni. : )

pause

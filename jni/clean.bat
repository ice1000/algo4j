@echo off
title cleaning jni library

if exist *.o (
	del /f /s /q *.o
)

if exist jni.layout (
	del /f /s /q jni.layout
)

if exist libjni.a (
	del /f /s /q libjni.a
)

if exist libjni.def (
	del /f /s /q libjni.def
)

if exist build (
	rd /s /q build
)

if exist ./cpp-test (
	cd ./cpp-test
	if exist *.exe (
		del /f /s /q *.exe
	)
	cd ..
)

if exist ../*.log (
	cd ..
	del /f /s /q *.log
	cd ./jni
)

REM cd ../
REM if exist jni.dll (
REM 	del /f /s /q jni.dll
REM )
REM cd ./jni

echo Clean complete.


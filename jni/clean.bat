@echo off
title cleaning jni library

if exist *.o (
	del /f /s /q *.o
)

cd bit
if exist *.o (
	del /f /s /q *.o
)
cd ..

cd global
if exist *.o (
	del /f /s /q *.o
)
cd ..

cd graph
if exist *.o (
	del /f /s /q *.o
)
cd ..

cd math
if exist *.o (
	del /f /s /q *.o
)
cd ..

cd util
if exist *.o (
	del /f /s /q *.o
)
cd ..

REM if exist *.res (
	REM del /f /s /q *.res
REM )

if exist *.layout (
	del /f /s /q *.layout
)

if exist *.a (
	del /f /s /q *.a
)

if exist *.def (
	del /f /s /q *.def
)

if exist *.exe (
	del /f /s /q *.exe
)

if exist build (
	rd /s /q build
)

cd ../out
if exist production (
	rd /s /q production
)
if exist test (
	rd /s /q test
)
cd ./jni

if exist cmake-build-debug (
	rd /s /q cmake-build-debug
)

if exist cpp-test (
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


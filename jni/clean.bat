@echo off
title cleaning jni library

cmake --build . --target clean -- -j 8

if exist *.o (
	del /f /s /q *.o
)

if exist *.cmake (
	del /f /s /q *.cmake
)

if exist CMakeCache.txt (
	del /f /s /q CMakeCache.txt
)

cd tree
	if exist *.o (
		del /f /s /q *.o
	)
	cd bit
		if exist *.o (
			del /f /s /q *.o
		)
	cd ..
	cd heap
		if exist *.o (
			del /f /s /q *.o
		)
	cd ..
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

cd win
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

if exist *.res (
	del /f /s /q *.res
)

if exist build (
	rd /s /q build
)

if exist cmake-build-debug (
	rd /s /q cmake-build-debug
)


if exist ./cpp-test (
	cd ./cpp-test
	call clean.bat
	cd ..
)

if exist ../*.log (
	cd ..
	del /f /s /q *.log
	cd ./jni
)

if exist ../out (
	cd ../out

	if exist production (
		rd /s /q production
	)
	if exist test (
		rd /s /q test
	)
	cd ./jni
)

if exist jni.dll (
	move jni.dll ../
)

if exist libjni.dll (
	move libjni.dll ../
)

if exist jni32.dll (
	move jni32.dll ../
)

REM cd ../
REM if exist jni.dll (
REM 	del /f /s /q jni.dll
REM )
REM cd ./jni

echo Clean complete.


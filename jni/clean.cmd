@echo off
title building jni library

mingw32-make -f Makefile.win all

if exist org_ice1000_bit_BinaryIndexedTree.o (
	del /f /s /q org_ice1000_bit_BinaryIndexedTree.o
)

if exist org_ice1000_graph_FrontStarGraph.o (
	del /f /s /q org_ice1000_graph_FrontStarGraph.o
)

if exist org_ice1000_bit_ReversePairSum.o (
	del /f /s /q org_ice1000_bit_ReversePairSum.o
)

if exist org_ice1000_public_functions.o (
	del /f /s /q org_ice1000_public_functions.o
)

if exist org_ice1000_util_ArrayUtils.o (
	del /f /s /q org_ice1000_util_ArrayUtils.o
)

if exist org_ice1000_util_Math.o (
	del /f /s /q org_ice1000_util_Math.o
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

REM cd ../
REM if exist jni.dll (
REM 	del /f /s /q jni.dll
REM )
REM cd ./jni

move jni.dll ../

echo Compile mission complete.
echo Have a nice day with jni. : )


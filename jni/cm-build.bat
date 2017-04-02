@echo off

title Compiling jni library using CMake

cmake -DCMAKE_BUILD_TYPE= -G "CodeBlocks - MinGW Makefiles" .

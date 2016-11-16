cmake_minimum_required(VERSION 3.6)
project(jni)

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++11")

set(BUILD_USE_64BITS on)

set(SOURCE_FILES
		org_ice1000_bit_BinaryIndexedTree.cpp
		org_ice1000_public_functions.cpp)
set(SOURCE_HEADERS
		org_ice1000_bit_BinaryIndexedTree.h
		org_ice1000_public_functions.h)

# add_executable(jni ${SOURCE_FILES})
add_library(jni ${SOURCE_FILES} ${SOURCE_HEADERS})

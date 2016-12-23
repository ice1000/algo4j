cmake_minimum_required(VERSION 3.6)
project(jni)

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++11")

set(BUILD_USE_64BITS on)

set(
		SOURCE_TEMPLATES
		global/templates.hpp
		global/sort.hpp
)

set(
		SOURCE_FILES
		bit/BinaryIndexedTree.cpp
		graph/FrontStarGraph.cpp
		math/Trigonometric.cpp
		global/functions.cpp
		util/Statistics.cpp
		math/MathUtils.cpp
		graph/UnionSet.cpp
		global/winapi.cpp
		global/bigint.cpp
		global/basics.hpp
		util/SeqUtils.cpp
		math/BigInt.cpp
		win/WinAPI.cpp
)

set(
		SOURCE_HEADERS
		bit/BinaryIndexedTree.h
		graph/FrontStarGraph.h
		math/Trigonometric.h
		global/functions.h
		util/Statistics.h
		math/MathUtils.h
		graph/UnionSet.h
		global/bigint.h
		global/winapi.h
		util/SeqUtils.h
		math/BigInt.h
		win/WinAPI.h
)

# add_executable(jni ${SOURCE_FILES})
add_library(
		jni
		SHARED
		${SOURCE_FILES}
		${SOURCE_TEMPLATES}
		${SOURCE_HEADERS}
)

target_link_libraries(jni)

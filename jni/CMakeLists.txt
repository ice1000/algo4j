cmake_minimum_required(VERSION 3.6)
project(jni)

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++11")

set(BUILD_USE_64BITS on)

set(
		SOURCE_FILES
		bit/BinaryIndexedTree.cpp
		graph/FrontStarGraph.cpp
		math/Trigonometric.cpp
		util/SequenceUtils.cpp
		global/functions.cpp
		global/templates.hpp
		math/MathUtils.cpp
		graph/UnionSet.cpp
		global/winapi.cpp
		global/basics.hpp
		global/sort.hpp
		math/BigInt.cpp
)

set(
		SOURCE_HEADERS
		bit/BinaryIndexedTree.h
		graph/FrontStarGraph.h
		math/Trigonometric.h
		util/SequenceUtils.h
		global/functions.h
		math/MathUtils.h
		graph/UnionSet.h
		global/winapi.h
		math/BigInt.h
)

# add_executable(jni ${SOURCE_FILES})
add_library(
		jni
		SHARED
		${SOURCE_FILES}
		${SOURCE_HEADERS}
)

target_link_libraries(jni)

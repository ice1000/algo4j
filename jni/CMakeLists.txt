cmake_minimum_required(VERSION 3.6)
project(jni)

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++11")

set(BUILD_USE_64BITS on)

set(SOURCE_FILES
		org_ice1000_bit_BinaryIndexedTree.cpp
		org_ice1000_graph_FrontStarGraph.cpp
		org_ice1000_math_Trigonometric.cpp
		org_ice1000_public_templates.hpp
		org_ice1000_public_functions.cpp
		org_ice1000_util_SequenceUtils.cpp
		org_ice1000_math_MathUtils.cpp
		org_ice1000_graph_UnionSet.cpp
		)

set(SOURCE_HEADERS
		org_ice1000_bit_BinaryIndexedTree.h
		org_ice1000_graph_FrontStarGraph.h
		org_ice1000_math_Trigonometric.h
		org_ice1000_public_functions.h
		org_ice1000_util_SequenceUtils.h
		org_ice1000_math_MathUtils.h
		org_ice1000_graph_UnionSet.h
		)

# add_executable(jni ${SOURCE_FILES})
add_library(jni
		SHARED
		${SOURCE_FILES}
		${SOURCE_HEADERS}
		)

target_link_libraries(jni)

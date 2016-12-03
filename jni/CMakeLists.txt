cmake_minimum_required(VERSION 3.6)
project(jni)

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++11")

set(BUILD_USE_64BITS on)

set(
		SOURCE_FILES
		bit/org_ice1000_bit_BinaryIndexedTree.cpp
		graph/org_ice1000_graph_FrontStarGraph.cpp
		math/org_ice1000_math_Trigonometric.cpp
		global/templates.hpp
		global/functions.cpp
		util/org_ice1000_util_SequenceUtils.cpp
		math/org_ice1000_math_MathUtils.cpp
		graph/org_ice1000_graph_UnionSet.cpp
)

set(
		SOURCE_HEADERS
		bit/org_ice1000_bit_BinaryIndexedTree.h
		graph/org_ice1000_graph_FrontStarGraph.h
		math/org_ice1000_math_Trigonometric.h
		global/functions.h
		util/org_ice1000_util_SequenceUtils.h
		math/org_ice1000_math_MathUtils.h
		graph/org_ice1000_graph_UnionSet.h
)

# add_executable(jni ${SOURCE_FILES})
add_library(
		jni
		SHARED
		${SOURCE_FILES}
		${SOURCE_HEADERS}
)

target_link_libraries(jni)

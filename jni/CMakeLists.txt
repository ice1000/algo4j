cmake_minimum_required(VERSION 3.6)
project(jni)

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++11")

set(BUILD_USE_64BITS on)

set(
		SOURCE_TEMPLATES
		global/basics.hpp
		global/templates.hpp
		global/sort.hpp
		global/heap.hpp
)

set(
		SOURCE_FILES
		graph/AdjacentMatrixGraph.cpp
		tree/bit/BinaryIndexedTree.cpp
		tree/heap/MinHeap.cpp
		tree/heap/MaxHeap.cpp
		graph/FrontStarGraph.cpp
		math/Trigonometric.cpp
		global/functions.cpp
		global/trie.cpp
		tree/Trie.cpp
		util/Statistics.cpp
		math/MathUtils.cpp
		tree/UnionSet.cpp
		global/bigint.cpp
		global/basics.hpp
		util/SeqUtils.cpp
		global/matrix.cpp
		math/BigInt.cpp
)

set(
		SOURCE_HEADERS
		graph/AdjacentMatrixGraph.h
		tree/bit/BinaryIndexedTree.h
		tree/heap/MinHeap.h
		tree/heap/MaxHeap.h
		graph/FrontStarGraph.h
		math/Trigonometric.h
		global/functions.h
		global/trie.h
		tree/Trie.h
		util/Statistics.h
		math/MathUtils.h
		tree/UnionSet.h
		global/bigint.h
		global/matrix.h
		util/SeqUtils.h
		math/BigInt.h
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

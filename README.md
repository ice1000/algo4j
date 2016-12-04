
# JniAlgorithm

This is an algorithm library for Java use, and core is written in C++ with JNI.

## Project structure

file name|usage
:---|---:
jni|C++ codes
code_drafts|something written but not used ATM
jni.dll|jni library
jni/cpp-discretizationTest|C++ tests
src|source
discretizationTest|tests

## Algorithm(also data structure)

- [X] Binary indexed tree, including point-update-interval-query, interval-update-point-query and interval-update-interval-query
- [X] Trigonometric functions, like: sin cos tan cot sec csc
- [X] Union set. including path compression and heuristic merge.
- [ ] MathUtils, will be more powerful than java.lang.Math.
- [ ] SequenceUtils, like sorting an data with different algorithm or discretization.
- [ ] Front star graph, including shortest-path-faster-algorithm, kruskal is still in progress.

Actually, every java classes are well-documented.<br/>
For more information, see Javadocs in each java file or package-info.java.

## Languages

part of this project|language
:---|---:
core|C++
core tests|C++
jni interface|Java
java port tests|Kotlin

## Contribute

There is a README file under `jni` path, it's strongly-recommended to read that.

This library is discretizationTest-driven, so there are tests for every class. If you want to contribute, please offer tests for your classes.


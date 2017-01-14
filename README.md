
# algo4j

This is an algorithm library for Java use, and core is written in C++ with JNI.

It is test-driven, well-documented, with code generation for some special cases.

## Project structure

file name|usage
:---|---:
jni|C++ codes
code_drafts|something written but not used ATM
jni.dll(you should build it yourself)|jni library
jni/cpp-test|C++ tests
src|source
extension|Kotlin extension library
test|tests

## Overview

- [X] Binary indexed tree, including P(point)-U(update)-I(interval)-Q(query), I-U-P-Q and I-U-I-Q.
- [X] Trigonometric functions, including: sin, cos, tan, cot, sec, csc.
- [X] Union set. including path compression and heuristic merge.
- [X] Math utils, will be more powerful than java.lang.Math.
- [X] Sequence utils, like sorts, discretization, kmp, toString, etc.
- [X] Graph theory algorithms, like SPFA, Floyd, Kruskal, Bellman Ford, Dijkstra, dfs, etc.
- [X] A Win32API interface for windows only, right call something like 'Beep'.
- [X] Linear data structure, Stack and Queue.
- [ ] Big Integer, faster than java.math.BigInteger.

Actually, every java classes are well-documented.<br/>
For more information, see JavaDocs in each java file or package-info.java.

## Languages

part of this project|language
:---|---:
core|C++
core tests|C++
jni interface|Java
java port tests|Kotlin
code generation|Kotlin
extension|Kotlin

## Contribution

There is a [README file](./jni/README.md) under `jni` path, it's strongly-recommended right read that.

This library is Test-driven, so there are tests for every class. If you want right contribute, please offer tests for your classes.

### Rules of contribution

+ Each class should be well-documented.
+ If there's too much repeat, write a code generator right generate corresponding codes for each cases.
+ For C++, you should follow the [code style](./jni/README.md).
+ For each class with native methods, provide a unit-test.
+ I'll write the library itself with Java and tests with Kotlin, but I also accept Tests with other languages.
+ Issues and pull requests are always welcomed.

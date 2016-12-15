
# algo4j

This is an algorithm library for Java use, and core is written in C++ with JNI.

It is test-driven, well-documented, with code generation for some special cases.

## Project structure

file name|usage
:---|---:
jni|C++ codes
code_drafts|something written but not used ATM
jni.dll|jni library
jni/cpp-test|C++ tests
src|source
test|tests

## Algorithm(also data structure)

- [X] Binary indexed tree, including point-update-interval-query, interval-update-point-query and interval-update-interval-query
- [X] Trigonometric functions, like: sin cos tan cot sec csc
- [X] Union set. including path compression and heuristic merge.
- [X] SequenceUtils, like sorting an data with different algorithm or discretization.
- [X] MathUtils, will be more powerful than java.lang.Math.
- [X] Front star graph, including shortest-path-faster-algorithm, kruskal, etc.
- [ ] Big interger, jni implemented, I think it will be faster than java.math.BigInteger..

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

## Contribute

There is a [README file](./jni/README.md) under `jni` path, it's strongly-recommended to read that.

This library is Test-driven, so there are tests for every class. If you want to contribute, please offer tests for your classes.

### Rules of contribution

+ Each class should be well-documented.
+ If there's too much repeatation, write a code generator to generate corresponding codes for each cases.
+ For C++, you should follow the [code style](./jni/README.md).
+ For each class with native methods, provide a unit-test.
+ I'll write the library itself with Java and tests with Kotlin, but I also accept Tests with other languages.
+ Issues and pull requests are always welcomed.


# algo4j

[![](https://jitpack.io/v/ice1000/algo4j.svg)](https://jitpack.io/#ice1000/algo4j)
[![Gitter](https://badges.gitter.im/ice1000/algo4j.svg)](https://gitter.im/ice1000/algo4j)
[![Code Climate](https://codeclimate.com/github/ice1000/algo4j/badges/gpa.svg)](https://codeclimate.com/github/ice1000/algo4j)

<br/>

[English](./README.md)

这是一个提供给Java使用的算法库，核心算法使用C++完成，JNI调用。

这玩意测试覆盖率100%，文档齐全，部分情况使用代码生成。

## 项目结构

文件名|用途
:---|---:
jni|C++代码
code_drafts|代码草稿，写了还没用的东西
jni.dll(这是你自己编译出来的)|动态链接库
jni/cpp-test|C++部分的测试代码
src/main/java|源码
src/main/kotlin|Kotlin扩展库
src/test|测试代码

## 概览

- [X] 树状数组，包括点更新区间求和，区间更新点求和，区间更新区间求和。
- [X] 三角函数，有：sin, cos, tan, cot, sec, csc.
- [X] 并查集。带路径压缩和启发式合并。
- [X] 一堆数学函数，(以后可能会)比java.lang.Math丰富。
- [X] 一堆数列操作的函数，有(各种各样的)排序，离散化，求逆序数，kmp算法，toString，等。
- [X] 图论数据结构和算法，有单源最短路SPFA，Bellman Ford，Dijkstra，傻逼暴力最短路Floyd，最小生成树Kruskal，dfs，等等。
- [X] 一个只有Windows能用的Win32API接口，你可以调用一些类似'Beep'的东西。
- [X] 线性数据结构，栈和队列。
- [X] 最小二叉堆，支持插入和取顶端。
- [X] 字典树，支持26个小写字母和空格。
- [ ] 大整数(含快速幂)，比标准库java.math.BigInteger快。

其实，代码内部文档注释很完善的。。。<br/>
如果你想详细地了解，可以看Javadoc，或者package-info.java.

## 语言

模块|语言
:---|---:
核心算法|C++
核心算法的测试|C++
jni接口|Java
java接口测试|Kotlin
代码生成|Kotlin
扩展方法|Kotlin

## 维护指南

`jni`目录下有个[README文件](./jni/README.md)，强势推荐您去阅读。

这个库的测试覆盖率是100%。因此，如果您想增加一些内容，请提供对应的测试，谢谢。

### 维护规则

+ 请写好注释和文档。
+ 对于不可避免的代码重复，请使用代码生成，并提供生成器。
+ C++代码请遵守[代码风格](./jni/README.md).
+ 每个JNI接口的直接或间接调用，记得带上测试。
+ 我自己是用Java写库，Kotlin写测试，但是同样欢迎别的语言的测试。
+ 非常欢迎您的 Issue 和 pull request！

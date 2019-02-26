
# algo4j

持续集成|状态
:---|:---:
Travis CI|[![Build Status](https://travis-ci.org/ice1000/algo4j.svg?branch=master)](https://travis-ci.org/ice1000/algo4j)
CircleCI|[![CircleCI](https://circleci.com/gh/ice1000/algo4j/tree/master.svg?style=svg)](https://circleci.com/gh/ice1000/algo4j/tree/master)
CodeShip|[![CodeShip](https://codeship.com/projects/313a88d0-0990-0135-51ec-6af2f1d244f3/status?branch=master)](https://app.codeship.com/projects/214594)
AppVeyor|[![Build status](https://ci.appveyor.com/api/projects/status/atqp1d81m5irdr9q?svg=true)](https://ci.appveyor.com/project/ice1000/algo4j)

[![JitPack](https://jitpack.io/v/ice1000/algo4j.svg)](https://jitpack.io/#ice1000/algo4j)
[![Gitter](https://badges.gitter.im/ice1000/algo4j.svg)](https://gitter.im/ice1000/algo4j)
[![Stories in Ready](https://badge.waffle.io/ice1000/algo4j.png?label=In%20Progress&title=In%20Progress)](http://waffle.io/ice1000/algo4j)
[![codecov](https://codecov.io/gh/ice1000/algo4j/branch/master/graph/badge.svg)](https://codecov.io/gh/ice1000/algo4j)

<br/>

[English](./README.md)

这是一个提供给Java使用的算法库，核心算法使用C++完成（禁用STL），JNI调用。

这玩意测试覆盖率100%，文档齐全，部分情况使用代码生成。

## 项目结构

文件名|用途
:---|---:
jni|C++代码
code_drafts|代码草稿，写了还没用的东西
libjni.dll/libjni.so/libjni.dylib|动态链接库
jni/cpp-test|C++部分的测试代码
src/main/java|源码
src/main/kotlin|Kotlin扩展库
src/test|测试代码

上面说的`动态链接库`没有包含在仓库内，你可以选择自己编译它，或者直接下载：

+ 通用下载方案：[GitHub release](https://github.com/ice1000/algo4j/releases)
+ Windows：[AppVeyor artifact](https://ci.appveyor.com/project/ice1000/algo4j/build/artifacts)
+ Linux：[CircleCI](https://circleci.com/gh/ice1000/algo4j)并转最新build的artifact界面

下载后放在运行的工作目录即可。

## 概览

- [X] 树状数组，包括点更新区间求和，区间更新点求和，区间更新区间求和。
- [X] 三角函数，有：sin, cos, tan, cot, sec, csc.
- [X] 并查集。带路径压缩和启发式合并。
- [X] 数学函数，快速幂系列，素数，斐波那契等。
- [X] 数列操作的函数，有(各种各样的)排序，离散化，求逆序数，kmp 算法，toString，等。
- [X] 图论数据结构和算法，有单源最短路 SPFA，Bellman Ford，Dijkstra，暴力最短路 Floyd，最小生成树 Kruskal，dfs，等等。
- [X] 只有 Windows 能用的 Win32API 接口，你可以调用一些类似'Beep/BatteryStatus'的东西。
- [X] 线性数据结构，栈和队列，还有对应的 Int 版。
- [X] 最小二叉堆，支持插入和取顶端。
- [X] 字典树，支持 ASCII 的 32 到 127 的字符，Trie<T> : Map<String, T>。
- [X] 多线程快速排序
- [X] 大整数快速幂
- [X] 大整数加减乘除余，部分情况比标准库 java.math.BigInteger 快。
- [X] 线段树，多种实现
- [ ] 可持久化线段树(主席树)，多种实现

其实，代码内部文档注释很完善的。。。<br/>
如果你想详细地了解，可以看 Javadoc，或者 package-info.java.

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

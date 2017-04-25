
# algo4j

持续集成|状态
:---|:---:
Travis CI|[![Build Status](https://travis-ci.org/ice1000/algo4j.svg?branch=master)](https://travis-ci.org/ice1000/algo4j)
AppVeyor|[![Build status](https://ci.appveyor.com/api/projects/status/atqp1d81m5irdr9q?svg=true)](https://ci.appveyor.com/project/ice1000/algo4j)
CodeShip|[![CodeShip](https://codeship.com/projects/313a88d0-0990-0135-51ec-6af2f1d244f3/status?branch=master)](https://app.codeship.com/projects/214594)
CircleCI|[![CircleCI](https://circleci.com/gh/ice1000/algo4j/tree/master.svg?style=svg)](https://circleci.com/gh/ice1000/algo4j/tree/master)

[![JitPack](https://jitpack.io/v/ice1000/algo4j.svg)](https://jitpack.io/#ice1000/algo4j)
[![Gitter](https://badges.gitter.im/ice1000/algo4j.svg)](https://gitter.im/ice1000/algo4j)
[![License: GPL v3](https://img.shields.io/badge/License-GPL%20v3-blue.svg)](http://www.gnu.org/licenses/gpl-3.0)
[![Stories in Ready](https://badge.waffle.io/ice1000/algo4j.png?label=In%20Progress&title=In%20Progress)](http://waffle.io/ice1000/algo4j)

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

上面说的`动态链接库`没有包含在仓库内，你可以选择自己编译它，或者：

+ 通用下载方案：[GitHub release](https://github.com/ice1000/algo4j/releases)
+ Windows：[AppVeyor artifact](https://ci.appveyor.com/project/ice1000/algo4j/build/artifacts)
+ Linux：[CircleCI](https://circleci.com/gh/ice1000/algo4j)并转最新build的artifact界面

## 概览

- [X] 树状数组，包括点更新区间求和，区间更新点求和，区间更新区间求和。
- [X] 三角函数，有：sin, cos, tan, cot, sec, csc.
- [X] 并查集。带路径压缩和启发式合并。
- [X] 一堆数学函数，(以后可能会)比java.lang.Math丰富。
- [X] 一堆数列操作的函数，有(各种各样的)排序，离散化，求逆序数，kmp算法，toString，等。
- [X] 图论数据结构和算法，有单源最短路SPFA，Bellman Ford，Dijkstra，傻逼暴力最短路Floyd，最小生成树Kruskal，dfs，等等。
- [X] 一个只有Windows能用的Win32API接口，你可以调用一些类似'Beep'的东西。
- [X] 线性数据结构，栈和队列，还有对应的Int版。
- [X] 最小二叉堆，支持插入和取顶端。
- [X] 字典树，支持ASCII的32到127的字符，Trie<T> : Map<String, T>。
- [X] 多线程快速排序
- [ ] 线段树，多种实现
- [ ] 可持久化线段树(主席树)，多种实现
- [ ] 大整数(含快速幂)，大部分情况比标准库java.math.BigInteger快。

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

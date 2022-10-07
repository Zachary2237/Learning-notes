# Java语言概述

## 1.1 java的特点

1. 面向对象
  - 两个基本概念：类、对象
  - 三大特性：封装、继承、多态
2. 健壮性
3. 跨平台性
  原理：JVM（java虚拟机），在不同的操作系统上都由JVM来负责java程序的运行。

## 1.2 两种核心机制

- Java虚拟机 (Java Virtal Machine)
- 垃圾收集机制 (Garbage Collection)

### 1.2.1 Java虚拟机

- JVM是一个虚拟的计算机，具有指令集并使用不同的存储区域。负责执行指令，管理数据、内存、寄存器。
- 对于不同的平台，有不同的虚拟机。
- 只有某平台提供了对应的java虚拟机，java程序才可在此平台运行
- Java虚拟机机制屏蔽了底层运行平台的差别，实现了“一次编译，到处运行”

### 1.2.2 垃圾回收

- 不再使用的内存空间应回收—— 垃圾回收。
- 在C/C++等语言中，由程序员负责回收无用内存。
- Java 语言消除了程序员回收无用内存空间的责任：它提供一种系统级线程跟踪存储空间的分配情况。并在JVM空闲时，检查并释放那些可被释放的存储空间。
- 垃圾回收在Java程序运行过程中自动进行，程序员无法精确控制和干预。

但是Java仍然会出现内存泄漏和内存溢出的问题

## 2.1 JDK与JRE

JDK(Java Development Kit Java开发工具包)
JDK是提供给Java开发人员使用的，其中包含了java的开发工具，也包括了JRE。所以安装了JDK，就不用在单独安装JRE了。
- 其中的开发工具：编译工具(javac.exe) 打包工具(jar.exe)等


JRE(Java Runtime Environment Java运行环境) 
包括Java虚拟机(JVM Java Virtual Machine)和Java程序所需的核心类库等，如果想要运行一个开发好的Java程序，计算机中只需要安装JRE即可。

总结：使用JDK的开发工具完成的java程序交给JRE去运行。

## 2.2 JDK、JRE与JVM

JDK = JRE + 开发工具集    
JRE = JVM + Java SE标准类库



<img width="319" alt="捕获" src="https://user-images.githubusercontent.com/91724689/186645609-379368de-3e86-48b8-96d9-4656cdaea101.PNG">

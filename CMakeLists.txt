cmake_minimum_required(VERSION 3.24)
project(Learning_notes)

set(CMAKE_CXX_STANDARD 14)

add_executable(Learning_notes
        C++/StudentTest.cpp
        DataStructure/src/SinglyLinkedList.cpp
        out/production/Learning_notes/DataStructure/SinglyLinkedList.cpp
        out/production/Learning_notes/src/DataStructure/SinglyLinkedList.cpp C++/Test.c DataStructure/src/Chapter1/SqList.cpp DataStructure/src/Chapter1/SqList.cpp DataStructure/src/Chapter1/SqListHeader.h DataStructure/src/Chapter1/LinkList.cpp DataStructure/src/Chapter1/LinkListHeader.h DataStructure/src/Chapter1/Predefined.h)

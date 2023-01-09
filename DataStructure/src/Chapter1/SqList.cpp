/**
 * Author: wxh
 * Date: 2023/1/7
 * Desc:
 *
 * 线性表的顺序存储结构
 *
 *
 * 顺序表优缺点:
 * - 优点:
 *      存储密度大(节点本身所占存储量 / 节点结构所占存储量)
 *      可以随机存取表中任一元素
 * - 缺点:
 *      在插入,删除某一元素时,需要移动大量元素
 *      浪费存储空间
 *      属于静态存储形式,数据元素的个数不能自由扩充
 *
 */


#include "Predefined.h"
#include "SqListHeader.h"

using namespace std;

//初始化线性表
Status InitList(SqList &L) { //构造一个空的顺序表L
//    L.elem = (ElemType *) malloc(MAXSIZE * sizeof(ElemType)); //标准C写法
    L.elem = new int(MAXSIZE); //C++写法 为顺序表分配空间
    if (!L.elem) exit(OVERFLOW); //存储分配失败
    L.length = 0; //空表长度为0

    return OK;
}

//销毁线性表
void DestroyList(SqList &L) {
    if (L.elem) delete L.elem; //释放存储空间
}

//清空线性表
void ClearList(SqList &L) {
    L.length = 0; //将长度重置为0
}

//获取线性表的长度
int GetLength(const SqList &L) {
    return L.length;
}

//查看线性表是否为空
int IsEmpty(const SqList &L) {
    if (L.length == 0) return 1;
    else return 0;
}

//获取线性表中第i个元素
int GetElem(const SqList &L, int i, ElemType &e) {
    if (i < 1 || i > L.length) return ERROR;
    e = L.elem[i - 1];
    return OK;
}

//查找线性表中有没有值为e的元素,返回其序号
int LocateElem(const SqList &L, ElemType e) {
    for (int i = 0; i < L.length; ++i) {
        if (L.elem[i] == e) {
            return i + 1;
        }
    }

    return 0; //未找到,返回0
}

//在表中第i个元素之前插入元素e
Status ListInsert(SqList &L, int i, ElemType e) {
    if (i < 1 || i > L.length)return ERROR;
    if (L.length == MAXSIZE) return ERROR;
    for (int j = i - 1; j < L.length; ++j) {
        L.elem[j + 1] = L.elem[j];
    }
    L.elem[i - 1] = e;
    L.length++;
    return OK;

}

//删除表中第i个元素
Status ListDelete(SqList &L, int i) {
    if (i < 1 || i > L.length) return ERROR;
    if (L.length == 0)return ERROR;
    for (int j = i - 1; j < L.length - 1; ++j) {
        L.elem[j] = L.elem[j + 1];
    }
    L.length--;
    return OK;
}

int main() {

    SqList L;


    return 0;
}


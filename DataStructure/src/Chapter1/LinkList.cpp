/**
 * Author: wxh
 * Date: 2023/1/9
 * Desc:
 *
 */

#include "Predefined.h"
#include "LinkListHeader.h"

using namespace std;

//单链表的初始化(带头节点的单链表)
Status InitList(LinkList &L) {
    L = new Lnode;
    L->next = NULL;
    return OK;
}

//判断链表是否为空
int IsEmpty(LinkList L) {
    if (L->next) {
        return FALSE;
    } else {
        return TRUE;
    }
}

Status DestroyList(LinkList &L) {
    Lnode *p;
    while (L) {
        p = L;
        L = L->next;
        delete p;
    }

    return OK;
}

Status ClearList(LinkList &L) {
    Lnode *p;
    Lnode *q;

    p = L->next;
    while (p) {
        q = p->next;
        delete p;
        p = q;
    }

    L->next = nullptr;

    return OK;
}

int ListLength(LinkList L) {
    Lnode *p;
    p = L->next;
    int len = 0;
    while (p) {
        len++;
        p = p->next;
    }

    return len;
}



int main() {
    LinkList L;


    return 0;
}

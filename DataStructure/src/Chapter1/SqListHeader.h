/**
 * Author: wxh
 * Date: 2023/1/7
 * Desc:
 *
 */


#ifndef LEARNING_NOTES_SQLISTHEADER_H
#define LEARNING_NOTES_SQLISTHEADER_H

#define MAXSIZE 100

typedef int Status;
typedef int ElemType;

typedef struct {
    ElemType *elem;
    int length;
} SqList;

Status InitList(SqList &L);

void DestroyList(SqList &L);

void ClearList(SqList &L);

int GetLength(const SqList &L);

int IsEmpty(const SqList &L);

int GetElem(const SqList &L, int i, ElemType &e);

int LocateElem(const SqList &L, ElemType e);

Status ListInsert(SqList &L, int i, ElemType e);

Status ListDelete(SqList &L, int i);

#endif //LEARNING_NOTES_SQLISTHEADER_H

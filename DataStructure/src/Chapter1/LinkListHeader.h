/**
 * Author: wxh
 * Date: 2023/1/9
 * Desc:
 *
 */


#ifndef LEARNING_NOTES_LINKLISTHEADER_H
#define LEARNING_NOTES_LINKLISTHEADER_H

typedef int Status;
typedef int ElemType;

typedef struct Lnode {
    ElemType data;
    struct Lnode *next;
} Lnode, *LinkList;

#endif //LEARNING_NOTES_LINKLISTHEADER_H

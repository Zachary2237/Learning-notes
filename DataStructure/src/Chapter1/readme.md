## 第一章: 线性表

|            |                       顺序表                        |                             链表                             |
| :--------: |:------------------------------------------------:| :----------------------------------------------------------: |
|  存储空间  |              预先分配，静态存储,可能会导致空间闲置或溢出              |              动态分配，不会出现空间闲置或者溢出              |
|  存储密度  |             存储密度为1，逻辑关系等于存储关系，没有额外开销             |     存储密度小于1，要借助指针域来表示元素之间的逻辑关系      |
|  存取元素  |              随机存取，按位置访问元素的时间复杂度O(1)              |         顺序存取，访问某位置的元素的时间复杂度为O(n)         |
| 插入、删除 |      插入和删除都要移动大量的元素。平均移动元素约为表的一半。时间复杂度O(n)       | 不需要移动元素，只需要改变指针位置，继而改变结点之间的链接关系。时间复杂度O(1) |
|  适用情况  | 1.表长变化不大，或者事先就能确定变化的范围<br />2.很少进行插入和删除，需要下标访问元素 |            1.长度变化较大<br />2.频繁的插入和删除            |


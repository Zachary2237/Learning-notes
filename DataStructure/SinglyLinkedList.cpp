```
/*单链表的模板代码,在链表类中将实现以下功能:
  get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
  addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
  addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
  addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。如果 index 等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
  deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。*/


#include<iostream>

using namespace std;

class MyListForward {
private:
	struct ListNode {
		int val;
		ListNode* next;
		ListNode(int x) : val(x), next(NULL){}
	}; 
	ListNode* head;
public:
	MyListForward() : head(NULL){}

	int get(int index) {
		int i = 0;
		ListNode* p = head;
		while (p && i < index) {//小于号优先级高
			p = p->next;
			i++;
		}
		if (p)return p->val;
		else return -1;
	}

	void addAtHead(int val) {
		ListNode* p = new ListNode(val);
		p->next = head;
		head = p;
	}
		
	void addAtTail(int val) {
		ListNode* p = new ListNode(val);
		if (head == NULL) {//链表为空，直接将新节点作为头节点
			head = p;
			return;
		}
		ListNode* q = head;
		while (q->next) {
			q = q->next;
		}
		q->next = p;
	}

	void addAtIndex(int index, int val) {
		ListNode* node = new ListNode(val);
    //1、index小于等于0，直接在头部插入节点
		if (index <= 0) {//注意这里不能使用指针p，因为p=node时，p所指向的地址发生了变化，head指向的地址没有变化，所以我们这里要使用指针head
			node->next = head;
			head = node;
			return;
		}
		int i = 0;
		ListNode* p = head;
    //在索引为index的节点之前插入新节点，我们需要找到它的前驱节点，然后插入在它的前驱节点后面
		while (p && i < index - 1) {
			p = p->next;
			++i;
		}
    //2、p为索引节点的前驱节点
		if (p) {
			node->next = p->next;
			p->next = node;
		}
	}

	void deleteAtIndex(int index) {
		if (index == 0 && head != NULL) {
			head = head->next;
			return;
		}
		int i = 0;
		ListNode* p = head;
		while (p && i < index - 1) {
			p = p->next;
			i++;
		}
		if (!p)return;
		if (p->next) {
			p->next = p->next->next;
		}

	}

	int length() {
		int i = 0;
		ListNode* p = head;
		while (p) {
			i++;
			p = p->next;
		}
		return i;
	}

};

int main() {
	MyListForward mlf;
	mlf.addAtIndex(0, 10);
	mlf.addAtIndex(0, 20);
	mlf.addAtIndex(1, 30);
	for (int i = 0; i < mlf.length(); i++) {
		cout << mlf.get(i) << " ";
	}
	cout << endl;


	return 0;
}
```

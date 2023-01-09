//
// Created by iimmy_o on 2022/12/28.
//

#include "iostream"
#include "string"

using namespace std;

struct Student {
    int id;
    int score;
};

struct Person {
    string name;
    int age;
    struct Student s;
};

void printStruct(Person *p) {
    p->age = 29;
    p->s.score = 64;
    cout << p->name << " " << p->age << " " << p->s.id << " " << p->s.score << endl;
}

int main() {

    Person p;
    p.name = "Tom";
    p.age = 19;
    p.s.id = 1;
    p.s.score = 98;

    cout << p.name << " " << p.age << " " << p.s.id << " " << p.s.score << endl;

    printStruct(&p);



    return 0;
}

//
// Created by iimmy_o on 2023/1/3.
//
#include "iostream"
#include "string"

using namespace std;

class Student {
private:
    int id;
    int score;

public:

    Student(int id = 0, int score = 0) : id(id), score(score) {
        cout << "Student Constructor" << endl;
    }

    virtual ~Student() {
        cout << "Student Destructor" << endl;
    }

};

class Person{

public:

    Person() {}

    Person(const string &name, int age, const Student &stu) : name(name), age(age), stu(stu) {
        cout << "Person Constructor" << endl;
    }

    virtual ~Person() {
        cout << "Person Destructor" << endl;

    }

private:
    string name;
    int age;
    Student stu;

};

int main() {
    Person p();

    int a[] = {1, 2, 3, 4, 5};
    int *ptr = a;
    int *q = &a[5];
    printf("%d", *q);
    printf("%d", *q - *ptr);


    return 0;
}

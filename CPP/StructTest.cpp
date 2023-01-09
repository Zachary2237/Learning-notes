#include "iostream"
#include "string"

using namespace std;

struct Student {
    string name;
    int score;
};

struct Teacher {
    string name;
    Student stu[5];
};

void giveValue(Teacher *p, int len) {
    string name;
    int score;
    for(int i = 0; i < len; i++) {
        cout << "Teacher's name: " << endl;
        cin >> name;
        p->name = name;
        for(int j = 0; j < 5; j++) {
            cout << "student's name & score : " << endl;
            cin >> name >> score;
            p->stu[j].name = name;
            p->stu[j].score = score;
        }
        p++;
        
    }

}

void printClass(Teacher *p, int len) {
    for(int i = 0; i < len; i++) {
        for(int j = 0; j < 5; j++) {
            cout << "teacher: " << p->name << " stu: " << p->stu[j].name << " " << p->stu[j].score << endl;
        }
        p++;
    }
}

int main() {
    int len = 3;

    Teacher teacher[3];

    giveValue(teacher, len);

    printClass(teacher, len);
    
    


    return 0;
}
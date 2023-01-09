#include "iostream"
#include "string"

using namespace std;

class Student{

private:
    string name;
    int id;


public:
    Student() {}
    Student(string name, int id) {
        this->name = name;
        this->id = id;
    }

    void setName(string name) {
        this->name = name;
    }

    void setId(int id) {
        this->id = id;
    }

    void show() {
        cout << "name: " << name << " id: " << id << endl;
    }


};

int main() {

    Student s;
    s.setName("Tom");
    s.setId(1);
    s.show();

    
    


    return 0;
}
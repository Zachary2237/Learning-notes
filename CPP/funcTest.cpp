#include "iostream"

using namespace std;

class Person{
    public:
        string name;
        int id;

};

int func(int a, int b, int c = 20) {
    return a + b + c;
}

int main() {

    cout << func(10, 20) << endl;


    return 0;
}
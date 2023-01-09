#include "iostream"

using namespace std;

int& test1() {
    static int a = 10;
    return a;
}

int main() {
    int &ans = test1();
    cout << ans << endl; //10

    test1() = 1000;
    cout << ans << endl; //1000


    return 0;
}
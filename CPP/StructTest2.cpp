#include "iostream"
#include "string"

using namespace std;

enum Sex{
    MALE,
    FEMALE
};

struct Hero {

    string name;
    int age;
    Sex sex;

};

void MySwap(Hero *a, Hero *b) {
    Hero temp = *a;
    *a = *b;
    *b = temp;
}

void bubbleSort(Hero *hero, int len) {
    for(int i = 0; i < len; i++) {
        for(int j = 0; j < len - 1; j++) {
            if (hero[j].age > hero[j + 1].age)
            {
                MySwap(&hero[j], &hero[j + 1]);
            }
            
        }
        
    }
    
}

void printHero(Hero *hero, int len) {
    for(int i = 0; i < len; i++) {
        cout << hero[i].name << " " << hero[i].age << " " << hero[i].sex << endl;
    }
}

int main() {

    Hero hero[5] = {{"刘备", 23, FEMALE}, {"guanyu", 24, FEMALE}, {"huamulan", 20, MALE}, {"wxh", 19, FEMALE}, {"zhaoyun", 25, FEMALE}};

    int len = sizeof(hero) / sizeof(hero[0]);

    int* a = new int(10);

    bubbleSort(hero, len);

    printHero(hero, len);




    return 0;
}
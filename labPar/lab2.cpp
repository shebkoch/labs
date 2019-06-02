//
// Created by shebkoch on 10/26/18.
//

#include "lab.h"
const int N = 10;
int buffer[N];

using namespace std;
int popNext(){

    for (int i = 0; i < N; ++i) {
        if(buffer[i] != -1) {
            int buff = buffer[i];
            buffer[i] = -1;
            return buff;
        }
    }
    return -1;
}

int setNext(int val){
    for (int i = 0; i < N; ++i) {
        if(buffer[i] == -1) {
            buffer[i] = val;
            return 0;
        }
    }
    return -1;
}
int write1(){
    while (true) {
        this_thread::sleep_for(std::chrono::seconds(1));
        setNext(rand() % 10);
    }
}
int write2() {
    while (true) {
        this_thread::sleep_for(std::chrono::seconds(2));
        setNext(rand() % 10 + 10);
    }
}
int read() {
    while (true) {
        int v = popNext();
        if (v != -1){
          cout << v << endl;
        }
    }
}
int lab2() {
    setbuf(stdout,0);
    for (int i = 0; i < N; ++i) {
        buffer[i] = -1;
    }
    thread writer1(write1);
    thread writer2(write2);
    thread reader(read);
    writer1.join();
    writer2.join();
    reader.join();

    return 0;
}

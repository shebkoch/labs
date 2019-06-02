//
// Created by shebkoch on 10/26/18.
//

#include "lab.h"


using namespace std;
void write(string *s){
    this_thread::sleep_for(std::chrono::seconds(5));
    *s = "hello world";
}
void read(string *s){
    while (s->empty());
    cout << *s;
}

int lab1() {
    string s;
    thread writer (write,&s);
    thread reader (read,&s);
    writer.join();
    reader.join();
    return 0;
}

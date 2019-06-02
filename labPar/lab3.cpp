#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <unistd.h>
#include <fcntl.h>
#include <sys/mman.h>
#include <string.h>
#include "lab.h"

using namespace std;

FILE* memFile;
bool canRead;

void writeFile(){
    this_thread::sleep_for(std::chrono::seconds(3));
    char str[] = "hello world";
    int i = 0;

    memFile = tmpfile();

    while (str[i] != '\0')
    {
        fputc(str[i], memFile);
        i++;
    }
    canRead = true;
}
void readFile(){
    while (!canRead);
    rewind(memFile);
    while (!feof(memFile)) {
        int c = fgetc(memFile);
        if(c != -1) putchar(c);
    }
}

int lab3(){
    thread writer(writeFile);
    thread reader(readFile);
    writer.join();
    reader.join();
    return 0;
}


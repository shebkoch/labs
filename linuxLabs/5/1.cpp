#include <stdio.h>
#include <stdlib.h>
#include <signal.h>
#include <unistd.h>
#include <ctime>
#include <string>
using namespace std;
char * path;
string last;
string target;
void term_handler(int i)
{
     if(i == SIGUSR1)
     {
          printf("SAVE\n");
          time_t seconds;
          time(&seconds);
	  last = to_string(seconds) + ".tar ";
	  string command = "tar -cvf " + target + last + string(path) + "\n";
          system(command.c_str());
     }
     if(i == SIGUSR2){
          printf ("LOAD\n");
	  string command = "tar -xvf " + target + last + "-C /";
	  system(command.c_str());
     }
}
void daemon()
{
    pid_t pid;
    pid = fork();
    if(pid != 0)
    	exit(EXIT_SUCCESS);
}
int main(int argc, char ** argv)
{
      daemon();
      path = argv[1];
	  target = argv[2];
      signal(SIGUSR1,term_handler);
      signal(SIGUSR2,term_handler);
      		
      while(1) sleep(1);
      return EXIT_FAILURE;
}

#include <stdio.h>
#include <stdlib.h>
#include <signal.h>
#include <unistd.h>
void term_handler(int i)
{
     if(i == SIGUSR1)
     {
          printf ("SIGUSR1\n");
          exit(EXIT_SUCCESS);
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
      signal(SIGUSR1, term_handler);
      while(1) sleep(1);
      return EXIT_FAILURE;
}

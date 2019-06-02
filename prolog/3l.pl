get(X,Y,Z) :- check(X,Y,Z),
	Z < 9 -> Z1 is Z +1,get(X,Y,Z1);
	Y < 9 -> Y1 is Y+1, get(X,Y1,0);
	X < 9 -> X1 is X + 1, get(X1,0,0);true.

check(X,Y,Z):- X\=Z->Y\=Z -> X\=Y -> writef('%w%w%w\n',[X,Y,Z]);true.

lab3():-get(0,0,0).

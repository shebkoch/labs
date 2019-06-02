negate(X):- maplist(negateNum, X, Z), write(Z).

negateNum(X,Z) :- X > 0 -> Z is X * -1;Z is X.

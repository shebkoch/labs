readText(Str):-readWord(Str,W,IsEnd), IsEnd = 0, readText(Str), is_set(W) -> string_chars(Res,W),writef("%w ", [Res]);true.

lab5() :- 
open("5.txt",read,Str),
readText(Str).

readWord(InStream,Chars,IsEnd):- 
	get_code(InStream,Char), 
	checkCharAndReadRest(Char,Chars,InStream, IsEnd).
	
checkCharAndReadRest(10,[],_, IsEnd):- IsEnd is 0, !. 
    
checkCharAndReadRest(32,[],_, IsEnd):- IsEnd is 0, !. 
 
checkCharAndReadRest(-1,[],_, IsEnd):- IsEnd is 1, !. 
    
checkCharAndReadRest(end_of_file,[],_, IsEnd):- IsEnd is 1, !. 
    
checkCharAndReadRest(Char,[Char|Chars],InStream,IsEnd):- 
	get_code(InStream,NextChar), 
	checkCharAndReadRest(NextChar,Chars,InStream,0).


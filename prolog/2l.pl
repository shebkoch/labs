country(russia, moscow, 146,europe).
country(belarus, minsk, 9,europe).
country(china,pekin,1386, asia).
country(kanada,ottawa,36,amerika).

show_all() :- country(X,Y,Z,Q), writef('country: %w. capital: %w. peopleCount: %wM. Continent: %w.',[X,Y,Z,Q]);true.
show_greater_then(V):- country(X,Y,Z,Q), Z>V, writef('country: %w. capital: %w. peopleCount: %wM. Continent: %w.',[X,Y,Z,Q]);true.
show_lesser_then(V):- country(X,Y,Z,Q), Z<V, writef('country: %w. capital: %w. peopleCount: %wM. Continent: %w.',[X,Y,Z,Q]);true.

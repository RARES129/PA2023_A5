EXERCITIUL 1 (Pentru acest exercitiu am folosit din greseaza directed cycle graph)

Verificam daca argumentul primit este de tip int. Daca este, vom continua rularea, in caz contrat vom inchide programul.

Memoram argumentul intr o variabila n;

Cream matricea de adiacenta a grafului dupa cum urmeaza, primul nod se uneste cu al doilea, al doilea nod cu al treilea ... etc ... iar ultimul nod cu primul.

Facem o copie a matricei de adiacenta CycleGraph in matricea A.

Cu ajutorul matricei B vom memora matricea initiala intai la puterea 2, apoi puterea a 3-a etc, pana ajunge la puterea n.

Dupa fiecare ridicare la putere, vom muta informatiile din matricea B in matricea A pentru a putea ridica in continuare la putere. 

La final, daca matricea initiala este egala cu matricea ridicata la puterea n, va afica ca ele sunt egale. (se intampla pentru orice n)

EXERCITIUL 2

Verificam daca argumentele primite sunt de tip int. Daca sunt, vom continua rularea, in caz contrat vom inchide programul.

Memoram argumentele in doua variabile n si k.
n - number of vertices
k - vertex degree

Daca k este mai mic sau egal decat n, vom incepe construirea matricei de adiacenta si o vom afisa ulterior, in caz contrat vom afisa ca nu exista un graf k regulat.

Pentru constructie: facem suma dintre numarul liniei si numarul coloanei, aflam restul impartirii sumei la numarul (n) de linii si coloane. daca restul (j) este diferit de numarul liniei (i), inseamna ca intre nodul corespondent lui j si nodul corespondent lui i au o linie intre ele. Pentru a face o matrice pentru un graf k regulat, fom rula al doilea for doar de k ori.
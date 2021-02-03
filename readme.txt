StatList ::= Stat
    | Stat StatList;

Stat ::= IfStat SEMI
    | WhileStat SEMI
    | ReadlnStat SEMI
    | WriteStat SEMI
    | AssignStat SEMI
    | CallProc SEMI
    | /* empty */;


Risolvo obbligando ad avere almeno un Stat non vuoto.

StatList::= Stat R
R::= empty| StatList


Stat ::= IfStat SEMI
    | WhileStat SEMI
    | ReadlnStat SEMI
    | WriteStat SEMI
    | AssignStat SEMI
    | CallProc SEMI


//modifica tolta dato che Stat non può essere vuoto non abbiamo conflitto.
/* WhileStat ::= WHILE StatList Expr DO StatList OD
    | WHILE Expr DO StatList OD;            perchè statlist può andare in stat che va in empty*/

WhileStat ::= WHILE StatList Expr DO StatList OD; risolto obbligando stat non essere vuoto


// modifiche alla grammatica per ordine di inserimento nella lista.

ResultTypeList ::= ResultType:r
    | ResultTypeList:list COMMA ResultType:r

ExprList ::= Expr:e
    | ExprList:list COMMA Expr:e

StatList ::= Stat:s
    | StatList:list Stat:s


////modifica aggiunta paramOP
CallProc ::= ID:e1 LPAR ExprList:list RPAR {:RESULT = new CallProcOP(new Constant("ID",e1),new ParamOP(list)); :}//modifica aggiunta paramOP
	| ID:e1 LPAR RPAR {:RESULT = new CallProcOP(new Constant("ID",e1)); :};



# OPERAZIONI

## OPTYPE1

| OP1 | OPERAND | RESULT |

| ! | BOOLEAN | BOOLEAN |
| - | FLOAT | FLOAT |
| - | INT| INT |

## OPTYPE2

|OP2|FIRST OPERAND|SECOND OPERAND|RESULT|

| < == > <= >= <> | BOOLEAN | BOOLEAN | BOOLEAN|
| < == > <= >= <> | INT | INT | BOOLEAN|
| < == > <= >= <> | FLOAT | FLOAT | BOOLEAN|
| < == > <= >= <> | FLOAT | INT | BOOLEAN|
| < == > <= >= <> | INT | FLOAT | BOOLEAN|
| < == > <= >= <> | STRING | STRING | BOOLEAN|
| AND OR | BOOLEAN | BOOLEAN | BOOLEAN|
| + - * / | INT | INT| INT|
| + - * / | FLOAT | FLOAT | FLOAT|
| + - * / | INT | FLOAT| FLOAT |
| + - * / | FLOAT | INT| FLOAT |


# Scelte


> Una StmtList non può essere vuota
> Il return deve esserci sempre alla fine della funzione, anche se è void //simbolo ->
> Nel While deve essere presente il token RETURN tra Stmt e Expr

> Non si possono passare come parametro a una funzione una qualsiasi chiamata a funzione con dei valori di ritorno multipli
> Per utilizzare una funzione, essa deve essere prima definita
> Al main si può assegnare qualsiasi tipo di ritorno, ma questo non sarà considerato e verrà sostituito con int e con valore di ritorno pari a 0


> Le variabili di tipo string, possono contenere stringhe che sono al massimo di 500 caratteri
// si può migliorare utilizzando un incrementatore, sapendo in fase di compilazione, problema in caso di inserimento stdin a runtime.

> Nelle espressioni si possono effettuare chiamate a funzione soltanto con un tipo di ritorno
> La ricorsione è possibile con funzioni che hanno un solo valore di ritorno

> Le operazioni sia unarie che binarie si rifanno alle tabelle OPTYPE1 e OPTYPE2


> Non può essere presente una funzione che ha lo stesso id di una variabile
//se si vuole permettere si potrebbe usare come key della riga della tabella oltre nome anche tipo di costrutto
> Non è possibile dichiarare funzioni con lo stesso nome, anche se hanno paramentri e tipi di ritorno differenti
//Per permettere Polimorfismo si può procedere cambiando la lookup in caso di proc, mette a confronto la signature del metodo.
> L'assegnamento è possibile solo tra elementi dello stesso tipo, ad eccezzione le stringhe possono ricevere anche null, e float anche int;



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



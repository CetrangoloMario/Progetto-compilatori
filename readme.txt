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






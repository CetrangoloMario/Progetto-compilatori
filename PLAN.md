
#Pianificazione

##Definizione linguaggio
- Delimitatori 
- Parole chiavi
- Identificatori
- Letterali
- Separatori  
- Operatori

###Delimitatori

|  Stringa | Classe | Token |
|:--------:|:------:|------:|
| "spazio" | | |
|   "\t"   | | |
|   "\n"   | | |

###Parole chiavi

| Stringa  | Classe   | Token    |
|:--------:|:--------:|:--------:|
| if       | If       | IF       |
| else     | Else     | ELSE     |
| while    | While    | WHILE    |
| for      | For      | FOR      |
| int      | Int      | INT      |
| float    | Float    | FLOAT    |
| bool     | Bool     | BOOL     |
| return   | Return   | RETURN   |
| main     | Main     | MAIN     |
| true     |   True   | TRUE     |
| false    |  False   | FALSE    |
    
###Identificatori

######( nota : "or" = "|" )

| Nome          | RegEx                        |
|:-------------:|:----------------------------:|
| letter        | ([a-z]or[A-Z])               |
| letter_       | (letter)or(_)                |
| digit         | [0-9]                        |
| digits        | (digit)or([1-9][0-9]*)       |          
| identifier    | letter_((letter_)or(digit))* |          

######( nota : "ATTR" = "Puntatore alla tabella delle stringhe" )
     
| RegEx       | Classe     | Token    |
|:-----------:|:----------:|:--------:|
| identifier  | Identifier | ID,ATTR  |

###Letterali

######( nota : "or" = "|" )

| Nome          | RegEx                        |
|:-------------:|:----------------------------:|
| digit         | [0-9]                        |
| integer       | 0or([1-9][0-9]*)       |          
| decimal       | integer.([0-9]*) |          

  
######( nota : "VAL" = "Valore effettivo del numero" )
   
| RegEx       | Classe     | Token       |
|:-----------:|:----------:|:-----------:|
| integer     | Integer    | INTNUM,VAL  |
| decimal     | Decimal    | DECNUM,VAL  |


### Separatori
     
| RegEx       | Classe     | Token     |
|:-----------:|:----------:|:---------:|
| (           | LRBracket  | LRBRACKET |
| )           | RRBracket  | RRBRACKET |
| {           | LBracket   | LBRACKET  |
| }           | RBracket   | RBRACKET  |
| [           | LSBracket  | LSBRACKET |
| ]           | RSBracket  | RSBRACKET |
| ,           | Comma      | COMMA     |
| ;           | SemiComma  | SEMICOMMA |

 
###Operatori

| Nome          | RegEx                       |
|:-------------:|:---------------------------:|
| less          | <                           |
| lessEquals    | <=                          |
| different     | <>                          |          
| greater       | \>                          |          
| equals        | =                           |          
| assign        | <-                          |          

     
| RegEx     | Classe            | Token           |
|:---------:|:-----------------:|:---------------:|
| <         | LessOp            | LESSOP          |
| <=        | LessEqualsOp      | LESSEQUALSOP    |
| <>        | NotEqualsOp       | NOTEQUALSOP     |
| <-        | AssignmentOp      | ASSIGNMENTOP    |
| \>        | GreaterOp         | GREATEROP       |
| \>=       | GreaterEqualsOp   | GREATEREQUALSOP |
| =         | EqualsOp          | EQUALSOP        |
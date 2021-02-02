#Esercitazione 3

 <b>N</b> = {
 
    Program, Stmt, Expr, Relop
 
 },
 
 
 <b>T</b> = {
 
    IF, ELSE, WHILE, FOR, INT, FLOAT, BOOL, **RETURN**,
    **MAIN**, TRUE, FALSE, ID, NUMBER, LESSOP, LESSQEUALSOP,
    NOTEQUALSOP, ASSIGNAMENTOP, GREATEROP, GREATEREQUALSOP,
    EQUALSOP, ID, NUMBER, LRBRACKET, RRBRACKET, LSBRACKET, 
    RSBRACKET, LBRACKET, RBRACKET
 
 },
 
 <b>S</b>= Program
 
   
   
 
  <b>P</b> = {
  
           Program -> Program Stmt 
           Program -> Stmt 
                                     
           Stmt -> IF LRBRACKET Expr RRBRACKET LBRACKET Stmt RBRACKET ELSE LBRACKET Stmt RBRACKET |
                   IF LRBRACKET Expr RRBRACKET LBRACKET Stmt RBRACKET
           Stmt -> WHILE LRBRACKET Expr RRBRACKET LBRACKET Stmt RBRACKET 
           Stmt -> DO LBRACKET Stmt RBRACKET WHILE LRBRACKET Expr RRBRACKET SEMICOMMA
           Stmt -> ID ASSIGNAMENTOP Expr SEMICOMMA 
     
           Expr ->  Expr Relop Expr 
           Expr ->   ID | NUMBER 

           Relop ->  LESSOP | LESSQEUALSOP | NOTEQUALSOP | GREATEROP | 
                     GREATEREQUALSOP | EQUALSOP  
   }
   
  <br><br>
   
 ####Grammatica non ricorsiva sinistra e non ambigua
 
 
   <b>S</b> = {
            
            Program -> Stmt Program'
            Program'-> Stmt Program' | eps
                
            Else -> ELSE LBRACKET Stmt RBRACKET | eps
                                      
            Stmt -> IF LRBRACKET Expr RRBRACKET LBRACKET Stmt RBRACKET Else 
            Stmt -> WHILE LRBRACKET Expr RRBRACKET LBRACKET Stmt RBRACKET 
            Stmt -> DO LBRACKET Stmt RBRACKET WHILE LRBRACKET Expr RRBRACKET SEMICOMMA
            Stmt -> ID ASSIGNAMENTOP Expr SEMICOMMA 
 
            Relop ->  LESSOP | LESSQEUALSOP | NOTEQUALSOP | GREATEROP | 
            GREATEREQUALSOP | EQUALSOP             
            
            Expr -> F Expr'
            Expr' -> Relop F Expr' | eps
            F-> ID | NUMBER
     
    }
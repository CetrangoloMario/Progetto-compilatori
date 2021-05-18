
#README

##Pianificazione
Per quanto riguarda la pianificazione del liNguaggio si rimanda al file "PLAN.MD".

Allegato pdf con i diagrammi di stato realizzati si rimanda file diagrammi.pdf

##GESTIONE ERRORI 

* I diagrammi implementati sono:
    - operatori relazionali
    - separatori
    - identificatori
    - numeri 
    - operatori aritmetrici , incluso not e not_equals (!, !=)
 
* caso afsa"\r"33"\t"4"\r"rwq 
    - il carattere \n \r \t sono letti e funziona in modo come se fossimo in caso del carattere di EOF, quindi stampa:
       <ID, "afsa"> 
       <NUMBER, "33">
       <NUMBER, "4">
       <ID, "rwq">
* 052 o 52a o etc sono stati risolti nel seguente modo:
    -  "052" diventa  <NUMBER, "0"> e poi <NUMBER, "52">, mentre 52a diventa <NUMBER, "52"> e <ID, "a"> ;
*0. 53.rewer 
    -nel caso di 0. o 53. restituisce <ERROR, "0."> <ERROR, "52."
    
* caso +++ o ---
    - <INCREASE> <GREATEROP> legge ++ e poi +; 

* qualsiasi carattere che non rispetta i pattern verà segnalato come <ERROR, "">
    
     
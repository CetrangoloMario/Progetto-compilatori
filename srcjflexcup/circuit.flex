// Circuit.lex
//
// Description of lexer for circuit description language.
//
// Ian
/*
* This class is a simple example lexer
*/
import java_cup.runtime.Symbol; 		//This is how we pass tokens to the parser
import java.io.*;
import java.util.HashMap;
import java.util.Map;

%%

										// Declarations for JFlex

%unicode 								// We wish to read text files
%class Lexer
%cupsym CircuitSym
%cup 									// Declare that we expect to use Java CUP
%line
%column                                 //servono per sapere la posizione linea e colonna yyline e yycoulomn


%{

    private StringBuffer string= new StringBuffer();
   // private static HashMap<String,Symbol> stringTable=new HashMap<String,Symbol>();

    private Symbol symbol(int type){
        return new Symbol(type, yyline,yycolumn);
    }

    private Symbol symbol(int type, Object value){
        return new Symbol(type, yyline, yycolumn, value);
    }

   /* private Symbol installID(String str){
        Symbol symbol;
        if(stringTable.containsKey(str)){
            return symbol(CircuitSym.ID,stringTable.get(str).toString());
        }
        else {
            symbol=new Symbol(CircuitSym.ID,str);
            stringTable.put(str,symbol);
            return symbol(CircuitSym.ID,str);
        }
    }

    private Symbol intNum(String str){
        Symbol symbol;
        symbol=new Symbol(CircuitSym.INTNUM,str);
        return symbol;
    }

    private Symbol decNUM(String str){
            Symbol symbol;
            symbol=new Symbol(CircuitSym.DECNUM,str);
            return symbol;
        }

        public void printStringTable(){
                //int x=0;
                System.out.println("--------String table--------");
                for (Map.Entry e : stringTable.entrySet())
                {
                    // x++;
                    System.out.println("| ID: "+e.getKey()+" | Token: "+e.getValue()+" |" );

                }
                System.out.println("------------------------------------" );
            }*/
%}




										// Abbreviations for regular expressions
delimitator=[ \r\n\t\f]
letter=([a-z]|[A-Z])
letter_=[a-z]|[A-Z]|_
digit=[0-9]
digits=(digit)|([1-9][0-9]*)
integer = (0)|([1-9]{digit}*)
identifier={letter_}({letter_}|{digit})*
decimal= {integer}((\.({digit}+))?)

//%state STRING

%%
							// Now for the actual tokens and assocated actions
"if" 		{ return new Symbol(CircuitSym.IF); }
"else"      {return new Symbol(CircuitSym.ELSE);}
"while"      {return new Symbol(CircuitSym.WHILE);}
"for"      {return new Symbol(CircuitSym.FOR);}
"int"      {return new Symbol(CircuitSym.INT);}
"float"      {return new Symbol(CircuitSym.FLOAT);}
"bool"      {return new Symbol(CircuitSym.BOOL);}
"return"      {return new Symbol(CircuitSym.RETURN);}
"main"      {return new Symbol(CircuitSym.MAIN);}
"true"      {return new Symbol(CircuitSym.TRUE);}
"false"      {return new Symbol(CircuitSym.FALSE);}
"then"      {return new Symbol(CircuitSym.THEN);}
"continue"      {return new Symbol(CircuitSym.CONTINUE);}
"string"      {return new Symbol(CircuitSym.STRING);}


{identifier}    { return new Symbol(CircuitSym.ID, yytext()); }

{integer}       {return new Symbol(CircuitSym.INTNUM, yytext()); }
{decimal}       {return new Symbol(CircuitSym.DECNUM, yytext());}



{delimitator} { /* ignore */ }
//\"             {string.setLength(0); yybegin(STRING);}

/*operator*/

"<="             {return new Symbol(CircuitSym.LESSEQUALSOP);}
"<>"            {return new Symbol(CircuitSym.NOTEQUALSOP);}
"<-"            {return new Symbol(CircuitSym.ASSIGNMENTOP);}
">="            {return new Symbol(CircuitSym.GREATEREQUALSOP);}
"="            {return new Symbol(CircuitSym.EQUALSOP);}
"<"            {return new Symbol(CircuitSym.LESSOP);}
">"            {return new Symbol(CircuitSym.GREATEROP);}

/*Separatori*/
"("             {return new Symbol(CircuitSym.LRBRACKET);}
")"             {return new Symbol(CircuitSym.RRBRACKET);}
"{"             {return new Symbol(CircuitSym.LBRACKET);}
"}"             {return new Symbol(CircuitSym.RBRACKET);}
"["             {return new Symbol(CircuitSym.LSBRACKET);}
"]"             {return new Symbol(CircuitSym.RSBRACKET);}
","             {return new Symbol(CircuitSym.COMMA);}
";"             {return new Symbol(CircuitSym.SEMICOMMA);}


/*operatori aritmetici*/
"++"             {return new Symbol(CircuitSym.INCREASE);}
"--"             {return new Symbol(CircuitSym.DECREASE);}
"+"             {return new Symbol(CircuitSym.ADDITION);}
"-"             {return new Symbol(CircuitSym.SUBTRACTION);}

"*"             {return new Symbol(CircuitSym.MULTIPLICATION);}
"/"             {return new Symbol(CircuitSym.DIVISION);}
"%"             {return new Symbol(CircuitSym.MODULE);}
"\(!=\)"             {return new Symbol(CircuitSym.NOT_EQUALS);}
"!"             {return new Symbol(CircuitSym.NOT);}





[^]			{ return new Symbol(CircuitSym.ERROR,yytext());}
<<EOF>> {return new Symbol(CircuitSym.EOF);}


//<STRING>{

//\"          {yybegin(YYINITIAL);
  //          return new Symbol(CircuitSym.STRING_LITERAL,string.toString());}

/*[^\n\r\"\\]+    {string.append(yytext());}
\\t             {string.append('\t');}
\\n             {string.append('\n');}
\\r             {string.append('\r');}
\\              {string.append('\\');}

}*/
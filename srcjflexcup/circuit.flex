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
%cupsym CircuitSym
%cup 									// Declare that we expect to use Java CUP
%line
%column                                 //servono per sapere la posizione linea e colonna yyline e yycoulomn


%{

    private StringBuffer string= new StringBuffer();
    private static HashMap<String,Symbol> stringTable=new HashMap<String,Symbol>();

    private Symbol symbol(int type){
        return new Symbol(type, yyline,yycolumn);
    }

    private Symbol symbol(int type, Object value){
        return new Symbol(type, yyline, yycolumn, value);
    }

    private Symbol installID(String str){
        Symbol symbol;
        if(stringTable.containsKey(str)){
            return symbol(CircuitSym.ID,stringTable.get(str).toString());
        }
        else {
            symbol=new Symbol(CircuitSym.ID,str.toString());
            stringTable.put(str,symbol);
            return symbol;
        }
    }

    private Symbol intNum(String str){
        Symbol symbol;
        symbol=new Symbol(CircuitSym.INTNUM,str.toString());
        return symbol;
    }

    private Symbol decNUM(String str){
            Symbol symbol;
            symbol=new Symbol(CircuitSym.DECNUM,str.toString());
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
            }
%}




										// Abbreviations for regular expressions
delimitator=[\n|\r|\t|' ']
letter=([a-z]|[A-Z])
letter_=(letter)|(_)
digit=[0-9]
digits=(digit)|([1-9][0-9]*)
integer=0|([1-9][0-9]*)
identifier= letter_((letter_)|(digit))*
decimal= integer.([0-9]*)
/*Comments*/
TraditionlComment="#"
CommentLines="/*"[^*]("*/")| "/*""*"+"/"
Comment= {TraditionlComment} | {CommentLines}

%state STRING

%%
<YYINITIAL>{
										// Now for the actual tokens and assocated actions
"if" 		{ return  symbol(CircuitSym.IF); }
"else"      {return  symbol(CircuitSym.ELSE);}
"while"      {return  symbol(CircuitSym.WHILE);}
"for"      {return  symbol(CircuitSym.FOR);}
"int"      {return  symbol(CircuitSym.INT);}
"float"      {return  symbol(CircuitSym.FLOAT);}
"bool"      {return  symbol(CircuitSym.BOOL);}
"else"      {return  symbol(CircuitSym.ELSE);}
"return"      {return  symbol(CircuitSym.RETURN);}
"main"      {return  symbol(CircuitSym.MAIN);}
"true"      {return  symbol(CircuitSym.TRUE);}
"false"      {return  symbol(CircuitSym.FALSE);}
"then"      {return  symbol(CircuitSym.THEN);}
"continue"      {return  symbol(CircuitSym.CONTINUE);}
"string"      {return  symbol(CircuitSym.STRING);}

{delimitator} { /* ignore */ }
{Comment}       {/*ignore*/}
\"             {string.setLength(0); yybegin(STRING);}

/*operator*/
"<"            {return symbol(CircuitSym.LESSOP);}
"<="             {return symbol(CircuitSym.LESSEQUALSOP);}
"<>"            {return symbol(CircuitSym.NOTEQUALSOP);}
"<-"            {return symbol(CircuitSym.ASSIGNMENTOP);}
">"            {return symbol(CircuitSym.GREATEROP);}
">="            {return symbol(CircuitSym.GREATEREQUALSOP);}
"="            {return symbol(CircuitSym.EQUALSOP);}

/*Separatori*/
"("             {return symbol(CircuitSym.LRBRACKET);}
")"             {return symbol(CircuitSym.RRBRACKET);}
"{"             {return symbol(CircuitSym.LBRACKET);}
"}"             {return symbol(CircuitSym.RBRACKET);}
"["             {return symbol(CircuitSym.LSBRACKET);}
"]"             {return symbol(CircuitSym.RSBRACKET);}
","             {return symbol(CircuitSym.COMMA);}
";"             {return symbol(CircuitSym.SEMICOMMA);}


{identifier}    { return installID(yytext()); }

{integer}       {return intNum(yytext()); }
{decimal}       {return decNUM(yytext());}


/*operatori aritmetici*/
"+"             {return symbol(CircuitSym.ADDITION);}
"-"             {return symbol(CircuitSym.SUBTRACTION);}
"++"             {return symbol(CircuitSym.INCREASE);}
"--"             {return symbol(CircuitSym.DECREASE);}
"*"             {return symbol(CircuitSym.MULTIPLICATION);}
"/"             {return symbol(CircuitSym.DIVISION);}
"%"             {return symbol(CircuitSym.MODULE);}
"!"             {return symbol(CircuitSym.NOT);}
"!="             {return symbol(CircuitSym.NOT_EQUALS);}


<STRING>{

\"          {yybegin(YYINITIAL);
            return symbol(CircuitSym.STRING_LITERAL,string.toString());}
[^\n\r\"\\]+    {string.append(yytext());}
\\t             {string.append('\t');}
\\n             {string.append('\n');}
\\r             {string.append('\r');}
\"              {string.append('\"');}
\\              {string.append('\\');}

}

<<EOF>> {return symbol(CircuitSym.EOF);}
[^]			{ return symbol(CircuitSym.ERROR,"<"+yytext()+">");}
}
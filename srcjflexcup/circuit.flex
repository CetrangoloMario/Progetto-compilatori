// toy.lex
//
// Description of lexer for circuit description language.
//
// Ian
/*
* This class is a simple example lexer
*/
import java_cup.runtime.Symbol;//This is how we pass tokens to the parser
import java.io.*;
import java.util.HashMap;
import java.util.Map;

%%

										// Declarations for JFlex

%unicode 								// We wish to read text files

%cupsym sym
%cup
 									// Declare that we expect to use Java CUP
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
float = {integer}((\.({digit}+)))
integer = (0)|([1-9]{digit}*)
identifier={letter_}({letter_}|{digit})*
decimal= {integer}((\.({digit}+))?)

//%state STRING

%state STRING_CONST
%state COMMENT
%state LINECOMMENT

%%
<YYINITIAL>{
							// Now for the actual tokens and assocated actions
"int"   {return new Symbol(sym.INT);}
"string"   {return new Symbol(sym.STRING);}
"float"   {return new Symbol(sym.FLOAT);}
"bool"   {return new Symbol(sym.BOOL);}
"proc"   {return new Symbol(sym.PROC);}
"corp"   {return new Symbol(sym.CORP);}
"void"   {return new Symbol(sym.VOID);}
"if"   {return new Symbol(sym.IF);}
"then"   {return new Symbol(sym.THEN);}
"elif"   {return new Symbol(sym.ELIF);}
"fi"   {return new Symbol(sym.FI);}
"else"   {return new Symbol(sym.ELSE);}
"while"   {return new Symbol(sym.WHILE);}
"do"   {return new Symbol(sym.DO);}
"od"   {return new Symbol(sym.OD);}
"readln"   {return new Symbol(sym.READ);}
"write"   {return new Symbol(sym.WRITE);}
"true"   {return new Symbol(sym.TRUE);}
"false"   {return new Symbol(sym.FALSE);}

"null"   {return new Symbol(sym.NULL);}






{delimitator} { /* ignore */ }
//\"             {string.setLength(0); yybegin(STRING);}
/* states */
	\" { string.setLength(0); yybegin(STRING_CONST); }
	\/\* { string.setLength(0); yybegin(COMMENT); }
	\/\/ { string.setLength(0); yybegin(LINECOMMENT); }

{identifier} { return new Symbol(sym.ID,yytext()); }
{integer}   {return new Symbol(sym.INT_CONST,yytext());}
{float} 	{ return new Symbol(sym.FLOAT_CONST,yytext()); }


"<="   {return new Symbol(sym.LE);}
"<>"   {return new Symbol(sym.NE);}
">="   {return new Symbol(sym.GE);}
"="   {return new Symbol(sym.EQ);}

"<"   {return new Symbol(sym.LT);}
">"   {return new Symbol(sym.GT);}

"&&"   {return new Symbol(sym.AND);}
"||"   {return new Symbol(sym.OR);}
"!"   {return new Symbol(sym.NOT);}
"->"   {return new Symbol(sym.RETURN);}

";"     {return new Symbol(sym.SEMI);}
","     {return new Symbol(sym.COMMA);}
"("   {return new Symbol(sym.LPAR);}
")"   {return new Symbol(sym.RPAR);}
":="   {return new Symbol(sym.ASSIGN);}
":"   {return new Symbol(sym.COLON);}

"+"   {return new Symbol(sym.PLUS);}
"-"   {return new Symbol(sym.MINUS);}
"*"   {return new Symbol(sym.TIMES);}
"/"   {return new Symbol(sym.DIV);}


[^]			{ return new Symbol(sym.error,yytext());}
<<EOF>> {return new Symbol(sym.EOF);}

}


    /*Stringhe*/

    <STRING> {

        \"                         { yybegin(YYINITIAL);
                                   return new Symbol(sym.STRING_CONST,string.toString());}

        [^\n\r\"\\]+               { string.append( yytext() ); }
        \\t                        { string.append('\t'); }
        \\n                        { string.append('\n'); }
        \\r                        { string.append('\r'); }
        \\\"                       { string.append('\"'); }
        \\                         { string.append('\\'); }
        <<EOF>> {System.err.println("Stringa costante non completata");
                    return Symbol(sym.EOF);}


    }

     /*Commenti*/

    <COMMENT> {

            \*\/		{ ;
            			  yybegin(YYINITIAL);
            			}

            [^]+               {string.append(yytext());}
            <<EOF>> {System.err.println("Commento non chiuso");}


        }
<LINECOMMENT>{

	<<EOF>>	{ yybegin(YYINITIAL);
			 }
	\n	{;
		 yybegin(YYINITIAL);
		 }
	[^\n]	{ /* ignore */ }

}



//<STRING>{

//\"          {yybegin(YYINITIAL);
  //          return new Symbol(CircuitSym.STRING_LITERAL,string.toString());}

/*[^\n\r\"\\]+    {string.append(yytext());}
\\t             {string.append('\t');}
\\n             {string.append('\n');}
\\r             {string.append('\r');}
\\              {string.append('\\');}

}*/
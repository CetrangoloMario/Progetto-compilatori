
import java_cup.runtime.Symbol;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Classe tester
 *C:\JFLEX\bin\jflex -d src srcjflexcup\circuit.flex
 */

public class Tester {

    public static void main (String [] args) throws IOException {

        FileReader inFile=new FileReader(args[0]);
        Yylex lexer=new Yylex(inFile);

        Symbol token= lexer.next_token();
        while (token.sym!= CircuitSym.EOF){
            switch (token.sym){
                case CircuitSym.ADDITION:
                    System.out.println("ADDITIoN ("
                    + (token.value)
                    +")");
                    break;
                    //...
            }
            token=lexer.next_token();
        }
    }
}

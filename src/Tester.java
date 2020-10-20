
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

        Symbol symbol= lexer.next_token();
        while (symbol.sym!= CircuitSym.EOF){
            switch (symbol.sym){

                case CircuitSym.IF:
                    System.out.println("IF");
                    break;
                case CircuitSym.ELSE:
                    System.out.println("ELSE");
                    break;
                case CircuitSym.WHILE:
                    System.out.println("WHILE");
                    break;
                case CircuitSym.FOR:
                    System.out.println("FOR");
                    break;
                case CircuitSym.INT:
                    System.out.println("INT");
                    break;
                case CircuitSym.FLOAT:
                    System.out.println("FLOAT");
                    break;
                case CircuitSym.BOOL:
                    System.out.println("BOOL");
                    break;
                case CircuitSym.RETURN:
                    System.out.println("RETURN");
                    break;
                case CircuitSym.MAIN:
                    System.out.println("MAIN");
                    break;
                case CircuitSym.TRUE:
                    System.out.println("TRUE");
                    break;
                case CircuitSym.FALSE:
                    System.out.println("FALSE");
                    break;
                case CircuitSym.THEN:
                    System.out.println("THEN");
                    break;
                case CircuitSym.CONTINUE:
                    System.out.println("CONTINUE");
                    break;
                case CircuitSym.STRING:
                    System.out.println("STRING");
                    break;

                case CircuitSym.LESSOP:
                    System.out.println("LESSOP");
                    break;
                case CircuitSym.LESSEQUALSOP:
                    System.out.println("LESSEQUALSOP");
                    break;
                case CircuitSym.NOTEQUALSOP:
                    System.out.println("NOTEQUALSOP");
                    break;
                case CircuitSym.ASSIGNMENTOP:
                    System.out.println("ASSIGNMENTOP");
                    break;
                case CircuitSym.GREATEROP:
                    System.out.println("GREATEROP");
                    break;
                case CircuitSym.GREATEREQUALSOP:
                    System.out.println("GREATEREQUALSOP");
                    break;
                case CircuitSym.EQUALSOP:
                    System.out.println("EQUALSOP");
                    break;


                case CircuitSym.LRBRACKET:
                    System.out.println("LRBRACKET");
                    break;
                case CircuitSym.RRBRACKET:
                    System.out.println("RRBRACKET");
                    break;
                case CircuitSym.LBRACKET:
                    System.out.println("LBRACKET");
                    break;
                case CircuitSym.RBRACKET:
                    System.out.println("RBRACKET");
                    break;
                case CircuitSym.LSBRACKET:
                    System.out.println("LSBRACKET");
                    break;
                case CircuitSym.RSBRACKET:
                    System.out.println("RSBRACKET");
                    break;
                case CircuitSym.COMMA:
                    System.out.println("COMMA");
                    break;
                case CircuitSym.SEMICOMMA:
                    System.out.println("SEMICOMMA");
                    break;


                case CircuitSym.ID:
                    System.out.println("(ID , "
                           +(symbol.value).toString()
                            +" )");
                    break;

                case CircuitSym.INTNUM:
                    System.out.println("( INTNUM , "
                            +(symbol.value).toString()
                            +"\" )");
                    break;

                case CircuitSym.DECNUM:
                    System.out.println("( DECNUM , "
                            +(symbol.value).toString()
                            +" )");
                    break;


                case CircuitSym.ADDITION:
                    System.out.println("ADDITION");
                    break;
                case CircuitSym.SUBTRACTION:
                    System.out.println("SUBTRACTION");
                    break;
                case CircuitSym.INCREASE:
                    System.out.println("INCREASE");
                    break;
                case CircuitSym.DECREASE:
                    System.out.println("DECREASE");
                    break;
                case CircuitSym.MULTIPLICATION:
                    System.out.println("MULTIPLICATION");
                    break;
                case CircuitSym.DIVISION:
                    System.out.println("DIVISION");
                    break;
                case CircuitSym.MODULE:
                    System.out.println("MODULE");
                    break;
                case CircuitSym.NOT:
                    System.out.println("NOT");
                    break;
                case CircuitSym.NOT_EQUALS:
                    System.out.println("NOT_EQUALS");
                    break;


                case CircuitSym.EOF:
                    System.out.println("\nEOF, il file di input è finito\n");
                    break;
                case CircuitSym.ERROR:
                    System.out.println("\n ERROR, <"+symbol.value+">\n");
                    break;

                default:
                    System.out.println("\n ERROR, <"+symbol.value+">\n");
                    break;

            }
            symbol=lexer.next_token();
        }
    }
}

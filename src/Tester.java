import java.io.IOException;
import java.util.ArrayList;


public class Tester {

   // private static ArrayList<Token> arraytokens;

    public static void main(String[] args) throws Exception {

        //arraytokens=new ArrayList<Token>();
        String test_path=args[0];
        parseAndPrintSrc(test_path);

        /*for (Token x: arraytokens)
            System.out.println(x);*/
    }

    private static void parseAndPrintSrc(String sourcePath) throws Exception {

        System.out.println("\n\n Printing lexem of "+ sourcePath+": \n");

        Lexer lex=new Lexer();
        RecDesParser parser= new RecDesParser(lex,sourcePath);
        if (parser.run()) {

            //System.out.println("Token EOF fine file");
            System.out.println("Tutto OK");

            parser.printDerivation();

        }
        else System.out.println("Errore");

    }

}

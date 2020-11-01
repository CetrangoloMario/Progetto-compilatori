import java.io.IOException;
import java.util.ArrayList;

public class Tester {

    private static ArrayList<Token> arraytokens;

    public static void main(String[] args) throws Exception {

        arraytokens=new ArrayList<Token>();
        String test_path=args[0];
        parseAndPrintSrc(test_path);

        /*for (Token x: arraytokens)
            System.out.println(x);*/
    }

    private static void parseAndPrintSrc(String sourcePath) throws Exception {

        System.out.println("\n\n Printing lexem of "+ sourcePath+": \n");

        Lexer lex=new Lexer(sourcePath);
        RecDesParser parser= new RecDesParser(lex);
        lex.printSymbolTable();
        lex.printKeyWordsTable();

        System.out.println("File not found!!");
    }

}

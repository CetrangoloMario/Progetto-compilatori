public class TesterLexer {

    public static void main(String[] args)   {

        String test=args[0];
        try {
            lessicalPrint(test);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //stampa
    private static void lessicalPrint(String source) throws Exception {
        System.out.println("\n\n Printing lexens of " + source + ": ");
        Lexer lex = new Lexer();
        if (lex.initialize(source)) {
            Token res;
            while (!(res = lex.nextToken()).getName().equals("EOF")) {
                System.out.println(res.toString());
            }
            System.out.println("Token EOF fine file");
            lex.printSymbolTable();
            lex.printKeyWordsTable();
        }
        else System.out.println("File not found!!");
    }

}

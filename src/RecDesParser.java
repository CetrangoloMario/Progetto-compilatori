import java.util.ArrayList;

public class RecDesParser {

    public RecDesParser(Lexer lex){
        this.lex=lex;
        this.arraytokens=null;
        this.ptr=0;
    }

    private boolean run() throws Exception {

            while ((res = this.lex.nextToken()).getName().equals("EOF")) {
                arraytokens.add(res);
            }
            if(!arraytokens.isEmpty()) {
            execute(arraytokens);
        }

        return true;
    }

    private void execute(ArrayList<Token> arraytokens) {

    }



    static boolean F(){
        //Check if ptr is ID |NUMBER
        return true

    }


    private Lexer lex;
    private int ptr;
    private ArrayList<Token> arraytokens;
    private Token res;
}

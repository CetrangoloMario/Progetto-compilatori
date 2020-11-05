import java.io.FileInputStream;
import java.util.ArrayList;

public class RecDesParser {

    public RecDesParser(Lexer lex, String sourcePath){
        this.lex=lex;
        this.inputStream=sourcePath;
        this.arraytokens=new ArrayList<>();
        this.globalPointer=0;
        this.forwordPointer=this.globalPointer;
        this.derivation=new ArrayList<>();
        derivation.add("The end");
    }

    public Boolean run() throws Exception {

        if (lex.initialize(inputStream)) {
            Token res;
            while (!(res = lex.nextToken()).getName().equals("EOF")) {
                arraytokens.add(res);
               // System.out.println(res.toString());
            }
            if(!arraytokens.isEmpty()) {
                //for (Token x : arraytokens)
                  //  System.out.println(x.getName());

                this.globalPointer=0;
                return S();
            }
        }

            else{
                System.out.println("File not found !!");
                return false;
            }
            return true;
    }


    //S -> Program Eof
    //se program vede il prossimo token che se fine file restituisce token.
    static Boolean S() throws Exception {
        if(Program()){
            String token=nextToken();
            if (token.equals("EOF")){
                //System.out.println("Token EOF fine file");
                derivation.add("P->Program EOF");
                return true;
            }
        }

        return false;
    }

    // Program -> Stmt Program'
    //verifica se stmt, è verifica poi program'. program'= programPrimo
    static boolean Program() throws Exception{
        if (Stmt()){
            if (ProgramPrimo()){
                derivation.add("Program->Stmt Program'");
                return true;
            }
        }

        return false;
    }

    /*
       Stmt -> IF LRBRACKET Expr RRBRACKET LBRACKET Stmt RBRACKET Else
       Stmt -> WHILE LRBRACKET Expr RRBRACKET LBRACKET Stmt RBRACKET
       Stmt -> DO LBRACKET Stmt RBRACKET WHILE LRBRACKET Expr RRBRACKET SEMICOMMA
       Stmt -> ID ASSIGNAMENTOP Expr SEMICOMMA
    */
    static Boolean Stmt() throws Exception{
        forwordPointer= globalPointer;
        String token=nextToken();

        if (token.equals("IF"))
            return functionIF();
        else if (token.equals("WHILE"))
            return functionWHILE();
        else if (token.equals("DO"))
            return functionDO();
        else if (token.equals("ID"))
            return functionID();

        globalPointer=forwordPointer;
        return false;
    }

    static Boolean functionIF() throws Exception {
        String token=nextToken();
        if (token.equals("LRBRACKET")) {
            if (Expr()) {
                token = nextToken();
                if (token.equals("RRBRACKET")) {
                    token = nextToken();
                    if (token.equals("LBRACKET")) {
                        if (Stmt()) {
                            token = nextToken();
                            if (token.equals("RBRACKET")) {
                                if (Else())
                                    derivation.add("Stmt -> IF LRBRACKET Expr RRBRACKET LBRACKET Stmt RBRACKET Else");
                                    return true;
                            } else {
                                globalPointer = forwordPointer;
                                derivation.add("!! BACKTRACK \n");
                                return false;
                            }
                        } else return false;
                    } else {
                        globalPointer = forwordPointer;
                        derivation.add("!! BACKTRACK \n");
                        return false;
                    }
                } else {
                    globalPointer = forwordPointer;
                    derivation.add("!! BACKTRACK \n");
                    return false;
                }
            } else{
                return false;
            }

        } else {
            globalPointer = forwordPointer;
            derivation.add("!! BACKTRACK \n");
            return false;
        }
    }


    static Boolean functionWHILE() throws Exception{

        String token=nextToken();
        if (token.equals("LRBRACKET")) {
            if (Expr()) {
                token = nextToken();
                if (token.equals("RRBRACKET")) {
                    token = nextToken();
                    if (token.equals("LBRACKET")) {
                        if (Stmt()) {
                            token = nextToken();
                            if (token.equals("RBRACKET")) {
                                derivation.add("Stmt -> WHILE LRBRACKET Expr RRBRACKET LBRACKET Stmt RBRACKET");
                                return true;
                            } else {
                                globalPointer = forwordPointer;
                                derivation.add("!! BACKTRACK \n");
                                return false;
                            }
                        } else return false;
                    } else {
                        globalPointer = forwordPointer;
                        derivation.add("!! BACKTRACK \n");
                        return false;
                    }
                } else {
                    globalPointer = forwordPointer;
                    derivation.add("!! BACKTRACK \n");
                    return false;
                }
            } else {
                return false;
            }
        } else {
            globalPointer = forwordPointer;
            derivation.add("!! BACKTRACK \n");
            return false;
        }

    }

    static Boolean functionDO() throws Exception{
        String token=nextToken();
        if (token.equals("LBRACKET")) {
            if (Stmt()) {
                token = nextToken();
                if (token.equals("RBRACKET")) {
                    token = nextToken();
                    if (token.equals("WHILE")) {
                        token = nextToken();
                        if (token.equals("LRBRACKET")) {
                            if (Expr()) {
                                token = nextToken();
                                if (token.equals("RRBRACKET")) {
                                    token = nextToken();
                                    if (token.equals("SEMICOMMA")) {
                                        derivation.add("Stmt -> DO LBRACKET Stmt RBRACKET WHILE LRBRACKET Expr RRBRACKET SEMICOMMA");
                                        return true;
                                    } else {
                                        globalPointer = forwordPointer;
                                        derivation.add("!! BACKTRACK \n");
                                        return false;
                                    }
                                } else {
                                    globalPointer = forwordPointer;
                                    derivation.add("!! BACKTRACK \n");
                                    return false;
                                }
                            } else {
                                derivation.add("!! BACKTRACK \n");
                                return false;
                            }
                        } else {
                            globalPointer = forwordPointer;
                            derivation.add("!! BACKTRACK \n");
                            return false;
                        }
                    } else {
                        globalPointer = forwordPointer;
                        derivation.add("!! BACKTRACK \n");
                        return false;
                    }
                } else {
                    globalPointer = forwordPointer;
                    derivation.add("!! BACKTRACK \n");
                    return false;
                }
            } else {
                return false;
            }
        } else {
            globalPointer = forwordPointer;
            derivation.add("!! BACKTRACK \n");
            return false;
        }
    }


    static Boolean functionID() throws Exception{
        String token=nextToken();
        if (token.equals("ASSIGNMENTOP")) {
            if (Expr()) {
                token = nextToken();
                if (token.equals("SEMICOMMA")) {
                    derivation.add("Stmt -> ID ASSIGNAMENTOP Expr SEMICOMMA");
                    return true;
                } else {
                    globalPointer = forwordPointer;
                    derivation.add("!! BACKTRACK \n");
                    return false;
                }
            } else {
                return false;
            }
        } else {
            globalPointer = forwordPointer;
            derivation.add("!! BACKTRACK \n");
            return false;
        }
    }

    // Program -> Stmt ProgramPrimo | eps
    static Boolean ProgramPrimo() throws Exception {
        if (Stmt()) {
            if (ProgramPrimo()) {
                derivation.add("Program -> Stmt Program' ");
                return true;
            } else {
                return false;
            }
        } else {
            derivation.add("Program-> eps");
            return true;
        }
    }

    // Relop ->  LESSOP | LESSQEUALSOP | NOTEQUALSOP | GREATEROP | GREATEREQUALSOP | EQUALSOP
    static Boolean Relop() throws Exception {
        forwordPointer = globalPointer;
        String token = nextToken();
        if (token.equals("LESSOP")){
            derivation.add("Relop-> LESSOP");
            return true;
        }
        else if (token.equals("LESSEQUALSOP")){
            derivation.add("Relop-> LESSEQUALSOP");
            return true;
        }
        else if (token.equals("NOTEQUALSOP")){
            derivation.add("Relop-> NOTEQUALSOP");
            return true;
        }
        else if (token.equals("GREATEROP")){
            derivation.add("Relop-> GREATEROP");
            return true;
        }
        else if (token.equals("GREATEREQUALSOP")){
            derivation.add("Relop-> GREATEREQUALSOP");
            return true;
        }
        else if (token.equals("EQUALSOP")){
            derivation.add("Relop-> EQUALSOP");
            return true;
        }
        globalPointer=forwordPointer;
        derivation.add("!! BACKTRACK \n");
        return false;
    }

    // F-> ID | NUMBER
    static Boolean F() throws Exception {
        forwordPointer = globalPointer;
        String token = nextToken();

        if (token.equals("ID")){
            derivation.add("F->ID");
            return true;
        }
        else if (token.equals("NUMBER")){
            derivation.add("F->NUMBER");
            return true;
        }

        globalPointer = forwordPointer;
        derivation.add("!! BACKTRACK \n");
        return false;

    }

    //Expr -> F Expr'
    static Boolean Expr() throws Exception {
        if (F()) {
            if (ExprPrimo()) {
                derivation.add("Expr->F Expr' ");
                return true;
            }
        }
        return false;
    }

    //Expr' -> Relop F Expr' | eps
    static Boolean ExprPrimo() throws Exception {
        if (Relop()) {
            if (F()) {
                if (ExprPrimo()) {
                    derivation.add("Expr'->Relop F Expr' ");
                    return true;
                }
            }
            return false;
        }
        derivation.add("Expr'-> eps ");
        return true;
    }

    // Else -> ELSE LBRACKET Stmt RBRACKET | eps
    static boolean Else() throws Exception {
        forwordPointer = globalPointer;
        String tokenName = nextToken();

        if (tokenName.equals("ELSE")) {
            tokenName = nextToken();
            if (tokenName.equals("LBRACKET")) {
                if (Stmt()) {
                    tokenName = nextToken();
                    if (tokenName.equals("RBRACKET")) {
                        derivation.add("Else -> ELSE LBRACKET Stmt RBRACKET");
                        return true;
                    } else {
                        globalPointer = forwordPointer;
                        derivation.add("!! BACKTRACK \n");
                        return false;
                    }
                } else {

                    return false;
                }
            } else {
                globalPointer = forwordPointer;
                derivation.add("!! BACKTRACK \n");
                return false;
            }
        } else {
            globalPointer = forwordPointer;
            derivation.add("!! BACKTRACK \n");
            return true;
        }
    }


    private static String nextToken() throws Exception{
        String token;
        if (arraytokens.size()>globalPointer){
            token=arraytokens.get(globalPointer).getName();
            globalPointer++;
            System.out.println(token.toString());
            return token;
        }
        return "EOF";
    }

    public void printDerivation(){
        int x=0;
        System.out.println("\nStampa delle derivazioni: \n");
        for (int i=derivation.size()-1; i>=0; i--){
            x++;
            System.out.println(x+")\t"+derivation.get(i));
        }
        System.out.println("\nStampa delle derivazioni finito");
    }

    private static Lexer lex;
    private static int globalPointer;
    private static ArrayList<Token> arraytokens;
    private static Token res;
    private static int forwordPointer;
    private String inputStream;

    private static ArrayList<String> derivation;
}
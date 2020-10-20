/**
 * Interfaccia generata manualmente al posto di CUP.
 */
public interface CircuitSym {

    public static final int EOF=0;
    public static final int MAIN=1;
    public static final int RETURN=2;
    public static final int THEN=3;
    public static final int CONTINUE=4;
    public static final int IF=5;
    public static final int ELSE=6;
    public static final int WHILE=7;
    public static final int FOR=8;
    public static final int INT=9;
    public static final int FLOAT=10;
    public static final int BOOL=11;
    public static final int TRUE=12;
    public static final int FALSE=13;
    public static final int STRING=14;
    public static final int ERROR=15;
    public static final int INTNUM=16;
    public static final int DECNUM=17;
    public static final int ID=18;
    public static final int LRBRACKET=19;
    public static final int RRBRACKET=20;
    public static final int LBRACKET=21;
    public static final int RBRACKET=22;
    public static final int LSBRACKET=23;
    public static final int RSBRACKET=24;
    public static final int COMMA=25;
    public static final int SEMICOMMA=26;
    public static final int LESSOP=27;
    public static final int LESSEQUALSOP=28;
    public static final int NOTEQUALSOP=29;
    public static final int ASSIGNMENTOP=30;
    public static final int GREATEROP=31;
    public static final int GREATEREQUALSOP=32;
    public static final int EQUALSOP=33;
    public static final int ADDITION=34;
    public static final int SUBTRACTION=35;
    public static final int MULTIPLICATION=36;
    public static final int DIVISION=37;
    public static final int MODULE=38;
    public static final int NOT=39;
    public static final int INCREASE=40;
    public static final int DECREASE=41;
    public static final int NOT_EQUALS=42;
    public static final int STRING_LITERAL=43;



    public static final String [] terminalNames=new String []{
            "EOF", "MAIN", "RETURN", "THEN", "CONTINUE", "IF", "ELSE", "WHILE", "FOR", "INT", "FLOAT",
            "BOOL", "TRUE", "FALSE", "STRING", "ERROR", "INTNUM","DECNUM",
            "ID", "LRBRACKET","RRBRACKET","LBRACKET","LSBRACKET","RSBRACKET",
            "COMMA","SEMICOMMA", "LESSOP", "LESSEQUALSOP","NOTEQUALSOP","ASSIGNMENTOP",
            "GREATEROP","GREATEREQUALSOP","EQUALSOP",
            "ADDIION","SUBTRACTION","MULTIPLICATION","DIVISION","MODULE",
            "NOT", "INCREASE", "DECREASE", "NOT_EQUALS", "STRING_LITERAL"
    };
}

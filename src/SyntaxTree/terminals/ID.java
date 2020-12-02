package SyntaxTree.terminals;

import SyntaxTree.nonterminals.ExpressionOP;

public class ID extends ExpressionOP {
    public ID(String id){
        this.child=id;
    }
    static String terminal="ID";
    String child;
}

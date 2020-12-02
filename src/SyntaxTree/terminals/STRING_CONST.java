package SyntaxTree.terminals;
import visitor.Visitor;
import SyntaxTree.nonterminals.ExpressionOP;

public class STRING_CONST extends ExpressionOP {
    STRING_CONST(String c){
        this.child=c;
    }

    Object accept(Visitor v) throws Exception {return v.visit(this);}

    static String terminal="STRING_CONST";
    String child;
}

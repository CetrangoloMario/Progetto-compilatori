package SyntaxTree.terminals;
import visitor.Visitor;
import SyntaxTree.nonterminals.ExpressionOP;

public class TRUE extends ExpressionOP {
    TRUE(){
        this.child=false;
    }

    Object accept(Visitor v) throws Exception {return v.visit(this);}

    static String terminal="TRUE";
    boolean child;
}

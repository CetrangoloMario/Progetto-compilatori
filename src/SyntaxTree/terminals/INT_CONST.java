package SyntaxTree.terminals;
import visitor.Visitor;
import SyntaxTree.nonterminals.ExpressionOP;

public class INT_CONST extends ExpressionOP {
    INT_CONST(int c){
        this.child=c;
    }

    Object accept(Visitor v)  {return v.visit(this);}

    static String terminal="INT_CONST";
    int child;
}

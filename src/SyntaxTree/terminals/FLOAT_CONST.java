package SyntaxTree.terminals;
import visitor.Visitor;
import SyntaxTree.nonterminals.ExpressionOP;

public class FLOAT_CONST extends ExpressionOP {
    FLOAT_CONST(float c){
        this.child=c;
    }

    Object accept(Visitor v)  {return v.visit(this);}

    static String terminal="INT_CONST";
    float child;
}

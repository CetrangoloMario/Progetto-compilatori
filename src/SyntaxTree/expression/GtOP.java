package SyntaxTree.expression;
import SyntaxTree.nonterminals.ExpressionOP;
import visitor.Visitor;

public class GtOP extends ExpressionOP {

    GtOP(ExpressionOP left, ExpressionOP right){
        this.left=left;
        this.right=right;
    }
    Object accept(Visitor v) {return v.visit(this);}
    ExpressionOP left,right;
}

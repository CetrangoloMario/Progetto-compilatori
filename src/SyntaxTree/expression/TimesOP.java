package SyntaxTree.expression;
import SyntaxTree.nonterminals.ExpressionOP;
import visitor.Visitor;

public class TimesOP extends ExpressionOP {

    TimesOP(ExpressionOP left, ExpressionOP right){
        this.left=left;
        this.right=right;
    }
    Object accept(Visitor v) {return v.visit(this);}
    ExpressionOP left,right;
}

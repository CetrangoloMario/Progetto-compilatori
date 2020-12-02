package SyntaxTree.expression;

import SyntaxTree.nonterminals.ExpressionOP;
import visitor.Visitor;

public class PlusOP extends ExpressionOP {

    PlusOP(ExpressionOP left, ExpressionOP right){
        this.left=left;
        this.right=right;
    }
    Object accept(Visitor v) {return v.visit(this);}
    ExpressionOP left,right;
}

package SyntaxTree.expression;

import SyntaxTree.nonterminals.ExpressionOP;
import visitor.Visitor;

public class GeOP extends ExpressionOP {

    GeOP(ExpressionOP left, ExpressionOP right){
        this.left=left;
        this.right=right;
    }
    Object accept(Visitor v) {return v.visit(this);}
    ExpressionOP left,right;
}

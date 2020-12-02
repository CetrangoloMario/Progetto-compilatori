package SyntaxTree.expression;

import SyntaxTree.nonterminals.ExpressionOP;
import visitor.Visitor;

public class NotOP extends ExpressionOP {

    NotOP(ExpressionOP left){
        this.left=left;

    }
    Object accept(Visitor v) {return v.visit(this);}
    ExpressionOP left;
}

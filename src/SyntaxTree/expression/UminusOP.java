package SyntaxTree.expression;

import SyntaxTree.nonterminals.ExpressionOP;
import visitor.Visitor;

public class UminusOP extends ExpressionOP {

    UminusOP(ExpressionOP left){
        this.left=left;

    }
    Object accept(Visitor v) {return v.visit(this);}
    ExpressionOP left;
}

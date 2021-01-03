package nodes.nonterminals;

import nodes.expression.ExpressionOP;
import visitor.Visitor;

public class WhileOP {

    public WhileOP(BodyOP bodyOP1, ExpressionOP expr, BodyOP bodyOP2) {
        this.bodyOP1 = bodyOP1;
        this.bodyOP2 = bodyOP2;
        this.expressionOp = expr;
    }

    public WhileOP(ExpressionOP expressionOp, BodyOP bodyOP1) {
        this.expressionOp = expressionOp;
        this.bodyOP1 = bodyOP1;
    }

    public ExpressionOP getExpressionOp() {
        return expressionOp;
    }

    public void setExpressionOp(ExpressionOP expressionOp) {
        this.expressionOp = expressionOp;
    }

    public BodyOP getBodyOp1() {
        return bodyOP1;
    }

    public void setBodyOp1(BodyOP bodyOP1) {
        this.bodyOP1 = bodyOP1;
    }

    public BodyOP getBodyOp2() {
        return bodyOP2;
    }

    public void setBodyOp2(BodyOP bodyOP2) {
        this.bodyOP2 = bodyOP2;
    }

    public Object accept(Visitor v){
        return v.visit(this);
    }

    ExpressionOP expressionOp;
    BodyOP bodyOP1;
    BodyOP bodyOP2;
}

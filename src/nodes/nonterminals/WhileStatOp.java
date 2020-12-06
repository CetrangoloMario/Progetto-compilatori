package nodes.nonterminals;

import nodes.expression.ExpressionOp;
import visitor.Visitor;

public class WhileStatOp {

    public WhileStatOp(BodyOp bodyOp1, ExpressionOp expr, BodyOp bodyOp2) {
        this.bodyOp1 = bodyOp1;
        this.bodyOp2 = bodyOp2;
        this.expressionOp = expr;
    }

    public WhileStatOp(ExpressionOp expressionOp, BodyOp bodyOp1) {
        this.expressionOp = expressionOp;
        this.bodyOp1 = bodyOp1;
    }

    public ExpressionOp getExpressionOp() {
        return expressionOp;
    }

    public void setExpressionOp(ExpressionOp expressionOp) {
        this.expressionOp = expressionOp;
    }

    public BodyOp getBodyOp1() {
        return bodyOp1;
    }

    public void setBodyOp1(BodyOp bodyOp1) {
        this.bodyOp1 = bodyOp1;
    }

    public BodyOp getBodyOp2() {
        return bodyOp2;
    }

    public void setBodyOp2(BodyOp bodyOp2) {
        this.bodyOp2 = bodyOp2;
    }

    public Object accept(Visitor v){
        return v.visit(this);
    }

    ExpressionOp expressionOp;
    BodyOp bodyOp1;
    BodyOp bodyOp2;
}

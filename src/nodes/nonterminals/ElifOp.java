package nodes.nonterminals;

import nodes.expression.ExpressionOp;
import visitor.Visitor;

public class ElifOp {

    ExpressionOp expr;
    BodyOp body;

    public ElifOp(ExpressionOp expr, BodyOp body) {
        this.expr = expr;
        this.body = body;
    }

    public ExpressionOp getExpr() {
        return expr;
    }

    public void setExpr(ExpressionOp expr) {
        this.expr = expr;
    }

    public BodyOp getBody() {
        return body;
    }

    public void setBody(BodyOp body) {
        this.body = body;
    }

    public Object accept(Visitor v){
        return v.visit(this);
    }
}

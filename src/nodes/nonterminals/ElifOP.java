package nodes.nonterminals;

import nodes.expression.ExpressionOP;
import visitor.Visitor;

public class ElifOP {

    ExpressionOP expr;
    BodyOP body;

    public ElifOP(ExpressionOP expr, BodyOP body) {
        this.expr = expr;
        this.body = body;
    }

    public ExpressionOP getExpr() {
        return expr;
    }

    public void setExpr(ExpressionOP expr) {
        this.expr = expr;
    }

    public BodyOP getBody() {
        return body;
    }

    public void setBody(BodyOP body) {
        this.body = body;
    }

    public Object accept(Visitor v){
        return v.visit(this);
    }
}

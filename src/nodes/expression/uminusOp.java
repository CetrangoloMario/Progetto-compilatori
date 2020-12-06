package nodes.expression;


import visitor.Visitor;

public class uminusOp extends ExpressionOp {

    public uminusOp(ExpressionOp child){
        this.expression = child;
    }

    public Object accept(Visitor v){
        return v.visit(this);
    }

    public ExpressionOp getExpression() {
        return expression;
    }

    public void setExpression(ExpressionOp expression) {
        this.expression = expression;
    }

    ExpressionOp expression;

}

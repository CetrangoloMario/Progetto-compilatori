package nodes.expression;


import visitor.Visitor;

public class UminusOP extends ExpressionOP {

    public UminusOP(ExpressionOP child){
        this.expression = child;
    }

    public Object accept(Visitor v){
        return v.visit(this);
    }

    public ExpressionOP getExpression() {
        return expression;
    }

    public void setExpression(ExpressionOP expression) {
        this.expression = expression;
    }

    ExpressionOP expression;

}

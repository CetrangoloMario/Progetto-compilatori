package nodes.expression;


import visitor.Visitor;

public class NotOP extends ExpressionOP {

    public NotOP(ExpressionOP child){
        this.child = child;
    }

    public Object accept(Visitor v){
        return v.visit(this);
    }

    public ExpressionOP getChild() {
        return child;
    }

    public void setChild(ExpressionOP child) {
        this.child = child;
    }

    ExpressionOP child;

}

package nodes.expression;


import visitor.Visitor;

public class notOp extends ExpressionOp {

    public notOp(ExpressionOp child){
        this.child = child;
    }

    public Object accept(Visitor v){
        return v.visit(this);
    }

    public ExpressionOp getChild() {
        return child;
    }

    public void setChild(ExpressionOp child) {
        this.child = child;
    }

    ExpressionOp child;

}

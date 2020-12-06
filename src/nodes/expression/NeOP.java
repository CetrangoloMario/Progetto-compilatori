package nodes.expression;


import visitor.Visitor;

public class NeOP extends ExpressionOP {

    public NeOP(ExpressionOP left, ExpressionOP right){
        this.left = left;
        this.right = right;
    }

    public Object accept(Visitor v){
        return v.visit(this);
    }

    public ExpressionOP getLeft() {
        return left;
    }

    public void setLeft(ExpressionOP left) {
        this.left = left;
    }

    public ExpressionOP getRight() {
        return right;
    }

    public void setRight(ExpressionOP right) {
        this.right = right;
    }

    ExpressionOP left,right;

}

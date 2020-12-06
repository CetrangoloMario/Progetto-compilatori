package nodes.expression;


import visitor.Visitor;

public class eqOp extends ExpressionOp {

    public eqOp(ExpressionOp left, ExpressionOp right){
        this.left = left;
        this.right = right;
    }

    public Object accept(Visitor v){
        return v.visit(this);
    }

    public ExpressionOp getLeft() {
        return left;
    }

    public void setLeft(ExpressionOp left) {
        this.left = left;
    }

    public ExpressionOp getRight() {
        return right;
    }

    public void setRight(ExpressionOp right) {
        this.right = right;
    }

    ExpressionOp left,right;

}

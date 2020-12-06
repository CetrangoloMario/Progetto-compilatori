package nodes.terminals;


import nodes.expression.ExpressionOp;
import visitor.Visitor;

public class FLOAT_CONST extends ExpressionOp {

    FLOAT_CONST(float child){
        this.child = child;
    }

    public Object accept(Visitor v){
        return v.visit(this);
    }

    static String terminal = "FLOAT_CONST";
    float child;

}

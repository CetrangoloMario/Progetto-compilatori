package nodes.terminals;


import nodes.expression.ExpressionOP;
import visitor.Visitor;

public class FLOAT_CONST extends ExpressionOP {

    FLOAT_CONST(float child){
        this.child = child;
    }

    public Object accept(Visitor v){
        return v.visit(this);
    }

    static String terminal = "FLOAT_CONST";
    float child;

}

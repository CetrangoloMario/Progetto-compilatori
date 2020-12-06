package nodes.terminals;


import nodes.expression.ExpressionOp;
import visitor.Visitor;

public class ID extends ExpressionOp {

    ID(String child){
        this.child = child;
    }

    public Object accept(Visitor v){
        return v.visit(this);
    }

    static String terminal = "FLOAT_CONST";
    String child;

}

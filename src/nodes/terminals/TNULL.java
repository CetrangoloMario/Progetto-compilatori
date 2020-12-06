package nodes.terminals;


import nodes.expression.ExpressionOp;
import visitor.Visitor;

public class TNULL extends ExpressionOp {


    public Object accept(Visitor v){
        return v.visit(this);
    }

    static String terminal = "NULL";

}

package nodes.terminals;


import nodes.expression.ExpressionOp;
import visitor.Visitor;

public class STRING_CONST extends ExpressionOp {

    public Object accept(Visitor v){
        return v.visit(this);
    }

    static String terminal = "STRING_CONST";
    String child;

}

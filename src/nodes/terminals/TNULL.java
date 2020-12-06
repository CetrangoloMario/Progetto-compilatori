package nodes.terminals;


import nodes.expression.ExpressionOP;
import visitor.Visitor;

public class TNULL extends ExpressionOP {


    public Object accept(Visitor v){
        return v.visit(this);
    }

    static String terminal = "NULL";

}

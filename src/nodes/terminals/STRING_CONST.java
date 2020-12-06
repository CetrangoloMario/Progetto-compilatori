package nodes.terminals;


import nodes.expression.ExpressionOP;
import visitor.Visitor;

public class STRING_CONST extends ExpressionOP {

    public Object accept(Visitor v){
        return v.visit(this);
    }

    static String terminal = "STRING_CONST";
    String child;

}

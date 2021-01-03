package nodes.terminals;


import nodes.expression.ExpressionOP;
import visitor.Visitor;

public class INT_CONST extends ExpressionOP {

    INT_CONST(int child){
        this.child = child;
    }

    public Object accept(Visitor v){
        return v.visit(this);
    }

    static String terminal = "INT_CONST";
    int child;

}

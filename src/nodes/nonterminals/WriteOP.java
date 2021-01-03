package nodes.nonterminals;

import nodes.expression.ExpressionOP;
import visitor.Visitor;

import java.util.ArrayList;

public class WriteOP {
    public WriteOP(ArrayList<ExpressionOP> expressionOpList) {
        this.expressionOpList = expressionOpList;
    }

    public ArrayList<ExpressionOP> getExpressionOpList() {
        return expressionOpList;
    }

    public void setExpressionOpList(ArrayList<ExpressionOP> expressionOpList) {
        this.expressionOpList = expressionOpList;
    }

    public Object accept(Visitor v){
        return v.visit(this);
    }

    ArrayList<ExpressionOP> expressionOpList;
}

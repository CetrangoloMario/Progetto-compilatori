package nodes.nonterminals;

import nodes.expression.ExpressionOp;
import visitor.Visitor;

import java.util.ArrayList;

public class WriteStatOp {
    public WriteStatOp(ArrayList<ExpressionOp> expressionOpList) {
        this.expressionOpList = expressionOpList;
    }

    public ArrayList<ExpressionOp> getExpressionOpList() {
        return expressionOpList;
    }

    public void setExpressionOpList(ArrayList<ExpressionOp> expressionOpList) {
        this.expressionOpList = expressionOpList;
    }

    public Object accept(Visitor v){
        return v.visit(this);
    }

    ArrayList<ExpressionOp> expressionOpList;
}

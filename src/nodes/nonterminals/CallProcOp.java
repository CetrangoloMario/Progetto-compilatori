package nodes.nonterminals;

import nodes.expression.ExpressionOp;
import nodes.terminals.Constant;
import visitor.Visitor;

import java.util.ArrayList;

public class CallProcOp extends ExpressionOp {


    Constant id;
    ArrayList<ExpressionOp> exprList;

    public CallProcOp(Constant id) {
        this.id = id;
    }

    public CallProcOp(Constant id, ArrayList<ExpressionOp> exprList) {
        this.id = id;
        this.exprList = exprList;
    }

    public Constant getId() {
        return id;
    }

    public void setId(Constant id) {
        this.id = id;
    }

    public ArrayList<ExpressionOp> getExprList() {
        return exprList;
    }

    public void setExprList(ArrayList<ExpressionOp> exprList) {
        this.exprList = exprList;
    }

    public Object accept(Visitor v){
        return v.visit(this);
    }
}

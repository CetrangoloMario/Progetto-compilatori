package nodes.nonterminals;
import nodes.expression.ExpressionOp;
import nodes.terminals.Constant;
import nodes.terminals.VOID;
import visitor.Visitor;

import java.util.ArrayList;

public class ReturnExprsOp {
    public ReturnExprsOp(Constant voidOp) {
        this.voidOp = voidOp;
    }

    public ReturnExprsOp(ArrayList<ExpressionOp> exprList) {
        this.exprList = exprList;
    }

    public ArrayList<ExpressionOp> getExprList() {
        return exprList;
    }

    public void setExprList(ArrayList<ExpressionOp> exprList) {
        this.exprList = exprList;
    }

    public Constant getVoidOp() {
        return voidOp;
    }

    public void setVoidOp(Constant voidOp) {
        this.voidOp = voidOp;
    }

    public Object accept(Visitor v){
        return v.visit(this);
    }

    ArrayList<ExpressionOp> exprList;
    Constant voidOp;
}

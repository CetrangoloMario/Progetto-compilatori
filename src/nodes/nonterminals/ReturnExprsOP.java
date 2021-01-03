package nodes.nonterminals;
import nodes.expression.ExpressionOP;
import nodes.terminals.Constant;
import visitor.Visitor;

import java.util.ArrayList;

public class ReturnExprsOP {
    public ReturnExprsOP(Constant voidOp) {
        this.voidOp = voidOp;
    }

    public ReturnExprsOP(ArrayList<ExpressionOP> exprList) {
        this.exprList = exprList;
    }

    public ArrayList<ExpressionOP> getExprList() {
        return exprList;
    }

    public void setExprList(ArrayList<ExpressionOP> exprList) {
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

    ArrayList<ExpressionOP> exprList;
    Constant voidOp;
}

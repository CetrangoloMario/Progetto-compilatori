package nodes.nonterminals;

import nodes.expression.ExpressionOP;
import nodes.terminals.Constant;
import visitor.Visitor;

import java.util.ArrayList;

public class CallProcOP extends ExpressionOP {


    Constant id;
    ArrayList<ExpressionOP> exprList;

    public CallProcOP(Constant id) {
        this.id = id;
    }

    public CallProcOP(Constant id, ArrayList<ExpressionOP> exprList) {
        this.id = id;
        this.exprList = exprList;
    }

    public Constant getId() {
        return id;
    }

    public void setId(Constant id) {
        this.id = id;
    }

    public ArrayList<ExpressionOP> getExprList() {
        return exprList;
    }

    public void setExprList(ArrayList<ExpressionOP> exprList) {
        this.exprList = exprList;
    }

    public Object accept(Visitor v){
        return v.visit(this);
    }
}

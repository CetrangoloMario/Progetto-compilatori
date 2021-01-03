package nodes.nonterminals;

import nodes.expression.ExpressionOP;
import visitor.Visitor;

import java.util.ArrayList;

public class IfOP {

    ExpressionOP expr;
    BodyOP body;
    ArrayList<ElifOP> elifList;
    ElseOP elseOp;

    public IfOP(ExpressionOP expr, BodyOP body, ArrayList<ElifOP> elifList, ElseOP elseOp) {
        this.expr = expr;
        this.body = body;
        this.elifList = elifList;
        this.elseOp = elseOp;
    }

    public ExpressionOP getExpr() {
        return expr;
    }

    public void setExpr(ExpressionOP expr) {
        this.expr = expr;
    }

    public BodyOP getBody() {
        return body;
    }

    public void setBody(BodyOP body) {
        this.body = body;
    }

    public ArrayList<ElifOP> getElifList() {
        return elifList;
    }

    public void setElifList(ArrayList<ElifOP> elifList) {
        this.elifList = elifList;
    }

    public ElseOP getElseOp() {
        return elseOp;
    }

    public void setElseOp(ElseOP elseOp) {
        this.elseOp = elseOp;
    }

    public Object accept(Visitor v){
        return v.visit(this);
    }
}

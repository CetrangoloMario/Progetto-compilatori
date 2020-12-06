package nodes.nonterminals;

import nodes.expression.ExpressionOp;
import visitor.Visitor;

import java.util.ArrayList;

public class IfStatOp {

    ExpressionOp expr;
    BodyOp body;
    ArrayList<ElifOp> elifList;
    ElseOp elseOp;

    public IfStatOp(ExpressionOp expr, BodyOp body, ArrayList<ElifOp> elifList, ElseOp elseOp) {
        this.expr = expr;
        this.body = body;
        this.elifList = elifList;
        this.elseOp = elseOp;
    }

    public ExpressionOp getExpr() {
        return expr;
    }

    public void setExpr(ExpressionOp expr) {
        this.expr = expr;
    }

    public BodyOp getBody() {
        return body;
    }

    public void setBody(BodyOp body) {
        this.body = body;
    }

    public ArrayList<ElifOp> getElifList() {
        return elifList;
    }

    public void setElifList(ArrayList<ElifOp> elifList) {
        this.elifList = elifList;
    }

    public ElseOp getElseOp() {
        return elseOp;
    }

    public void setElseOp(ElseOp elseOp) {
        this.elseOp = elseOp;
    }

    public Object accept(Visitor v){
        return v.visit(this);
    }
}

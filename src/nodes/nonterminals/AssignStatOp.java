package nodes.nonterminals;

import nodes.expression.ExpressionOp;
import nodes.terminals.Constant;
import visitor.Visitor;

import java.util.ArrayList;

public class AssignStatOp {

    public AssignStatOp(ArrayList<Constant> idList, ArrayList<ExpressionOp> expressionList) {
        this.idList = idList;
        this.expressionList = expressionList;
    }

    public AssignStatOp(Constant id, ExpressionOp expression) {
        this.id = id;
        this.expression = expression;
    }

    public Constant getId() {
        return id;
    }

    public void setId(Constant id) {
        this.id = id;
    }

    public ExpressionOp getExpression() {
        return expression;
    }

    public void setExpression(ExpressionOp expression) {
        this.expression = expression;
    }

    public ArrayList<Constant> getIdList() {
        return idList;
    }

    public void setIdList(ArrayList<Constant> idList) {
        this.idList = idList;
    }

    public ArrayList<ExpressionOp> getExpressionList() {
        return expressionList;
    }

    public void setExpressionList(ArrayList<ExpressionOp> expressionList) {
        this.expressionList = expressionList;
    }

    public Object accept(Visitor v){
        return v.visit(this);
    }

    Constant id;
    ExpressionOp expression;
    ArrayList<Constant> idList;
    ArrayList<ExpressionOp> expressionList;
}

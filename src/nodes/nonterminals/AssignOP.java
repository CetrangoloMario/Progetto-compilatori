package nodes.nonterminals;

import nodes.expression.ExpressionOP;
import nodes.terminals.Constant;
import visitor.Visitor;

import java.util.ArrayList;

public class AssignOP {

    public AssignOP(ArrayList<Constant> idList, ArrayList<ExpressionOP> expressionList) {
        this.idList = idList;
        this.expressionList = expressionList;
    }

    public AssignOP(Constant id, ExpressionOP expression) {
        this.id = id;
        this.expression = expression;
    }

    public Constant getId() {
        return id;
    }

    public void setId(Constant id) {
        this.id = id;
    }

    public ExpressionOP getExpression() {
        return expression;
    }

    public void setExpression(ExpressionOP expression) {
        this.expression = expression;
    }

    public ArrayList<Constant> getIdList() {
        return idList;
    }

    public void setIdList(ArrayList<Constant> idList) {
        this.idList = idList;
    }

    public ArrayList<ExpressionOP> getExpressionList() {
        return expressionList;
    }

    public void setExpressionList(ArrayList<ExpressionOP> expressionList) {
        this.expressionList = expressionList;
    }

    public Object accept(Visitor v){
        return v.visit(this);
    }

    public Object accept(Visitor v, Boolean bool){
        return v.visit(this, bool);
    }

    Constant id;
    ExpressionOP expression;
    ArrayList<Constant> idList;
    ArrayList<ExpressionOP> expressionList;
}

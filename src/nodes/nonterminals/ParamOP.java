package nodes.nonterminals;

import nodes.expression.ExpressionOP;
import visitor.Visitor;

import java.util.ArrayList;

/*Classe usata lista parametri callprocOP*/
public class ParamOP {


    public ParamOP (ArrayList<ExpressionOP> lista){
        this.expressionList=lista;
    }

    public Object accept(Visitor v){
        return v.visit(this);
    }

    public ArrayList<ExpressionOP> getExpressionList() {
        return expressionList;
    }

    public void setExpressionList(ArrayList<ExpressionOP> expressionList) {
        this.expressionList = expressionList;
    }

    ArrayList<ExpressionOP> expressionList;
}

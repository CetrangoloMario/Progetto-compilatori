package nodes.expression;

//Aggiungere Classe CallProc

import visitor.Visitor;

public class ExpressionOp {

    public Object accept(Visitor v){
        return v.visit(this);
    }

}

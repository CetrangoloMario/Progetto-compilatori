package nodes.expression;

//Aggiungere Classe CallProc

import visitor.Visitor;

public class ExpressionOP {

    public Object accept(Visitor v){
        return v.visit(this);
    }

}

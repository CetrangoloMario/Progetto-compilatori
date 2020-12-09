package nodes.nonterminals;

import nodes.expression.ExpressionOP;
import nodes.terminals.Constant;
import visitor.Visitor;

import java.util.ArrayList;

public class CallProcOP extends ExpressionOP {


    Constant id;
    ParamOP paramOP;

    public CallProcOP(Constant id) {
        this.id = id;
    }

    public CallProcOP(Constant id, ParamOP paramlist) {
        this.id = id;
        this.paramOP = paramlist;
    }

    public Constant getId() {
        return id;
    }

    public void setId(Constant id) {
        this.id = id;
    }

    public ParamOP getParamOP() {
        return paramOP;
    }

    public void setParamOP(ParamOP paramOP) {
        this.paramOP = paramOP;
    }

    public Object accept(Visitor v){
        return v.visit(this);
    }
}

package nodes.nonterminals;

import nodes.terminals.Constant;
import visitor.Visitor;

public class ResultTypeOP {

    public TypeOP getType() {
        return type;
    }


    public ResultTypeOP(TypeOP type) {
        this.type = type;
    }

    public ResultTypeOP(Constant voidOp) {
        this.voidOp = voidOp;
    }



    public void setType(TypeOP type) {
        this.type = type;
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

    TypeOP type;
    Constant voidOp;
}

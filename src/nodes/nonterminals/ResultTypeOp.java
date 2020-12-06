package nodes.nonterminals;

import nodes.terminals.Constant;
import visitor.Visitor;

public class ResultTypeOp {

    public ResultTypeOp(TypeOp type) {
        this.type = type;
    }

    public ResultTypeOp(Constant voidOp) {
        this.voidOp = voidOp;
    }

    public TypeOp getType() {
        return type;
    }

    public void setType(TypeOp type) {
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

    TypeOp type;
    Constant voidOp;
}

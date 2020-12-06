package nodes.nonterminals;

import nodes.terminals.Constant;
import visitor.Visitor;

public class IdInitOp {

    public IdInitOp(Constant id) {
        this.id = id;
    }

    public IdInitOp(AssignStatOp assignament) {
        this.assignament = assignament;
    }

    public Constant getId() {
        return id;
    }

    public void setId(Constant id) {
        this.id = id;
    }

    public AssignStatOp getAssignament() {
        return assignament;
    }

    public void setAssignament(AssignStatOp assignament) {
        this.assignament = assignament;
    }

    public Object accept(Visitor v){
        return v.visit(this);
    }

    Constant id;
    AssignStatOp assignament;
}

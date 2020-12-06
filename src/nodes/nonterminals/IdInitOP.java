package nodes.nonterminals;

import nodes.terminals.Constant;
import visitor.Visitor;

public class IdInitOP {

    public IdInitOP(Constant id) {
        this.id = id;
    }

    public IdInitOP(AssignOP assignament) {
        this.assignament = assignament;
    }

    public Constant getId() {
        return id;
    }

    public void setId(Constant id) {
        this.id = id;
    }

    public AssignOP getAssignament() {
        return assignament;
    }

    public void setAssignament(AssignOP assignament) {
        this.assignament = assignament;
    }

    public Object accept(Visitor v){
        return v.visit(this);
    }

    Constant id;
    AssignOP assignament;
}

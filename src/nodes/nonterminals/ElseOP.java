package nodes.nonterminals;

import visitor.Visitor;

public class ElseOP {

    BodyOP body;

    public ElseOP(BodyOP body) {
        this.body = body;
    }

    public BodyOP getBody() {
        return body;
    }

    public void setBody(BodyOP body) {
        this.body = body;
    }

    public Object accept(Visitor v){
        return v.visit(this);
    }
}

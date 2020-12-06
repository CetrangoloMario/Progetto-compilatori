package nodes.nonterminals;

import visitor.Visitor;

public class ElseOp {

    BodyOp body;

    public ElseOp(BodyOp body) {
        this.body = body;
    }

    public BodyOp getBody() {
        return body;
    }

    public void setBody(BodyOp body) {
        this.body = body;
    }

    public Object accept(Visitor v){
        return v.visit(this);
    }
}

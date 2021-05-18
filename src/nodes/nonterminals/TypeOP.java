package nodes.nonterminals;


import visitor.Visitor;

public class TypeOP {
    public TypeOP(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Object accept(Visitor v){
        return v.visit(this);
    }

    String type;
}
package nodes.nonterminals;

import nodes.terminals.Constant;
import visitor.Visitor;

import java.util.ArrayList;

public class ParDeclOP {


    TypeOP type;
    ArrayList<Constant> idList;

    public ParDeclOP(TypeOP type, ArrayList<Constant> idList) {
        this.type = type;
        this.idList = idList;
    }

    public TypeOP getType() {
        return type;
    }

    public void setType(TypeOP type) {
        this.type = type;
    }

    public ArrayList<Constant> getIdList() {
        return idList;
    }

    public void setIdList(ArrayList<Constant> idList) {
        this.idList = idList;
    }

    public Object accept(Visitor v){
        return v.visit(this);
    }
}

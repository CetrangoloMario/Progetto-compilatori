package nodes.nonterminals;

import visitor.Visitor;

import java.util.ArrayList;

public class VarDeclOP {

    public VarDeclOP(TypeOP type, ArrayList<IdInitOP> idList) {
        this.type = type;
        this.idList = idList;
    }

    public TypeOP getType() {
        return type;
    }

    public void setType(TypeOP type) {
        this.type = type;
    }

    public ArrayList<IdInitOP> getIdList() {
        return idList;
    }

    public void setIdList(ArrayList<IdInitOP> idList) {
        this.idList = idList;
    }

    public Object accept(Visitor v){
        return v.visit(this);
    }

    TypeOP type;
    ArrayList<IdInitOP> idList;



}

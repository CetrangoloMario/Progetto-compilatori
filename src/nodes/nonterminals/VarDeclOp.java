package nodes.nonterminals;

import visitor.Visitor;

import java.util.ArrayList;

public class VarDeclOp {

    public VarDeclOp(TypeOp type, ArrayList<IdInitOp> idList) {
        this.type = type;
        this.idList = idList;
    }

    public TypeOp getType() {
        return type;
    }

    public void setType(TypeOp type) {
        this.type = type;
    }

    public ArrayList<IdInitOp> getIdList() {
        return idList;
    }

    public void setIdList(ArrayList<IdInitOp> idList) {
        this.idList = idList;
    }

    public Object accept(Visitor v){
        return v.visit(this);
    }

    TypeOp type;
    ArrayList<IdInitOp> idList;



}

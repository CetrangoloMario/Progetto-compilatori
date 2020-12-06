package nodes.nonterminals;

import visitor.Visitor;

import java.util.ArrayList;

public class BodyOp {


    ArrayList<StatOp> statList;

    public BodyOp(ArrayList<StatOp> statList) {
        this.statList = statList;
    }

    public ArrayList<StatOp> getStatList() {
        return statList;
    }

    public void setStatList(ArrayList<StatOp> statList) {
        this.statList = statList;
    }

    public Object accept(Visitor v){
        return v.visit(this);
    }
}

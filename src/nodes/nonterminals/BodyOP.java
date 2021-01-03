package nodes.nonterminals;

import visitor.Visitor;

import java.util.ArrayList;

public class BodyOP {


    ArrayList<StatOP> statList;

    public BodyOP(ArrayList<StatOP> statList)
    {
        this.statList = statList;
    }

    public ArrayList<StatOP> getStatList() {
        return statList;
    }

    public void setStatList(ArrayList<StatOP> statList) {
        this.statList = statList;
    }

    public Object accept(Visitor v){
        return v.visit(this);
    }
}

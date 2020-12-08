package nodes.nonterminals;

import nodes.terminals.Constant;
import visitor.Visitor;

import java.util.ArrayList;

public class ReadlnOP {
    public ReadlnOP(ArrayList<Constant> idList) {
        IdList = idList;
    }

    public ArrayList<Constant> getIdList() {
        return IdList;
    }

    public void setIdList(ArrayList<Constant> idList) {
        IdList = idList;
    }



    public Object accept(Visitor v){
        return v.visit(this);
    }

    ArrayList<Constant> IdList;
}

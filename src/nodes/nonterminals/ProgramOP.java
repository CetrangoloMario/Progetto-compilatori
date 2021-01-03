package nodes.nonterminals;

import visitor.Visitor;

import java.util.ArrayList;

public class ProgramOP {

    public ProgramOP(ArrayList<VarDeclOP> varDecList, ArrayList<ProcOP> procList) {
        this.varDecList = varDecList;
        this.procList = procList;
    }

    public ArrayList<VarDeclOP> getVarDecList() {
        return varDecList;
    }

    public void setVarDecList(ArrayList<VarDeclOP> varDecList) {
        this.varDecList = varDecList;
    }

    public ArrayList<ProcOP> getProcList() {
        return procList;
    }

    public void setProcList(ArrayList<ProcOP> procList) {
        this.procList = procList;
    }

    public Object accept(Visitor v){
        return v.visit(this);
    }

    ArrayList<VarDeclOP> varDecList;
    ArrayList<ProcOP> procList;
}

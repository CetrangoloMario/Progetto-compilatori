package nodes.nonterminals;

import visitor.Visitor;

import java.util.ArrayList;

public class ProgramOp {

    public ProgramOp(ArrayList<VarDeclOp> varDecList, ArrayList<ProcOp> procList) {
        this.varDecList = varDecList;
        this.procList = procList;
    }

    public ArrayList<VarDeclOp> getVarDecList() {
        return varDecList;
    }

    public void setVarDecList(ArrayList<VarDeclOp> varDecList) {
        this.varDecList = varDecList;
    }

    public ArrayList<ProcOp> getProcList() {
        return procList;
    }

    public void setProcList(ArrayList<ProcOp> procList) {
        this.procList = procList;
    }

    public Object accept(Visitor v){
        return v.visit(this);
    }

    ArrayList<VarDeclOp> varDecList;
    ArrayList<ProcOp> procList;
}

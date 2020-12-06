package nodes.nonterminals;

import visitor.Visitor;

import java.util.ArrayList;

public class ProcBodyOp {

    ArrayList<VarDeclOp> varDeclList;
    ArrayList<StatOp> statList;
    ReturnExprsOp returnExprs;

    public ProcBodyOp(ArrayList<VarDeclOp> varDeclList, ReturnExprsOp returnExprs) {
        this.varDeclList = varDeclList;
        this.returnExprs = returnExprs;
    }

    public ProcBodyOp(ArrayList<VarDeclOp> varDeclList, ArrayList<StatOp> statList, ReturnExprsOp returnExprs) {
        this.varDeclList = varDeclList;
        this.statList = statList;
        this.returnExprs = returnExprs;
    }

    public ArrayList<VarDeclOp> getVarDeclList() {
        return varDeclList;
    }

    public void setVarDeclList(ArrayList<VarDeclOp> varDeclList) {
        this.varDeclList = varDeclList;
    }

    public ArrayList<StatOp> getStatList() {
        return statList;
    }

    public void setStatList(ArrayList<StatOp> statList) {
        this.statList = statList;
    }

    public ReturnExprsOp getReturnExprs() {
        return returnExprs;
    }

    public void setReturnExprs(ReturnExprsOp returnExprs) {
        this.returnExprs = returnExprs;
    }

    public Object accept(Visitor v){
        return v.visit(this);
    }
}

package nodes.nonterminals;

import visitor.Visitor;

import java.util.ArrayList;

public class ProcBodyOP {

    ArrayList<VarDeclOP> varDeclList;
    ArrayList<StatOP> statList;
    ReturnExprsOP returnExprs;

    public ProcBodyOP(ArrayList<VarDeclOP> varDeclList, ReturnExprsOP returnExprs) {
        this.varDeclList = varDeclList;
        this.returnExprs = returnExprs;
    }

    public ProcBodyOP(ArrayList<VarDeclOP> varDeclList, ArrayList<StatOP> statList, ReturnExprsOP returnExprs) {
        this.varDeclList = varDeclList;
        this.statList = statList;
        this.returnExprs = returnExprs;
    }

    public ArrayList<VarDeclOP> getVarDeclList() {
        return varDeclList;
    }

    public void setVarDeclList(ArrayList<VarDeclOP> varDeclList) {
        this.varDeclList = varDeclList;
    }

    public ArrayList<StatOP> getStatList() {
        return statList;
    }

    public void setStatList(ArrayList<StatOP> statList) {
        this.statList = statList;
    }

    public ReturnExprsOP getReturnExprs() {
        return returnExprs;
    }

    public void setReturnExprs(ReturnExprsOP returnExprs) {
        this.returnExprs = returnExprs;
    }

    public Object accept(Visitor v){
        return v.visit(this);
    }
}

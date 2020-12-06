package nodes.nonterminals;

import nodes.terminals.Constant;
import visitor.Visitor;

import java.util.ArrayList;

public class ProcOp {
    public ProcOp(Constant idOp, ArrayList<ParDeclOp> parDeclList, ArrayList<ResultTypeOp> resultTypeList, ProcBodyOp procBody) {
        this.idOp = idOp;
        this.parDeclList = parDeclList;
        this.resultTypeList = resultTypeList;
        this.procBody = procBody;
    }

    public ProcOp(Constant idOp, ArrayList<ResultTypeOp> resultTypeList, ProcBodyOp procBody) {
        this.idOp = idOp;
        this.resultTypeList = resultTypeList;
        this.procBody = procBody;
    }

    public Constant getIdOp() {
        return idOp;
    }

    public void setIdOp(Constant idOp) {
        this.idOp = idOp;
    }

    public ArrayList<ParDeclOp> getParDeclList() {
        return parDeclList;
    }

    public void setParDeclList(ArrayList<ParDeclOp> parDeclList) {
        this.parDeclList = parDeclList;
    }

    public ArrayList<ResultTypeOp> getResultTypeList() {
        return resultTypeList;
    }

    public void setResultTypeList(ArrayList<ResultTypeOp> resultTypeList) {
        this.resultTypeList = resultTypeList;
    }

    public ProcBodyOp getProcBody() {
        return procBody;
    }

    public void setProcBody(ProcBodyOp procBody) {
        this.procBody = procBody;
    }

    public Object accept(Visitor v){
        return v.visit(this);
    }

    Constant idOp;
    ArrayList<ParDeclOp> parDeclList;
    ArrayList<ResultTypeOp> resultTypeList;
    ProcBodyOp procBody;

}

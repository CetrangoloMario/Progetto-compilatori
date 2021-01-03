package nodes.nonterminals;

import nodes.terminals.Constant;
import visitor.Visitor;

import java.util.ArrayList;

public class ProcOP {
    public ProcOP(Constant idOp, ArrayList<ParDeclOP> parDeclList, ArrayList<ResultTypeOP> resultTypeList, ProcBodyOP procBody) {
        this.idOp = idOp;
        this.parDeclList = parDeclList;
        this.resultTypeList = resultTypeList;
        this.procBody = procBody;
    }

    public ProcOP(Constant idOp, ArrayList<ResultTypeOP> resultTypeList, ProcBodyOP procBody) {
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

    public ArrayList<ParDeclOP> getParDeclList() {
        return parDeclList;
    }

    public void setParDeclList(ArrayList<ParDeclOP> parDeclList) {
        this.parDeclList = parDeclList;
    }

    public ArrayList<ResultTypeOP> getResultTypeList() {
        return resultTypeList;
    }

    public void setResultTypeList(ArrayList<ResultTypeOP> resultTypeList) {
        this.resultTypeList = resultTypeList;
    }

    public ProcBodyOP getProcBody() {
        return procBody;
    }

    public void setProcBody(ProcBodyOP procBody) {
        this.procBody = procBody;
    }

    public Object accept(Visitor v){
        return v.visit(this);
    }

    Constant idOp;
    ArrayList<ParDeclOP> parDeclList;
    ArrayList<ResultTypeOP> resultTypeList;
    ProcBodyOP procBody;

}

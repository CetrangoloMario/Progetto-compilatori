package nodes.nonterminals;

import visitor.Visitor;

public class StatOP {

    public StatOP(IfOP ifOP) {
        this.ifOP = ifOP;
    }

    public StatOP(WhileOP whileOP) {
        this.whileOP = whileOP;
    }

    public StatOP(ReadlnOP readLnOP) {
        this.readLnOP = readLnOP;
    }

    public StatOP(WriteOP writeOP) {
        this.writeOP = writeOP;
    }

    public StatOP(AssignOP assignOP) {
        this.assignOP = assignOP;
    }

    public StatOP(CallProcOP callProcOp) {
        this.callProcOp = callProcOp;
    }

    public IfOP getIfStatOp() {
        return ifOP;
    }

    public void setIfStatOp(IfOP ifOP) {
        this.ifOP = ifOP;
    }

    public WhileOP getWhileStatOp() {
        return whileOP;
    }

    public void setWhileStatOp(WhileOP whileOP) {
        this.whileOP = whileOP;
    }

    public ReadlnOP getReadlnStatOp() {
        return readLnOP;
    }

    public void setReadlnStatOp(ReadlnOP readLnOP) {
        this.readLnOP = readLnOP;
    }

    public WriteOP getWriteStatOp() {
        return writeOP;
    }

    public void setWriteStatOp(WriteOP writeOP) {
        this.writeOP = writeOP;
    }

    public AssignOP getAssignStatOp() {
        return assignOP;
    }

    public void setAssignStatOp(AssignOP assignOP) {
        this.assignOP = assignOP;
    }

    public CallProcOP getCallProcOp() {
        return callProcOp;
    }

    public void setCallProcOp(CallProcOP callProcOp) {
        this.callProcOp = callProcOp;
    }

    public Object accept(Visitor v){
        return v.visit(this);
    }

    IfOP ifOP;
    WhileOP whileOP;
    ReadlnOP readLnOP;
    WriteOP writeOP;
    AssignOP assignOP;
    CallProcOP callProcOp;
}

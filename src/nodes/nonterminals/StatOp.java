package nodes.nonterminals;

import visitor.Visitor;

public class StatOp {

    public StatOp(IfStatOp ifStatOp) {
        this.ifStatOp = ifStatOp;
    }

    public StatOp(WhileStatOp whileStatOp) {
        this.whileStatOp = whileStatOp;
    }

    public StatOp(ReadlnStatOp readlnStatOp) {
        this.readlnStatOp = readlnStatOp;
    }

    public StatOp(WriteStatOp writeStatOp) {
        this.writeStatOp = writeStatOp;
    }

    public StatOp(AssignStatOp assignStatOp) {
        this.assignStatOp = assignStatOp;
    }

    public StatOp(CallProcOp callProcOp) {
        this.callProcOp = callProcOp;
    }

    public IfStatOp getIfStatOp() {
        return ifStatOp;
    }

    public void setIfStatOp(IfStatOp ifStatOp) {
        this.ifStatOp = ifStatOp;
    }

    public WhileStatOp getWhileStatOp() {
        return whileStatOp;
    }

    public void setWhileStatOp(WhileStatOp whileStatOp) {
        this.whileStatOp = whileStatOp;
    }

    public ReadlnStatOp getReadlnStatOp() {
        return readlnStatOp;
    }

    public void setReadlnStatOp(ReadlnStatOp readlnStatOp) {
        this.readlnStatOp = readlnStatOp;
    }

    public WriteStatOp getWriteStatOp() {
        return writeStatOp;
    }

    public void setWriteStatOp(WriteStatOp writeStatOp) {
        this.writeStatOp = writeStatOp;
    }

    public AssignStatOp getAssignStatOp() {
        return assignStatOp;
    }

    public void setAssignStatOp(AssignStatOp assignStatOp) {
        this.assignStatOp = assignStatOp;
    }

    public CallProcOp getCallProcOp() {
        return callProcOp;
    }

    public void setCallProcOp(CallProcOp callProcOp) {
        this.callProcOp = callProcOp;
    }

    public Object accept(Visitor v){
        return v.visit(this);
    }

    IfStatOp ifStatOp;
    WhileStatOp whileStatOp;
    ReadlnStatOp readlnStatOp;
    WriteStatOp writeStatOp;
    AssignStatOp assignStatOp;
    CallProcOp callProcOp;
}

package visitor;

//import SyntaxTree.*;

import nodes.expression.*;
import nodes.nonterminals.*;
import nodes.terminals.Constant;

public interface Visitor {

	public Object visit(ExpressionOP n);

	public Object visit(PlusOP n);
	public Object visit(MinusOP n);
	public Object visit(AndOP n);
	public Object visit(DivOP n);
	public Object visit(TimesOP n);
	public Object visit(EqOP n);
	public Object visit(NeOP n);
	public Object visit(NotOP n);
	//public Object visit(TRUE n);
	//public Object visit(FALSE n);
	//public Object visit(TNULL n);
	//public Object visit(ID n);
	//public Object visit(INT_CONST n);
	//public Object visit(STRING_CONST n);
	//public Object visit(FLOAT_CONST n);
	public Object visit(UminusOP n);
	public Object visit(LeOP n);
	public Object visit(LtOP n);
	public Object visit(GtOP n);
	public Object visit(GeOP n);
	public Object visit(OrOP n);
	public Object visit(Constant n);
	//public Object visit(VOID n);

	public Object visit(AssignOP n, Boolean bool);
	public Object visit(AssignOP n);
	public Object visit(BodyOP n);
	public Object visit(CallProcOP n);
	public Object visit(ElifOP n);
	public Object visit(ElseOP n);
	public Object visit(IdInitOP n);
	public Object visit(IfOP n);
	public Object visit(ParDeclOP n);
	public Object visit(ProcBodyOP n);
	public Object visit(ProcOP n);
	public Object visit(ProgramOP n);
	public Object visit(ReadlnOP n);
	public Object visit(ResultTypeOP n);
	public Object visit(ReturnExprsOP n);
	public Object visit(StatOP n);
	public Object visit(TypeOP n);
	public Object visit(VarDeclOP n);
	public Object visit(WhileOP n);
	public Object visit(WriteOP n);
    public Object visit(ParamOP n);
}
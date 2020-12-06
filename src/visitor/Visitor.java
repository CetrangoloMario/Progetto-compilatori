package visitor;

//import SyntaxTree.*;
import nodes.expression.*;
import nodes.terminals.*;
import nodes.nonterminals.*;

public interface Visitor {

	public Object visit(ExpressionOp n);

	public Object visit(plusOp n);
	public Object visit(minusOp n);
	public Object visit(andOp n);
	public Object visit(divOp n);
	public Object visit(timesOp n);
	public Object visit(eqOp n);
	public Object visit(neOp n);
	public Object visit(notOp n);
	//public Object visit(TRUE n);
	//public Object visit(FALSE n);
	//public Object visit(TNULL n);
	//public Object visit(ID n);
	//public Object visit(INT_CONST n);
	//public Object visit(STRING_CONST n);
	//public Object visit(FLOAT_CONST n);
	public Object visit(uminusOp n);
	public Object visit(leOp n);
	public Object visit(ltOp n);
	public Object visit(gtOp n);
	public Object visit(geOp n);
	public Object visit(orOp n);
	public Object visit(Constant n);
	//public Object visit(VOID n);


	public Object visit(AssignStatOp n);
	public Object visit(BodyOp n);
	public Object visit(CallProcOp n);
	public Object visit(ElifOp n);
	public Object visit(ElseOp n);
	public Object visit(IdInitOp n);
	public Object visit(IfStatOp n);
	public Object visit(ParDeclOp n);
	public Object visit(ProcBodyOp n);
	public Object visit(ProcOp n);
	public Object visit(ProgramOp n);
	public Object visit(ReadlnStatOp n);
	public Object visit(ResultTypeOp n);
	public Object visit(ReturnExprsOp n);
	public Object visit(StatOp n);
	public Object visit(TypeOp n);
	public Object visit(VarDeclOp n);
	public Object visit(WhileStatOp n);
	public Object visit(WriteStatOp n);



}
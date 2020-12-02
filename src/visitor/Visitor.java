package visitor;

import SyntaxTree.terminals.*;
import SyntaxTree.nonterminals.*;
import SyntaxTree.expression.*;

public interface Visitor {

	Object visit(ExpressionOP node);



}
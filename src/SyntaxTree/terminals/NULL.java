package SyntaxTree.terminals;
import visitor.Visitor;
import SyntaxTree.nonterminals.ExpressionOP;

public class NULL extends ExpressionOP {
    NULL(){
          this.child=null;
    }

    Object accept(Visitor v) throws Exception {return v.visit(this);}

    static String terminal="NULL";
    String child;
}

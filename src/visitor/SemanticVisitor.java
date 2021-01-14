package visitor;


import nodes.expression.*;
import nodes.nonterminals.*;
import nodes.terminals.Constant;
import symbolTable.Item;
import symbolTable.TypeEnvironment;
import tableOpType.OpType;

import java.util.ArrayList;

// prende in input AST prodotto dall'analisi sintattica, fa il type checking sui tipi
// crea tabelle dei simboli nel nodo program op e procop.
public class SemanticVisitor implements Visitor{

    public SemanticVisitor (){
        optype= new OpType();
        typeEnvironment=new TypeEnvironment();
    }

    @Override
    public Object visit(ExpressionOP n){
        return null;
    }

    @Override
    public Object visit(PlusOP n) {

        String t1= checkExpression("plusOp", n.getLeft().accept(this));
        String t2= checkExpression("plusOp", n.getRight().accept(this));

        String resultType= optype.checkOpType2("plusOp", t1,t2);

        if (resultType == null) System.err.println("plusOp: mismatch\n t1: "+ t1+ " t2: "+t2+"\n");

        return resultType;
    }

    @Override
    public Object visit(MinusOP n) {
        String t1= checkExpression("minusOp", n.getLeft().accept(this));
        String t2= checkExpression("minusOp", n.getRight().accept(this));

        String resultType= optype.checkOpType2("minusOp", t1,t2);

        if (resultType == null) System.err.println("minusOp: mismatch\n t1: "+ t1+ " t2: "+t2+"\n");

        return resultType;
    }

    @Override
    public Object visit(AndOP n) {
        String t1= checkExpression("andOp", n.getLeft().accept(this));
        String t2= checkExpression("andOp", n.getRight().accept(this));

        String resultType= optype.checkOpType2("andOp", t1,t2);

        if (resultType == null) System.err.println("andOp: mismatch\n t1: "+ t1+ " t2: "+t2+"\n");

        return resultType;
    }

    @Override
    public Object visit(DivOP n) {
        String t1= checkExpression("divOp", n.getLeft().accept(this));
        String t2= checkExpression("divOp", n.getRight().accept(this));

        String resultType= optype.checkOpType2("divOp", t1,t2);

        if (resultType == null) System.err.println("divOp: mismatch\n t1: "+ t1+ " t2: "+t2+"\n");

        return resultType;
    }

    @Override
    public Object visit(TimesOP n) {
        String t1= checkExpression("timesOp", n.getLeft().accept(this));
        String t2= checkExpression("timesOp", n.getRight().accept(this));

        String resultType= optype.checkOpType2("timesOp", t1,t2);

        if (resultType == null) System.err.println("timesOp: mismatch\n t1: "+ t1+ " t2: "+t2+"\n");

        return resultType;
    }

    @Override
    public Object visit(EqOP n) {
        String t1= checkExpression("eqOp", n.getLeft().accept(this));
        String t2= checkExpression("eqOp", n.getRight().accept(this));

        String resultType= optype.checkOpType2("eqOp", t1,t2);

        if (resultType == null) System.err.println("eqOp: mismatch\n t1: "+ t1+ " t2: "+t2+"\n");

        return resultType;
    }

    @Override
    public Object visit(NeOP n) {
        String t1= checkExpression("neOp", n.getLeft().accept(this));
        String t2= checkExpression("neOp", n.getRight().accept(this));

        String resultType= optype.checkOpType2("neOp", t1,t2);

        if (resultType == null) System.err.println("neOp: mismatch\n t1: "+ t1+ " t2: "+t2+"\n");

        return resultType;
    }

    @Override
    public Object visit(NotOP n) {

        String t= checkExpression("notOp", n.getChild().accept(this));

        String resultType=optype.checkOpType1("notOp", t);

        if (resultType == null) System.err.println("not Op: mismatch\n type: "+t+"\n");

        return resultType;
    }

    @Override
    public Object visit(UminusOP n) {

        String t= checkExpression("uminusOp", n.getExpression().accept(this));

        String resultType=optype.checkOpType1("uminusOp", t);

        if (resultType == null) System.err.println("uminusOp: mismatch\n type: "+t+"\n");

        return resultType;
    }

    @Override
    public Object visit(LeOP n) {
        String t1= checkExpression("leOp", n.getLeft().accept(this));
        String t2= checkExpression("leOp", n.getRight().accept(this));

        String resultType= optype.checkOpType2("leOp", t1, t2);

        if (resultType==null) System.err.println("leOp: mismatch\n t1: "+t1+ "t2: "+ t2);

        return resultType;
    }

    @Override
    public Object visit(LtOP n) {
        String t1= checkExpression("ltOp", n.getLeft().accept(this));
        String t2= checkExpression("ltOp", n.getRight().accept(this));

        String resultType = optype.checkOpType2("ltOp", t1, t2);

        if (resultType==null) System.err.println("ltOp: mismatch\n t1:"+t1+ " t2: "+t2+"\n");

        return resultType;
    }

    @Override
    public Object visit(GtOP n) {
        String t1= checkExpression("gtOp", n.getLeft().accept(this));
        String t2= checkExpression("gtOp", n.getRight().accept(this));

        String resultType = optype.checkOpType2("gtOp", t1, t2);

        if (resultType==null) System.err.println("gtOp: mismatch\n t1:"+t1+ " t2: "+t2+"\n");

        return resultType;
    }

    @Override
    public Object visit(GeOP n) {

        String t1= checkExpression("geOp", n.getLeft().accept(this));
        String t2= checkExpression("geOp", n.getRight().accept(this));

        String resultType = optype.checkOpType2("geOp", t1, t2);

        if (resultType==null){
            System.err.println("geOp: mismatch\n t1:"+t1+ " t2: "+t2+"\n");
            System.exit(1);
        }

        return resultType;

    }

    @Override
    public Object visit(OrOP n) {

        String t1= checkExpression("orOp", n.getLeft().accept(this));
        String t2= checkExpression("orOp", n.getRight().accept(this));

        String resultType = optype.checkOpType2("orOp", t1, t2);

        if (resultType==null) {
            System.err.println("orOp: mismatch\n t1:"+t1+ " t2: "+t2+"\n");
            System.exit(1);
        }

        return resultType;
    }

    @Override
    public Object visit(Constant n) {

        String textElement = "(" +n.getName();
        if(n.getValue()!=null) {
            textElement = textElement + ", "+ n.getValue();
        }
        textElement = textElement+ ")";

        //se ID controllo se c'è nel type enviroment
        if (n.getName()=="ID"){
            Item i = typeEnvironment.lookup( n.getValue());

            if(i==null) {
                System.err.println(n.getValue() + " ID non trovato");
                System.exit(1);
            }

            if(i.getCostrutto()=="proc"){
                String sign= i.getTipo();
                String [] val= sign.split("->");
                String [] vals= val[1].trim().split(" ");

                return i.getTipo();
            }

            return i.getTipo();
        }

        return n.getName();
    }

    @Override
    public Object visit(AssignOP n) {
        return null;
    }

    @Override
    public Object visit(BodyOP n) {
        return null;
    }

    @Override
    public Object visit(CallProcOP n) {
        return null;
    }

    @Override
    public Object visit(ElifOP n) {
        return null;
    }

    @Override
    public Object visit(ElseOP n) {
        return null;
    }

    @Override
    public Object visit(IdInitOP n) {
        return null;
    }

    @Override
    public Object visit(IfOP n) {
        return null;
    }

    @Override
    public Object visit(ParDeclOP n) {
        return null;
    }

    @Override
    public Object visit(ProcBodyOP n) {
        return null;
    }

    @Override
    public Object visit(ProcOP n) {
        return null;
    }

    @Override
    public Object visit(ProgramOP n) {
        return null;
    }

    @Override
    public Object visit(ReadlnOP n) {
        return null;
    }

    @Override
    public Object visit(ResultTypeOP n) {
        return null;
    }

    @Override
    public Object visit(ReturnExprsOP n) {
        return null;
    }

    @Override
    public Object visit(StatOP n) {
        return null;
    }

    @Override
    public Object visit(TypeOP n) {
        return null;
    }

    @Override
    public Object visit(VarDeclOP n) {
        return null;
    }

    @Override
    public Object visit(WhileOP n) {
        return null;
    }

    @Override
    public Object visit(WriteOP n) {
        return null;
    }

    @Override
    public Object visit(ParamOP n) {
        return null;
    }


    public TypeEnvironment executeVisit(ProgramOP radice){
        radice.accept(this);
        return typeEnvironment;
    }

    /*
    controlla che sia solo un elemento e lo restituisce, controlla se un array o singlo oggetto.
     */
    private String checkExpression(String name, Object o){
        String t="";

        if(o.getClass().getSimpleName().equals("ArrayList")) {
            ArrayList<String> e = (ArrayList<String>) o;

            if (e.size() != 1) {
                System.err.println(name + " : non può essere usata funzione in un espressione che ritorna void o più di un parametro");
                System.exit(1);
            } else {
                t = e.get(0);
            }
        }
        else {
            t= (String) o;
        }
        return t;
    }


    private OpType optype;
    TypeEnvironment typeEnvironment;

}

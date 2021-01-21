package visitor;

import nodes.expression.*;
import nodes.nonterminals.*;
import nodes.terminals.Constant;
import symbolTable.TypeEnvironment;
import tableOpType.OpType;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

public class CToyVisitor implements Visitor{

    private String nomeFile;
    private FileWriter fw;
    /*per printf e scanf*/
    private Boolean dontWrite;
    private String tempToWrite;

    /*per dichiarare i puntatori*/
    private String header;
    private ArrayList<String> tempReturnParam;


    private String toWrite;
    private OpType optype;
    TypeEnvironment typeEnvironment;

    public CToyVisitor(String nomeFile){

        optype= new OpType();
        tempToWrite="";
        dontWrite=false;
        tempReturnParam=new ArrayList<>();

        toWrite="";
        this.nomeFile=nomeFile;

        try {
            fw= new FileWriter(nomeFile+".c");
        } catch (IOException x){

            System.err.println(" Errore creazione File .c ");
            x.printStackTrace();
        }

    }

    private void organizzaFile (String str){
        if (dontWrite){
            tempToWrite+= str;
        } else {
            toWrite+=str;
        }
    }

    public void scriviFile(){
        try{
            String str= header + toWrite;
            fw.write(str);
        } catch (IOException x){
            System.err.println(" Errore scrittura nel file ");
            x.printStackTrace();
        }
    }




    @Override
    public Object visit(ExpressionOP n) {
        return null;
    }

    @Override
    public Object visit(PlusOP n) {
        String t1= (String) n.getLeft().accept(this);
        organizzaFile(" + ");
        String t2= (String) n.getRight().accept(this);

        return optype.checkOpType2("plusOp", t1, t2);
    }

    @Override
    public Object visit(MinusOP n) {

        String t1= (String) n.getLeft().accept(this);
        organizzaFile(" - ");
        String t2= (String) n.getRight().accept(this);

        return optype.checkOpType2("minusOp", t1, t2);
    }

    @Override
    public Object visit(AndOP n) {

        String t1= (String) n.getLeft().accept(this);
        organizzaFile(" && ");
        String t2= (String) n.getRight().accept(this);

        return optype.checkOpType2("andOp", t1, t2);
    }

    @Override
    public Object visit(DivOP n) {

        String t1= (String) n.getLeft().accept(this);
        organizzaFile(" / ");
        String t2= (String) n.getRight().accept(this);

        return optype.checkOpType2("divOp", t1, t2);
    }

    @Override
    public Object visit(TimesOP n) {

        String t1= (String) n.getLeft().accept(this);
        organizzaFile(" * ");
        String t2= (String) n.getRight().accept(this);

        return optype.checkOpType2("timesOp", t1, t2);
    }

    @Override
    public Object visit(EqOP n) {

        String t1= (String) n.getLeft().accept(this);
        organizzaFile(" == ");
        String t2= (String) n.getRight().accept(this);

        return optype.checkOpType2("eqOp", t1, t2);
    }

    @Override
    public Object visit(NeOP n) {

        String t1= (String) n.getLeft().accept(this);
        organizzaFile(" != ");
        String t2= (String) n.getRight().accept(this);

        return optype.checkOpType2("timesOp", t1, t2);
    }

    @Override
    public Object visit(NotOP n) {

        organizzaFile(" !");
        String t= (String) n.getChild().accept(this);

        return optype.checkOpType1("notOp", t);
    }

    @Override
    public Object visit(UminusOP n) {

        organizzaFile(" -");
        String t= (String) n.getExpression().accept(this);

        return optype.checkOpType1("uminusOp", t);
    }

    @Override
    public Object visit(LeOP n) {

        String t1= (String) n.getLeft().accept(this);
        organizzaFile(" != ");
        String t2= (String) n.getRight().accept(this);

        return optype.checkOpType2("timesOp", t1, t2);
    }

    @Override
    public Object visit(LtOP n) {
        return null;
    }

    @Override
    public Object visit(GtOP n) {
        return null;
    }

    @Override
    public Object visit(GeOP n) {
        return null;
    }

    @Override
    public Object visit(OrOP n) {
        return null;
    }

    @Override
    public Object visit(Constant n) {
        return null;
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
}

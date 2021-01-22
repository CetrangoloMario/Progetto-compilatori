package visitor;

import nodes.expression.*;
import nodes.nonterminals.*;
import nodes.terminals.Constant;
import symbolTable.Item;
import symbolTable.TypeEnvironment;
import tableOpType.OpType;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

public class CToyVisitor implements Visitor{

    private String nomeFile;
    private FileWriter fw;
    /*per printf e scanf*/
    private Boolean dontWrite;
    private String tempToWrite;

    /*per dichiarare i puntatori*/
    private String header_file;
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
            String str= header_file + toWrite;
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
        organizzaFile(" <= ");
        String t2= (String) n.getRight().accept(this);

        return optype.checkOpType2("leOp", t1, t2);
    }

    @Override
    public Object visit(LtOP n) {

        String t1= (String) n.getLeft().accept(this);
        organizzaFile(" < ");
        String t2= (String) n.getRight().accept(this);

        return optype.checkOpType2("ltOp", t1, t2);

    }

    @Override
    public Object visit(GtOP n) {

        String t1= (String) n.getLeft().accept(this);
        organizzaFile(" > ");
        String t2= (String) n.getRight().accept(this);

        return optype.checkOpType2("gtOp", t1, t2);
    }

    @Override
    public Object visit(GeOP n) {

        String t1= (String) n.getLeft().accept(this);
        organizzaFile(" >= ");
        String t2= (String) n.getRight().accept(this);

        return optype.checkOpType2("geOp", t1, t2);
    }

    @Override
    public Object visit(OrOP n) {

        String t1= (String) n.getLeft().accept(this);
        organizzaFile(" || ");
        String t2= (String) n.getRight().accept(this);

        return optype.checkOpType2("orOp", t1, t2);
    }

    @Override
    public Object visit(Constant n) {

        if (n.getValue()!= null) {

            if (n.getName().equals("string")) {
                organizzaFile("\"" + n.getValue() + "\"");
            } else if (n.getName().equals("ID")){
                Item i = typeEnvironment.lookup(n.getValue());
                organizzaFile(""+ n.getValue()+ "");
                return i.getTipo();
            } else {
                organizzaFile(n.getValue());
            }
        } else {
            if (!n.getName().equals("void")){
                organizzaFile(n.getName());
            }
        }
        return n.getName();
    }

    @Override
    public Object visit(AssignOP n) {

        if (n.getIdList()!= null && n.getExpressionList() != null){
            for (int i= 0; i<n.getIdList().size(); i++){
                n.getIdList().get(i).accept(this);
                organizzaFile(" = ");
                n.getExpressionList().get(i).accept(this);
            }
        } else if (n.getId() !=null && n.getExpression() != null){
            n.getId().accept(this);
            organizzaFile(" = ");
            n.getExpression().accept(this);
        }

        return true;
    }

    @Override
    public Object visit(BodyOP n) {
        for (StatOP st: n.getStatList()){
            st.accept(this);
        }
        return true;
    }

    @Override
    public Object visit(CallProcOP n) {

        Item func= typeEnvironment.lookup(n.getId().getValue());
        String sign= func.getTipo();
        String [] param= sign.split("->");
        String [] returnTemp= param[1].trim().split(" ");

        ArrayList<String> returnTipoLista= new ArrayList<>(Arrays.asList(returnTemp));

        while (returnTipoLista.remove("")){
        }

        for ( int i=0; i<returnTipoLista.size(); i++){
            String parametri= returnTipoLista.get(i)+" "+ returnTipoLista.get(i)+"_ret"+i+";\n";

            int j=i;
            while (typeEnvironment.lookup(returnTipoLista.get(i)+ "_ret"+ i)!=null){
                j++;
            }

            typeEnvironment.addId(returnTipoLista.get(i) + "_ret"+i, new Item(returnTipoLista.get(i)+"_ret"+ i, returnTipoLista.get(i), "var"));

            organizzaFile(returnTipoLista.get(i)+ " "+ returnTipoLista.get(i)+"_ret"+ i+":\n");
        }

        n.getId().accept(this);
        organizzaFile(" (");

        if (n.getParamOP()!=null){
            if (n.getParamOP().getExpressionList() != null){

                for (int i=0; i<n.getParamOP().getExpressionList().size(); i++){
                    n.getParamOP().getExpressionList().get(i).accept(this);

                    if (i!= n.getParamOP().getExpressionList().size()-1){
                        organizzaFile(", ");
                    }
                }
            }
        }

        if (returnTipoLista.size()>0){
            if (n.getParamOP()!=null){

                if (n.getParamOP().getExpressionList() != null){
                    organizzaFile(", ");
                }
                for (int i=0; i<returnTipoLista.size(); i++){
                    organizzaFile(" &"+returnTipoLista.get(i)+"_ret"+i);

                    if (i!=returnTipoLista.size()-1){
                        organizzaFile(", ");
                    }
                }
            }
        }
        organizzaFile(")");

        if (returnTipoLista.size() == 1)
            return returnTipoLista.get(0);

        return returnTipoLista;
    }

    @Override
    public Object visit(ElifOP n) {

        organizzaFile("else { if(");
        n.getExpr().accept(this);
        organizzaFile(") {");

        n.getBody().accept(this);
        organizzaFile(" }");

        return true;
    }

    @Override
    public Object visit(ElseOP n) {

        organizzaFile(" else {\n");
        n.getBody().accept(this);
        organizzaFile("\n}\n");

        return true;
    }

    @Override
    public Object visit(IdInitOP n) {

        if (n.getId()!=null ){

            n.getId().accept(this);
        }

        if (n.getAssignament()!= null){
            n.getAssignament().accept(this);
        }

        return true;
    }

    @Override
    public Object visit(IfOP n) {

        organizzaFile("if (");
        n.getExpr().accept(this);
        organizzaFile(") { \n");
        n.getBody().accept(this);
        organizzaFile("\n}\n");

        for (ElifOP el: n.getElifList()){
            el.accept(this);
        }

        if (n.getElseOp() != null)
            n.getElseOp().accept(this);
        //chiudere le parentesi elseif concatenati
        for (int i=0; i<n.getElifList().size(); i++){
            organizzaFile("\n}\n");
        }

        return true;

    }

    @Override
    public Object visit(ParDeclOP n) {

        n.getType().accept(this);
        organizzaFile(" ");

        for (int i=0; i<n.getIdList().size(); i++){
            n.getIdList().get(i).accept(this);

            //se abbiamo più variabili
            if (i!= n.getIdList().size()-1)
                organizzaFile(", ");
        }
        return true;
    }

    @Override
    public Object visit(ProcBodyOP n) {

        for (VarDeclOP vdl: n.getVarDeclList()){
            vdl.accept(this);
        }
        organizzaFile("\n");

        if (n.getStatList()!= null){
            for (StatOP st: n.getStatList()){
                st.accept(this);
            }
        }

        n.getReturnExprs().accept(this);

        return true;
    }

    @Override
    public Object visit(ProcOP n) {

        typeEnvironment.enterScopeClang();

        organizzaFile("\n void ");
        n.getIdOp().accept(this);

        organizzaFile(" (");
        if (n.getParDeclList() != null){

            for (int i=0; i<n.getParDeclList().size(); i++){

                n.getParDeclList().get(i).accept(this);
                if (i!= n.getParDeclList().size()-1)
                    organizzaFile(", ");
            }
        }

        for (int i=0; i<n.getResultTypeList().size(); i++){

            if (n.getParDeclList() != null && i==0){
                if (n.getParDeclList().size()>0){
                    organizzaFile(", ");
                }
            }

            n.getResultTypeList().get(i).accept(this);

            if (n.getResultTypeList().get(i).getVoidOp() == null){
                if (i!= n.getResultTypeList().size()-1){
                    organizzaFile(" *"+ n.getResultTypeList().get(i).getType().getType() + "_par"+ i+ ", ");
                } else {
                    organizzaFile(" *"+n.getResultTypeList().get(i).getType().getType()+ "_par"+ i);
                }
            }
        }

        organizzaFile(")");
        organizzaFile("{\n");
        n.getProcBody().accept(this);
        organizzaFile("\n}\n");

        typeEnvironment.exitScope();
        return true;
    }

    @Override
    public Object visit(ProgramOP n) {
        typeEnvironment.enterScopeClang();

        header_file = "#include <stdio.h>\n";
        header_file += "#include <stdbool.h>\n";
        header_file += "#include <string.h>\n";

        for (VarDeclOP vdl: n.getVarDecList()){
            vdl.accept(this);
        }

        for (ProcOP proc: n.getProcList()){
            proc.accept(this);
        }

        for (String param: tempReturnParam){
            header_file+= param;
        }
        typeEnvironment.exitScope();

        scriviFile();
        try {
            fw.close();
        } catch (IOException exception){
            exception.printStackTrace();
        }

        return true;
    }

    @Override
    public Object visit(ReadlnOP n) {

        tempToWrite="";
        organizzaFile("scanf(\" ");
        dontWrite=true;

        for (Constant c: n.getIdList()){
            organizzaFile(", ");

            if (c.getName().equals("ID")){
                Item i= typeEnvironment.lookup(c.getValue());
                if (!i.getTipo().equals("string"))
                    organizzaFile("&");
            }

            String tipo= (String) c.accept(this);
            dontWrite= false;
            switch (tipo){
                case "bool":
                case "int":
                    organizzaFile("%d");
                    break;
                case "float":
                    organizzaFile("%f");
                    break;
                case "string":
                    organizzaFile("%s");
                    break;
            }

            organizzaFile(" ");
            dontWrite=true;
        }

        dontWrite=false;
        organizzaFile("\""+tempToWrite+");\n");
        tempToWrite="";
        return true;
    }

    @Override
    public Object visit(ResultTypeOP n) {

        if (n.getType()!=null){
            n.getType().accept(this);
        }
        if (n.getVoidOp()!= null){
            n.getVoidOp().accept(this);
        }

        return true;
    }

    @Override
    public Object visit(ReturnExprsOP n) {

        if (n.getExprList()!=null){

            for (int i=0; i<n.getExprList().size(); i++){
                dontWrite=true;
                String tipo=(String) n.getExprList().get(i).accept(this);
                dontWrite=false;
                organizzaFile("*"+tipo+"_par"+i+" = ");
                organizzaFile(tempToWrite);
                organizzaFile(";");
                tempToWrite="";
            }
        } else if (n.getVoidOp()!=null){
            n.getVoidOp().accept(this);
        }

        return true;
    }

    @Override
    public Object visit(StatOP n) {

        if (n.getIfStatOp() != null) {
             n.getIfStatOp().accept(this);
        } else if (n.getWhileStatOp() != null) {
             n.getWhileStatOp().accept(this);
        }else if (n.getReadlnStatOp() != null) {
             n.getReadlnStatOp().accept(this);
        }else if (n.getWriteStatOp() != null) {
             n.getWriteStatOp().accept(this);
        }else if (n.getAssignStatOp() != null) {
             n.getAssignStatOp().accept(this);
             organizzaFile(";\n");
        }else if (n.getCallProcOp() != null) {
             n.getCallProcOp().accept(this);
            organizzaFile(";\n");
        }

        return true;
    }

    @Override
    public Object visit(TypeOP n) {
        organizzaFile(n.getType());
        return true;
    }

    @Override
    public Object visit(VarDeclOP n) {

        n.getType().accept(this);
        organizzaFile(" ");

        for (int i=0; i<n.getIdList().size(); i++){
            n.getIdList().get(i).accept(this);

            if (i!=n.getIdList().size()-1)
                organizzaFile(", ");
        }

        organizzaFile(";\n");
        return true;
    }

    @Override
    public Object visit(WhileOP n) {

        if (n.getBodyOp1()!=null){
            n.getBodyOp1().accept(this);
        }
        organizzaFile("while( ");
        n.getExpressionOp().accept(this);
        organizzaFile(" ){\n");

        if (n.getBodyOp2()!=null){
            n.getBodyOp2().accept(this);
        }
        /*if (n.getBodyOp1()!=null){
            n.getBodyOp1().accept(this);
        }*/

        organizzaFile("\n}\n");
        organizzaFile(tempToWrite);
        return true;
    }

    @Override
    public Object visit(WriteOP n) {

        tempToWrite = "";
        organizzaFile("printf(\" ");
        dontWrite = true;
        for (ExpressionOP e : n.getExpressionOpList()) {
            organizzaFile(", ");
            String tipo = "";
            if (e.getClass().getSimpleName().equals("CallProcOp")) {

            }
            Object o = e.accept(this);
            if (o.getClass().getSimpleName().equals("ArrayList")) {
                ArrayList<String> tipoLista = (ArrayList<String>) o;
                for (int i = 0; i < tipoLista.size(); i++) {
                    dontWrite = false;
                    switch (tipoLista.get(i)) {
                        case "bool":
                        case "int":
                            organizzaFile("%d");
                            break;
                        case "float":
                            organizzaFile("%f");
                            break;
                        case "string":
                            organizzaFile("%s");
                            break;
                    }
                    organizzaFile(" ");
                    dontWrite = true;
                }
            } else {
                tipo = (String) o;
                dontWrite = false;
                switch (tipo) {
                    case "bool":
                    case "int":
                        organizzaFile("%d");
                        break;
                    case "float":
                        organizzaFile("%f");
                        break;
                    case "string":
                        organizzaFile("%s");
                        break;
                }
                organizzaFile(" ");
                dontWrite = true;
            }
        }
        dontWrite = false;
        organizzaFile("\" " + tempToWrite + ");\n");
        tempToWrite = "";
        return true;
    }

    @Override
    public Object visit(ParamOP n) {
        return true;
    }

    public void executeVisit(ProgramOP root, TypeEnvironment typeEnvironment){
        this.typeEnvironment=typeEnvironment;
        typeEnvironment.setIndex(0);
        root.accept(this);
    }
}

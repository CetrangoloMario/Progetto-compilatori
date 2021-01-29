package visitor;

import nodes.expression.*;
import nodes.nonterminals.*;
import nodes.terminals.Constant;
import symbolTable.Item;
import symbolTable.TypeEnvironment;
import tableOpType.OpType;

import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class CToyVisitor implements Visitor{

    private String nomeFile;
    private FileWriter fw;
    /*per printf e scanf*/
    private Boolean dontWrite;//serve per bloccare la scrittura funz nelle read write
    private String tempToWrite;// mantiene temporaneamente prima di scrivere

    /*per dichiarare i puntatori*/
    private String header_file;
    private ArrayList<String> tempReturnParam;


    private String toWrite;
    private OpType optype;
    TypeEnvironment typeEnvironment;

    public CToyVisitor(String nomeFile){//inizializza e crea il file

        optype= new OpType();
        tempToWrite="";
        dontWrite=false;
        tempReturnParam=new ArrayList<>();
        returnIndex=0;
        isMain=false;

        toWrite="";
        this.nomeFile=nomeFile;

        try {
            fw= new FileWriter(nomeFile+".c");
        } catch (IOException x){

            System.err.println(" Errore creazione File .c ");
            x.printStackTrace();
        }

    }

    //serve per concatenare il testo
    private void organizzaFile (String str){
        if (dontWrite){
            tempToWrite+= str;
        } else {
            toWrite+=str;
        }
    }

    //scrive
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

    //
    @Override
    public Object visit(PlusOP n) {
        String t1= (String) n.getLeft().accept(this);
        //System.out.println(t1); restituisce il tipo
        organizzaFile(" + ");
        String t2= (String) n.getRight().accept(this);
        //System.out.println(t2);

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

        dontWrite=true;
        String t1= (String) n.getLeft().accept(this);
        dontWrite=false;

        //per i controlli delle condizioni in caso di stringa si usa la strcmp di c
        if (t1.equalsIgnoreCase("string")){
            organizzaFile("strcmp("+tempToWrite+",");
        }else {
            organizzaFile(tempToWrite+" == ");
        }
        tempToWrite="";

        String t2= (String) n.getRight().accept(this);
        if (t1.equals("string")) organizzaFile(") == 0");
        return optype.checkOpType2("eqOp", t1, t2);
    }

    @Override
    public Object visit(NeOP n) {

        dontWrite=true;
        String t1= (String) n.getLeft().accept(this);
        dontWrite=false;

        //per i controlli delle condizioni in caso di stringa si usa la strcmp di c
        if (t1.equalsIgnoreCase("string"))
            organizzaFile("strcmp("+ tempToWrite+", ");
        else
            organizzaFile(tempToWrite+" != ");

        tempToWrite="";
        String t2= (String) n.getRight().accept(this);
        if (t1.equalsIgnoreCase("string"))
            organizzaFile(") != 0");

        return optype.checkOpType2("neOp", t1, t2);
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
        dontWrite=true;
        String t1= (String) n.getLeft().accept(this);
        dontWrite=false;

        if (t1.equalsIgnoreCase("string"))
            organizzaFile("strcmp("+tempToWrite+",");
        else
            organizzaFile(tempToWrite+" <= ");

        String t2= (String) n.getRight().accept(this);
        if (t1.equalsIgnoreCase("string"))
            organizzaFile(") <=0");
        return optype.checkOpType2("leOp", t1, t2);
    }

    @Override
    public Object visit(LtOP n) {

        dontWrite=true;
        String t1= (String) n.getLeft().accept(this);
        dontWrite=false;

        if (t1.equalsIgnoreCase("string"))
            organizzaFile("strcmp("+tempToWrite+",");
        else
            organizzaFile(tempToWrite+" < ");

        String t2= (String) n.getRight().accept(this);
        if (t1.equalsIgnoreCase("string"))
            organizzaFile(") < 0");

        return optype.checkOpType2("ltOp", t1, t2);

    }

    @Override
    public Object visit(GtOP n) {

        dontWrite=true;
        String t1= (String) n.getLeft().accept(this);
        dontWrite=false;

        if (t1.equalsIgnoreCase("string"))
            organizzaFile("strcmp("+tempToWrite+",");
        else
            organizzaFile(tempToWrite+" > ");

        String t2= (String) n.getRight().accept(this);
        if (t1.equalsIgnoreCase("string"))
            organizzaFile(") >0");

        return optype.checkOpType2("gtOp", t1, t2);
    }

    @Override
    public Object visit(GeOP n) {

        dontWrite=true;
        String t1= (String) n.getLeft().accept(this);
        dontWrite=false;

        if (t1.equalsIgnoreCase("string"))
            organizzaFile("strcmp("+tempToWrite+",");
        else
            organizzaFile(tempToWrite+" >= ");

        String t2= (String) n.getRight().accept(this);
        if (t1.equalsIgnoreCase("string"))
            organizzaFile(") >=");

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

            } else {//se non è una stringa e id
                organizzaFile(n.getValue());
            }
        } else {//Constant NULL
            if (!n.getName().equalsIgnoreCase("void")){
                //System.out.println("se non è void"+n.getName());
                if (!n.getName().equalsIgnoreCase("null"))
                    organizzaFile("\"\\0\"");
                else
                    organizzaFile(n.getName());
            }
        }
        return n.getName();
    }


    @Override
    public Object visit(AssignOP n, Boolean bool){

        ArrayList<String> tempList= new ArrayList<>();

        if (n.getExpressionList()!=null){

            for (ExpressionOP exp: n.getExpressionList()){

                if (exp.getClass().getSimpleName().equalsIgnoreCase("CallProcOP")){

                    CallProcOP clp=(CallProcOP) exp;
                    Item func = typeEnvironment.lookup(clp.getId().getValue());
                    String sign = func.getTipo();

                    String[] param = sign.split("->");
                    String[] returnTemp = param[1].trim().split(" ");

                    ArrayList<String> returnTipoLista = new ArrayList<>(Arrays.asList(returnTemp));
                    while (returnTipoLista.remove("")) {
                    }
                    int sizeReturnLista = returnTipoLista.size();

                    if (sizeReturnLista > 1) {
                        int oldReturnIndice = returnIndex;
                        Object o=exp.accept(this);

                        if (o.getClass().getSimpleName().equalsIgnoreCase("ArrayList")){

                            ArrayList<String> tipoLista=(ArrayList<String>) o;
                            for (int i=0; i<tipoLista.size(); i++){
                                tempList.add(tipoLista.get(i)+ "_return"+ (oldReturnIndice+i));
                            }
                        }
                        organizzaFile(";\n\t");
                    }
                }
            }
        }

        if (n.getIdList()!=null && n.getExpressionList()!=null) {
            int j = 0;
            int returnsize = 0;

            for (int i = 0; i < n.getIdList().size(); i++) {

                n.getIdList().get(i).accept(this);
                organizzaFile("[500] ");
                organizzaFile(" = ");

                if (n.getExpressionList().get(j).getClass().getSimpleName().equalsIgnoreCase("CallProcOp")) {

                    CallProcOP clp = (CallProcOP) n.getExpressionList().get(j);
                    Item func = typeEnvironment.lookup(clp.getId().getValue());
                    String sign = func.getTipo();

                    String[] param = sign.split("->");
                    String[] returnTemp = param[1].trim().split(" ");

                    ArrayList<String> returnTipoLista = new ArrayList<>(Arrays.asList(returnTemp));

                    while (returnTipoLista.remove("")) {
                    }
                    int sizeReturnLista = returnTipoLista.size();

                    if (returnsize < sizeReturnLista) {
                        returnsize++;
                    } else {
                        returnsize = 0;
                        j++;
                    }

                    if (sizeReturnLista>1){
                        String paramNome= tempList.get(i);
                        organizzaFile(paramNome);
                    } else
                        n.getExpressionList().get(i).accept(this);
                } else
                    n.getExpressionList().get(i).accept(this);

                if (n.getIdList().size()-1 > i)
                    organizzaFile(";\n\t");
            }
        } else if (n.getId() != null && n.getExpression() != null){

            n.getId().accept(this);
            organizzaFile("[500] ");
            organizzaFile(" = ");
            n.getExpression().accept(this);
        }

        return true;
    }

    @Override
    public Object visit(AssignOP n) {

        ArrayList<String> tempList= new ArrayList<>();
        Boolean strcpy=false;

        if (n.getExpressionList() != null){

            for (ExpressionOP exp: n.getExpressionList()){

                if (exp.getClass().getSimpleName().equalsIgnoreCase("CallProcOP")){

                    CallProcOP clp=(CallProcOP) exp;
                    Item func = typeEnvironment.lookup(clp.getId().getValue());
                    String sign = func.getTipo();

                    String[] param = sign.split("->");
                    String[] returnTemp = param[1].trim().split(" ");

                    ArrayList<String> returnTipoLista = new ArrayList<>(Arrays.asList(returnTemp));
                    while (returnTipoLista.remove("")) {
                    }
                    int sizeReturnLista = returnTipoLista.size();

                    if (sizeReturnLista > 1) {
                        int oldReturnIndice = returnIndex;
                        Object o=exp.accept(this);

                        if (o.getClass().getSimpleName().equalsIgnoreCase("ArrayList")){

                            ArrayList<String> tipoLista=(ArrayList<String>) o;
                            for (int i=0; i<tipoLista.size(); i++){
                                tempList.add(tipoLista.get(i)+ "_return"+ (oldReturnIndice+i));
                            }
                        }
                        organizzaFile(";\n\t");
                    }
                }
            }
        }

        if (n.getIdList()!=null && n.getExpressionList()!=null) {
            int j = 0;
            int returnsize = 0;
            strcpy = false;

            for (int i = 0; i < n.getIdList().size(); i++) {

                Item item = typeEnvironment.lookup(n.getIdList().get(i).getValue());
                if (item.getTipo().equalsIgnoreCase("string")) {
                    strcpy = true;
                    organizzaFile("strcpy(");
                }

                n.getIdList().get(i).accept(this);
                if (!strcpy)
                    organizzaFile(" = ");
                else
                    organizzaFile(",");

                if (n.getExpressionList().get(j).getClass().getSimpleName().equalsIgnoreCase("CallProcOp")) {

                    CallProcOP clp = (CallProcOP) n.getExpressionList().get(j);
                    Item func = typeEnvironment.lookup(clp.getId().getValue());
                    String sign = func.getTipo();

                    String[] param = sign.split("->");
                    String[] returnTemp = param[1].trim().split(" ");

                    ArrayList<String> returnTipoLista = new ArrayList<>(Arrays.asList(returnTemp));

                    while (returnTipoLista.remove("")) {
                    }
                    int sizeReturnLista = returnTipoLista.size();

                    if (returnsize < sizeReturnLista) {
                        returnsize++;
                    } else {
                        returnsize = 0;
                        j++;
                    }

                    if (sizeReturnLista>1){
                        String paramNome= tempList.get(i);
                        organizzaFile(paramNome);
                    } else
                        n.getExpressionList().get(i).accept(this);
                } else
                    n.getExpressionList().get(i).accept(this);

                if (strcpy)
                    organizzaFile(")\n\t");
                if (n.getIdList().size()-1 > i)
                    organizzaFile(";\n\t");
                strcpy=false;
            }
        } else if (n.getId() != null && n.getExpression() != null){

            Item item = typeEnvironment.lookup(n.getId().getValue());
            if (item.getTipo().equalsIgnoreCase("string")){
                strcpy=true;
                organizzaFile("\tstrcpy(");
            }

            n.getId().accept(this);
            if (!strcpy)
                organizzaFile(" = ");
            else
                organizzaFile(",");

            n.getExpression().accept(this);

            if (strcpy)
                organizzaFile(")");
        }
        /*if (n.getIdList()!= null && n.getExpressionList() != null){

            if (n.getIdList().size()==n.getExpressionList().size()){
                for (int i= 0; i<n.getIdList().size(); i++){

                    organizzaFile("\t");
                    n.getIdList().get(i).accept(this);
              //System.out.println("idList "+n.getIdList().get(i).getName()+" "+n.getIdList().get(i).getValue());
                    organizzaFile(" = ");
                    n.getExpressionList().get(i).accept(this);

                    if (i!=n.getIdList().size()-1)
                        organizzaFile(";\n");

                }
            }
           else{
                //Caso a,b,c:=0;
                int idlistsize=n.getIdList().size();
                int explistsize=n.getExpressionList().size();
                int j=0;
                for (int i=0; i<(idlistsize-explistsize); i++){
                    n.getIdList().get(i);

                    j=i;
                }
                for (int i=j; i<n.getIdList().size(); i++){
                    int ind=0;
                    n.getIdList().get(i).accept(this);
                    //  System.out.println("idList "+n.getIdList().get(i).getName()+" "+n.getIdList().get(i).getValue());
                    organizzaFile(" = ");
                    n.getExpressionList().get(ind).accept(this);
                    ind++;
                }

            }

        } else if (n.getId() !=null && n.getExpression() != null){

            n.getId().accept(this);
            organizzaFile(" = ");
            n.getExpression().accept(this);

        }*/

        return true;
    }

    @Override
    public Object visit(BodyOP n) {
        for (StatOP st: n.getStatList()){
            organizzaFile("\t");
            st.accept(this);
        }
        return true;
    }

    @Override
    public Object visit(CallProcOP n) {

        Item func = typeEnvironment.lookup(n.getId().getValue());
        String sign = func.getTipo();

        String[] param = sign.split("->");
        String[] returnTemp = param[1].trim().split(" ");


/*        System.out.println("param Temp");
        for (String x : param){
            System.out.println(x);
        }*/
        ArrayList<String> returnTipoLista = new ArrayList<>(Arrays.asList(returnTemp));

        //rimuove void a fine lista
        //if (returnTipoLista.get(returnTipoLista.size()-1).equalsIgnoreCase("void"))
        //  returnTipoLista.remove(returnTipoLista.size()-1);

        while (returnTipoLista.remove("")) {
        }
        int oldReturn = 0;

        if (returnTipoLista.size() != 1) {
            oldReturn = returnIndex;

            for (int i = 0; i < returnTipoLista.size(); i++) {
                if (returnTipoLista.get(i).equalsIgnoreCase("string")) {
                    //tempReturnParam.add("\tchar " + returnTipoLista.get(i) + "_return" + returnIndex + "[500];\n");
                    organizzaFile("\n\tchar " + returnTipoLista.get(i) + "_return" + returnIndex + "[500];\n");
                } else {
                    organizzaFile("\n\t"+returnTipoLista.get(i) + " " + returnTipoLista.get(i) + "_return" + returnIndex + ";\n");
                    //tempReturnParam.add(  "\t"+returnTipoLista.get(i) + " *" + returnTipoLista.get(i) + "_return" + returnIndex + ";\n");
                }

                typeEnvironment.addId(returnTipoLista.get(i) + "_return" + returnIndex, new Item(returnTipoLista.get(i) + "_return" + returnIndex, returnTipoLista.get(i), "var"));
                //li scrivo come variabili globali;
                //tempReturnParam.add(  returnTipoLista.get(i) + " *" + returnTipoLista.get(i) + "_return" + returnIndex + ";\n");

                returnIndex++;
            }

        }

        n.getId().accept(this);
        organizzaFile(" (");

        if (n.getParamOP() != null) {
            if (n.getParamOP().getExpressionList() != null) {

                for (int i = 0; i < n.getParamOP().getExpressionList().size(); i++) {

                    if (n.getParamOP().getExpressionList().get(i).getClass().getSimpleName().equalsIgnoreCase("CallProcOP")) {

                        n.getParamOP().getExpressionList().get(i).accept(this);
                        if (i != n.getParamOP().getExpressionList().size() - 1)
                            organizzaFile(", ");
                    }
                    n.getParamOP().getExpressionList().get(i).accept(this);
                    if (i != n.getParamOP().getExpressionList().size() - 1)
                        organizzaFile(", ");
                }
            }
        }

        if (returnTipoLista.size()>1){
            if (n.getParamOP()!=null){
                if (n.getParamOP().getExpressionList() != null){
                    organizzaFile(", ");
                }
            }
            for (int i=0; i<returnTipoLista.size(); i++){
                if (returnTipoLista.get(i).equalsIgnoreCase("string")) {
                    organizzaFile( returnTipoLista.get(i) + "_return" + (oldReturn+i));
                }else {
                    organizzaFile(" &"+returnTipoLista.get(i)+"_return"+(oldReturn+i));
                }

                if (i!=returnTipoLista.size()-1){
                    organizzaFile(", ");
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

        organizzaFile("\n\telse { if(");
        n.getExpr().accept(this);
        organizzaFile(") {\n\t");

        n.getBody().accept(this);
        organizzaFile("\t }\n");

        return true;
    }

    @Override
    public Object visit(ElseOP n) {

        organizzaFile("\t else {\n\t");
        n.getBody().accept(this);
        organizzaFile("\n\t}\n");

        return true;
    }

    @Override
    public Object visit(IdInitOP n) {

        if (n.getId()!=null ){
            n.getId().accept(this);
            Item i=typeEnvironment.lookup(n.getId().getValue());
            if (i.getTipo().equalsIgnoreCase("string")) organizzaFile("[500]");
        }

        if (n.getAssignament()!= null){
            Item i= typeEnvironment.lookup(n.getAssignament().getId().getValue());
            if (i.getTipo().equalsIgnoreCase("string")) {
                n.getAssignament().accept(this, true);
            }
            else {
                n.getAssignament().accept(this);
            }
        }

        return n;
    }

    @Override
    public Object visit(IfOP n) {

        organizzaFile("\n\tif (");
        n.getExpr().accept(this);
        organizzaFile(") { \n\t");
        n.getBody().accept(this);
        organizzaFile("\n\t}\n");


        for (ElifOP el: n.getElifList()){
            el.accept(this);
        }

        if (n.getElseOp() != null)
            n.getElseOp().accept(this);
        //chiudere le parentesi elseif concatenati
        //for (int i=0; i<n.getElifList().size(); i++){
          //  organizzaFile("\n}\n");
        //}

        for (int i=n.getElifList().size(); i>0; i--){
            String str="";
            for (int j=0; j<i; j++){
                str+="\t";
            }
            organizzaFile("\n"+str+"}\n");
        }

        return true;

    }

    @Override
    public Object visit(ParDeclOP n) {
        //parametri all'interno della callproc
        for (int i=0; i<n.getIdList().size(); i++){
            n.getType().accept(this);
            organizzaFile(" ");
            n.getIdList().get(i).accept(this);

            Item it=typeEnvironment.lookup(n.getIdList().get(i).getValue());
            if (it.getTipo().equalsIgnoreCase("string")){
                organizzaFile("[]");
            }
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

        if (!isMain)
            n.getReturnExprs().accept(this);
        isMain=false;
        return true;
    }

    @Override
    public Object visit(ProcOP n) {

        typeEnvironment.enterScopeClang();

        if (n.getIdOp().getValue().equalsIgnoreCase("main")){
            organizzaFile("\n int ");
            isMain = true;
        } else {
            isMain=false;
            if (n.getResultTypeList().size()==1 && n.getResultTypeList().get(0).getType()!=null){
                organizzaFile("\n"+ n.getResultTypeList().get(0).getType().getType()+" ");
            } else if (n.getResultTypeList().size()>=1){
                organizzaFile("\n void");
            }
        }
        //organizzaFile("\n void ");//tutte le fuzioni sono void

        n.getIdOp().accept(this);
        organizzaFile(" (");

        if (n.getParDeclList() != null){

            for (int i=0; i<n.getParDeclList().size(); i++){

                n.getParDeclList().get(i).accept(this);
                if (i!= n.getParDeclList().size()-1)
                    organizzaFile(", ");
            }
        }

        if (!n.getIdOp().getValue().equalsIgnoreCase("main")) {
            if (n.getResultTypeList().size()>1){

                for (int i = 0; i < n.getResultTypeList().size(); i++) {

                    if (n.getParDeclList() != null && i == 0) {
                        if (n.getParDeclList().size() > 0) {
                            organizzaFile(", ");
                        }
                    }
                    //System.out.println(n.getResultTypeList().get(i).accept(this));
                    n.getResultTypeList().get(i).accept(this);

                    //uso dei puntatori per passare il parametro per salvare risultato
                    if (n.getResultTypeList().get(i).getVoidOp() == null) {
                        if (i != n.getResultTypeList().size() - 1) {
                            organizzaFile(" *" + n.getResultTypeList().get(i).getType().getType() + "_parametri" + i + ", ");

                        } else {
                            organizzaFile(" *" + n.getResultTypeList().get(i).getType().getType() + "_pararametri" + i);

                        }
                    }
                }
            }

        }

        organizzaFile(")");
        organizzaFile("{\n\t");
        n.getProcBody().accept(this);
        if (n.getIdOp().getValue().equals("main")) {
            organizzaFile("\n\t return 0;");
        }
        organizzaFile("\n\t}\n");

        typeEnvironment.exitScope();
        return true;
    }

    @Override
    public Object visit(ProgramOP n) {
        typeEnvironment.enterScopeClang();

        header_file = "#include <stdio.h>\n";
        header_file += "#include <stdbool.h>\n";
        header_file += "#include <string.h>\n\n";


        for (VarDeclOP vdl: n.getVarDecList()){
            vdl.accept(this);
        }

        for (ProcOP proc: n.getProcList()){
            proc.accept(this);
        }

        //elimino elementi ripetuti nel caso funzioni ricorsive
        Set<String> set = new HashSet<>(tempReturnParam);
        tempReturnParam.clear();
        tempReturnParam.addAll(set);

        //parametri per valoi di ritorno da inizializzare
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
        organizzaFile("\tscanf(\"");
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
                    organizzaFile("%s");
                    break;
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

            organizzaFile("");
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
            //alla fine della funzione salvo nei puntatori i valore di ritorno
            if (n.getExprList().size()==1){
                organizzaFile("\n\t return ");
                n.getExprList().get(0).accept(this);
                organizzaFile(";\n");
            } else {
                for (int i = 0; i < n.getExprList().size(); i++) {
                    dontWrite = true;
                    String tipo = (String) n.getExprList().get(i).accept(this);
                    //System.out.println("tipo:"+tipo);
                    dontWrite = false;

                    if (tipo.equalsIgnoreCase("string")){
                        organizzaFile("\tstrcpy("+tipo+"_parametri"+i+",");
                        organizzaFile(tempToWrite);
                        organizzaFile(");");
                    } else {
                        organizzaFile("\t*" + tipo + "_parametri" + i + " = ");
                        organizzaFile(tempToWrite);
                        //System.out.println(tempToWrite);
                        organizzaFile(";\n");
                    }
                    tempToWrite = "";
                }
            }
        } else if (n.getVoidOp()!=null){
            n.getVoidOp().accept(this);
        }

        return true;
    }

    @Override
    public Object visit(StatOP n) {

        if (n.getIfStatOp() != null) {
            organizzaFile("\t");
             n.getIfStatOp().accept(this);
        } else if (n.getWhileStatOp() != null) {
            organizzaFile("\t");
             n.getWhileStatOp().accept(this);
        }else if (n.getReadlnStatOp() != null) {
            organizzaFile("\t");
             n.getReadlnStatOp().accept(this);
        }else if (n.getWriteStatOp() != null) {
            organizzaFile("\t");
             n.getWriteStatOp().accept(this);
        }else if (n.getAssignStatOp() != null) {
            organizzaFile("\t");
             n.getAssignStatOp().accept(this);
             organizzaFile(";\n");
        }else if (n.getCallProcOp() != null) {
            organizzaFile("\t");
             n.getCallProcOp().accept(this);
            organizzaFile(";\n");
        }

        return true;
    }

    @Override
    public Object visit(TypeOP n) {
        if (n.getType().equalsIgnoreCase("string")){
            organizzaFile("\tchar");
        } else
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

        if (n.getBodyOp2()!=null){

            n.getBodyOp1().accept(this);
            organizzaFile("\twhile( ");
            n.getExpressionOp().accept(this);
            organizzaFile(" ){\n\t");
            n.getBodyOp2().accept(this);
            n.getBodyOp1().accept(this);
        }
        else {
            organizzaFile("\twhile( ");
            n.getExpressionOp().accept(this);
            organizzaFile(" ){\n\t");
            n.getBodyOp1().accept(this);
        }

            /*
        if (n.getBodyOp1()!=null){
            n.getBodyOp1().accept(this);
        }

        organizzaFile("\twhile( ");
        n.getExpressionOp().accept(this);
        organizzaFile(" ){\n\t");


        if (n.getBodyOp2()!=null){
            n.getBodyOp2().accept(this);
        }
        if (n.getBodyOp1()!=null){
            n.getBodyOp1().accept(this);
        }
        */

        organizzaFile("\t}\n\t");
        organizzaFile(tempToWrite);


        return true;
    }

    @Override
    public Object visit(WriteOP n) {

        tempToWrite="";
        ArrayList<String> tempcall=new ArrayList<>();
//devo chiamare la funzione prima della printf e poi sostituire nella printf i valori di ritorno
        for (ExpressionOP e : n.getExpressionOpList()) {
            if (e.getClass().getSimpleName().equalsIgnoreCase("CallProcOp")) {

                CallProcOP clp= (CallProcOP) e;
                //faccio come la callproc prendo i parametri..
                Item func= typeEnvironment.lookup(clp.getId().getValue());
                String sign= func.getTipo();

                String [] param= sign.split("->");
                String [] returnTemp= param[1].trim().split(" ");

                ArrayList<String> returnTipoLista= new ArrayList<>(Arrays.asList(returnTemp));
                while (returnTipoLista.remove("")){
                }

                int sizeReturn= returnTipoLista.size();

                //if (sizeReturn>=1){
                if (sizeReturn>1){//se il valore di ritorno sono più di uno chiamo la funzione fuori, se levi uguale la funzione la chiama dentro
                    int oldReturn= returnIndex;
                    Object o= e.accept(this);

                    if (o.getClass().getSimpleName().equalsIgnoreCase("ArrayList")){
                        ArrayList<String> tipoLista= (ArrayList<String>) o;
                        for (int i=0; i<tipoLista.size(); i++){
                            tempcall.add(tipoLista.get(i)+"_return"+(oldReturn+i));
                        }
                    }
                   // else //quando è solo un valore di ritorno leva else e mette direttamente la funzione
                     //   tempcall.add((String)o+"_return"+oldReturn);

                    organizzaFile(";\n");
                }
            }
        }

        organizzaFile("\tprintf(\"");
        dontWrite = true;
        for (ExpressionOP e : n.getExpressionOpList()) {
            organizzaFile(", ");
            String tipo = "";


            if (!e.getClass().getSimpleName().equals("CallProcOP")) {
                Object o= e.accept(this);

                tipo=(String) o;
                dontWrite = false;

                switch (tipo) {
                    case "bool":
                        organizzaFile("&s");
                        break;
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

            } else {//se callproc
                CallProcOP clp=(CallProcOP)e;

                Item func=typeEnvironment.lookup(clp.getId().getValue());
                String sign=func.getTipo();
                String [] param= sign.split("->");
                String [] returnTemp= param[1].trim().split(" ");

                ArrayList<String> returnTipoLista= new ArrayList<>(Arrays.asList(returnTemp));
                while (returnTipoLista.remove("")){
                }

                int sizeRitorno=returnTipoLista.size();
                //System.out.println(sizeRitorno);
                //if (sizeRitorno>=1){
                if (sizeRitorno>1){//leva uguale per farla chiamare all'interno della printf usando else if successivo
                    //devo prenderli al contrario ordine FIFO
                    for (int i=0; i<sizeRitorno; i++){
                        String paramNome= tempcall.get(i);
                        String [] listaValori= paramNome.split("_");
                        tipo=listaValori[0];
                        dontWrite=false;

                        switch (tipo) {
                            case "bool":
                                organizzaFile("%s");
                                break;
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

                        organizzaFile("");
                        dontWrite = true;
                        organizzaFile(paramNome);
                        if (i<sizeRitorno-1)
                            organizzaFile(", ");
                    }
                } //else if (sizeRitorno==0){ //se solo un valore di return inserisco la chiamata a funzione, se metti sizeRitorno ==1 per far chiamare la procedura dentro la printf
                  else if (sizeRitorno==1){
                    tipo= (String) e.accept(this);
                   // System.out.println(tipo);
                    dontWrite=false;

                    switch (tipo) {
                        case "bool":
                            organizzaFile("%s");
                            break;
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

    private int returnIndex;
    //per non scrivere i return nel procbodyop quando main
    private boolean isMain;
}

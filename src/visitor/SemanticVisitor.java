package visitor;


import nodes.expression.*;
import nodes.nonterminals.*;
import nodes.terminals.Constant;
import symbolTable.Item;
import symbolTable.TypeEnvironment;
import tableOpType.OpType;

import javax.naming.ldap.ExtendedRequest;
import java.util.ArrayList;
import java.util.Arrays;

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
        ArrayList<String> idTipoList= new ArrayList<>();
        ArrayList<String> expTipoList= new ArrayList<>();

        if(n.getId() != null){
            idTipoList.add((String) n.getId().accept(this));
        }


        if(n.getExpression() != null){
            Object x= n.getExpression().accept(this);

            if (x.getClass().getSimpleName().equals("ArrayList")){
                ArrayList<String> tipoLista= (ArrayList<String>) x;
                for (String tipo: tipoLista){
                    expTipoList.add(tipo);
                }

            }else{
                expTipoList.add((String) x);
            }
        }

        if( n.getIdList() != null){

            for(Constant id: n.getIdList()){
                idTipoList.add((String) id.accept(this));
            }
        }

        if (n.getExpressionList() != null){

            for(ExpressionOP e : n.getExpressionList()){
                Object x= e.accept(this);

                if(x.getClass().getSimpleName().equals("ArrayList")){
                    ArrayList<String> tipoLista= (ArrayList<String>) x;

                    for( String tipo: tipoLista){
                        expTipoList.add(tipo);
                    }
                }else{
                    expTipoList.add((String) x);
                }
            }
        }

        //deco controllare che abbiano lo stesso tipo i contenuti nella stessa posizione dell'array
        for ( int i=0; i < expTipoList.size(); i++ ){

            if (!expTipoList.get(i).equals(idTipoList.get(i))){
                System.err.println("AssignOp: errore assegnamento controllo dei tipi idList e expList");
                System.exit(1);
            }
        }

        return true;
    }

    @Override
    public Object visit(BodyOP n) {

        for( StatOP s: n.getStatList()){
            s.accept(this);
        }
        return true;
    }

    @Override
    public Object visit(CallProcOP n) {

        String sign= (String) n.getId().accept(this);
        String[] param= sign.split("->");
        String[] paramTemp= param[0].trim().split(" ");
        String[] returnTemp= param[1].trim().split(" ");

        ArrayList<String> paramTipoList= new ArrayList<>(Arrays.asList(paramTemp));
        ArrayList<String> returnTipoList= new ArrayList<>(Arrays.asList(returnTemp));

        ArrayList<String> expList= new ArrayList<>();

        while( paramTipoList.remove("")){

        }
        while (returnTipoList.remove("")){

        }

        int size=paramTipoList.size();

        ArrayList<String> paramOpList= (ArrayList<String>) n.getParamOP().accept(this);

        //se non ho parametri
        if (size==0 && paramOpList == null)
            return returnTipoList;
        else if (paramOpList == null && size !=0){
            System.err.println("\nErrore CallProc: Funzione si aspetta "+size+" parametri, ne sono stati passati 0\n");
            System.exit(1);
        }

        //altri casi si poteva mettere questo al posto else if sopra
        if (size!=paramOpList.size()){
            System.err.println("\nErrore CallProc: Funzione si aspetta "+size+" parametri, ne sono stati passati "+paramOpList.size()+"\n");
            System.exit(1);
        }

        for (int i=0; i<paramOpList.size(); i++){
            if (! paramOpList.get(i).equals(paramTipoList.get(i))){
                System.err.println("\n Errore CallProc: Funzione si aspetta "+size+" parametri, ne sono stati passati "+paramOpList.size()+"\n");
                System.exit(1);
            }
        }


        return returnTipoList;
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

        ArrayList<String> paramOpList= new ArrayList<>();

        if(n.getExpressionList() != null){
            for (ExpressionOP exp : n.getExpressionList()){
                Object x = exp.accept(this);

                if (x.getClass().getSimpleName().equals("ArrayList")){
                    ArrayList<String> tipoLista= (ArrayList<String>) x;
                    for (String tipo: tipoLista){
                        paramOpList.add(tipo);
                    }
                } else {
                    paramOpList.add((String) x);
                }
            }
        } //else
           // return null;

        return paramOpList;
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

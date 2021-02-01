package visitor;


import com.sun.org.apache.bcel.internal.Const;
import nodes.expression.*;
import nodes.nonterminals.*;
import nodes.terminals.Constant;
import sun.awt.image.GifImageDecoder;
import sun.font.DelegatingShape;
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
        typeEnvironment= new TypeEnvironment();
    }

    @Override
    public Object visit(ExpressionOP n){
        return null;
    }

    /**
     * controllo se i due tipi sono compatibili
     * @param n
     * @return
     */
    @Override
    public Object visit(PlusOP n) {

        String t1= checkExpression("plusOp", n.getLeft().accept(this));
        //System.out.println("t1"+t1);
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

        if (resultType == null){
            System.out.println(resultType+" , "+ n.getLeft().accept(this)+ " , "+ n.getRight().accept(this));
            System.err.println("eqOp: mismatch\n t1: "+ t1+ " t2: "+t2+"\n");
        }

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
                System.err.println(n.getValue() + ": ID non trovato");
                System.exit(1);
            }

            if(i.getCostrutto()=="proc"){
                String sign= i.getTipo();
                //System.out.println("sign proc:" +sign);
                String [] val= sign.split("->");
                String [] vals= val[1].trim().split(" ");

                return i.getTipo();//mi serve nella callproc
            }

            return i.getTipo();
        }

        return n.getName();
    }

    @Override
    public Object visit(AssignOP n, Boolean bool){
        return null;
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

        if ( expTipoList.size()!= idTipoList.size()){
            System.err.println("AssignOP 1: Errore Assegnamento");
            for (Constant c: n.getIdList()){
                System.out.println("\n"+c.getValue());
            }
            if (n.getId()!= null)
                System.out.println("\n"+n.getId().getValue());
            System.exit(1);
        }


        //deco controllare che abbiano lo stesso tipo i contenuti nella stessa posizione dell'array
        for ( int i=0; i < expTipoList.size(); i++ ){
           // System.out.println("\n  Controllo AssignOP "+ expTipoList.get(i)+ " \n" +
              //      " "+idTipoList.get(i)+"\nfine\n ");
            if (!expTipoList.get(i).equalsIgnoreCase(idTipoList.get(i))){

                if (idTipoList.get(i).equalsIgnoreCase("string") && !expTipoList.get(i).equalsIgnoreCase("NULL")){
                    System.err.println("AssignOp 2: Stringhe si può assegnare solo null o string\n");
                    System.exit(1);
                }else if (!idTipoList.get(i).equalsIgnoreCase("string") && expTipoList.get(i).equalsIgnoreCase("NULL")){
                    System.err.println("AssignOP 3: i tipi non corrispondono");
                    System.exit(1);
                }
            }
        }

        return true;
    }

    @Override
    public Object visit(BodyOP n) {

        for( StatOP s: n.getStatList()){
            s.accept(this);
        }
        //System.out.println("BodyOP true");
        return true;
    }

    @Override
    public Object visit(CallProcOP n) {
    //prendo i parametri e val ritorno
        String sign= (String) n.getId().accept(this);//mi restituisce il campo dell'item  Vedi visit per Constant
        String[] param= sign.split("->");//contiene in pos 0 parametri e pos 1 valori ritorno
        String[] paramTemp= param[0].trim().split(" ");
        String[] returnTemp= param[1].trim().split(" ");

        ArrayList<String> paramTipoList= new ArrayList<>(Arrays.asList(paramTemp));
        ArrayList<String> returnTipoList= new ArrayList<>(Arrays.asList(returnTemp));

        //System.out.println(n.getId().getValue());
       // paramTipoList.remove(paramTipoList.size()-1);
        //returnTipoList.remove(returnTipoList.size()-1);

        ArrayList<String> expList= new ArrayList<>();

        //if (!paramTipoList.isEmpty())
        while( paramTipoList.remove("")){
        }
        //if (!returnTipoList.isEmpty())
        while (returnTipoList.remove("")){
        }
        /*
        if (paramTipoList.isEmpty() && n.getParamOP().accept(this)== null) {
            System.out.println("aiaiai");
            return returnTipoList;
        }*/

        int size=paramTipoList.size();
        //se non ho ParamOP è vuota
        if (n.getParamOP()==null) return  returnTipoList;

        if (size==0 && n.getParamOP().getExpressionList()== null)
            return returnTipoList;


        //System.out.println("1");
        if (n.getParamOP().getExpressionList() != null){

            ArrayList<ExpressionOP> paramOpLista= (ArrayList<ExpressionOP>) n.getParamOP().accept(this);
            for (ExpressionOP exp: paramOpLista ){

                Object x= exp.accept(this);

                if (x.getClass().getSimpleName().equals("ArrayList")) {
                    System.err.println("CallProc: non possono essere passate funzioni con più valori di ritorno: "+n.getId().getValue()+" "+sign);
                    System.exit(1);
                    ArrayList<String> tipoLista=(ArrayList<String>) x;

                    for (String tipo: tipoLista){
                        expList.add(tipo);
                    }
                }else {
                    expList.add((String) x);
                    //System.out.println(x);
                }
            }
        } else {
            System.err.println("CallProc:"+n.getId().getValue()+" Errore 1 la funzione si aspett "+ size +" parametri, passati 0");
            System.exit(1);
        }

        if (size!= expList.size()){
            System.err.println("CallProc:"+n.getId().getValue()+" Errore 2 il numero parametri non combacia");
            System.exit(1);
        }

        //controllo i vari tipi se combaciano
        for (int i=0; i<expList.size(); i++){

            if (! expList.get(i).equals(paramTipoList.get(i))){
                System.err.println("Callproc:"+n.getId().getValue()+" Errore 3 passaggio parametri non combacia tipo");
                System.exit(1);
            }
        }

        return returnTipoList;
    }

    @Override
    public Object visit(ElifOP n) {

        String exptipo= (String) n.getExpr().accept(this);

        if (!exptipo.equalsIgnoreCase("bool")){
            System.err.println("Elif:"+n.getExpr() +" missmatch dell'espressione non è boolean");
            System.exit(1);
        }

        n.getBody().accept(this);

        return true;
    }

    @Override
    public Object visit(ElseOP n) {

        n.getBody().accept(this);
        return true;
    }

    @Override
    public Object visit(IdInitOP n) {

        if(n.getId() !=null){
            n.getId().accept(this);
        }

        if (n.getAssignament()!= null){
            n.getAssignament().accept(this);
        }

        return n;
    }

    @Override
    public Object visit(IfOP n) {

        String expTipo= (String) n.getExpr().accept(this);

        if(!expTipo.equalsIgnoreCase("bool")){
            System.err.println("If:"+n.getExpr()+" missmatch espressione non è booleano");
            System.exit(1);
        }

        n.getBody().accept(this);

        for (ElifOP e: n.getElifList()) {
            e.accept(this);
        }

        if (n.getElseOp() != null){
            n.getElseOp().accept(this);
        }

        return true;
    }

    @Override
    public Object visit(ParDeclOP n) {

        String tipo= (String) n.getType().accept(this);
        //System.out.println(tipo);
        for (Constant id: n.getIdList()){
            typeEnvironment.addId(id.getValue(), new Item(id.getValue(), tipo, "var"));
            //System.out.println(id.getValue());
            id.accept(this);
        }
        return true;
    }

    @Override
    public Object visit(ProcBodyOP n) {

        for (VarDeclOP vdl : n.getVarDeclList()){
            vdl.accept(this);
        }

        if (n.getStatList()!=null){
            for (StatOP s: n.getStatList()){
                s.accept(this);
            }
        }

        return n.getReturnExprs().accept(this);
    }

    @Override
    public Object visit(ProcOP n) {

        typeEnvironment.enterScope();

        n.getIdOp().accept(this);

        if (n.getParDeclList()!=null){
            for (ParDeclOP pdl: n.getParDeclList()){
                pdl.accept(this);
            }
        }

        for (ResultTypeOP rt: n.getResultTypeList()){
            rt.accept(this);
        }

        //controllo se void sta nei tipi di ritorno, deve avere solo 1 tipo di ritorno
        if (n.getResultTypeList().contains("void") && n.getResultTypeList().size() != 1){
            System.err.println("ProcOP:"+n.getIdOp().getValue()+" La funzione non può avere altri tipi se contiene void come valore di ritorno ");
            System.exit(1);
        }

        ArrayList<String> resultExprLista= (ArrayList<String>) n.getProcBody().accept(this);

        //System.out.println("Funzione: "+ n.getIdOp().getValue());
        //System.out.println( n.getResultTypeList());
        //System.out.println(resultExprLista);

        //controllo che il numero di valori di ritorno si trova con quelli restituiti dalla proc
        if (n.getResultTypeList().size()!= resultExprLista.size()){
            System.err.println("Proc err 1:+"+n.getIdOp().getValue()+" errore tipi di ritorno della funzione, diverso numero");
            System.exit(1);
        }

        for (int i=0; i<n.getResultTypeList().size(); i++){
            //se non è null
            if (n.getResultTypeList().get(i).getType() != null){
                //Controllo i tipi se combaciano
                if (! n.getResultTypeList().get(i).getType().getType().equalsIgnoreCase(resultExprLista.get(i))){
                    System.err.println("Proc err 2:"+n.getIdOp().getValue()+" errore tipi di ritorno della funzione non combaciano");
                    System.exit(1);
                }
            } else {//se void
                //devo controllare quando void
                if (!n.getResultTypeList().get(i).getVoidOp().getName().equalsIgnoreCase(resultExprLista.get(i))){
                    System.out.println("\n"+n.getIdOp().getValue()+": "+n.getResultTypeList().get(i).getVoidOp().getName()+"\n"+resultExprLista.get(i)+"\n\n");
                    System.err.println("Proc err 3: errore due tipi di ritorno della funzione");
                    System.exit(1);
                }
            }
        }

        typeEnvironment.exitScope();
        return true;
    }

    @Override
    public Object visit(ProgramOP n) {
        typeEnvironment.enterScope();

        for (VarDeclOP vdl: n.getVarDecList()){
            vdl.accept(this);
        }

        for (ProcOP p: n.getProcList()){
            String paramString="";
            String resultString="";

            //salvo parametri
            if (p.getParDeclList()!= null){
                for (ParDeclOP par: p.getParDeclList()){
                    ArrayList<Constant> idLista= par.getIdList();

                    for (Constant c: idLista){
                        paramString += par.getType().getType() + " ";
                    }
                }
            }

            //salvo valori di ritorno
            if (p.getResultTypeList() != null){
                for (ResultTypeOP param: p.getResultTypeList()) {
                    if (param.getType() == null) {
                        resultString += "void";//nota
                        break;
                    }
                    resultString+= param.getType().getType() + " ";
                }
            }

            //aggiungo alla tabella, le proc le aggiungo sotto la tabella principale
            typeEnvironment.addId(p.getIdOp().getValue(), new Item( p.getIdOp().getValue(), paramString+ "->" + resultString, "proc"));
            p.accept(this);
        }

        Item i= typeEnvironment.lookup("main");
        if (i==null){
            System.err.println("Il main non esiste");
            System.exit(1);
        }
        if (!i.getCostrutto().equals("proc")){
            System.err.println("Il main non esiste come proc");
            System.exit(1);
        }

        typeEnvironment.exitScope();
        return true;
    }

    @Override
    public Object visit(ReadlnOP n) {

        for (Constant c: n.getIdList()){

            if (c.getName().equals("ID")){

                Item i= typeEnvironment.lookup(c.getValue());
                if (!i.getCostrutto().equals("proc"))
                    c.accept(this);
                else {
                    System.err.println("\n"+c.getValue()+" Non è possibile inserire una funzione in un'operazione di READ");
                    System.exit(1);
                }
            }else {
                System.err.println("\n"+c.getValue()+" è consentito l'inserimento soltanto di ID in un'operazione di READ");
                System.exit(1);
            }
        }

        return true;
    }

    @Override
    public Object visit(ResultTypeOP n) {

        if (n.getType() != null){
            n.getType().accept(this);
        }

        if (n.getVoidOp() != null){
            n.getVoidOp().accept(this);
        }

        return true;
    }

    @Override
    public Object visit(ReturnExprsOP n) {

        ArrayList<String> returnTipoLista= new ArrayList<>();

        if (n.getExprList()!= null){
            for (ExpressionOP exp: n.getExprList()){

                Object x= exp.accept(this);
                if (x.getClass().getSimpleName().equals("ArrayList")){
                    ArrayList<String> tipoLista= (ArrayList<String>) x;

                    for (String tipo: tipoLista){
                        returnTipoLista.add(tipo);
                    }
                } else {
                    returnTipoLista.add((String) x);
                }
            }
        }
        else if (n.getVoidOp() != null){
            n.getVoidOp().accept(this);
            returnTipoLista.add("void");
        }

        return returnTipoLista;
    }

    @Override
    public Object visit(StatOP n) {
        if (n.getIfStatOp() != null) {
            return n.getIfStatOp().accept(this);
        }

        if (n.getWhileStatOp() != null) {
            //System.out.println(n.getWhileStatOp().toString());
            return n.getWhileStatOp().accept(this);
        }

        if (n.getReadlnStatOp() != null) {
            return n.getReadlnStatOp().accept(this);
        }

        if (n.getWriteStatOp() != null) {
            return n.getWriteStatOp().accept(this);
        }

        if (n.getAssignStatOp() != null) {
            return n.getAssignStatOp().accept(this);
        }

        if (n.getCallProcOp() != null) {
            return n.getCallProcOp().accept(this);
        }

        return true;
    }

    @Override
    public Object visit(TypeOP n) {
        return n.getType();
    }

    @Override
    public Object visit(VarDeclOP n) {

        String tipo= (String) n.getType().accept(this);

        for ( IdInitOP x: n.getIdList()){

            if (x.getId() != null){
                typeEnvironment.addId(x.getId().getValue(), new Item(x.getId().getValue(), tipo, "var"));
            }//se assegnamento
            else if (x.getAssignament() != null){
                if (x.getAssignament().getId() != null){
                    typeEnvironment.addId(x.getAssignament().getId().getValue(), new Item(x.getAssignament().getId().getValue(), tipo, "var"));
                }//lista
                else if (x.getAssignament().getIdList() != null){
                    for (Constant id: x.getAssignament().getIdList()){
                        typeEnvironment.addId(id.getValue(), new Item(id.getValue(), tipo, "var"));
                    }
                }
            }
            x.accept(this);
        }
        return true;
    }

    @Override
    public Object visit(WhileOP n) {

        if (n.getBodyOp1()!=null){
            n.getBodyOp1().accept(this);
            //System.out.println(n.getBodyOp1().getStatList().toString());
        }

        //controllo che espressione dia solo un valore bool
        String expTipo= checkExpression("while", n.getExpressionOp().accept(this));
        //System.out.println(expTipo);
        //System.out.println(n.getExpressionOp().toString());
        if (! expTipo.equals("bool")){
            System.err.println("while:"+n.getExpressionOp()+" Errore di tipo dell'espressione");
            System.exit(1);
        }

        if (n.getBodyOp2() != null) {
            n.getBodyOp2().accept(this);
            //System.out.println(n.getBodyOp2().getStatList());
        }
        return true;
    }

    @Override
    public Object visit(WriteOP n) {

        for (ExpressionOP exp: n.getExpressionOpList()){
            exp.accept(this);
        }

        return true;
    }

    @Override
    public Object visit(ParamOP n) {

        /*

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
        } else{
            System.out.println("ParamOP restituisce null");
            return null;
        }*/
        //System.out.println(n.getExpressionList());

       /* ArrayList<String> listaRitorno;
        if (n.getExpressionList()!=null){

            for (ExpressionOP exp: n.getExpressionList()){

                Object x= exp.accept(this);

                if (x.getClass().getSimpleName().equals("ArrayList")){

                    ArrayList<String> tipoLista=(ArrayList<String>) x;

                    for (String tipo:tipoLista){
                        listaRitorno.add()
                    }
                }


            }
            }

            */
        return n.getExpressionList();
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
        //se oggetto è un arratylist, lo converte array di stringhe e controlla sia un solo elemento e lo restituisce
        if(o.getClass().getSimpleName().equals("ArrayList")) {
            ArrayList<String> e = (ArrayList<String>) o;

            if (e.size() != 1) {
                System.err.println(name + " : non può essere usata funzione in un espressione che ritorna void o più di un parametro");
                System.exit(1);
            } else {
                t = e.get(0);
            }
        }
        // altrimenti se non nè un arraylist prende oggetto e lo restituisce
        else {
            t= (String) o;
        }
        return t;//return tipo
    }


    private OpType optype;
    TypeEnvironment typeEnvironment;

}

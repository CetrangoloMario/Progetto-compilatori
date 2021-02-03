package visitor;

import nodes.expression.*;
import nodes.nonterminals.*;
import nodes.terminals.Constant;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.Text;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class XMLVisitor implements Visitor {


    public XMLVisitor() {

        try {
            //Definisce un api per la costruzione di alberi di oggetti DOM da documenti XML
            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();//ottiene una nuova istanza (ricorda è un singleton)
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();//istanze del documento DOM da XML
            this.document = documentBuilder.newDocument();//un nuovo Document per costruire un albero DOM
            //la variabile di istanza rappresenta un documento xml.

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }


    }


    @Override
    public Object visit(ExpressionOP n) {

        return null;
    }

    @Override
    public Object visit(PlusOP n) {
        //Element è un interfaccia e rappresenta un elemento in un documento xml, può avere attributi associati (Simile alla classe NODE)
        Element node = document.createElement(n.getClass().getSimpleName());
                                                //crea un elemento di tipo specificato

        //metodo appendChild della classe Node serve ad aggiungere un nodo alla fine dell'elenco del nodo padre specificato
        node.appendChild((Node) n.getLeft().accept(this));
        node.appendChild((Node) n.getRight().accept(this));

        return node;
    }

    @Override
    public Object visit(MinusOP n) {
        Element node = document.createElement(n.getClass().getSimpleName());

        node.appendChild((Node) n.getLeft().accept(this));
        node.appendChild((Node) n.getRight().accept(this));

        return node;
    }

    @Override
    public Object visit(AndOP n) {
        Element node = document.createElement(n.getClass().getSimpleName());

        node.appendChild((Node) n.getLeft().accept(this));
        node.appendChild((Node) n.getRight().accept(this));

        return node;
    }

    @Override
    public Object visit(DivOP n) {
        Element node = document.createElement(n.getClass().getSimpleName());

        node.appendChild((Node) n.getLeft().accept(this));
        node.appendChild((Node) n.getRight().accept(this));

        return node;
    }

    @Override
    public Object visit(TimesOP n) {
        Element node = document.createElement(n.getClass().getSimpleName());

        node.appendChild((Node) n.getLeft().accept(this));
        node.appendChild((Node) n.getRight().accept(this));

        return node;
    }

    @Override
    public Object visit(EqOP n) {
        Element node = document.createElement(n.getClass().getSimpleName());

        node.appendChild((Node) n.getLeft().accept(this));
        node.appendChild((Node) n.getRight().accept(this));

        return node;
    }

    @Override
    public Object visit(NeOP n) {
        Element node = document.createElement(n.getClass().getSimpleName());

        node.appendChild((Node) n.getLeft().accept(this));
        node.appendChild((Node) n.getRight().accept(this));

        return node;
    }

    @Override
    public Object visit(NotOP n) {
        Element node = document.createElement(n.getClass().getSimpleName());

        node.appendChild((Node) n.getChild().accept(this));

        return node;
    }

    @Override
    public Object visit(UminusOP n) {
        Element node = document.createElement(n.getClass().getSimpleName());

        node.appendChild((Node) n.getExpression().accept(this));

        return node;
    }

    @Override
    public Object visit(LeOP n) {
        Element node = document.createElement(n.getClass().getSimpleName());

        node.appendChild((Node) n.getLeft().accept(this));
        node.appendChild((Node) n.getRight().accept(this));

        return node;
    }

    @Override
    public Object visit(LtOP n) {
        Element node = document.createElement(n.getClass().getSimpleName());

        node.appendChild((Node) n.getLeft().accept(this));
        node.appendChild((Node) n.getRight().accept(this));

        return node;
    }

    @Override
    public Object visit(GtOP n) {
        Element node = document.createElement(n.getClass().getSimpleName());

        node.appendChild((Node) n.getLeft().accept(this));
        node.appendChild((Node) n.getRight().accept(this));

        return node;
    }

    @Override
    public Object visit(GeOP n) {
        Element node = document.createElement(n.getClass().getSimpleName());

        node.appendChild((Node) n.getLeft().accept(this));
        node.appendChild((Node) n.getRight().accept(this));

        return node;
    }

    @Override
    public Object visit(OrOP n) {
        Element node = document.createElement(n.getClass().getSimpleName());

        node.appendChild((Node) n.getLeft().accept(this));
        node.appendChild((Node) n.getRight().accept(this));

        return node;
    }

    @Override
    public Object visit(Constant n) {//deve comporre la stringa da stampare usa classe TEXT
        String textElement = "(" + n.getName();

        if (n.getValue() != null) {
            textElement = textElement + ", " + n.getValue();
        }

        textElement = textElement + ")";

        Text node = document.createTextNode(textElement);

        return node;
    }

    @Override
    public Object visit(AssignOP n, Boolean bool){
        return null;
    }



    @Override
    public Object visit(AssignOP n) {
        Element node = document.createElement(n.getClass().getSimpleName());

        if (n.getId() != null) {//se ce constant a cui assegnare allora appende il nodo ID..
            node.appendChild((Text) n.getId().accept(this));
        }

        if (n.getExpression() != null) {//se c'è espressione
            node.appendChild((Node) n.getExpression().accept(this));
        }

        if (n.getExpressionList() != null) {
            //Collections.reverse(n.getExpressionList());//inverte ordine sono inseriti al contrario
            for (ExpressionOP e : n.getExpressionList()) {

                node.appendChild((Node) e.accept(this));

            }
        }

        if (n.getIdList() != null) {//lista di elementi Constsant id
            //Collections.reverse(n.getIdList());
            for (Constant id : n.getIdList()) {

                node.appendChild((Text) id.accept(this));

            }
        }

        return node;
    }

    @Override
    public Object visit(BodyOP n) {
        Element node = document.createElement(n.getClass().getSimpleName());//nodo BodyOP
        //Collections.reverse(n.getStatList());
        for (StatOP stat : n.getStatList()) {

            node.appendChild((Node) stat.accept(this));

        }

        return node;
    }

    @Override
    public Object visit(ParamOP n){
        Element node = document.createElement(n.getClass().getSimpleName());

        if (n.getExpressionList()!=null) {
            for (ExpressionOP ex : n.getExpressionList()) {

                node.appendChild((Node) ex.accept(this));
            }
        }

        return node;
    }

    @Override
    public Object visit(CallProcOP n) {
        Element node = document.createElement(n.getClass().getSimpleName());

        node.appendChild((Text) n.getId().accept(this));

        if (n.getParamOP()!=null){
            node.appendChild((Node) n.getParamOP().accept(this));
        }

        return node;
    }

    @Override
    public Object visit(ElifOP n) {
        Element node = document.createElement(n.getClass().getSimpleName());

        node.appendChild((Node) n.getExpr().accept(this));
        node.appendChild((Node) n.getBody().accept(this));

        return node;
    }

    @Override
    public Object visit(ElseOP n) {
        Element node = document.createElement(n.getClass().getSimpleName());
        node.appendChild((Node) n.getBody().accept(this));
        return node;
    }

    @Override
    public Object visit(IdInitOP n) {
        Element node = document.createElement(n.getClass().getSimpleName());

        if (n.getId() != null) {
            node.appendChild((Text) n.getId().accept(this));//chiama accept su istanza Constant
        }

        if (n.getAssignament() != null) {//secondo costruttore vedere assignOP
            node.appendChild((Node) n.getAssignament().accept(this));
        }

        return node;
    }

    @Override
    public Object visit(IfOP n) {
        Element node = document.createElement(n.getClass().getSimpleName());

        node.appendChild((Node) n.getExpr().accept(this));
        node.appendChild((Node) n.getBody().accept(this));

        //Collections.reverse(n.getElifList());
        for (ElifOP e : n.getElifList()) {
            if(e!=null) {
                node.appendChild((Node) e.accept(this));
            }
        }
        if(n.getElseOp()!=null) {
            node.appendChild((Node) n.getElseOp().accept(this));
        }

        return node;
    }

    @Override
    public Object visit(ParDeclOP n) {
        Element node = document.createElement(n.getClass().getSimpleName());

        node.appendChild((Text) n.getType().accept(this));

        for (Constant id : n.getIdList()) {

            node.appendChild((Text) id.accept(this));

        }

        return node;
    }

    @Override
    public Object visit(ProcBodyOP n) {
        Element node = document.createElement(n.getClass().getSimpleName());

        for (VarDeclOP v : n.getVarDeclList()) {
            node.appendChild((Node) v.accept(this));
        }

        if (n.getStatList() != null) {

            for (StatOP s : n.getStatList()) {

                node.appendChild((Node) s.accept(this));

            }
        }

        node.appendChild((Node) n.getReturnExprs().accept(this));

        return node;
    }

    @Override
    public Object visit(ProcOP n) {
        Element node = document.createElement(n.getClass().getSimpleName());

        node.appendChild((Text) n.getIdOp().accept(this));

        if (n.getParDeclList() != null) {
            //Collections.reverse(n.getParDeclList());
            for (ParDeclOP p : n.getParDeclList()) {

                node.appendChild((Node) p.accept(this));

            }
        }
        //Collections.reverse(n.getResultTypeList());
        for (ResultTypeOP r : n.getResultTypeList()) {

            //TODO Forse (Node)
            node.appendChild((Node) r.accept(this));

        }

        node.appendChild((Node) n.getProcBody().accept(this));

        return node;
    }

    @Override
    public Object visit(ProgramOP n) {

        Element node = document.createElement(n.getClass().getSimpleName());

        for (VarDeclOP v : n.getVarDecList()) {

            node.appendChild((Node) v.accept(this));

        }

        for (ProcOP p : n.getProcList()) {

            node.appendChild((Node) p.accept(this));

        }
        return node;
    }

    @Override
    public Object visit(ReadlnOP n) {
        Element node = document.createElement(n.getClass().getSimpleName());

        for (Constant e : n.getIdList()) {

            node.appendChild((Text) e.accept(this));

        }
        return node;
    }

    @Override
    public Object visit(ResultTypeOP n) {
        Element node = document.createElement(n.getClass().getSimpleName());

        if (n.getType() != null) {
            node.appendChild((Text) n.getType().accept(this));
        }

        if (n.getVoidOp() != null) {
            node.appendChild((Text) n.getVoidOp().accept(this));
        }

        return node;
    }

    @Override
    public Object visit(ReturnExprsOP n) {
        Element node = document.createElement(n.getClass().getSimpleName());

        if (n.getExprList() != null) {

            for (ExpressionOP e : n.getExprList()) {

                node.appendChild((Node) e.accept(this));

            }
        }

        if (n.getVoidOp() != null) {
            node.appendChild((Text) n.getVoidOp().accept(this));
        }

        return node;
    }

    @Override
    public Object visit(StatOP n) {

        if (n.getIfStatOp() != null) {
            return n.getIfStatOp().accept(this);
        }

        if (n.getWhileStatOp() != null) {
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


        return null;
    }

    @Override
    public Object visit(TypeOP n) {
        Text node = document.createTextNode("(" + n.getType() + ")");

        return node;
    }

    @Override
    public Object visit(VarDeclOP n) {
        Element node = document.createElement(n.getClass().getSimpleName());

        node.appendChild((Text) n.getType().accept(this));

        for (IdInitOP i : n.getIdList()) {

            node.appendChild((Node) i.accept(this));

        }

        return node;
    }

    @Override
    public Object visit(WhileOP n) {
        Element node = document.createElement(n.getClass().getSimpleName());

        if(n.getBodyOp2()!=null){//allora primo costruttore

            node.appendChild((Node) n.getBodyOp1().accept(this));
            node.appendChild((Node) n.getExpressionOp().accept(this));
            node.appendChild((Node) n.getBodyOp2().accept(this));
        }
        else{//altrimenti seconda produzione del while
            node.appendChild((Node) n.getExpressionOp().accept(this));
            node.appendChild((Node) n.getBodyOp1().accept(this));
        }

        return node;
    }

    @Override
    public Object visit(WriteOP n) {
        Element node = document.createElement(n.getClass().getSimpleName());

        for (ExpressionOP e : n.getExpressionOpList()) {

            node.appendChild((Node) e.accept(this));

        }

        return node;
    }

    public Document executeVisit(ProgramOP root, String outFileName) {

        Node node = (Node) root.accept(this);
        document.appendChild(node);


        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = null;
        try {
            transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File(outFileName));
            transformer.transform(domSource, streamResult);
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }


        return document;

    }

    Document document;
}

package visitor;

import com.sun.org.apache.xpath.internal.operations.And;
import nodes.expression.*;
import nodes.nonterminals.*;
import nodes.terminals.Constant;

import java.io.File;
import java.util.Collections;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.*;

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

    //TODO
    @Override
    public Object visit(ExpressionOP n) {
        /*Text node = document.createTextNode("Expression");
        return node;*/
        return null;
    }

    @Override //TODO
    public Object visit(PlusOP n) {
        //Element è un interfaccia e rappresenta un elemento in un documento xml, può avere attributi associati (Simile alla classe NODE)
        Element node = document.createElement(n.getClass().getSimpleName());
                                                //crea un elemento di tipo specificato

        //metodo appendChild della classe Node serve ad aggiungere un nodo alla fine dell'elenco del nodo padre specificato
        node.appendChild((Node) n.getLeft().accept(this));
        node.appendChild((Node) n.getRight().accept(this));

        return node;
    }

    @Override //TODO
    public Object visit(MinusOP n) {
        Element node = document.createElement(n.getClass().getSimpleName());

        node.appendChild((Node) n.getLeft().accept(this));
        node.appendChild((Node) n.getRight().accept(this));

        return node;
    }

    @Override //TODO
    public Object visit(AndOP n) {
        Element node = document.createElement(n.getClass().getSimpleName());

        node.appendChild((Node) n.getLeft().accept(this));
        node.appendChild((Node) n.getRight().accept(this));

        return node;
    }

    @Override //TODO
    public Object visit(DivOP n) {
        Element node = document.createElement(n.getClass().getSimpleName());

        node.appendChild((Node) n.getLeft().accept(this));
        node.appendChild((Node) n.getRight().accept(this));

        return node;
    }

    @Override //TODO
    public Object visit(TimesOP n) {
        Element node = document.createElement(n.getClass().getSimpleName());

        node.appendChild((Node) n.getLeft().accept(this));
        node.appendChild((Node) n.getRight().accept(this));

        return node;
    }

    @Override //TODO
    public Object visit(EqOP n) {
        Element node = document.createElement(n.getClass().getSimpleName());

        node.appendChild((Node) n.getLeft().accept(this));
        node.appendChild((Node) n.getRight().accept(this));

        return node;
    }

    @Override //TODO
    public Object visit(NeOP n) {
        Element node = document.createElement(n.getClass().getSimpleName());

        node.appendChild((Node) n.getLeft().accept(this));
        node.appendChild((Node) n.getRight().accept(this));

        return node;
    }

    @Override //TODO
    public Object visit(NotOP n) {
        Element node = document.createElement(n.getClass().getSimpleName());

        node.appendChild((Node) n.getChild().accept(this));

        return node;
    }

    @Override //TODO
    public Object visit(UminusOP n) {
        Element node = document.createElement(n.getClass().getSimpleName());

        node.appendChild((Node) n.getExpression().accept(this));

        return node;
    }

    @Override //TODO
    public Object visit(LeOP n) {
        Element node = document.createElement(n.getClass().getSimpleName());

        node.appendChild((Node) n.getLeft().accept(this));
        node.appendChild((Node) n.getRight().accept(this));

        return node;
    }

    @Override //TODO
    public Object visit(LtOP n) {
        Element node = document.createElement(n.getClass().getSimpleName());

        node.appendChild((Node) n.getLeft().accept(this));
        node.appendChild((Node) n.getRight().accept(this));

        return node;
    }

    @Override //TODO
    public Object visit(GtOP n) {
        Element node = document.createElement(n.getClass().getSimpleName());

        node.appendChild((Node) n.getLeft().accept(this));
        node.appendChild((Node) n.getRight().accept(this));

        return node;
    }

    @Override //TODO
    public Object visit(GeOP n) {
        Element node = document.createElement(n.getClass().getSimpleName());

        node.appendChild((Node) n.getLeft().accept(this));
        node.appendChild((Node) n.getRight().accept(this));

        return node;
    }

    @Override //TODO
    public Object visit(OrOP n) {
        Element node = document.createElement(n.getClass().getSimpleName());

        node.appendChild((Node) n.getLeft().accept(this));
        node.appendChild((Node) n.getRight().accept(this));

        return node;
    }

    @Override
    public Object visit(Constant n) {
        String textElement = "(" + n.getName();

        if (n.getValue() != null) {
            textElement = textElement + ", " + n.getValue();
        }

        textElement = textElement + ")";

        Text node = document.createTextNode(textElement);

        return node;
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
            Collections.reverse(n.getExpressionList());//inverte ordine sono inseriti al contrario
            for (ExpressionOP e : n.getExpressionList()) {

                node.appendChild((Node) e.accept(this));

            }
        }

        if (n.getIdList() != null) {//lista di elementi Constsant id
            Collections.reverse(n.getIdList());
            for (Constant id : n.getIdList()) {

                node.appendChild((Text) id.accept(this));

            }
        }

        return node;
    }

    @Override //TODO
    public Object visit(BodyOP n) {
        Text node = document.createTextNode("BodyOp");
        return node;
    }

    @Override //TODO
    public Object visit(CallProcOP n) {
        Text node = document.createTextNode("CallProcOp");
        return node;
    }

    @Override //TODO
    public Object visit(ElifOP n) {
        Text node = document.createTextNode("ElifOp");
        return node;
    }

    @Override //TODO
    public Object visit(ElseOP n) {
        Text node = document.createTextNode("ElseOp");
        return node;
    }

    @Override
    public Object visit(IdInitOP n) {
        Element node = document.createElement(n.getClass().getSimpleName());

        if (n.getId() != null) {
            node.appendChild((Text) n.getId().accept(this));
        }

        if (n.getAssignament() != null) {
            node.appendChild((Node) n.getAssignament().accept(this));
        }

        return node;
    }

    @Override //TODO
    public Object visit(IfOP n) {
        Text node = document.createTextNode("IfOP");
        return node;
    }

    @Override
    public Object visit(ParDeclOP n) {
        Element node = document.createElement(n.getClass().getSimpleName());

        node.appendChild((Text) n.getType().accept(this));
        //Collections.reverse(n.getIdList());
        for (Constant id : n.getIdList()) {

            node.appendChild((Text) id.accept(this));

        }

        return node;
    }

    @Override
    public Object visit(ProcBodyOP n) {
        Element node = document.createElement(n.getClass().getSimpleName());
        Collections.reverse(n.getVarDeclList());
        for (VarDeclOP v : n.getVarDeclList()) {
            node.appendChild((Node) v.accept(this));
        }

        if (n.getStatList() != null) {
            Collections.reverse(n.getStatList());
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
        Collections.reverse(n.getResultTypeList());
        for (ResultTypeOP r : n.getResultTypeList()) {

            //TODO Forese (Text)
            node.appendChild((Node) r.accept(this));

        }

        node.appendChild((Node) n.getProcBody().accept(this));

        return node;
    }

    @Override
    public Object visit(ProgramOP n) {

        Element node = document.createElement(n.getClass().getSimpleName());
        Collections.reverse(n.getVarDecList());
        for (VarDeclOP v : n.getVarDecList()) {

            node.appendChild((Node) v.accept(this));

        }
        Collections.reverse(n.getProcList());
        for (ProcOP p : n.getProcList()) {

            node.appendChild((Node) p.accept(this));

        }
        return node;
    }

    @Override //TODO
    public Object visit(ReadlnOP n) {
        Text node = document.createTextNode("ReadOp");
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
            Collections.reverse(n.getExprList());
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
       // Collections.reverse(n.getIdList());
        for (IdInitOP i : n.getIdList()) {

            node.appendChild((Node) i.accept(this));

        }

        return node;
    }

    @Override //TODO
    public Object visit(WhileOP n) {
        Text node = document.createTextNode("WhileOP");
        return node;
    }

    @Override //TODO
    public Object visit(WriteOP n) {
        Text node = document.createTextNode("WriteOp");
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

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

public class XMLVisitor_Saved_OK implements Visitor {


    public XMLVisitor_Saved_OK() {

        try {
            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
            this.document = documentBuilder.newDocument();


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
        Element node = document.createElement(n.getClass().getSimpleName());

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
        String textElement = "("+n.getName();

        if(n.getValue() != null){
            textElement = textElement + ", "+n.getValue();
        }

        textElement = textElement + ")";

        Text node = document.createTextNode(textElement);

        return node;
    }

    @Override
    public Object visit(AssignOP n) {
        Element node = document.createElement(n.getClass().getSimpleName());



        if(n.getId() != null){
            node.appendChild((Text) n.getId().accept(this));
        }

        if(n.getExpression() != null){
            node.appendChild((Node) n.getExpression().accept(this));
        }

        if(n.getExpressionList() != null){
            for (ExpressionOP e:n.getExpressionList()) {

                node.appendChild((Node) e.accept(this));

            }
        }

        if(n.getIdList() != null){
            for (Constant id: n.getIdList()) {

                node.appendChild((Text) id.accept(this));

            }
        }

        return node;
    }

    @Override //TODO
    public Object visit(BodyOP n) {
        Text node = document.createTextNode("BodyOP");
        return node;
    }

    @Override //TODO
    public Object visit(CallProcOP n) {
        Text node = document.createTextNode("CallProcOP");
        return node;
    }

    @Override //TODO
    public Object visit(ElifOP n) {
        Text node = document.createTextNode("ElifOP");
        return node;
    }

    @Override //TODO
    public Object visit(ElseOP n) {
        Text node = document.createTextNode("ElseOP");
        return node;
    }

    @Override
    public Object visit(IdInitOP n) {
        Element node = document.createElement(n.getClass().getSimpleName());

        if(n.getId() != null){
            node.appendChild((Text) n.getId().accept(this));
        }

        if(n.getAssignament() != null){
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

        for (Constant id:n.getIdList()) {

            node.appendChild((Text) id.accept(this));

        }

        return node;
    }

    @Override
    public Object visit(ProcBodyOP n) {
        Element node = document.createElement(n.getClass().getSimpleName());

        for(VarDeclOP v : n.getVarDeclList()){
            node.appendChild((Node) v.accept(this));
        }

        if(n.getStatList() != null){
            for (StatOP s: n.getStatList()) {

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

        if(n.getParDeclList() != null){
            for (ParDeclOP p: n.getParDeclList()) {

                node.appendChild((Node) p.accept(this));

            }
        }

        for (ResultTypeOP r: n.getResultTypeList()) {

            //TODO Forese (Text)
            node.appendChild((Node) r.accept(this) );

        }

        node.appendChild((Node) n.getProcBody().accept(this));

        return node;
    }

    @Override
    public Object visit(ProgramOP n) {

        Element node = document.createElement(n.getClass().getSimpleName());

        for(VarDeclOP v: n.getVarDecList()) {

           node.appendChild((Node) v.accept(this));

        }

        for (ProcOP p: n.getProcList()) {

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

        if(n.getType() != null){
            node.appendChild((Text) n.getType().accept(this));
        }

        if(n.getVoidOp() != null){
            node.appendChild((Text) n.getVoidOp().accept(this));
        }

        return node;
    }

    @Override
    public Object visit(ReturnExprsOP n) {
        Element node = document.createElement(n.getClass().getSimpleName());

        if(n.getExprList() != null){
            for (ExpressionOP e:n.getExprList()) {

                node.appendChild((Node) e.accept(this));

            }
        }

        if(n.getVoidOp() != null){
            node.appendChild((Text) n.getVoidOp().accept(this));
        }

        return node;
    }

    @Override
    public Object visit(StatOP n) {

        if(n.getIfStatOp() != null){
            return n.getIfStatOp().accept(this);
        }

        if(n.getWhileStatOp() != null){
            return n.getWhileStatOp().accept(this);
        }

        if(n.getReadlnStatOp() != null){
            return n.getReadlnStatOp().accept(this);
        }

        if(n.getWriteStatOp() != null){
            return n.getWriteStatOp().accept(this);
        }

        if(n.getAssignStatOp() != null){
            return n.getAssignStatOp().accept(this);
        }

        if(n.getCallProcOp() != null){
            return n.getCallProcOp().accept(this);
        }


        return null;
    }

    @Override
    public Object visit(TypeOP n) {
        Text node = document.createTextNode("("+n.getType()+")");

        return node;
    }

    @Override
    public Object visit(VarDeclOP n) {
        Element node = document.createElement(n.getClass().getSimpleName());

        node.appendChild((Text) n.getType().accept(this));

        for(IdInitOP i:n.getIdList()) {

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

    public Document executeVisit(ProgramOP root, String outFileName){

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
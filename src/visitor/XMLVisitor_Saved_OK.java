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
    public Object visit(ExpressionOp n) {
        /*Text node = document.createTextNode("Expression");
        return node;*/
        return null;
    }

    @Override //TODO
    public Object visit(plusOp n) {
        Element node = document.createElement(n.getClass().getSimpleName());

        node.appendChild((Node) n.getLeft().accept(this));
        node.appendChild((Node) n.getRight().accept(this));

        return node;
    }

    @Override //TODO
    public Object visit(minusOp n) {
        Element node = document.createElement(n.getClass().getSimpleName());

        node.appendChild((Node) n.getLeft().accept(this));
        node.appendChild((Node) n.getRight().accept(this));

        return node;
    }

    @Override //TODO
    public Object visit(andOp n) {
        Element node = document.createElement(n.getClass().getSimpleName());

        node.appendChild((Node) n.getLeft().accept(this));
        node.appendChild((Node) n.getRight().accept(this));

        return node;
    }

    @Override //TODO
    public Object visit(divOp n) {
        Element node = document.createElement(n.getClass().getSimpleName());

        node.appendChild((Node) n.getLeft().accept(this));
        node.appendChild((Node) n.getRight().accept(this));

        return node;
    }

    @Override //TODO
    public Object visit(timesOp n) {
        Element node = document.createElement(n.getClass().getSimpleName());

        node.appendChild((Node) n.getLeft().accept(this));
        node.appendChild((Node) n.getRight().accept(this));

        return node;
    }

    @Override //TODO
    public Object visit(eqOp n) {
        Element node = document.createElement(n.getClass().getSimpleName());

        node.appendChild((Node) n.getLeft().accept(this));
        node.appendChild((Node) n.getRight().accept(this));

        return node;
    }

    @Override //TODO
    public Object visit(neOp n) {
        Element node = document.createElement(n.getClass().getSimpleName());

        node.appendChild((Node) n.getLeft().accept(this));
        node.appendChild((Node) n.getRight().accept(this));

        return node;
    }

    @Override //TODO
    public Object visit(notOp n) {
        Element node = document.createElement(n.getClass().getSimpleName());

        node.appendChild((Node) n.getChild().accept(this));

        return node;
    }

    @Override //TODO
    public Object visit(uminusOp n) {
        Element node = document.createElement(n.getClass().getSimpleName());

        node.appendChild((Node) n.getExpression().accept(this));

        return node;
    }

    @Override //TODO
    public Object visit(leOp n) {
        Element node = document.createElement(n.getClass().getSimpleName());

        node.appendChild((Node) n.getLeft().accept(this));
        node.appendChild((Node) n.getRight().accept(this));

        return node;
    }

    @Override //TODO
    public Object visit(ltOp n) {
        Element node = document.createElement(n.getClass().getSimpleName());

        node.appendChild((Node) n.getLeft().accept(this));
        node.appendChild((Node) n.getRight().accept(this));

        return node;
    }

    @Override //TODO
    public Object visit(gtOp n) {
        Element node = document.createElement(n.getClass().getSimpleName());

        node.appendChild((Node) n.getLeft().accept(this));
        node.appendChild((Node) n.getRight().accept(this));

        return node;
    }

    @Override //TODO
    public Object visit(geOp n) {
        Element node = document.createElement(n.getClass().getSimpleName());

        node.appendChild((Node) n.getLeft().accept(this));
        node.appendChild((Node) n.getRight().accept(this));

        return node;
    }

    @Override //TODO
    public Object visit(orOp n) {
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
    public Object visit(AssignStatOp n) {
        Element node = document.createElement(n.getClass().getSimpleName());



        if(n.getId() != null){
            node.appendChild((Text) n.getId().accept(this));
        }

        if(n.getExpression() != null){
            node.appendChild((Node) n.getExpression().accept(this));
        }

        if(n.getExpressionList() != null){
            for (ExpressionOp e:n.getExpressionList()) {

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
    public Object visit(BodyOp n) {
        Text node = document.createTextNode("BodyOp");
        return node;
    }

    @Override //TODO
    public Object visit(CallProcOp n) {
        Text node = document.createTextNode("CallProcOp");
        return node;
    }

    @Override //TODO
    public Object visit(ElifOp n) {
        Text node = document.createTextNode("ElifOp");
        return node;
    }

    @Override //TODO
    public Object visit(ElseOp n) {
        Text node = document.createTextNode("ElseOp");
        return node;
    }

    @Override
    public Object visit(IdInitOp n) {
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
    public Object visit(IfStatOp n) {
        Text node = document.createTextNode("IfOP");
        return node;
    }

    @Override
    public Object visit(ParDeclOp n) {
        Element node = document.createElement(n.getClass().getSimpleName());

        node.appendChild((Text) n.getType().accept(this));

        for (Constant id:n.getIdList()) {

            node.appendChild((Text) id.accept(this));

        }

        return node;
    }

    @Override
    public Object visit(ProcBodyOp n) {
        Element node = document.createElement(n.getClass().getSimpleName());

        for(VarDeclOp v : n.getVarDeclList()){
            node.appendChild((Node) v.accept(this));
        }

        if(n.getStatList() != null){
            for (StatOp s: n.getStatList()) {

                node.appendChild((Node) s.accept(this));

            }
        }

        node.appendChild((Node) n.getReturnExprs().accept(this));

        return node;
    }

    @Override
    public Object visit(ProcOp n) {
        Element node = document.createElement(n.getClass().getSimpleName());

        node.appendChild((Text) n.getIdOp().accept(this));

        if(n.getParDeclList() != null){
            for (ParDeclOp p: n.getParDeclList()) {

                node.appendChild((Node) p.accept(this));

            }
        }

        for (ResultTypeOp r: n.getResultTypeList()) {

            //TODO Forese (Text)
            node.appendChild((Node) r.accept(this) );

        }

        node.appendChild((Node) n.getProcBody().accept(this));

        return node;
    }

    @Override
    public Object visit(ProgramOp n) {

        Element node = document.createElement(n.getClass().getSimpleName());

        for(VarDeclOp v: n.getVarDecList()) {

           node.appendChild((Node) v.accept(this));

        }

        for (ProcOp p: n.getProcList()) {

            node.appendChild((Node) p.accept(this));

        }
        return node;
    }

    @Override //TODO
    public Object visit(ReadlnStatOp n) {
        Text node = document.createTextNode("ReadOp");
        return node;
    }

    @Override
    public Object visit(ResultTypeOp n) {
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
    public Object visit(ReturnExprsOp n) {
        Element node = document.createElement(n.getClass().getSimpleName());

        if(n.getExprList() != null){
            for (ExpressionOp e:n.getExprList()) {

                node.appendChild((Node) e.accept(this));

            }
        }

        if(n.getVoidOp() != null){
            node.appendChild((Text) n.getVoidOp().accept(this));
        }

        return node;
    }

    @Override
    public Object visit(StatOp n) {

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
    public Object visit(TypeOp n) {
        Text node = document.createTextNode("("+n.getType()+")");

        return node;
    }

    @Override
    public Object visit(VarDeclOp n) {
        Element node = document.createElement(n.getClass().getSimpleName());

        node.appendChild((Text) n.getType().accept(this));

        for(IdInitOp i:n.getIdList()) {

            node.appendChild((Node) i.accept(this));

        }

        return node;
    }

    @Override //TODO
    public Object visit(WhileStatOp n) {
        Text node = document.createTextNode("WhileOP");
        return node;
    }

    @Override //TODO
    public Object visit(WriteStatOp n) {
        Text node = document.createTextNode("WriteOp");
        return node;
    }

    public Document executeVisit(ProgramOp root,String outFileName){

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

import nodes.nonterminals.ProgramOP;
import symbolTable.TypeEnvironment;
import visitor.CToyVisitor;
import visitor.SemanticVisitor;
import visitor.XMLVisitor;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

public class Main {

    public static void main (String [] args) throws FileNotFoundException {

        String filename = args[0];
        Reader input = new BufferedReader(new FileReader(filename));

        parser p = new parser(new Yylex(input));

        /*
//main esercitazione 4
        // l'uso di p.debug_parse() al posto di p.parse() produce tutte le azioni del parser durante il riconoscimento
        try {
            ProgramOP program = (ProgramOP) p.debug_parse().value; //p.parse().value;
            XMLVisitor visitor = new XMLVisitor();
            visitor.executeVisit(program,"C:/Users/cetra/Desktop/Cetrangolo_es5_scg/AST.xml");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

         */

        //main esercitazione 5
        try {
            ProgramOP program = (ProgramOP) p.parse().value;
            SemanticVisitor visitorSemantico = new SemanticVisitor();
            CToyVisitor visitorC= new CToyVisitor("CToyVisitor");

            XMLVisitor visitorXML = new XMLVisitor();
            visitorXML.executeVisit(program,"AST.xml");

             TypeEnvironment typeEnv= visitorSemantico.executeVisit(program);
             visitorC.executeVisit(program,typeEnv);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

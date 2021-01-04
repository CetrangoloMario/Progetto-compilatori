package tableOpType;



import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class OpType {


    HashMap<Op1, String> op1Map;
    HashMap<Op2, String> op2Map;


    private class Op1 {
        String op1;
        String operand;

        public Op1(String op1, String operand) {
            this.op1 = op1;
            this.operand = operand;
        }
    }

    private class Op2 {
        String op2;
        String firstOperand;
        String secondOperand;

        public Op2(String op2, String firstOperand, String secondOperand) {
            this.op2 = op2;
            this.firstOperand = firstOperand;
            this.secondOperand = secondOperand;
        }
    }


    public OpType() {
        op1Map = new HashMap<>();
        op2Map = new HashMap<>();
        // lettura dal file di testo per tabella op1 e op2
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(Config.OP1_FILE_PATH));
            String line = reader.readLine();
            while (line != null) {
                String[] items = line.split("|");
                op1Map.put(new Op1(items[0], items[1]), items[2]);
                line = reader.readLine();
            }
            reader.close();

            reader = new BufferedReader(new FileReader(Config.OP2_FILE_PATH));
            line = reader.readLine();
            while (line != null) {
                String[] items = line.split("|");
                op2Map.put(new Op2(items[0], items[1], items[2]), items[3]);
                line = reader.readLine();
            }
            reader.close();

        } catch (Exception e) {
            System.out.println(" *** Errore OpTable *** ");
            e.printStackTrace();
        }
    }

    public String checkOpType1(String op1, String operand) {
        Op1 toSearch = new Op1(op1, operand);
        return op1Map.get(toSearch);
    }

    public String checkOpType2(String op2, String firstOperand, String secondOperand) {
        Op2 toSearch = new Op2(op2, firstOperand, secondOperand);
        return op2Map.get(toSearch);
    }


}

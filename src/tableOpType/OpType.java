package tableOpType;



import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Objects;

public class OpType {


    HashMap<Op1, String> op1Map;
    HashMap<Op2, String> op2Map;

    /*+
    Classe per la tabella 1 contiene un stringa e operando (operandi unari)
     */
    private class Op1 {
        String op;
        String arg;

        public Op1(String op, String arg) {
            this.op = op;
            this.arg = arg;
        }

        @Override
        public String toString() {
            return "Op1{" +
                    "operazione='" + op + '\'' +
                    ", argomenti='" + arg + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Op1 op11 = (Op1) o;
            return Objects.equals(op, op11.op) &&
                    Objects.equals(arg, op11.arg);
        }

        @Override
        public int hashCode() {
            return Objects.hash(op, arg);// genera valore hash per oggetto sequenza in input.
            // hashcode tollera il null.
        }
    }

    /**
     * Classe per la tabella 2 contiene una stringa operazione e due arg
     */
    private class Op2 {
        String op;
        String arg1;
        String arg2;

        public Op2(String op2, String arg1, String arg2) {
            this.op = op2;
            this.arg1 = arg1;
            this.arg2 = arg2;
        }
        @Override
        public String toString() {
            return "Op2{" +
                    "operazione='" + op + '\'' +
                    ", Primo Argomento='" + arg1 + '\'' +
                    ", Secondo Argomento='" + arg2 + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Op2 op21 = (Op2) o;
            return Objects.equals(op, op21.op) &&
                    Objects.equals(arg1, op21.arg1) &&
                    Objects.equals(arg2, op21.arg2);
        }

        @Override
        public int hashCode() {
            return Objects.hash(op, arg1, arg2);// genera valore hash per oggetto sequenza in input.
            // hashcode tollera il null.
        }
    }


    /**
     * Funzione per inserimento nel hash map (Symbol Table)
     */
    public OpType() {
        op1Map = new HashMap<>();
        op2Map = new HashMap<>();
        // lettura dal file
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(Config.OP1_FILE_PATH));
            String line = reader.readLine();
            while (line != null) {
                String[] items = line.split(";");
                op1Map.put(new Op1(items[0], items[1]), items[2]);
                line = reader.readLine();
            }
            reader.close();

            reader = new BufferedReader(new FileReader(Config.OP2_FILE_PATH));
            line = reader.readLine();
            while (line != null) {
                String[] items = line.split(";");
                op2Map.put(new Op2(items[0], items[1], items[2]), items[3]);
                line = reader.readLine();
            }
            reader.close();

        } catch (Exception e) {
            System.out.println(" *** Errore load OpTable *** ");
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

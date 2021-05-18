import java.io.*;
import java.util.HashMap;
import java.util.Map;


public class Lexer {


    private File input;
    private static HashMap<String, Token> symbolTable; //ID e NUM
    private static HashMap<String, Token> keyWordsTable; //ID e NUM
    private int state;
    private FileInputStream inputStream;
    private long globalPointer;

    /**
     * Costruttore
     * con generazione dell symbol table e inserimento delle parole chiavi
     * all'interno della tabella delle parole chiavi
     */
    public Lexer() {
        symbolTable = new HashMap<String, Token>();
        keyWordsTable = new HashMap<String, Token>();
        state = 0;
        globalPointer = 0;
        keyWordsTable.put("main", new Token("MAIN"));
        keyWordsTable.put("return", new Token("RETURN"));
        keyWordsTable.put("then", new Token("THEN"));
        keyWordsTable.put("continue", new Token("CONTINUE"));
        keyWordsTable.put("if", new Token("IF"));
        keyWordsTable.put("else", new Token("ELSE"));
        keyWordsTable.put("while", new Token("WHILE"));
        keyWordsTable.put("for", new Token("FOR"));
        keyWordsTable.put("int", new Token("INT"));
        keyWordsTable.put("float", new Token("FLOAT"));
        keyWordsTable.put("bool", new Token("BOOL"));
        keyWordsTable.put("true", new Token("TRUE"));
        keyWordsTable.put("false", new Token("FALSE"));
        keyWordsTable.put("string", new Token("STRING"));

    }

    /**
     * Inizializza l'analizzatore lessicale
     *
     * @param filePath il path del file
     * @return true se il file esiste e può essere letto
     * @exception   IOException problema nel realizzare un puntatore al file e il puntatore alla posizione da dove si parte a leggere all'interno del file
     */

    public Boolean initialize(String filePath) {
        input = new File(filePath);
        if (!input.exists()) return false;
        if (!input.canRead() || !input.isFile()) return false;
        try {
            inputStream = new FileInputStream(input);
            globalPointer = inputStream.getChannel().position(); //Salva all'imterno della var la poizione del puntatore all'interno del file
            return true;
        } catch (IOException e) {
            return false;
        }
    }


    /**
     * @return Analizza il file dato in input all'analizzatore lessicale e restituisce il
     * token relativo al primo lessema letto che rispetta i pattern definiti, oppure restituisce
     * un token di errore
     * @throws Exception
     */
    public Token nextToken() throws Exception {

        //Ad ogni chiamata del lexer (nextToken())
        //si resettano tutte le variabili utilizzate
        state = 0;

        StringBuilder lessema = new StringBuilder(); //Il lessema riconosciuto
        char c;

        while (true) {

            // legge un carattere da input e lancia eccezione quando incontra EOF per restituire null
            //  per indicare che non ci sono piu' token
            globalPointer = inputStream.getChannel().position(); /*Salva la posizione corrente del puntatore prima
                                                                di leggere un nuovo carattere e quindi di
                                                                incrementare la posizione*/
            int intChar = inputStream.read();
            if (intChar == -1) return null; // -1 = End Of File

            c = (char) intChar;
            if (isDelimiter(c)) {
                if (lessema.length() <= 0) continue;
                if (state > 0 && state < 18) {
                    return new Token(lessema.toString());
                }
                if (state == 20 || state == 21) {
                    return installID(lessema.toString());
                }
            }


            //Operator
            switch (state) {
                case 0://caso legge minore, uguale, maggiore
                    if (c == '<') {
                        state = 1;
                        lessema.append(c);
                        // Nel caso in cui il file e' terminato ma ho letto qualcosa di valido
                        // devo lanciare il token (altrimenti perderei l'ultimo token, troncato per l'EOF)
                        if (inputStream.available() <= 0 || nextCharIsDelimiter()) { //Niente più da leggere
                            return new Token("LESSOP");
                        }
                        break;
                    }
                    if (c == '=') {
                        state = 2;
                        lessema.append(c);
                        return new Token("EQUALSOP");
                    }
                    if (c == '>') {
                        state = 3;
                        lessema.append(c);
                        // Nel caso in cui il file e' terminato ma ho letto qualcosa di valido
                        // devo lanciare il token (altrimenti perderei l'ultimo token, troncato per l'EOF)
                        if (inputStream.available() <= 0 || nextCharIsDelimiter()) { //Niente più da leggere
                            return new Token("GREATEROP");
                        }
                        break;
                    }

                    state = 10;//PROSSIMO DIAGRAMMA
                    break;

                case 1:// caso legge dopo il carattere minore un aggiore, un uguale, un trattino altrimente restituisce solo minore
                    if (c == '>') {
                        state = 4; //FINALE
                        lessema.append(c);
                        return new Token("NOTEQUALSOP");
                    }
                    if (c == '=') {
                        state = 5; //FINALE
                        lessema.append(c);
                        return new Token("LESSEQUALSOP");
                    }
                    if (c == '-') {
                        state = 6; //FINALE
                        lessema.append(c);
                        return new Token("ASSIGNMENTOP");
                    }
                    state = 7; //FINALE
                    retrack();
                    return new Token("LESSOP");

                case 3:// dopo aver letto il maggiore, legge il carattere uguale altrimenti restituisce maggiore
                    if (c == '=') {
                        state = 8; //FINALE
                        lessema.append(c);
                        return new Token("GREATEREQUALSOP");
                    }
                    state = 9; //FINALE
                    retrack();
                    return new Token("GREATEROP");

                default:
                    break;
            }
            //end switch

            // separator switch
            switch (state) {
                case 10:
                    if (c == '(') {
                        state = 11;
                        lessema.append(c);
                        return new Token("LRBRACKET");
                    }
                    if (c == ')') {
                        state = 12;
                        lessema.append(c);
                        return new Token("RRBRACKET");
                    }
                    if (c == '[') {
                        state = 13;
                        lessema.append(c);
                        return new Token("LSBRACKET");
                    }
                    if (c == ']') {
                        state = 14;
                        lessema.append(c);
                        return new Token("RSBRACKET");
                    }
                    if (c == '{') {
                        state = 15;
                        lessema.append(c);
                        return new Token("LBRACKET");
                    }
                    if (c == '}') {
                        state = 16;
                        lessema.append(c);
                        return new Token("RBRACKET");
                    }
                    if (c == ',') {
                        state = 17;
                        lessema.append(c);
                        return new Token("COMMA");
                    }
                    if (c == ';') {
                        state = 18;
                        lessema.append(c);
                        return new Token("SEMICOMMA");
                    }

                    state = 19;//PROSSIMO DIAGRAMMA
                default:
                    break;
            }

            //Identifier
            switch (state) {
                case 19:// caso un carattere o trattino basso, legge il prossimo carattere altrimente va nel prossimo diagramma

                    if (Character.isLetter(c) | Character.compare('_', c) == 0) {
                        state = 20;
                        lessema.append(c);

                        // Nel caso in cui il file � terminato ma ho letto qualcosa di valido
                        // devo lanciare il token (altrimenti perderei l'ultimo token, troncato per l'EOF)
                        if (inputStream.available() <= 0 || nextCharIsDelimiter()) {//Niente più da leggere
                            retrack();
                            return installID(lessema.toString());
                        }
                        break;
                    }
                    state = 21; //Diagramma successivo
                    break;

                case 20:// caso in cui dopo aver letto una lettera o trattino basso legge una lettera o un numero o trattino

                    if (Character.isLetterOrDigit(c) | Character.compare('_', c) == 0) {
                        lessema.append(c);

                        if (inputStream.available() <= 0 || nextCharIsDelimiter()) { //Niente più da leggere
                            return installID(lessema.toString());
                        }
                        break;
                    } else {
                        state = 21;// diagramma successivo
                        retrack();
                        return installID(lessema.toString());
                    }

                default:
                    break;
            }//end switch


            //Number
            switch (state) {
                case 21:// caso in cui numero 0 va nello stato 22 se un numero da 1 a 9 procede nello stato 23

                    if (c=='0') {
                        state=22;
                        lessema.append(c);
                        // Nel caso in cui il file � terminato ma ho letto qualcosa di valido
                        // devo lanciare il token (altrimenti perderei l'ultimo token, troncato per l'EOF)
                        if (inputStream.available() <= 0 || nextCharIsDelimiter()) {//Niente più da leggere
                            //retrack();
                            return number(lessema.toString());
                        }

                        break;
                    }
                    if (Character.isDigit(c) && c!=0) {
                        state=23;
                        lessema.append(c);
                        // Nel caso in cui il file � terminato ma ho letto qualcosa di valido
                        // devo lanciare il token (altrimenti perderei l'ultimo token, troncato per l'EOF)
                        if (inputStream.available() <= 0 || nextCharIsDelimiter()) {//Niente più da leggere
                            //retrack();
                            return number(lessema.toString());
                        }

                        break;
                    }
                    state = 28; //Diagramma successivo
                    break;

                case 22:// dopo uno 0 posso leggere solo . altrimenti restituisco 0
                    if (Character.compare('.', c) == 0) {
                         //serve per la stampa in caso if successivo o ci sia un delimiatatore
                        if (inputStream.available() <= 0 || nextCharIsDelimiter()) { //Niente più da leggere
                            //retrack();
                            lessema.append(c);
                            state = 100;// Stato di errore
                        } else {
                            lessema.append(c);
                            state = 25;
                        }
                        break;
                    } else {
                        state = 24;// FINE
                        retrack();
                        return number(lessema.toString());
                    }

                case 23:// dopo un numero leggo un altro numero oppure leggo un .
                    if (Character.isDigit(c)) {
                        lessema.append(c);
                        if (inputStream.available() <= 0 || nextCharIsDelimiter()) { //Niente più da leggere

                            return number(lessema.toString());
                        }
                        break;
                    }
                    if (Character.compare('.', c) == 0) {
                        state=25;
                        lessema.append(c);
                        if (inputStream.available() <= 0 || nextCharIsDelimiter()) { //Niente più da leggere
                            //retrack();
                            state=100; //Stato di errore
                        }
                        break;
                    }
                    state = 24;// FINE
                    retrack();
                    return number(lessema.toString());
                case 25:// dopo il punto leggo un numero continuo, altrimenti faccio errore
                    if (Character.isDigit(c)) {
                        state=26;
                        lessema.append(c);
                        if (inputStream.available() <= 0 || nextCharIsDelimiter()) { //Niente più da leggere

                            return number(lessema.toString());
                        }
                        break;
                    } else {
                        state = 100; //Stato di errore
                        retrack();
                        break;
                        //return installID(lessema.toString());
                    }
                case 26:// dopo un numero leggo un altro altrimenti restitusco il numero
                    if (Character.isDigit(c)) {
                        lessema.append(c);
                        if (inputStream.available() <= 0 || nextCharIsDelimiter()) { //Niente più da leggere

                            return number(lessema.toString());
                        }
                        break;
                    } else {
                        state = 27; //FINE
                        retrack();
                        return number(lessema.toString());
                        //return installID(lessema.toString());
                    }

                default:
                    break;
            }//end switch


            //Operatori
            switch (state) {
                case 28://caso leggo un + o - * / % ! dirotto nei relativi stati altrimenti errore
                    if (c == '+') {
                        state = 29;
                        lessema.append(c);
                        // Nel caso in cui il file � terminato ma ho letto qualcosa di valido
                        // devo lanciare il token (altrimenti perderei l'ultimo token, troncato per l'EOF)
                        if (inputStream.available() <= 0 || nextCharIsDelimiter()) {//Niente più da leggere

                            return new Token("OP", "ADDITION");
                        }
                        break;
                    }
                    if (c == '-') {
                        state = 30;
                        lessema.append(c);
                        // Nel caso in cui il file � terminato ma ho letto qualcosa di valido
                        // devo lanciare il token (altrimenti perderei l'ultimo token, troncato per l'EOF)
                        if (inputStream.available() <= 0 || nextCharIsDelimiter()) {//Niente più da leggere

                            return new Token("OP", "SUBTRACTION");
                        }
                        break;
                    }

                    if (c == '*') {
                        state = 31;//FINALE
                        lessema.append(c);
                        return new Token("OP", "MULTIPLICATION");
                    }

                    if (c == '/') {
                        state = 32;//FINALE
                        lessema.append(c);
                        return new Token("OP", "DIVISION");
                    }

                    if (c == '%') {
                        state = 33;//FINAL
                        lessema.append(c);
                        return new Token("OP", "MODULE");
                    }

                    if (c == '!') {
                        state = 34;//ci può essere not equals
                        lessema.append(c);
                        // Nel caso in cui il file � terminato ma ho letto qualcosa di valido
                        // devo lanciare il token (altrimenti perderei l'ultimo token, troncato per l'EOF)
                        if (inputStream.available() <= 0 || nextCharIsDelimiter()) {//Niente più da leggere

                            return new Token("OP", "NOT");
                        }
                        break;
                    }

                    state = 100;//prossimo diagramma 39
                    break;

                case 29:// caso dopo il simbolo + leggo un + altrimenti restituisco un solo +
                    if (c == '+') {//++ incremento
                        state = 35;//FINALE
                        lessema.append(c);
                        return new Token("OP", "INCREASE");

                    } else {
                        state = 38;//FINALE
                        retrack();
                        return new Token("OP", "ADDITION");
                    }
                case 30:// caso dopo il simbolo - leggo un altro - altrimenti restituisco un solo -
                    if (c == '-') {// -- decremento
                        state = 36;//FINALE
                        lessema.append(c);
                        return new Token("OP", "DECREASE");

                    } else {
                        state = 38;//FINALE
                        retrack();
                        return new Token("OP", "SUBTRACTION");
                    }

                case 34:// dopo aver letto ! leggo un = altrimenti restituisco solo il !
                    if (c == '=') {// != not equals
                        state = 37;//FINALE
                        lessema.append(c);
                        return new Token("OP", "NOT_EQUALS");

                    } else {
                        state = 38;//FINALE
                        retrack();
                        return new Token("OP", "NOT");
                    }

                default:
                    break;
            }//end swith prossimo 39

            //Error
            switch (state) {
                case 100://stampa errore con lessema che lo ha generato

                    return new Token("ERROR",lessema.toString());
                default:
                    break;
            }//end swith



        }//end while
    }//end method


    /**
     *  Controlla se il lessema sia una parola chiave, allora restituisce il token corrispondente
     *  se no controlla se il lessema è contenuto della tabella dei simboli se stato già inserito e restituisce il token
     *  altrimenti inserisce un nuovo token nella tabella dei simboli e restituisce il token appena aggiunto.
     * @param lessema
     * @return token
     */
    private Token installID(String lessema) {
        Token token;
        //controllo se il lessema è una parola chiave
        if (!keyWordsTable.containsKey(lessema)) {
            //se non è una parola chiave verifico se esiste già, altrimenti la creo e la memorizzo
            //utilizzo come chiave della hashmap il lessema
            if (symbolTable.containsKey(lessema))
                //return symbolTable.get(lessema);
                return symbolTable.get(lessema);
            else {
                token = new Token("ID", lessema);
                symbolTable.put(lessema, token);
                return token;
            }
        }
        return keyWordsTable.get(lessema);
    }

    //serve a stampare il token dei numeri in formato.
    private Token number(String lessema) {
        Token token;
        token = new Token("NUMBER", lessema);
        return token;
    }



    /**
     * Effettua il retrack, quindi porta il puntatore di inputStream alla posizione precedente
     */
    private void retrack() {
        try {
            inputStream.getChannel().position(globalPointer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     *
     * @param c
     * @return se è un delimitatore
     */
    private Boolean isDelimiter(char c) {
        if (c == '\n' || c == '\t' || c == ' ' || c == '\r') return true;
        return false;
    }

    /**
     * se è il carattere dopo è un en of file restituisce true altrimenti legge carattere successivo e verifica se sia un delimitatore
     * @return
     * @throws Exception
     */
    public Boolean nextCharIsDelimiter() throws Exception {

        globalPointer = inputStream.getChannel().position(); /*Salva la posizione corrente del puntatore primadi leggere un nuovo carattere e quindi diincrementare la posizione*/
        int intChar = inputStream.read();
        if (intChar == -1) return true; // -1 = End Of File

        char c = (char) intChar;
        retrack();
        return isDelimiter(c);

    }


    public void printSymbolTable(){
        //int x=0;
        System.out.println("--------String table--------");
        for (Map.Entry e : symbolTable.entrySet())
        {
            // x++;
            System.out.println("| ID: "+e.getKey()+" | Token: "+e.getValue()+" |" );

        }
        System.out.println("------------------------------------" );
    }

    public void printKeyWordsTable(){
        //int x=0;
        System.out.println("\n--------Key words table--------");
        for (Map.Entry e : keyWordsTable.entrySet())
        {
            //x++;
            System.out.println("| ID: "+e.getKey()+" | Token: "+e.getValue()+" |" );
        }
        System.out.println("------------------------------------" );
    }

}



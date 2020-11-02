

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
     */
    /*public Lexer(String sourcePath) {
        symbolTable = new HashMap<String, Token>();
        keyWordsTable = new HashMap<String, Token>();
        state = 0;
        globalPointer = 0;
        keyWordsTable.put("if", new Token("IF"));
        keyWordsTable.put("else", new Token("ELSE"));
        keyWordsTable.put("while", new Token("WHILE"));
        keyWordsTable.put("do", new Token("DO"));
        keyWordsTable.put("eof", new Token("EOF"));

        this.initialize(sourcePath);
    }*/

    public Lexer() {
        symbolTable = new HashMap<String, Token>();
        keyWordsTable = new HashMap<String, Token>();
        state = 0;
        globalPointer = 0;
        keyWordsTable.put("if", new Token("IF"));
        keyWordsTable.put("else", new Token("ELSE"));
        keyWordsTable.put("while", new Token("WHILE"));
        keyWordsTable.put("do", new Token("DO"));
        keyWordsTable.put("eof", new Token("EOF"));
    }

    /**
     * Questo metodo permette l'inizializzazione del Lexer, permettendo la lettura del file che gli viene passato in input
     *
     * @param filePath il path del file
     * @return true se il file esiste e può essere letto altrimenti restituisce false
     */

    public Boolean initialize(String filePath) {
        input = new File(filePath);
        if (!input.exists()) return false;
        if (!input.canRead() || !input.isFile()) return false;
        try {
            inputStream = new FileInputStream(input);
            globalPointer = inputStream.getChannel().position(); //Inizializza la variabile GlobalPointer assegnando la posizione del puntatore di inputStream
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    /**
     * @return Trova il prossimo lessema e se corrisponde ad un pattern restituisce il token relativo
     * altrimenti restituisce un token di errore
     * @throws Exception
     */
    public Token nextToken() throws Exception {

        //Ad ogni chiamata del seguente metodo vengono inizilizzate le seguenti variagili
        state = 0;
        StringBuilder lessema = new StringBuilder();
        char c;

        while (true) {


            globalPointer = inputStream.getChannel().position(); /*Salva la posizione corrente del puntatore prima
                                                                di leggere un nuovo carattere e quindi di
                                                                incrementare la posizione*/
            int intChar = inputStream.read();//Lettura di un carattere per volta
                if (intChar == -1) return  new Token("EOF");// -1 = End Of File restuisce null per indicare che in file è finito

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

            //OPERATORI RELAZIONALI
            switch (state) {
                case 0:
                    if (c == '<') {
                        state = 1;
                        lessema.append(c);
                        if (inputStream.available() <= 0 || nextCharIsDelimiter()) { //Niente più da leggere o il carattere successivo è un delimitatore
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
                        if (inputStream.available() <= 0 || nextCharIsDelimiter()) { //Niente più da leggere o il carattere successivo è un delimitatore
                            return new Token("GREATEROP");
                        }
                        break;
                    }

                    state = 10;//PROSSIMO DIAGRAMMA
                    break;

                case 1:
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

                case 3:
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

            //SEPARATORI
            switch (state) {
                case 10:
                    if (c == '(') {
                        state = 11; //FINALE
                        lessema.append(c);
                        return new Token("LRBRACKET");
                    }
                    if (c == ')') {
                        state = 12; //FINALE
                        lessema.append(c);
                        return new Token("RRBRACKET");
                    }
                    if (c == '[') {
                        state = 13; //FINALE
                        lessema.append(c);
                        return new Token("LSBRACKET");
                    }
                    if (c == ']') {
                        state = 14; //FINALE
                        lessema.append(c);
                        return new Token("RSBRACKET");
                    }
                    if (c == '{') {
                        state = 15; //FINALE
                        lessema.append(c);
                        return new Token("LBRACKET");
                    }
                    if (c == '}') {
                        state = 16; //FINALE
                        lessema.append(c);
                        return new Token("RBRACKET");
                    }
                    if (c == ',') {
                        state = 17; //FINALE
                        lessema.append(c);
                        return new Token("COMMA");
                    }
                    if (c == ';') {
                        state = 18; //FINALE
                        lessema.append(c);
                        return new Token("SEMICOMMA");
                    }

                    state = 19;//PROSSIMO DIAGRAMMA
                default:
                    break;
            }

            //IDENTIFICATORI
            switch (state) {
                case 19:

                    if (Character.isLetter(c) | Character.compare('_', c) == 0) {
                        state = 20;
                        lessema.append(c);

                        if (inputStream.available() <= 0 || nextCharIsDelimiter()) {//Niente più da leggere

                            return installID(lessema.toString());
                        }
                        break;
                    }
                    state = 21;//PROSSIMO DIAGRAMMA
                    break;

                case 20:

                    if (Character.isLetterOrDigit(c) | Character.compare('_', c) == 0) {
                        lessema.append(c);

                        if (inputStream.available() <= 0 || nextCharIsDelimiter()) { //Niente più da leggere
                            return installID(lessema.toString());
                        }
                        break;
                    } else {
                        state = 21;//PROSSIMO DIAGRAMMA
                        retrack();
                        return installID(lessema.toString());
                    }

                default:
                    break;
            }//end switch


            //NUMERI
            switch (state) {
                case 21:

                    if (c=='0') {
                        state=22;
                        lessema.append(c);
                        if (inputStream.available() <= 0 || nextCharIsDelimiter()) {//Niente più da leggere
                            return number(lessema.toString());
                        }


                        break;
                    }
                    if (Character.isDigit(c) && c!=0) {
                        state=23;
                        lessema.append(c);
                        if (inputStream.available() <= 0 || nextCharIsDelimiter()) {//Niente più da leggere
                            return number(lessema.toString());
                        }


                        break;
                    }
                    lessema.append(c);
                        state = 100; //STATO DI ERRORE
                    break;

                case 22:
                    if (Character.compare('.', c) == 0) {
                        if (inputStream.available() <= 0 || nextCharIsDelimiter()) { //Niente più da leggere
                            lessema.append(c);
                        state = 100; //STATO DI ERRORE
                        } else {
                            lessema.append(c);
                            state = 25;
                        }
                        break;
                    } else {
                        state = 24; //FINALE
                        retrack();
                        return number(lessema.toString());
                    }

                case 23:
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

                            state=100; //STATO DI ERRORE
                        }
                        break;
                    }
                    state = 24; //FINALE
                    retrack();
                    return number(lessema.toString());
                case 25:
                    if (Character.isDigit(c)) {
                        state=26;
                        lessema.append(c);
                        if (inputStream.available() <= 0 || nextCharIsDelimiter()) { //Niente più da leggere

                            return number(lessema.toString());
                        }
                        break;
                    } else {

                        state = 100; //STATO DI ERRORE
                        retrack();
                        break;
                    }
                case 26:
                    if (Character.isDigit(c)) {
                        lessema.append(c);
                        if (inputStream.available() <= 0 || nextCharIsDelimiter()) { //Niente più da leggere

                            return number(lessema.toString());
                        }
                        break;
                    } else {
                        state = 27; //FINALE
                        retrack();
                        return number(lessema.toString());
                    }

                default:
                    break;
            }//end switch

            //STATO DI ERRORE
            switch (state) {
                case 100:

                    return new Token("ERROR",lessema.toString());
                default:
                    break;
            }//end swith
        }//end while
    }//end method


    /**
     *
     * Se il lessema in input corrisponde ad un ID nella tabella delle stringhe restituisce direttamente in token
     * altrimenti aggiunge un campo nella teballa delle stringhe e poi restituisce il token
     *
     * @param lessema lessema preso in input
     * @return restituisce un token relativo all'id
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


    /**
     * Restituisce il token <NUMBER,valore> relativo al lessema che gli viene dato in input
     * @param lessema lessema preso in inpur
     * @return Restituisce il token <NUMBER,valore> relativo al lessema che gli viene dato in input
     */
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
     * Controlla se un carattere è un delimitatore
     * @param c carattere in input
     * @return true se c è un delimitatore altrimenti false
     */
    private Boolean isDelimiter(char c) {
        if (c == '\n' || c == '\t' || c == ' ' || c == '\r') return true;
        return false;
    }

    /**
     * Controlla se il prossimo carattere da leggere è un delimitatore
     * @return True se il prossimo carettere da leggere è un delimitatore e se il prossimo carattere è EOF, altrimenti false
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

    /**
     *
     * @return Restituisce una stringa che rappresenta la tabella delle stringhe
     */
    public String printSymbolTable(){
        StringBuilder s = new StringBuilder();
        s.append("--------Symbol table--------\n");
        for (Map.Entry e : symbolTable.entrySet())
        {

            s.append("| ID: "+e.getKey()+" | Token: "+e.getValue()+" |\n" );

        }
        s.append("------------------------------------\n" );
        return s.toString();
    }


    /**
     *
     * @return Restituisce una stringa che rappresenta la tabella delle stringhe
     */
    public String printKeyWordsTable(){
        StringBuilder s = new StringBuilder();
        s.append("\n--------Key words table--------\n");
        for (Map.Entry e : keyWordsTable.entrySet())
        {
            s.append("| ID: "+e.getKey()+" | Token: "+e.getValue()+" |\n" );
        }
        s.append("------------------------------------\n" );
        return s.toString();
    }

}






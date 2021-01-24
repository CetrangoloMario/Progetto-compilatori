package symbolTable;

import java.util.ArrayList;
import java.util.Stack;

//Problema riscontrato quando si usa lo stack si cancellava elemento al top, quindi nella
//successiva visita quella di Clang, perdevo le tabelle, due strade o salvare in un altro stack
// e portarselo appress o usare un array list e facendo in modo che di non togliere riferimento.
// ma avere nella tabella figlio puntatore a quella del padre.

/**
 * Type enviroment è un insieme di tabelle, al top (pensandolo come stack abbiamo tabella corrente)
 */
public class TypeEnvironment {
    public TypeEnvironment() {
        index = 0; //indice alla tabella corrente
        indexVisit = -1;
        this.typeEnvironment = new ArrayList<Tabella>();
    }

    public ArrayList<Tabella> getTypeEnvironment() {
        return typeEnvironment;
    }

    public void setTypeEnvironment(ArrayList<Tabella> typeEnvironment) {
        this.typeEnvironment = typeEnvironment;
    }

    // restituisce null se non trova l'elemento
    public Item lookup(String symbol) {
        return typeEnvironment.get(index).find(symbol);//prende la tabella corrente e fa ricerca
    }

    //Avviare un nuovo ambito
    public void enterScope() {
        Tabella newTable;
        if (typeEnvironment.size() > 0) //abbiamo tabelle già inserite
            newTable = new Tabella(typeEnvironment.get(index), index); //crea una nuova tabella usando il riferimento a quella del padre
        else // altrimenti crea da zero
            newTable = new Tabella();
        index = typeEnvironment.size();
        typeEnvironment.add(newTable);
    }

    public void enterScopeClang() {
        indexVisit++;
        index = indexVisit;
    }


    //Quando esco dallo scope devo ritornare alla tabella del padre.
    public void exitScope() {
        index = typeEnvironment.get(index).indicePadre;
    }

    public void addId(String id, Item item) {
        //se già presente
        if (probe(id)) {
            System.err.println("Errore di dichiarazione multipla");
            System.exit(1);
        }
        Tabella table = typeEnvironment.get(index);
        table.addItem(id, item);
    }

    /**
     * restituisce true se contiene id
     * @param id
     * @return boolean
     */
    public boolean probe(String id) {
        return typeEnvironment.get(index).getElementi().containsKey(id);
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    ArrayList<Tabella> typeEnvironment;
    int index;
    int indexVisit;
}

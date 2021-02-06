package symbolTable;

import java.util.HashMap;



public class Tabella {

    //diversi costruttori


    public Tabella(Tabella padre, int indicePadre) {
        this.elementi = new HashMap<>();
        this.padre = padre;
        this.indicePadre = indicePadre;
    }

    public Tabella() {
        this.elementi = new HashMap<>();
    }

    /**
     * getter e setter
     *
     */
    public HashMap<String, Item> getElementi() {
        return elementi;
    }

    public void setElementi(HashMap<String, Item> elementi) {
        this.elementi = elementi;
    }

    public Tabella getPadre() {
        return padre;
    }

    public void setPadre(Tabella padre) {
        this.padre = padre;
    }

    public void addItem(String key, Item item) {
        elementi.put(key, item);
    }

    /*
    cerca tra gli elementi della table corrente se contiene il simbolo
    altrimenti controlla quella del padre
    se non trova restituisce null.
     */
    public Item find(String symbol) {
        if (elementi.containsKey(symbol))
            return elementi.get(symbol);
        else if (padre != null)
            return padre.find(symbol);
        else
            return null;
    }

    @Override
    public String toString() {
        return "\nTabella{" +"elementi=" + elementi +", padre=" + padre + '}';
    }


    HashMap<String, Item> elementi;
    Tabella padre;
    int indicePadre;
}

package symbolTable;

import java.util.HashMap;

public class Tabella {

    public Tabella(Tabella padre) {
        this.elementi = new HashMap<>();
        this.padre = padre;
    }

    public Tabella() {
        this.elementi = new HashMap<>();
    }

    public Tabella(HashMap<String, Item> elementi, Tabella padre) {
        this.elementi = elementi;
        this.padre = padre;
    }

    public Tabella(HashMap<String, Item> elementi) {
        this.elementi = elementi;
    }

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
        return "\nTabella{" +
                "elementi=" + elementi +
                ", padre=" + padre +
                '}';
    }



    HashMap<String, Item> elementi;
    Tabella padre;
}

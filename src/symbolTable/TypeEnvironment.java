package symbolTable;

import java.util.Stack;

public class TypeEnvironment {
    public TypeEnvironment() {
        this.typeEnvironment = new Stack<Tabella>();
    }

    public Stack<Tabella> getTypeEnvironment() {
        return typeEnvironment;
    }

    public void setTypeEnvironment(Stack<Tabella> typeEnvironment) {
        this.typeEnvironment = typeEnvironment;
    }

    // restituisce null se non trova l'elemento
    public Item lookup(String symbol) {
        return typeEnvironment.peek().find(symbol);
    }

    public void enterScope() {
        Tabella newTable;
        if(typeEnvironment.size() > 0)
            newTable = new Tabella(typeEnvironment.peek());
        else
            newTable = new Tabella();
        typeEnvironment.push(newTable);
    }

    public void exitScope() {
        typeEnvironment.pop();
    }

    public void addId(String id, Item item) {
        if(probe(id))
           // throw new Error("Errore di dichiarazione multipla");
            System.err.println("Errore di dichiarazione multipla");
        Tabella table = typeEnvironment.peek();
        table.addItem(id, item);
    }

    public boolean probe(String id) {
        return typeEnvironment.peek().getElementi().containsKey(id);
    }

    Stack<Tabella> typeEnvironment;
}

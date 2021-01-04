package symbolTable;

public class Item {
    String value;
    String tipo;
    // function or variable
    String costrutto;

    public Item(String value, String tipo, String costrutto) {
        this.value = value;
        this.tipo = tipo;
        this.costrutto = costrutto;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCostrutto() {
        return costrutto;
    }

    public void setCostrutto(String costrutto) {
        this.costrutto = costrutto;
    }

    @Override
    public String toString() {
        return "Item{" +
                "value='" + value + '\'' +
                ", tipo='" + tipo + '\'' +
                ", costrutto='" + costrutto + '\'' +
                '}';
    }
}

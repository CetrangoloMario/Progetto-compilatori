package nodes.terminals;

import nodes.expression.ExpressionOP;
import visitor.Visitor;

public class Constant extends ExpressionOP {

    String name;
    String value;

    public Constant(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public Constant(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Object accept(Visitor v){
        return v.visit(this);
    }
}

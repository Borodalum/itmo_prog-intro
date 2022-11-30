package expression;

public class Variable implements AbstractExpression {
    private final String var;
    public Variable(String var) {
        this.var = var;
    }

    public int evaluate(int x) {
        return x;
    }
    public String toString() {
        return var;
    }

    @Override
    public boolean equals(Object otherExp) {
        return (otherExp instanceof Variable) && otherExp.toString().equals(var);
    }
    @Override
    public int hashCode() {
        return var.hashCode();
    }
}

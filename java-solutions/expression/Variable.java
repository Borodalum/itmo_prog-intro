package expression;

public class Variable implements AbstractExpression {
    private final String var;
    public Variable(String var) {
        this.var = var;
    }

    public int evaluate(int x) {
        return x;
    }
    public int evaluate(int x, int y, int z) {
        int value;
        if (var.equals("x")) {
            value = x;
        } else if(var.equals("y")) {
            value = y;
        } else {
            value = z;
        }
        return value;
    }
    public double evaluate(double x) {
        return x;
    }
    @Override
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

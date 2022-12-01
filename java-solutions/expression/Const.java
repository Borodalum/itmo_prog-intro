package expression;

public class Const implements AbstractExpression {
    private final int value;
    public Const(int value) {
        this.value = value;
    }

    public int evaluate(int x, int y, int z) {
        return value;
    }
    public int evaluate(int x) {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
    @Override
    public boolean equals(Object otherExp) {
        return (otherExp instanceof Const) && ((Const)otherExp).toString().equals(this.toString());
    }
    @Override
    public int hashCode() {
        return value;
    }
}

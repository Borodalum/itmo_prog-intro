package expression;

public class Const implements AbstractExpression {
    private final String value;
    private final boolean isDouble;
    public Const(int value) {
        this.value = String.valueOf(value);
        isDouble = false;
    }
    public Const(double value) {
        this.value = String.valueOf(value);
        isDouble = true;
    }

    public int evaluate(int x, int y, int z) {
        if (isDouble)
            return (int)Double.parseDouble(value);
        return Integer.parseInt(value);
    }
    public int evaluate(int x) {
        if (isDouble)
            return (int)Double.parseDouble(value);
        return Integer.parseInt(value);
    }
    public double evaluate(double x) {
        if (isDouble)
            return Double.parseDouble(value);
        return (double)Integer.parseInt(value);
    }

    @Override
    public String toString() {
        return value;
    }
    @Override
    public boolean equals(Object otherExp) {
        return (otherExp instanceof Const) && ((Const)otherExp).toString().equals(this.toString());
    }
    @Override
    public int hashCode() {
        int result;
        if (isDouble) {
            long doubleAsLong = Double.doubleToLongBits(Double.parseDouble(value));
            result = (int)(doubleAsLong ^ (doubleAsLong >> 32));
        } else {
            result = Integer.parseInt(value);
        }
        return result;
    }
}

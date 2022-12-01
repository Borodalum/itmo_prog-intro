package expression;

public class Const implements AbstractExpression {
    private final double value;
    private final boolean isDouble;
    public Const(int value) {
        this.value = (double)value;
        isDouble = false;
    }
    public Const(double value) {
        this.value = value;
        isDouble = true;
    }

    public int evaluate(int x, int y, int z) {
        return (int)value;
    }
    public int evaluate(int x) {
        return (int)value;
    }
    public double evaluate(double x) {
        return value;
    }

    @Override
    public String toString() {
        return isDouble ? String.valueOf(value) : String.valueOf(((int)value));
    }
    @Override
    public boolean equals(Object otherExp) {
        return (otherExp instanceof Const) && ((Const)otherExp).toString().equals(this.toString());
    }
    @Override
    public int hashCode() {
        int result;
        if (isDouble) {
            long doubleAsLong = Double.doubleToLongBits(value);
            result = (int)(doubleAsLong ^ (doubleAsLong >> 32));
        } else {
            result = (int)value;
        }
        return result;
    }
}

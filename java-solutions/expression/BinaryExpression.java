package expression;

public abstract class BinaryExpression implements AbstractExpression {
    public final AbstractExpression[] expressionList;
    public final String sign;

    public BinaryExpression(final AbstractExpression firstExp, final AbstractExpression secondExp, String sign) {
        this.expressionList = new AbstractExpression[] {firstExp, secondExp};
        this.sign = sign;
    }
    public int evaluate(int x) {
        return (int)doOperation(x, false);
    }
    public int evaluate(int x, int y, int z) {
        return switch (sign) {
            case "+" -> expressionList[0].evaluate(x, y, z) + expressionList[1].evaluate(x, y, z);
            case "-" -> expressionList[0].evaluate(x, y, z) - expressionList[1].evaluate(x, y, z);
            case "*" -> expressionList[0].evaluate(x, y, z) * expressionList[1].evaluate(x, y, z);
            case "/" -> expressionList[0].evaluate(x, y, z) / expressionList[1].evaluate(x, y, z);
            default -> throw new UnsupportedOperationException("Unsupported operation " + "'" + sign + "'");
        };
    }
    public double evaluate(double x) {
        return doOperation(x, true);
    }
    private double doOperation(double x, boolean isDouble) {
        switch (sign) {
            case "+":
                if (isDouble) {
                    return expressionList[0].evaluate(x) + expressionList[1].evaluate(x);
                } else {
                    return expressionList[0].evaluate((int) x) + expressionList[1].evaluate((int) x);
                }
            case "-":
                if (isDouble) {
                    return expressionList[0].evaluate(x) - expressionList[1].evaluate(x);
                } else {
                    return expressionList[0].evaluate((int) x) - expressionList[1].evaluate((int) x);
                }
            case "*":
                if (isDouble) {
                    return expressionList[0].evaluate(x) * expressionList[1].evaluate(x);
                } else {
                    return expressionList[0].evaluate((int) x) * expressionList[1].evaluate((int) x);
                }
            case "/":
                if (isDouble) {
                    return expressionList[0].evaluate(x) / expressionList[1].evaluate(x);
                } else {
                    return expressionList[0].evaluate((int) x) / expressionList[1].evaluate((int) x);
                }
            default:
                throw new UnsupportedOperationException("Unsupported operation " + "'" + sign + "'");
        }
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("(").append(expressionList[0].toString());
        for (int i = 1; i < expressionList.length; i++) {
            sb.append(" ").append(sign).append(" ").append(expressionList[i].toString());
        }
        sb.append(")");
        return sb.toString();
    }
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof BinaryExpression))
            return false;
        return this.sign.equals(((BinaryExpression)obj).sign)
                && ((BinaryExpression)obj).expressionList[0].equals(this.expressionList[0])
                && ((BinaryExpression)obj).expressionList[1].equals(this.expressionList[1]);
    }
    @Override
    public int hashCode() {
        return (((sign.hashCode())*17 + expressionList[0].hashCode())*17
                + expressionList[1].hashCode())*17;
    }
}

package expression;

public abstract class BinaryExpression implements AbstractExpression {
    public final AbstractExpression[] expressionList;
    public final String sign;

    public BinaryExpression(final AbstractExpression firstExp, final AbstractExpression secondExp, String sign) {
        this.expressionList = new AbstractExpression[] {firstExp, secondExp};
        this.sign = sign;
    }
    public int evaluate(int x) {
        if (sign.equals("+")) {
            return expressionList[0].evaluate(x) + expressionList[1].evaluate(x);
        } else if (sign.equals("-")) {
            return expressionList[0].evaluate(x) - expressionList[1].evaluate(x);
        } else if (sign.equals("*")) {
            return expressionList[0].evaluate(x) * expressionList[1].evaluate(x);
        } else if (sign.equals("/")) {
            return expressionList[0].evaluate(x) / expressionList[1].evaluate(x);
        } else {
            throw new UnsupportedOperationException("Unsupported operation " + "'" + sign + "'");
        }
    }
    public int evaluate(int x, int y, int z) {
        if (sign.equals("+")) {
            return expressionList[0].evaluate(x, y, z) + expressionList[1].evaluate(x, y, z);
        } else if (sign.equals("-")) {
            return expressionList[0].evaluate(x, y, z) - expressionList[1].evaluate(x, y, z);
        } else if (sign.equals("*")) {
            return expressionList[0].evaluate(x, y, z) * expressionList[1].evaluate(x, y, z);
        } else if (sign.equals("/")) {
            return expressionList[0].evaluate(x, y, z) / expressionList[1].evaluate(x, y, z);
        } else {
            throw new UnsupportedOperationException("Unsupported operation " + "'" + sign + "'");
        }
    }
    public double evaluate(double x) {
        if (sign.equals("+")) {
            return expressionList[0].evaluate(x) + expressionList[1].evaluate(x);
        } else if (sign.equals("-")) {
            return expressionList[0].evaluate(x) - expressionList[1].evaluate(x);
        } else if (sign.equals("*")) {
            return expressionList[0].evaluate(x) * expressionList[1].evaluate(x);
        } else if (sign.equals("/")) {
            return expressionList[0].evaluate(x) / expressionList[1].evaluate(x);
        } else {
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

package expression;

public abstract class BinaryExpression implements AbstractExpression {
    public final AbstractExpression[] expressionList;
    private final String sign;

    public BinaryExpression(AbstractExpression firstExp, AbstractExpression secondExp, String sign) {
        this.expressionList = new AbstractExpression[] {firstExp, secondExp};
        this.sign = sign;
    }

    public int evaluate(int x) {
        return x;
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
    public int hashCode() {
        return (((sign.hashCode())*17 + expressionList[0].hashCode())*17
                + expressionList[1].hashCode())*17;
    }
}

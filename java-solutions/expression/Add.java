package expression;

public class Add extends BinaryExpression {
    public Add(AbstractExpression firstExp, AbstractExpression secondExp) {
        super(firstExp, secondExp, "+");
    }
}

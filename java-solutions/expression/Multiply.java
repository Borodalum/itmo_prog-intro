package expression;

public class Multiply extends BinaryExpression {
    public Multiply(AbstractExpression firstExp, AbstractExpression secondExp) {
        super(firstExp, secondExp, "*");
    }

}

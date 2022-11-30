package expression;

public class Divide extends BinaryExpression {
    public Divide(AbstractExpression firstExp, AbstractExpression secondExp) {
        super(firstExp, secondExp, "/");
    }

}

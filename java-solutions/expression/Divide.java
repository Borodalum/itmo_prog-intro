package expression;

public class Divide extends BinaryExpression {
    public Divide(AbstractExpression firstExp, AbstractExpression secondExp) {
        super(firstExp, secondExp, "/");
    }

    @Override
    public int evaluate(int x) {
        int div;
        div = expressionList[0].evaluate(x) / expressionList[1].evaluate(x);
        return div;
    }

    @Override
    public boolean equals(Object otherExp) {
        if (!(otherExp instanceof Divide))
            return false;
        return this.expressionList[0].equals(((Divide)otherExp).expressionList[0])
                && this.expressionList[1].equals(((Divide)otherExp).expressionList[1]);
    }}

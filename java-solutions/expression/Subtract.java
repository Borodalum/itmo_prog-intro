package expression;

public class Subtract extends BinaryExpression {
    public Subtract(AbstractExpression firstExp, AbstractExpression secondExp) {
        super(firstExp, secondExp, "-");
    }

    @Override
    public int evaluate(int x) {
        int sub;
        sub = expressionList[0].evaluate(x) - expressionList[1].evaluate(x);
        return sub;
    }

    @Override
    public boolean equals(Object otherExp) {
        if (!(otherExp instanceof Subtract))
            return false;
        return this.expressionList[0].equals(((Subtract)otherExp).expressionList[0])
                && this.expressionList[1].equals(((Subtract)otherExp).expressionList[1]);
    }}

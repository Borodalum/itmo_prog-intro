package expression;

public class Add extends BinaryExpression {
    public Add(AbstractExpression firstExp, AbstractExpression secondExp) {
        super(firstExp, secondExp, "+");
    }

    @Override
    public int evaluate(int x) {
        int sum = 0;
        sum += super.expressionList[0].evaluate(x) + super.expressionList[1].evaluate(x);
        return sum;
    }

    @Override
    public boolean equals(Object otherExp) {
        if (!(otherExp instanceof Add))
            return false;
        return expressionList[0].equals(((Add)otherExp).expressionList[0])
                && expressionList[1].equals(((Add)otherExp).expressionList[1]);
    }
}

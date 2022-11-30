package expression;

import java.util.List;

public class Multiply extends BinaryExpression {
    public Multiply(AbstractExpression firstExp, AbstractExpression secondExp) {
        super(firstExp, secondExp, "*");
    }

    @Override
    public int evaluate(int x) {
        int mult;
        mult = expressionList[0].evaluate(x) * expressionList[1].evaluate(x);
        return mult;
    }

    @Override
    public boolean equals(Object otherExp) {
        if (!(otherExp instanceof Multiply))
            return false;
        return this.expressionList[0].equals(((Multiply)otherExp).expressionList[0])
                && this.expressionList[1].equals(((Multiply)otherExp).expressionList[1]);
    }
}

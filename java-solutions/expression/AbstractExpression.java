package expression;

public interface AbstractExpression extends Expression, TripleExpression, DoubleExpression {
    int evaluate(int x);
    int evaluate(int x, int y, int z);
    double evaluate(double x);
    //double evaluate(double x, double y, double z)
    boolean equals(Object exp);
    String toString();
}

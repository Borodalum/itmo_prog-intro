package expression;

public interface AbstractExpression extends Expression {
    int evaluate(int x);
    boolean equals(Object exp);
    String toString();
}

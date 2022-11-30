package expression;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AbstractExpression output = new Add(
                new Subtract(
                        new Multiply(new Variable("x"), new Variable("x")),
                        new Multiply(new Const(2), new Variable("x"))
                ),
                new Const(1)
        );
        String input = sc.next();
        try {
            int outputEval = output.evaluate(Integer.parseInt(input));
            System.out.println(outputEval);
        } catch (NumberFormatException | InputMismatchException e) {
            double outputEval = output.evaluate(Double.parseDouble(input));
            System.out.println(outputEval);
        }
    }
}

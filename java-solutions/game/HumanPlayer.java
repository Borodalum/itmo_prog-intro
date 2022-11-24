package game;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HumanPlayer implements Player {
    private final String indentifier;
    private final Scanner in;
    public HumanPlayer(String indentifier) {
        this.indentifier = indentifier;
        this.in = new Scanner(System.in);
    }

    @Override
    public Move move(final Cell cell) {
        while(true) {
            System.out.println("Введите свой ход: ");
            String row = in.next();
            String column = in.next();
            try {
                return new Move(Integer.parseInt(row), Integer.parseInt(column), cell);
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("Ход должен составлять два числа - координаты клетки.");
                System.out.println("Попробуйте еще раз.");
            }
        }
    }

    public String getIndentifier() {
        return indentifier;
    }
}

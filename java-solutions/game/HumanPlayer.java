package game;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
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
            int count = 0;
            ArrayList<String> tokens = new ArrayList<String>();
            try {
                Scanner parseSc = new Scanner(in.nextLine());
                while (parseSc.hasNext()) {
                    tokens.add(parseSc.next());
                    count++;
                    if (count > 2) {
                        return new Move(-1, -1, cell);
                    }
                }
                if (count == 1) {
                    parseSc = new Scanner(in.nextLine());
                    while (parseSc.hasNext()) {
                        tokens.add(parseSc.next());
                        count++;
                        if (count > 2) {
                            return new Move(-1, -1, cell);
                        }
                    }
                }
                String row = tokens.get(0);
                String column = tokens.get(1);
                try {
                    return new Move(Integer.parseInt(row) - 1, Integer.parseInt(column) - 1, cell);
                } catch (NumberFormatException | InputMismatchException e) {
                    System.out.println("Ход должен составлять два числа - координаты клетки.");
                    System.out.println("Попробуйте еще раз.");
                }
            } catch (NoSuchElementException ne) {
                System.out.println("Ввод окончен.");
                return null;
            }
        }
    }

    public String getIndentifier() {
        return indentifier;
    }
}

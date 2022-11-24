package game;

public class Game {
    private final boolean log;
    private final Player[] players;
    public Game(boolean log, Player... players) {
        this.log = log;
        this.players = players;
    }

    public String play(Board board) {
        System.out.println("Игра началась!");
        System.out.println(board.toString());
        while (true) {
            int i = 0;
            for (Player player : players) {
                System.out.println("Ход игрока " + player.getIndentifier());
                final String result = move(board, player, i);
                if (result != null) {
                    return result;
                }
                i++;
            }
        }
    }
    /*public String match(Board board, int pointsForWin) {
        final Match match = new Match(pointsForWin);
        while (match.getResult == Result.UNKNOWN) {
            match.playRound(board);
        }
        return match.getResult();
    }*/
    private String move(final Board board, final Player player, int numb) {
        final Move move = player.move(board.getTurn());
        final Result result = board.makeMove(move);
        System.out.println(board);
        if (result == Result.WIN) {
            return player.getIndentifier() + " выйграл";
        } else if (result == Result.LOSE) {
            return players[players.length - numb - 1].getIndentifier() + " выйграл";
        } else if (result == Result.DRAW) {
            return "Ничья";
        } else {
            return null;
        }
    }
}

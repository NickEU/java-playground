package tf.nick.hyperskill.ticTacToe.fieldAnalyzerStage3;

public class TicTacToe {
    private GameState gameState;
    private final GameBoard board;

    public TicTacToe(String initialBoardState) {
        this.board = new GameBoard(initialBoardState);
    }

    public boolean play() {
        renderGameBoard();
        printGameState();
        return true;
    }

    private void printGameState() {
        if (gameState == null) {
            calcGameState();
        }
        System.out.println(gameState.getMsg());
    }

    private void calcGameState() {
        RuleAnalyzer rules = new RuleAnalyzer(board);
        if (rules.illegalXODifference() || rules.xWins() && rules.oWins()) {
            gameState = GameState.IMPOSSIBLE;
            return;
        }

        if (rules.xWins()) {
            gameState = GameState.X_WINS;
            return;
        }

        if (rules.oWins()) {
            gameState = GameState.O_WINS;
            return;
        }

        gameState = rules.noEmptyCellsLeft() ? GameState.DRAW : GameState.IN_PROGRESS;
    }

    private void renderGameBoard() {
        String DECOR_BORDER = "---------";
        char[][] boardOfCells = board.getBoardCells();
        System.out.println(DECOR_BORDER);
        for (char[] row : boardOfCells) {
            System.out.printf("| %c %c %c |\n", row[0], row[1], row[2]);
        }
        System.out.println(DECOR_BORDER);
    }
}

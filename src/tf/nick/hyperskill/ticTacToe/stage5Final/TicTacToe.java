package tf.nick.hyperskill.ticTacToe.stage5Final;

public class TicTacToe {
    private final GameBoard board;
    private GameState gameState;
    private final RuleAnalyzer rules;

    TicTacToe(String initialBoardState) {
        this.board = new GameBoard(initialBoardState);
        rules = new RuleAnalyzer(board);
        updateGameState();
    }

    TicTacToe() {
        this("         ");
    }

    String getStateMsg() {
        return gameState.getMsg();
    }

    boolean isInProgress() {
        return gameState == GameState.IN_PROGRESS;
    }

    private void updateGameState() {
        if (rules.illegalXODifference() || rules.xWins() && rules.oWins()) {
            gameState = GameState.IMPOSSIBLE;
        } else if (rules.xWins()) {
            gameState = GameState.X_WINS;
        } else if (rules.oWins()) {
            gameState = GameState.O_WINS;
        } else {
            gameState = rules.noEmptyCellsLeft() ? GameState.DRAW : GameState.IN_PROGRESS;
        }
    }

    boolean tryMakeMove(int row, int col, char piece) {
        if (gameState != GameState.IN_PROGRESS) {
            return false;
        }

        boolean moveWasMade = board.tryChangeCell(row, col, piece);
        if (moveWasMade) {
            updateGameState();
        }
        return moveWasMade;
    }

    char[][] getCells() {
        return board.getBoardCells();
    }
}

package tf.nick.hyperskill.ticTacToe.firstMoveStage4;

import static tf.nick.hyperskill.ticTacToe.firstMoveStage4.GameBoard.O_CHAR;
import static tf.nick.hyperskill.ticTacToe.firstMoveStage4.GameBoard.X_CHAR;

class RuleAnalyzer {
    private final GameBoard board;
    private final int SIZE;

    RuleAnalyzer(GameBoard board) {
        this.board = board;
        SIZE = getCells().length;
    }

    private char[][] getCells() {
        return board.getBoardCells();
    }

    boolean illegalXODifference() {
        return Math.abs(countChar(X_CHAR) - countChar(O_CHAR)) >= 2;
    }

    private int countChar(char targetChar) {
        int count = 0;
        for (char[] row : getCells()) {
            for (char cell : row) {
                if (cell == targetChar) {
                    count++;
                }
            }
        }
        return count;
    }

    boolean xWins() {
        return charHasWon(X_CHAR);
    }

    boolean oWins() {
        return charHasWon(O_CHAR);
    }

    private boolean charHasWon(char xo) {
        return rowsHaveWinner(xo) || diagonalsHaveWinner(xo) || columnsHaveWinner(xo);
    }

    private boolean columnsHaveWinner(char xo) {
        char[][] cells = getCells();
        for (int col = 0; col < SIZE; col++) {
            boolean foundWinner = true;
            for (int row = 0; row < SIZE; row++) {
                char cell = cells[row][col];
                if (cell != xo) {
                    foundWinner = false;
                    break;
                }
            }
            if (foundWinner) {
                return true;
            }
        }
        return false;
    }

    private boolean diagonalsHaveWinner(char xo) {
        char[][] cells = getCells();
        // check main diag
        boolean foundWinner = true;
        for (int row = 0, col = 0; row < SIZE; row++, col++) {
            if (cells[row][col] != xo) {
                foundWinner = false;
                break;
            }
        }

        if (foundWinner) {
            return true;
        }

        // check side diag
        foundWinner = true;
        for (int row = SIZE - 1, col = 0; row >= 0 && col < SIZE; row--, col++) {
            if (cells[row][col] != xo) {
                foundWinner = false;
                break;
            }
        }

        return foundWinner;
    }

    private boolean rowsHaveWinner(char xo) {
        for (char[] row : getCells()) {
            boolean foundWinner = true;
            for (char cell : row) {
                if (cell != xo) {
                    foundWinner = false;
                    break;
                }
            }
            if (foundWinner) {
                return true;
            }
        }

        return false;
    }

    boolean noEmptyCellsLeft() {
        for (char[] row : getCells()) {
            for (char cell : row) {
                if (cell != X_CHAR && cell != O_CHAR) {
                    return false;
                }
            }
        }
        return true;
    }
}

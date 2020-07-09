package tf.nick.hyperskill.ticTacToe.stage4FirstMove;

class GameBoard {
    static final char X_CHAR = 'X';
    static final char O_CHAR = 'O';
    private final char[][] boardCells;

    GameBoard(String initialBoardState) {
        int BOARD_SIZE = 3;
        boardCells = new char[BOARD_SIZE][BOARD_SIZE];
        for (int j = 0, i = 0; j < BOARD_SIZE; j++) {
            for (int k = 0; k < BOARD_SIZE; k++) {
                boardCells[j][k] = initialBoardState.charAt(i);
                i++;
            }
        }
    }

    char[][] getBoardCells() {
        return this.boardCells.clone();
    }

    boolean cellIsOccupied(int row, int col) {
        char targetCell = boardCells[row][col];
        return targetCell == X_CHAR || targetCell == O_CHAR;
    }

    boolean tryChangeCell(int row, int col, char piece) {
        if (cellIsOccupied(row, col)) {
            return false;
        }

        boardCells[row][col] = piece;
        return true;
    }
}

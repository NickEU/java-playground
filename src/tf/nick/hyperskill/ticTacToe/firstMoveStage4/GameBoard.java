package tf.nick.hyperskill.ticTacToe.firstMoveStage4;

public class GameBoard {
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
}

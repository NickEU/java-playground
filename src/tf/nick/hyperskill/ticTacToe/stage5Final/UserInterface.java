package tf.nick.hyperskill.ticTacToe.stage5Final;

import java.util.Scanner;
import static tf.nick.hyperskill.ticTacToe.stage5Final.GameBoard.O_CHAR;
import static tf.nick.hyperskill.ticTacToe.stage5Final.GameBoard.X_CHAR;

public class UserInterface {
    private final Scanner sc = new Scanner(System.in);
    private TicTacToe game;
    private XOChar curMovePiece;

    public void start() {
        game = new TicTacToe();
        // easy to change first move to X or O
        curMovePiece = new XOChar(X_CHAR);
        renderGameBoard();
        while (game.isInProgress()) {
            getMoveCoordinatesFromUser();
        }
        // print final result at the end
        System.out.println(game.getStateMsg());
    }

    private void getMoveCoordinatesFromUser() {
        while (true) {
            System.out.println("Enter the coordinates: ");
            String userInput = sc.nextLine();
            UserMoveResult parseResult = parseUserMoveInput(userInput);
            if (parseResult == UserMoveResult.SUCCESS) {
                renderGameBoard();
                curMovePiece.next();
                break;
            }
            System.out.println(parseResult.getMsg());
        }
    }

    UserMoveResult parseUserMoveInput(String userInput) {
        try {
            String[] coords = userInput.split(" ");
            int userRow = Integer.parseInt(coords[0]);
            int userCol = Integer.parseInt(coords[1]);
            if (coordinateOutOfBounds(userRow) || coordinateOutOfBounds(userCol)) {
                return UserMoveResult.FAIL_OUT_OF_BOUNDS;
            }
            int row = Math.abs(userCol - 3);
            int col = userRow - 1;
            return game.tryMakeMove(row, col, curMovePiece.getCurrent())
                    ? UserMoveResult.SUCCESS
                    : UserMoveResult.FAIL_CELL_OCCUPIED;
        } catch(Exception e) {
            return UserMoveResult.FAIL_NAN;
        }
    }

    private boolean coordinateOutOfBounds(int coord) {
        return coord < 1 || coord > 3;
    }

    private void renderGameBoard() {
        String DECOR_BORDER = "---------";
        System.out.println(DECOR_BORDER);
        for (char[] row : game.getCells()) {
            System.out.printf("| %c %c %c |\n", row[0], row[1], row[2]);
        }
        System.out.println(DECOR_BORDER);
    }

    private static class XOChar {
        private char current;

        public XOChar(char startingChar) {
            current = startingChar;
        }

        char getCurrent() {
            return current;
        }

        void next() {
            current = current == X_CHAR ? O_CHAR : X_CHAR;
        }
    }
}
